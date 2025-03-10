package fr.ensai.library;

public class Main {

    public static void main(String[] args) {

        Author tolkien = new Author("J.R.R. Tolkien", 81, "UK");
        String csvFilePath = "books.csv";

        Book fellowshipOfTheRing = new Book(
                "978-0-618-26025-6",
                "The Fellowship of the Ring",
                tolkien,
                1954,
                423);

        Magazine svj = new Magazine("10145ef", "Science et vie junior", "138", 2020, 0);
        Magazine imagedoc = new Magazine("10355ht", "Images doc", "528", 2023, 0);

        System.out.println(fellowshipOfTheRing.toString());

        Library bibliotheque = new Library("Ma Bibliothèque", null);
        bibliotheque.loadItemsFromCSV(csvFilePath);
        bibliotheque.addItem(svj);
        bibliotheque.addItem(imagedoc);

        bibliotheque.displayItems();

    }
}