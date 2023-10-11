package model;

import enums.BookStatus;
import enums.Genre;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    private String bookId;
    private String title;
    private String author;
    private Genre genre;
    private Date publicationDate;
    private String barcode;     // unique
    private Integer copyId;     // unique
    private Integer rackNo;
    private Date issueDate;
    private BookStatus bookStatus;
    private Person issuedTo;
}
