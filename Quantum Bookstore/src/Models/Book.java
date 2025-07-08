package Models;

public abstract class Book {
    private String ISBN;
    private String title;
    private double price;
    private int publishingYear;

    public Book(String ISBN, String title, double price, int publishingYear) {
        this.ISBN = ISBN;
        this.title = title;
        this.price = price;
        this.publishingYear = publishingYear;

    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    @Override
    public int hashCode() {
        return ISBN.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return ISBN.equals(((Book)obj).ISBN);
    }

    @Override
    public String toString() {
        return "Book: " + getTitle();
    }
}
