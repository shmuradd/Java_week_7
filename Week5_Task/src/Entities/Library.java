package Entities;

import java.util.ArrayList;
import java.util.Arrays;

public class Library {
    private String name;
    private ArrayList<Book> mybooks; //instead Book[] Array list is used

    public Library()
    {
        mybooks= new ArrayList<>();

    }

    public void setName(String name)
    {
        this.name=name;
    }
    public String getName()
    {
        return name;
    }


    public void AddBook(Book book1)
    {
        for (Book existingBook : mybooks) {
            if (existingBook.getName().equals(book1.getName()) && existingBook.getAuthor().equals(book1.getAuthor())) {
                // If yes, increase the count and exit
                existingBook.increaseCount(book1.getCount());
                return;
            }
        }
        //If not
        mybooks.add(book1);

    }


    public void ShowBooks()
    {
        for (Book book:mybooks)
        {
            book.FullInfo();
            System.out.println("\n");
        }
    }
    public Book FindBookById(int bookId) {
        for (Book book : mybooks) {
            if (book.getId() == bookId) {
                return book;

            }
        }
        return null; // Book not found
    }

    public void DeleteBookById(int bookId) {
        for (Book book : mybooks) {
            if (book.getId() == bookId) {
                mybooks.remove(book);
                System.out.println("Book with ID " + bookId + " deleted successfully!");
                return;
            }
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    public Book FindBookByKeyword(String keyword) {
        for (Book book : mybooks) { //String.valueOf()-converts to String
            if (String.valueOf(book.getId()).equals(keyword) ||
                    book.getName().equalsIgnoreCase(keyword) ||
                    book.getAuthor().equalsIgnoreCase(keyword)) {
                return book;
            }
        }
        return null; // Book not found
    }

}
