package com.ehsieh2.books20

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.ehsieh2.books20.ui.theme.Books20Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Books20Theme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val viewModel: BooksViewModel by viewModels()
                    val uiState by viewModel.uiState.collectAsState()

                    BooksApp(homeUIState = uiState,
                        showDetail = {
                            viewModel.selectBook(it)
                        },
                        hideDetail = {
                            viewModel.hideDetail()
                        }, Modifier.fillMaxSize())
                }
            }
        }
    }
}