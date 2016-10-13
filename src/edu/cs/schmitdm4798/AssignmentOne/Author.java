package edu.cs.schmitdm4798.AssignmentOne;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 10/12/2016.
 */
public class Author {

    private List<Book> bookList;

    public Author(){
        bookList = new ArrayList<>();
    }

    public void addBook(Book book){

        boolean isDone = false;
        int i = 0;

        if(bookList.size() != 0){

            while(isDone || bookList.size() <= i){

                if(bookList.get(i).equals(book)){
                    bookList.get(i).addLocation(book.getLocation().get(0));
                    isDone = true;
                }else{
                    ++i;
                }
            }

            if(i == bookList.size()){
                bookList.add(book);
            }
        }else{
            bookList.add(book);
        }



    }

}
