package APIs;

import Exceptions.CannotBeBoughtException;
import Exceptions.NotFoundException;
import Models.Book;
import Models.Buyable;

public class BookAPI {
    Inventory inventory = new Inventory();

    public void add(Book book){
        inventory.add(book);
    }

    public int removeOutdated(int lessThan){
        var books = inventory.getAll();

        int removed = 0;
        for (Book book: books) {
            if (book.getPublishingYear() < lessThan) {
                inventory.remove(book);
                removed++;
            }
        }
        return removed;
    }

    public double buy(String ISBN,int quantity, String email, String address){
        var book = inventory.get(ISBN);

        if(book == null) throw new NotFoundException("No book with ISBN = " + ISBN);

        if(book instanceof Buyable)
            return ((Buyable) book).buy(quantity, email, address);

        throw new CannotBeBoughtException("The book with ISBN = " + ISBN +" can't be bought");
    }
}
