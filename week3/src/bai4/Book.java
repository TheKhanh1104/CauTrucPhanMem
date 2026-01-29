package bai4;
interface Book {
    String getTitle();
    void displayDetails();
}

class PaperBook implements Book {
    private String title;
    public PaperBook(String title) { this.title = title; }
    public String getTitle() { return title; }
    public void displayDetails() { System.out.println("[Sách giấy]: " + title); }
}

abstract class BookFactory {
    public abstract Book createBook(String title);
}

class PaperBookFactory extends BookFactory {
    public Book createBook(String title) { return new PaperBook(title); }
}