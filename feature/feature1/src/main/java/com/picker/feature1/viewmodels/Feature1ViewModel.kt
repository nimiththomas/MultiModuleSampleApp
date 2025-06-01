package com.picker.feature1.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.multimodulesample.domain.Feature1UseCase
import com.picker.feature1.states.Feature1UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class Feature1ViewModel @Inject constructor(
    private val feature1UseCase: Feature1UseCase
) : ViewModel() {
    private var _state = MutableStateFlow(Feature1UiState())
    val state: StateFlow<Feature1UiState> = _state
        .onStart {
            init()
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = _state.value
        )

    fun init() {
        _state.update {
            it.copy(
                screenName = "Feature1"
            )
        }
    }
}