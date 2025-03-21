package com.andret.fetchhiring.features

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.andret.fetchhiring.domain.GetSortedItemsListUseCase

class HomeViewModelFactory(private val getSortedItemsList: GetSortedItemsListUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(getSortedItemsList) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}