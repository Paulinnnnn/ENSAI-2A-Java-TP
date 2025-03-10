package fr.ensai.library;

public abstract class Item {
    protected String title;
    protected Integer year;
    protected Integer pageCount;

    public Item(String title, Integer year, Integer pageCount) {
        this.title = title;
        this.year = year;
        this.pageCount = pageCount;
    }
}
