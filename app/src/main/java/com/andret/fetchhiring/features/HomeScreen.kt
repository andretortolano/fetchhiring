package com.andret.fetchhiring.features

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.andret.fetchhiring.domain.ItemEntity
import com.andret.fetchhiring.domain.ItemListEntity
import com.andret.fetchhiring.ui.ds.FetchCard
import com.andret.fetchhiring.ui.theme.FetchHiringTheme
import org.koin.androidx.compose.koinViewModel

// stateful composable
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val viewModel: HomeViewModel = koinViewModel()

    val state by viewModel.state.collectAsState()
    HomeScreen(modifier, state)
}

// stateless composable
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
        items(state) { list ->
            FetchCard(header = list.id.toString()) {
                Column(
                    modifier = Modifier.padding(horizontal = 12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    list.items.forEach { item ->
                        Text(text = item.name)
                    }
                }
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun HomeScreenPreview() {
    FetchHiringTheme {
        val state = listOf(
            ItemListEntity(1, listOf(ItemEntity(1, 1, "Item 1"), ItemEntity(2, 1, "Item 2"))),
            ItemListEntity(2, listOf(ItemEntity(3, 2, "Item 3"), ItemEntity(4, 2, "Item 4")))
        )

        HomeScreen(Modifier, state)
    }
}