package com.praveen.composeuitest.graph.presentation.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


/**
 * Created by Praveen.Sharma on 12/12/24 - 18:18..
 *
 ***/

@Composable
@Preview
fun previewStatrCard() {
    val stateData = HashMap<String, String>()
    stateData["CatA"] = "2000"
    stateData["CatB"] = "100%"
    stateData["CatC"] = "Kya kru"

    val gradientList = listOf(
        listOf(Color.Green, Color.Black),
        listOf(Color.Red, Color.Green),
        listOf(Color.Gray, Color.Red)
    )

    val titles = stateData.keys.toList()
    val values = stateData.values.toList()

    Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        stateData.values.forEachIndexed { index, value ->
            StatCard(
                title = titles[index],
                value = values[index],
            )

        }
    }


}

@Composable
fun StatCard(title: String, value: String) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .size(150.dp, 100.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Brush.verticalGradient(colors =listOf(Color.Green, Color.Black),))
            .padding(16.dp)
    ) {
        Column {
            Text(text = title, color = Color.White, style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = value, color = Color.White, style = MaterialTheme.typography.headlineMedium)
        }
    }


}