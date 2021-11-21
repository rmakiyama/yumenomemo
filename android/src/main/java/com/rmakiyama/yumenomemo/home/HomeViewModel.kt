package com.rmakiyama.yumenomemo.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rmakiyama.yumenomemo.core.ViewStore
import com.rmakiyama.yumenomemo.model.Yumenomemo
import com.rmakiyama.yumenomemo.usecase.GetYumenomemoListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    private val getYumenomemoList: GetYumenomemoListUseCase,
) : ViewModel(), ViewStore<HomeViewModel.State, Void, HomeViewModel.Action> {

    private val _state = MutableStateFlow(State())
    override val state: StateFlow<State> = _state.asStateFlow()
    override val effect: Flow<Void> = flowOf()

    override fun dispatch(action: Action) {
        when (action) {
            Action.Launch -> launch()
        }
    }

    private fun launch() {
        viewModelScope.launch {
            val list = getYumenomemoList()
            _state.update { it.copy(yumenomemoList = list) }
        }
    }

    data class State(
        val yumenomemoList: List<Yumenomemo> = emptyList()
    )

    sealed class Action {
        object Launch : Action()
    }
}
