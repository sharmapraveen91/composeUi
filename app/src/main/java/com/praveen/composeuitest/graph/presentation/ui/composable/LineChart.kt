package com.praveen.composeuitest.graph.presentation.ui.composable

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.praveen.composeuitest.graph.extension.div


/**
 * Created by Praveen.Sharma on 11/12/24 - 16:50..
 *
 ***/
@Composable
@Preview(showBackground = true, showSystemUi = false)
fun previewLineChart() {
    val dataPoints = listOf<Double>(1.1, 1.5, 1.4, 1.5, 1.3, 1.7, 1.2)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .size(300.dp),
        verticalArrangement = Arrangement.Center


    ) {
        LineChart(dataPoints = dataPoints)
    }
}


@Composable
fun LineChart(dataPoints: List<Double>) {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        val spacing = size.width / (dataPoints.size - 1) // scale factor for X axis
        val maxValue = dataPoints.maxOrNull()?.plus(1f) ?: 1f
        val scale = size.height / maxValue // scale factor for Y axis

        //Draw lines
        // start from index to index+1
        for (i in 0 until dataPoints.size - 1) {
            drawLine(
                color = Color.Black,
                start = Offset(i * spacing, (size.height - (dataPoints[i] * scale)).toFloat()),
                end = Offset(
                    (i + 1) * spacing,
                    (size.height - (dataPoints[i + 1] * scale)).toFloat()
                ),
                strokeWidth = 4f
            )
        }
        //Draw points on exact point value
        dataPoints.forEachIndexed { index, value ->
            drawCircle(
                color = Color.Green,
                radius = 6f,
                Offset(x = index * spacing, y = ((size.height - (value * scale).toFloat())))
            )

        }
    }
}

