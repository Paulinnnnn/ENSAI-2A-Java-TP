package fr.ensai.library;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private String name;
    private List<Item> items;

    public Library(String name, List<Item> items) {
        this.name = name;
        this.items = (items != null) ? new ArrayList<Item>(items) : new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void displayItems() {
        if (items.size() > 0) {
            for (Item livre : items) {
                System.out.println(livre.toString());
            }
        } else {
            System.out.println("Pas de livre, désolé !");
        }
    }

    /**
     * Loads items from a CSV file and adds them to the library.
     * 
     * @param filePath The path to the CSV file containing item data.
     * @throws IOException If there is an error reading the file, an
     *                     {@link IOException} will be thrown.
     */
    public void loadItemsFromCSV(String filePath) {

        URL url = getClass().getClassLoader().getResource(filePath);

        try (BufferedReader br = new BufferedReader(new FileReader(url.getFile()))) {
            Map<String, Author> authors = new HashMap<>();
            String line;
            br.readLine(); // Skip the header line

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length == 5) {
                    String isbn = data[0].trim();
                    String title = data[1].trim();
                    String authorName = data[2].trim();
                    int year = Integer.parseInt(data[3].trim());
                    int pageCount = Integer.parseInt(data[4].trim());

                    // Check if author already exists in the map
                    Author author = authors.get(authorName);
                    if (author == null) {
                        author = new Author(authorName);
                        authors.put(authorName, author);
                        System.out.println(author.toString());
                    }
                    Item item = new Book(isbn, title, author, year, pageCount);

                    this.addItem(item);
                }
            }
        } catch (

        IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
