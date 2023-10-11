package model;

import enums.Genre;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import service.SearchBooksService;

@Getter
@Setter
public class Customer extends Person {

    private Integer totalBooksCheckedOut;

    public List<Book> searchBooks(String title, String author, Genre genre, Date publicationDate) {
        return SearchBooksService.searchBooks(title, author, genre, publicationDate);
    }

    public List<Book> checkOutAndReserveBook(String title, String author, Genre genre, Date publicationDate) {
        return SearchBooksService.checkOutAndReserveBook(title, author, genre, publicationDate);
    }

    public List<Book> reserveBook(String title, String author, Genre genre, Date publicationDate) {
        return SearchBooksService.reserveBook(title, author, genre, publicationDate);
    }
}
