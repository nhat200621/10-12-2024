package com.example.library;
import java.util.ArrayList;
import java.util.List;
public class Library implements LibraryManager {
    private String id;
    private String name;
    private List<Book> bookList;
    public Library(String id, String name) {
        this.id = id;
        this.name = name;
        this.bookList = new ArrayList<>();
    }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<Book> getBookList() { return bookList; }
    public void addBook(Book book) {
        bookList.add(book);
    }
    public void removeBook(String bookId) {
        bookList.removeIf(book -> book.getId().equals(bookId));
    }
    public Book searchBook(String titleOrAuthor) {
        return bookList.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(titleOrAuthor) ||
                        book.getAuthor().equalsIgnoreCase(titleOrAuthor))
                .findFirst()
                .orElse(null);
    }
    public void displayBooks() {
        for (Book book : bookList) {
            System.out.println(book);
        }
    }
    public String toString() {
        return "Library ID: " + id + ", Name: " + name + ", Total Books: " + bookList.size();
    }
}
