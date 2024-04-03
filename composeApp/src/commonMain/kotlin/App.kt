import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun App() {
    MaterialTheme {

        var showContent by remember { mutableStateOf(false) }
        val greeting = remember { Greeting().greet() }
        Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(modifier = Modifier.size(160.dp, 25.dp),
                contentPadding = PaddingValues(2.dp),
                onClick = { showContent = !showContent }) {
                Text(fontSize = 11.sp,
                text = "Draw Railway Line!")
            }

            if (showContent){
                Canvas(modifier = Modifier.fillMaxSize()){
                    var check = Pair<Offset, Offset>(Offset(0f, 0f), Offset(0f, 0f))
                    var check2 = Pair<Offset, Offset>(Offset(0f, 0f), Offset(0f, 0f))
                    var current = Offset(0f, 0f)
                    var current2 = Offset(0f, 200f)
                    val end: Offset = Offset(size.width, size.height)

                    this.drawIntoCanvas {
                        while (check.second.x < end.x && check.second.y < end.y) {
                            // calling it
                            check = drawRailLine(it, current, DrawCase.horizontal)
                            current = check.first
                        }
                        while (check2.second.x < end.x && check2.second.y < end.y) {
                            // calling it
                            check2 = drawRailLine(it, current2, DrawCase.horizontal)
                            current2 = check2.first
                        }
                    }
                }
            }

//            AnimatedVisibility(showContent) {
//                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
////                    Image(painterResource("compose-multiplatform.xml"), null)
//                    Text("Compose: $greeting")
//                }
//            }
        }
    }
}

enum class DrawCase{
    vertical, horizontal
}

fun drawRailLine(canvas: Canvas, po: Offset, case: DrawCase): Pair<Offset, Offset>{
    // initial decloration
    var point = po
    var lastPoint: Offset
    val futurePoint: Offset

    // changeable values to update
    val pause = 7f
    val bigger = 100f
    val smaller = 15f

    // set margin
    val margin = Offset(60f, 60f)
    if (point.x == 0f && point.x == 0f){
        point = Offset(point.x + margin.x, point.y + margin.y)
    }

    when(case){
        // draw vertically
        DrawCase.vertical -> {
            val width = smaller
            val height = bigger

            // painter
            val painter = Paint().apply {
                color = Color.Blue
                this.strokeWidth = width
            }

            // down
            lastPoint = Offset(point.x + width, point.y + height)

            // draw
            val rect = Rect(point.x, point.y, lastPoint.x, lastPoint.y)
            canvas.drawRect(rect, painter)
            mylog("TAG", "start: [${point.x}, ${point.y}]   end: [${lastPoint.x}, ${lastPoint.y}]")

            // new down
            lastPoint = Offset(lastPoint.x - width, lastPoint.y + pause )
            futurePoint = Offset(lastPoint.x, lastPoint.y + height)
        }
        // draw horizontally
        DrawCase.horizontal -> {
            val width = bigger
            val height = smaller

            // painter
            val painter = Paint().apply {
                color = Color.Blue
                this.strokeWidth = height
            }

            // down
            lastPoint = Offset(point.x + width, point.y + height)

            // draw
            val rect = Rect(point.x, point.y, lastPoint.x, lastPoint.y)
            canvas.drawRect(rect, painter)
            mylog("TAG", "start: [${point.x}, ${point.y}]   end: [${lastPoint.x}, ${lastPoint.y}]")

            // new down
            lastPoint = Offset(lastPoint.x + pause, lastPoint.y - height)
            futurePoint = Offset(lastPoint.x + width, lastPoint.y)
        }
    }
    return Pair(lastPoint, futurePoint)
}

// my log - bu har xil platformaga moslab log qilish uchun abstract funksiyadek sunksiya
// implementatsiyasi platformalar uchun alohida yoziladi
// chunki Timber.tag().d() yoki Log.d() bu class uchun accessible emas
expect fun mylog(tag: String, message: String)
