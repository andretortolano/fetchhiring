package com.andret.fetchhiring.features

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.andret.fetchhiring.data.ItemRepository
import com.andret.fetchhiring.data.remote.RetrofitItemService
import com.andret.fetchhiring.data.remote.RetrofitItemSource
import com.andret.fetchhiring.data.wrapper.S3RetrofitWrapper
import com.andret.fetchhiring.domain.GetSortedItemsListUseCase
import com.andret.fetchhiring.domain.ItemEntity
import com.andret.fetchhiring.domain.ItemListEntity

private fun getViewModelFactory(): HomeViewModelFactory {
    return HomeViewModelFactory(
        GetSortedItemsListUseCase(
            ItemRepository(
                RetrofitItemSource(
                    S3RetrofitWrapper.retrofit.create(RetrofitItemService::class.java)
                )
            )
        )
    )
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val factory = remember { getViewModelFactory() }
    val viewModel: HomeViewModel = viewModel(factory = factory)

    val state by viewModel.state.collectAsState()

    HomeScreen(modifier, state)
}

@Composable
fun HomeScreen(modifier: Modifier, state: List<ItemListEntity>) {
    LazyColumn(
        modifier = Modifier
            .then(modifier)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(12.dp)
    ) {
        items(state) {
            Card {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.primary),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        Text(
                            modifier = Modifier.padding(8.dp),
                            text = it.id.toString()
                        )
                    }
                    it.items.forEach {
                        Text(text = it.name)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    MaterialTheme {
        val state = listOf(
            ItemListEntity(1, listOf(ItemEntity(1, 1, "Item 1"), ItemEntity(2, 1, "Item 2"))),
            ItemListEntity(2, listOf(ItemEntity(3, 2, "Item 3"), ItemEntity(4, 2, "Item 4")))
        )

        HomeScreen(Modifier, state)
    }
}