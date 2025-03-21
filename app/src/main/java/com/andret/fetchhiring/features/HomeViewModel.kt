package com.andret.fetchhiring.features

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andret.fetchhiring.domain.GetItemsListUseCase
import com.andret.fetchhiring.domain.ItemList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getItemsListUseCase: GetItemsListUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<List<ItemList>>(emptyList())
    val state: StateFlow<List<ItemList>> = _state

    init {
        viewModelScope.launch {
            _state.update { getItemsListUseCase.invoke() }
        }
    }
}