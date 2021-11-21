package com.rmakiyama.yumenomemo.android.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rmakiyama.yumenomemo.model.Yumenomemo
import com.rmakiyama.yumenomemo.usecase.GetYumenomemoListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getYumenomemoList: GetYumenomemoListUseCase
) : ViewModel() {

    val yumenomemoList: StateFlow<List<Yumenomemo>> = flow {
        emit(getYumenomemoList())
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
}
