import org.example.bookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class BookTest {
    @Test
    public void check()
    {

        bookService b[];
        b = new bookService[2];

        bookService books = new bookService();

        //Test Case for NullPointerException
        Assertions.assertThrows(NullPointerException.class, () ->
        {
            books.addBook(null, "hello", "world", 1000);
        });

        //Test Case for id length
        bookService books1 = new bookService();
        books1.addBook("1000000", "the moon", "om", 1950);
        bookService books2 = new bookService();
        books2.addBook("10000", "the world", "dhruv", 1951);
        bookService books3 = new bookService();
        books3.addBook("189", "the sky", "nadeem", 20000);

        //Test Case for unique id
        for (int i = 0; i < 2; i++) {
            b[i] = new bookService();
            b[i].addBook("199", "the mars", "karan", 1221);
        }

        //Test Case to check no book available
        books1.addBook("10000", "the star", "jay", 1988);
        Assertions.assertThrows(NoSuchElementException.class, () ->
        {
            books.viewAvailableBooks();
        });

    }


    @Test
    public void checkborrow()
    {
        bookService b = new bookService();
        bookService a[] = new bookService[2];
        a[0] = new bookService();
        a[0].addBook("123", "the neptune", "obama", 2000);
        a[1] = new bookService();
        a[1].addBook("345", "the colour", "vikram", 2010);

        Assertions.assertThrows(NullPointerException.class, () ->
        {
            b.borrowBook(null);

        });
        Assertions.assertThrows(NullPointerException.class, () -> {
            b.borrowBook("ubutm");
        });
    }

}
