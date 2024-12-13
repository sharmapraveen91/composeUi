package com.praveen.composeuitest.graph.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.praveen.composeuitest.graph.presentation.ui.composable.LineChart
import com.praveen.composeuitest.graph.presentation.ui.composable.PieChart
import com.praveen.composeuitest.graph.presentation.ui.composable.StatCard


/**
 * Created by Praveen.Sharma on 11/12/24 - 16:44..
 *
 ***/
@Composable
@Preview
fun previewDashBoard() {
    Dashboard()

}

@Composable
fun Dashboard() {

    val lineChartData = listOf(10.0, 15.0, 17.0, 25.0, 12.0)
    val pieChartData = mapOf("Sales" to 20f, "Ads" to 30f, "Marketing" to 40f, "Technology" to 10f)

    val statCards = listOf(
        Pair("Total Sales", "$5000"),
        Pair("User Growth", "+20%"),
        Pair("Active Users", "1200")
    )
    val pieChartColors = listOf(Color.Green, Color.DarkGray, Color.Cyan)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Text(
            text = "DashBoard",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .padding(16.dp)
        )

        LineChart(lineChartData)
        Text(
            text = "Line Chart",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))

        PieChart(data = pieChartData)
        Text(
            text = "Pie Chart",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))
        LazyRow {
            items(statCards) { card ->
                StatCard(
                    title = card.first,
                    value = card.second,
                )
            }
        }
    }
}
