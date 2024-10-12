package com.example.baitaptablayout.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Book  implements Parcelable {
    private int image;
    private String bookName;
    private String author;
    private double price;
    private String description;
    private String isbn;
    private String category;
    private String publisher;
    private int saleNumber;
    public Book(){

    }

    public Book(int image, String bookName, String author, double price, String description, String isbn, String category, String publisher, int saleNumber) {
        this.image = image;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.description = description;
        this.isbn = isbn;
        this.category = category;
        this.publisher = publisher;
        this.saleNumber = saleNumber;
    }

    public Book(int image, String bookName) {
        this.image = image;
        this.bookName = bookName;
    }

    public Book(int image, String bookName, String author, double price, String description, String isbn) {
        this.image = image;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.description = description;
        this.isbn = isbn;
    }

    public Book(int saleNumber, int image, String bookName) {
        this.saleNumber =saleNumber;
        this.image = image;
        this.bookName = bookName;
    }
    public Book(int image){
        this.image = image;
    }
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getSaleNumber() {
        return saleNumber;
    }

    public void setSaleNumber(int saleNumber) {
        this.saleNumber = saleNumber;
    }

    protected Book(Parcel in) {
        image = in.readInt();
        bookName = in.readString();
    }
    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(image);
        parcel.writeString(bookName);
    }
}
