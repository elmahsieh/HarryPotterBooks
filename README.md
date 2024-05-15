# README
### Summary
This app introduces navigation and additional screens to enhance the user experience — the main functionalities are integrated into the viewModel with selectBook and hideDetail functions for managing book selection and hiding details. The HomeScreen, which is located in the screens package within the ui package displays the books in the series without the synopsis; on the other hand, the DetailScreen, also in the same package location, displays detailed information about a selected book, excluding the quote (this screen also includes a “Back” button that takes the user back to the HomeScreen). The BooksApp has been updated to remove the old UI code and now switches between the HomeScreen and DetailScreen baed on the showsDetail boolean in HomeStateUI. 

### User Instructions
* Click on the selected book in the list to get detailed description of the book.
* To return to the Home Screen, click on the “Back” button located at the bottom of the screen. 