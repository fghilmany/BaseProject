package com.fghilmany.baseproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.fghilmany.baseproject.factories.MainAppNavHost
import com.fghilmany.baseproject.factories.MainApplication
import com.fghilmany.baseproject.ui.theme.BaseProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainComponent = (application as MainApplication).mainComponent
        setContent {
            BaseProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainAppNavHost(mainComponent = mainComponent)
                }
            }
        }
    }
}
