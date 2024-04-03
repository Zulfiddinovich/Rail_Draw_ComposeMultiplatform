import android.util.Log
import androidx.compose.ui.unit.dp

actual fun mylog(tag: String, message: String) {
    Log.d(tag, message)
}