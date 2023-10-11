package service;

import enums.Genre;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Book;

public class SearchBooksService {

    public static List<Book> searchBooks(String title, String author, Genre genre, Date publicationDate) {
        List<Book> books = new ArrayList<>();
        return books;
    }

    public static List<Book> checkOutAndReserveBook(String title, String author, Genre genre, Date publicationDate) {
        List<Book> books = new ArrayList<>();
        return books;
    }

    public static List<Book> reserveBook(String title, String author, Genre genre, Date publicationDate) {
        List<Book> books = new ArrayList<>();
        return books;
    }
}
