package org.example;

public class book {
    private String id;
    private String title;
    private String author;
    private Integer year;
    private boolean isAvailable;
    public book() {}

    public book(String id, String title, String author, int year) {

        checkid(id);
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public boolean isAvailable() {
        return isAvailable;
    }


    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
        } else {
            throw new IllegalStateException("The book is already borrowed.");
        }
    }

    public void returnBook()
    {
        isAvailable = true;
    }

    public void checkid(String id)
    {

        try {
            if (id.length() < 3 || id.length() > 3) {
                throw new RuntimeException("Length must be of 3 ");
            }
        }

        catch(RuntimeException e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }
}
