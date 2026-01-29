package bai4;

import java.util.List;

interface SearchStrategy {
    List<Book> search(String keyword, List<Book> books);
}

class SearchByTitle implements SearchStrategy {
    public List<Book> search(String keyword, List<Book> books) {
        return books.stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(keyword))
                .toList();
    }
}