package com.andret.fetchhiring.features.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.andret.fetchhiring.ui.theme.FetchHiringTheme

@Composable
fun HomeErrorScene(modifier: Modifier = Modifier, message: String) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Red)
            .height(100.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(message)
    }
}

@Preview
@Composable
private fun Preview() {
    FetchHiringTheme {
        HomeErrorScene(message = "Test Error Message")
    }
}