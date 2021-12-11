package com.rmakiyama.yumenomemo.write

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rmakiyama.yumenomemo.core.ViewStore
import com.rmakiyama.yumenomemo.usecase.WriteYumenomemoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class WriteViewModel @Inject constructor(
    private val writeYumenomemo: WriteYumenomemoUseCase,
) : ViewModel(), ViewStore<WriteViewModel.State, WriteViewModel.Effect, WriteViewModel.Action> {

    private val _state = MutableStateFlow(State())
    override val state: StateFlow<State> = _state.asStateFlow()
    private val effectChannel = Channel<Effect>(Channel.UNLIMITED)
    override val effect: Flow<Effect> = effectChannel.receiveAsFlow()

    override fun dispatch(action: Action) {
        when (action) {
            Action.Write -> write()
            is Action.UpdateDetail -> _state.update { it.copy(detail = action.detail) }
            is Action.UpdateImpression -> _state.update { it.copy(impression = action.impression) }
        }
    }

    private fun write() {
        viewModelScope.launch {
            val params = WriteYumenomemoUseCase.Params(
                detail = state.value.detail,
                impression = state.value.impression,
            )
            writeYumenomemo(params)
            effectChannel.send(Effect.Completed)
        }
    }

    data class State(
        val detail: String = "",
        val impression: String = "",
    )

    sealed class Action {
        object Write : Action()
        data class UpdateDetail(val detail: String) : Action()
        data class UpdateImpression(val impression: String) : Action()
    }

    sealed class Effect {
        object Completed : Effect()
    }
}
