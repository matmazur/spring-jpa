package com.matmazur.springjpa.model;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue
    @Column(name = "BOOK_ID")
    private Long bookId;
    private String title;
    private String author;
    @Column(nullable = false, length = 13, unique = true)
    private String isbn;


    @PrePersist
    public void prePersist() {
        System.out.println("----PRE-PERSIST----");
    }

    @PostPersist
    public void postPersist() {
        System.out.println("----POST-PERSIST----");
    }

    @PreUpdate
    public void preUpdate() {
        System.out.println("----PRE-UPDATE----");
    }

    @PostUpdate
    public void postUpdate() {
        System.out.println("----POST-UPDATE----");
    }

    @PreRemove
    public void preRemove() {
        System.out.println("----PRE-REMOVE----");
    }

    @PostRemove
    public void postRemove() {
        System.out.println("----POST-REMOVE----");
    }


    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }

    public Book() {
    }

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
