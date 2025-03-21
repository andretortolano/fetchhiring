package com.andret.fetchhiring.ui.ds

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.andret.fetchhiring.ui.theme.FetchHiringTheme

@Composable
fun FetchCard(
    modifier: Modifier = Modifier,
    header: String,
    content: @Composable RowScope.() -> Unit
) {
    Card(modifier = modifier) {
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
                    color = MaterialTheme.colorScheme.onPrimary,
                    text = header
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.secondary)
                    .padding(12.dp)
            ) {
                val textStyle =
                    MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.onSecondary)

                CompositionLocalProvider(LocalTextStyle provides textStyle) {
                    content()
                }
            }
        }
    }
}

@Preview("Dynamic Colors")
@Composable
fun FetchCardPreview() {
    FetchHiringTheme {
        FetchCard(header = "Header") {
            Column {
                Text(text = "Item 1")
                Text(text = "Item 2")
            }
        }
    }
}

@Preview("Dark Colors")
@Composable
fun FetchCardPreviewDark() {
    FetchHiringTheme(
        darkTheme = true,
        dynamicColor = false
    ) {
        FetchCard(header = "Header") {
            Column {
                Text(text = "Item 1")
                Text(text = "Item 2")
            }
        }
    }
}

@Preview("Light Colors")
@Composable
fun FetchCardPreviewLight() {
    FetchHiringTheme(
        darkTheme = false,
        dynamicColor = false
    ) {
        FetchCard(header = "Header") {
            Column {
                Text(text = "Item 1")
                Text(text = "Item 2")
            }
        }
    }
}

