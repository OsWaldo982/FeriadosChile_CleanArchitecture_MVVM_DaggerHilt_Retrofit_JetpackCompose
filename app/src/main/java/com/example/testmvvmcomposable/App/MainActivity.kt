package com.example.testmvvmcomposable.App

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.testmvvmcomposable.App.theme.TestmvvmComposableTheme
import com.example.testmvvmcomposable.Feriados.ui.composables.FeriadosComposable
import com.example.testmvvmcomposable.Feriados.viewmodel.FeriadosViewModel
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class MainActivity() : ComponentActivity() {

    // Hilt proporciona automáticamente el ViewModel usando viewModels()
    private val viewModel: FeriadosViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestmvvmComposableTheme {
                Surface(
                    modifier = Modifier
                        .background(Color.Blue)
                        .fillMaxHeight()
                ) {
                    FeriadosComposable(viewModel)
                }
            }
        }
    }
}



