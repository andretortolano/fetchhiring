package com.andret.fetchhiring.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andret.fetchhiring.domain.GetSortedItemsListUseCase
import com.andret.fetchhiring.domain.ItemListEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getSortedItemsListUseCase: GetSortedItemsListUseCase
) : ViewModel() {

    sealed class UiState {
        data object Loading : UiState()
        data class Success(val items: List<ItemListEntity>) : UiState()
        data class Error(val message: String) : UiState()
    }

    private val _state = MutableStateFlow<UiState>(UiState.Loading)
    val state: StateFlow<UiState> = _state

    init {
        viewModelScope.launch {
            _state.update {
                try {
                    val result = getSortedItemsListUseCase.invoke()
                    UiState.Success(result)
                } catch (e: Exception) {
                    // TODO: use case should instead return a Result object so we don't have the need to try catch in the viewModel
                    UiState.Error(e.message ?: "Unknown error")
                }
            }
        }
    }
}