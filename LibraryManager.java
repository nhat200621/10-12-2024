package com.example.library;
public interface LibraryManager {
    void addBook(Book book);
    void removeBook(String bookId);
    Book searchBook(String titleOrAuthor);
    void displayBooks();
}
