import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import com.ehsieh2.books20.models.Book
import com.ehsieh2.books20.models.HomeUIState
import com.ehsieh2.books20.ui.theme.Books20Theme


@Composable
fun HomeScreen(homeUIState: HomeUIState,
               showDetail: (Int) -> Unit,
               hideDetail: () -> Unit,
               selectedBook: Book? = null,
               modifier: Modifier
               ) {
    Box(
        modifier = modifier
    ) {
        if (homeUIState.selectedBook != null && homeUIState.showsDetail) {
            DetailScreen(
                book = homeUIState.selectedBook,
                hideDetail = hideDetail,
                modifier = modifier)
        } else {
            LazyColumn(modifier = modifier)
            {
                items(homeUIState.books) { book ->
                    BookItem(
                        book = book,
                        isSelected = book.index == selectedBook?.index,
                        selectBook = { index ->
                            showDetail(index)
                        }
                    )
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    Books20Theme {
        HomeScreen(homeUIState = HomeUIState(),
            showDetail = {},
            hideDetail = {},
            modifier = Modifier.fillMaxSize())
    }
}

@Composable
fun BookItem(
    book: Book,
    isSelected: Boolean = false,
    selectBook: (Int) -> Unit,
) {

    Column(modifier = Modifier
        .padding(15.dp)
        .semantics { selected = isSelected }
        .clickable { selectBook(book.index) }
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            // Image
            Box(
                modifier = Modifier
                    .width(70.dp)
                    .aspectRatio(3f / 4) // Aspect ratio for the image
            ) {
                Image(
                    painter = painterResource(id = book.coverImage),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.width(13.dp))

            Column(modifier = Modifier.weight(4f)) {
                Text(
                    text = "${book.index}. ${book.title}",
                    style = TextStyle(
                        fontSize = 23.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                )
                Text(
                    text = "Author: ${book.author}",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif
                    )
                )
                Text(
                    text = "Released: ${book.released}",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                )
            }
        }

        Row(
            modifier = Modifier.padding(3.dp)

        ) {
            Text(
                text = book.quote,
                style = TextStyle(
                    fontSize = 13.sp,
                    fontStyle = FontStyle.Italic,
                    fontFamily = FontFamily.SansSerif
                )
            )
        }
//        Spacer(modifier = Modifier.height(3.dp))
    }
}
