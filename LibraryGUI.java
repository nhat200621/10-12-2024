package com.example.library;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class LibraryGUI extends Application {
    private Library library = new Library("1", "My Library");
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Library Management System");
        TextField bookIdField = new TextField();
        bookIdField.setPromptText("Book ID");
        TextField titleField = new TextField();
        titleField.setPromptText("Title");
        TextField authorField = new TextField();
        authorField.setPromptText("Author");
        TextField genreField = new TextField();
        genreField.setPromptText("Genre");
        TextField yearField = new TextField();
        yearField.setPromptText("Year");
        Button addButton = new Button("Add Book");
        Button displayButton = new Button("Display Books");
        TextArea displayArea = new TextArea();
        displayArea.setEditable(false);
        addButton.setOnAction(e -> {
            String id = bookIdField.getText();
            String title = titleField.getText();
            String author = authorField.getText();
            String genre = genreField.getText();
            int year = Integer.parseInt(yearField.getText());
            Book newBook = new Book(id, title, author, genre, year, "Available");
            library.addBook(newBook);
            displayArea.appendText("Added: " + newBook.toString() + "\n");
        });
        displayButton.setOnAction(e -> {
            displayArea.clear();
            for (Book book : library.getBookList()) {
                displayArea.appendText(book.toString() + "\n");
            }
        });
        VBox layout = new VBox(10);
        layout.getChildren().addAll(
                bookIdField, titleField, authorField, genreField, yearField,
                addButton, displayButton, displayArea
        );
        Scene scene = new Scene(layout, 400, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}