package edu.cs.schmitdm4798.AssignmentOne;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Dave and Jack on 10/12/2016.
 *
 * Holds Book Information
 */
public class Book {

    private String bookCode;
    private String title;
    private String publisherCode;
    private String type;
    private Float price;
    private boolean paperback;
    private List<Location> location;

    public Book(String bookCode, String title, String publisherCode, String type, Float price, boolean paperback) {
        this.bookCode = bookCode;
        this.title = title;
        this.publisherCode = publisherCode;
        this.type = type;
        this.price = price;
        this.paperback = paperback;
    }

    public Book(String bookCode, String title, Float price, String location, int onHand){
        this.bookCode = bookCode;
        this.title = title;
        this.price = price;
        Location location1 = new Location(location, onHand);
        this.location = new ArrayList<Location>();
        this.location.add(location1);
    }

    public String getBookCode() {
        return bookCode;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisherCode() {
        return publisherCode;
    }

    public String getType() {
        return type;
    }

    public Float getPrice() {
        return price;
    }

    public boolean isPaperback() {
        return paperback;
    }

    public List<Location> getLocation(){
        return location;
    }

    public void addLocation(Location location1){
        location.add(location1);
    }

    public boolean equals(Object object){
        Book book = (Book)object;
        return (this.bookCode.equals(book.bookCode));
    }

    public String toString(){
        return title;
    }
}
