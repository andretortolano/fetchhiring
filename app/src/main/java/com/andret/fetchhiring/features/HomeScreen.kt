package com.andret.fetchhiring.features

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.andret.fetchhiring.domain.Item
import com.andret.fetchhiring.domain.ItemList

@Composable
fun HomeScreen(modifier: Modifier = Modifier, viewModel: HomeViewModel) {
    val state by viewModel.state.collectAsState()

    HomeScreen(modifier, state)
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier, state: List<ItemList>) {
    LazyColumn(
        modifier = Modifier
            .then(modifier)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
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
                        Text(text = it.id.toString())
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
            ItemList(1, listOf(Item(1, 1, "Item 1"), Item(2, 1, "Item 2"))),
            ItemList(2, listOf(Item(3, 2, "Item 3"), Item(4, 2, "Item 4")))
        )

        HomeScreen(Modifier.padding(16.dp), state)
    }
}