package com.praveen.composeuitest.graph.presentation.ui.composable

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


/**
 * Created by Praveen.Sharma on 12/12/24 - 17:14..
 *
 ***/
@Composable
@Preview
fun previewPieChart() {
    val dataPoints = HashMap<String, Float>()
    dataPoints["India"] = 20.5f
    dataPoints["Uk"] = 25.0f
    dataPoints["US"] = 25.0f
    dataPoints["Europe"] = 20.5f
    dataPoints["Canada"] = 10f


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(color = Color.White),

        ) {
        PieChart(data = dataPoints)
    }

}

@Composable
fun PieChart(data: Map<String, Float>) {
    val colors = listOf(Color.Red, Color.Blue, Color.Yellow, Color.Green, Color.DarkGray)
    val total = data.values.sum()
    var startAngle = 0f

    Canvas(modifier = Modifier.size(200.dp)) {
        data.values.forEachIndexed { index, value ->
            val sweepAngle = (value / total) * 360
            drawArc(
                color = colors[index % colors.size],
                startAngle = startAngle,
                sweepAngle = sweepAngle,
                useCenter = true,
            )
            startAngle += sweepAngle
        }
    }
}