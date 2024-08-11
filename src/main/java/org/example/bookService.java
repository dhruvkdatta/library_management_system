package org.example;

import java.time.Year;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class bookService {
    private Map<String,book> books;

    public bookService() {
        books = new HashMap<>();
    }

    public void addBook(String id,String title,String author ,Integer year)
    {
        checknull(id,title,author,year);
        checkyear(year);
        checkid(id);

        books.put(id,new book(id,title,author,year));
    }

    public void borrowBook(String isbn) {
        if (books.containsKey(isbn))
        {
            book book = books.get(isbn);

            if (book.isAvailable())
            {
                book.borrowBook();
                System.out.println("You have successfully borrowed: " + book.getTitle());
            }
            else
            {
                System.out.println("The book is currently unavailable.");
            }
        }
        else
        {
            throw new IllegalArgumentException("The book with ISBN " + isbn + " does not exist.");
        }
    }

    public void returnBook(String isbn) {
        if (books.containsKey(isbn)) {
            book book = books.get(isbn);
            book.returnBook();
            System.out.println("You have successfully returned: " + book.getTitle());
        }
        else
        {
            throw new IllegalArgumentException("The book with ISBN " + isbn + " does not exist.");
        }
    }
    public void checknull(String id,String title,String author,Integer year) {
        if (id == null || title == null || author == null || year == null) {
            throw new NullPointerException("cannot be blank");
        }
    }
    public void checkyear(Integer year)
    {
        Integer y = Year.now().getValue();
        if (year > y)
        {
            throw new RuntimeException("year is greater than current year");
        }
    }
    public void checkid(String id)
    {

        for(book a:books.values())
        {
            try
            {
                if (a.getId().equalsIgnoreCase(id)) {
                    throw new RuntimeException("ID ALREADY EXIST");

                }
            }
            catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void viewAvailableBooks() {
        try
        {
            if (books.size() == 0)
            {
                throw new NoSuchElementException("No Books Available");
            }
        }
        catch(NoSuchElementException e)
        {
            System.out.println(e.getMessage());
        }
        for(book a:books.values())
        {
            System.out.println("ISBN:"+a.getId()+"\n"+"Title:"+a.getTitle()+"\n"+"Author:"+a.getAuthor()+"\n"+"publication_year:"+a.getYear());
            System.out.println("--------------------------");
        }

    }
}
