package APIs;

import Models.Book;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Inventory {
    private HashSet<Book> table = new HashSet<>();

    public void add(Book book){
        table.add(book);
    }

    public Book get(String ISBN){
        for (Book b : table)
         if(Objects.equals(b.getISBN(), ISBN))
             return b;

        return null;
    }

    public void remove(Book b){
        table.remove(b);
    }

    public Set<Book> getAll(){
        return new HashSet<>(table);
    }
}
