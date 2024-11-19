import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColorSelectionApp()
        }
    }
}

@Composable
fun ColorSelectionApp() {
    var selectedColor by remember { mutableStateOf(Color.Gray) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        ColorList(colors = listOf(Color.Red, Color.Green, Color.Blue, Color.Yellow)) { color ->
            selectedColor = color
        }

        Spacer(modifier = Modifier.height(32.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(selectedColor)
        )
    }
}

@Composable
fun ColorList(colors: List<Color>, onColorSelected: (Color) -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    ) {
        colors.forEach { color ->
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(color, CircleShape)
                    .clickable { onColorSelected(color) } // Notifica el color seleccionado
            )
        }
    }
}
