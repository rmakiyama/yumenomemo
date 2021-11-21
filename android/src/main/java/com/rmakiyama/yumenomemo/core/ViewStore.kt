package com.rmakiyama.yumenomemo.core

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface ViewStore<STATE, EFFECT, ACTION> {
    val state: StateFlow<STATE>
    val effect: Flow<EFFECT>
    fun dispatch(action: ACTION)
}
