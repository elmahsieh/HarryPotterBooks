package com.ehsieh2.books20.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ehsieh2.books20.models.Book
import com.ehsieh2.books20.models.BookTestData.books
import com.ehsieh2.books20.ui.theme.Books20Theme

@Composable
fun DetailScreen(book: Book,
                 hideDetail: () -> Unit,
                 modifier: Modifier
) {
    Column(modifier = Modifier
        .padding(16.dp)
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = book.coverImage),
                contentDescription = null,
                modifier = Modifier
                    .size(400.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "${book.index}. ${book.title}",
            style = TextStyle(
                fontSize = 22.sp,
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

        Spacer(modifier = Modifier.height(14.dp))
        Text(
            text = book.synopsis,
            style = TextStyle(
                fontSize = 12.sp,
                fontFamily = FontFamily.SansSerif

            )
        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = hideDetail,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            Text("Back")
        }

        Spacer(modifier = Modifier.height(35.dp))
    }
}


@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    Books20Theme {
        DetailScreen(
            book = books[0],
            hideDetail = {},
            modifier = Modifier.fillMaxSize()
        )
    }
}