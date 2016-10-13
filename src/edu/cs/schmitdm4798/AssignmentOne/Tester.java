package edu.cs.schmitdm4798.AssignmentOne;

/**
 * Created by Admin on 10/13/2016.
 */
public class Tester {

    public static void main(String[] args) {
        Author author = new Author("Dave", "Schmitz");
        Book book1 = new Book("111", "Dave's Book ONE", 29.99F, "Barnes", 5);
        Book book1location = new Book("111", "Dave's Book ONE", 29.99F, "Apples", 4);
        Book book2 = new Book("112", "Dave's Book TWO", 29.99F, "Barnes", 3);

        author.addBook(book1);
        author.addBook(book1location);
        author.addBook(book2);

        System.out.println(author.getBookList().size());
    }
}
