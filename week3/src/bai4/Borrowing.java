package bai4;
interface Borrowing {
    String getDetails();
    double getCost();
}

class BasicBorrowing implements Borrowing {
    private Book book;
    public BasicBorrowing(Book book) { this.book = book; }
    public String getDetails() { return "Mượn sách: " + book.getTitle(); }
    public double getCost() { return 10000; } // Giá cơ bản
}

abstract class BorrowingDecorator implements Borrowing {
    protected Borrowing decoratedBorrowing;
    public BorrowingDecorator(Borrowing b) { this.decoratedBorrowing = b; }
    public String getDetails() { return decoratedBorrowing.getDetails(); }
    public double getCost() { return decoratedBorrowing.getCost(); }
}

class ExtraTimeDecorator extends BorrowingDecorator {
    public ExtraTimeDecorator(Borrowing b) { super(b); }
    @Override
    public String getDetails() { return super.getDetails() + " + Gia hạn thêm 7 ngày"; }
    @Override
    public double getCost() { return super.getCost() + 5000; }
}