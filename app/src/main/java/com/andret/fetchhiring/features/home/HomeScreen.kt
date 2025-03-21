package com.andret.fetchhiring.features.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.andret.fetchhiring.domain.ItemEntity
import com.andret.fetchhiring.domain.ItemListEntity
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
fun HomeScreen(modifier: Modifier, state: HomeViewModel.UiState) {
    when (state) {
        is HomeViewModel.UiState.Loading -> HomeLoadingScene(modifier)
        is HomeViewModel.UiState.Success -> HomeSuccessScene(modifier, state.items)
        is HomeViewModel.UiState.Error -> HomeErrorScene(modifier, state.message)
    }

}

@Preview(
    showBackground = true
)
@Composable
fun HomeScreenPreview() {
    FetchHiringTheme {
        val state = HomeViewModel.UiState.Success(
            listOf(
                ItemListEntity(1, listOf(ItemEntity(1, 1, "Item 1"), ItemEntity(2, 1, "Item 2"))),
                ItemListEntity(2, listOf(ItemEntity(3, 2, "Item 3"), ItemEntity(4, 2, "Item 4")))
            )
        )

        HomeScreen(Modifier, state)
    }
}