package com.rmakiyama.yumenomemo.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rmakiyama.yumenomemo.usecase.GetYumenomemoListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    private val getYumenomemoList: GetYumenomemoListUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(HomeViewState.Empty)
    val state: StateFlow<HomeViewState> = _state.asStateFlow()

    fun load() {
        viewModelScope.launch {
            val list = getYumenomemoList()
            _state.update { it.copy(yumenomemoList = list) }
        }
    }
}
