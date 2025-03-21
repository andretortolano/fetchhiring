package com.andret.fetchhiring

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.andret.fetchhiring.data.ItemRepository
import com.andret.fetchhiring.domain.GetSortedItemsListUseCase
import com.andret.fetchhiring.features.HomeScreen
import com.andret.fetchhiring.features.HomeViewModel
import com.andret.fetchhiring.ui.theme.FetchHiringTheme

class MainActivity : ComponentActivity() {

    private val homeViewModel = HomeViewModel(GetSortedItemsListUseCase(ItemRepository()))

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FetchHiringTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(
                        modifier = Modifier.padding(innerPadding),
                        viewModel = homeViewModel,
                    )
                }
            }
        }
    }
}