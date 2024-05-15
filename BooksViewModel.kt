import androidx.lifecycle.ViewModel
import com.ehsieh2.books20.models.BookTestData
import com.ehsieh2.books20.models.HomeUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class BooksViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUIState(books = emptyList()))
    val uiState: StateFlow<HomeUIState> = _uiState

    init {
        _uiState.value = HomeUIState(books = BookTestData.books)
    }

    fun selectBook(idx: Int) {
        val book = uiState.value.books.find { it.index == idx }
        _uiState.value = _uiState.value.copy(
            selectedBook = book,
            showsDetail = true
        )
    }
    fun hideDetail() {
        _uiState.value = _uiState.value.copy(
            selectedBook = _uiState.value.books.first(),
            showsDetail = false
        )
    }

}