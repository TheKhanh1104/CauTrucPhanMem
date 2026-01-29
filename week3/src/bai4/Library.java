package bai4;
import java.util.*;

// Interface cho Observer
interface Observer {
    void update(String message);
}

public class Library {
    private static Library instance;
    private List<Book> books = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();
    private SearchStrategy searchStrategy;

    private Library() {}

    public static synchronized Library getInstance() {
        if (instance == null) instance = new Library();
        return instance;
    }

    public void addObserver(Observer o) { observers.add(o); }
    
    public void addBook(Book book) {
        books.add(book);
        notifyObservers("Sách mới đã được thêm: " + book.getTitle());
    }

    private void notifyObservers(String msg) {
        for (Observer o : observers) o.update(msg);
    }

    public void setSearchStrategy(SearchStrategy strategy) { this.searchStrategy = strategy; }

    public void performSearch(String keyword) {
        List<Book> results = searchStrategy.search(keyword, books);
        results.forEach(Book::displayDetails);
    }
}