package com.andret.fetchhiring.features

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

    private val _state = MutableStateFlow<List<ItemListEntity>>(emptyList())
    val state: StateFlow<List<ItemListEntity>> = _state

    init {
        viewModelScope.launch {
            _state.update { getSortedItemsListUseCase.invoke() }
        }
    }
}