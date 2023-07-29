package com.ayush.humaranagartask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ayush.humaranagartask.ui.theme.HumaraNagarTaskTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OnboardingScreen(
                listOf(
                    ImageData(R.drawable.img1, resources.getString(R.string.text1)),
                    ImageData(R.drawable.img2, resources.getString(R.string.text2)),
                    ImageData(R.drawable.img3, resources.getString(R.string.text3)),
                    ImageData(R.drawable.img4, resources.getString(R.string.text4)),
                )
            )
        }
    }
}
