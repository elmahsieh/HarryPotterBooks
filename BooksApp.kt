import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ehsieh2.books20.models.BookTestData
import com.ehsieh2.books20.models.HomeUIState
import com.ehsieh2.books20.ui.theme.Books20Theme
import com.ehsieh2.books20.ui.theme.screens.DetailScreen
import com.ehsieh2.books20.ui.theme.screens.HomeScreen

@Composable
fun BooksApp(
    homeUIState: HomeUIState,
    showDetail: (Int) -> Unit,
    hideDetail: () -> Unit,
    modifier: Modifier) {

    if (homeUIState.showsDetail && homeUIState.selectedBook != null) {
        DetailScreen(book = homeUIState.selectedBook,
            hideDetail = hideDetail,
            Modifier.fillMaxSize())
    } else {
        HomeScreen(homeUIState = homeUIState,
            showDetail = showDetail,
            hideDetail = hideDetail,
            selectedBook = homeUIState.selectedBook,
            modifier = Modifier.fillMaxSize())
    }
}

@Preview(showBackground = true)
@Composable
fun BooksAppPreview() {
    Books20Theme {
        BooksApp(homeUIState = HomeUIState(
            books = BookTestData.books,
        ),
            showDetail = {},
            hideDetail = {},
            modifier = Modifier)
    }
}

