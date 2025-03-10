package fr.ensai.library;

public class Magazine extends Item {
    private String issn;
    private String issueNumber;

    public Magazine(String issn, String title, String issueNumber, int year, int pageCount) {
        super(title, year, pageCount);
        this.issn = issn;
        this.issueNumber = issueNumber;
    }

    @Override
    public String toString() {
        return "Magazine " + title;
    }
}
