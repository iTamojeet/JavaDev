import com.example.SearchEngine;

void main() {
    var engine = new SearchEngine();
    String choice;

    do {
        IO.println("\n===== Google Search Simulation =====");
        IO.println("1. Add Search Data");
        IO.println("2. Search Keyword");
        IO.println("3. Delete Keyword");
        IO.println("4. Display All");
        IO.println("5. Custom Sorting");
        IO.println("6. Exit");
        IO.print("Enter your choice: ");
        choice = IO.readln();

        try {
            switch (choice) {
                case "1" -> {
                    IO.print("Enter search keyword: ");
                    String keyword = IO.readln();
                    IO.print("Enter number of results: ");
                    int n = Integer.parseInt(IO.readln());
                    var results = new java.util.ArrayList<String>();
                    for (int i = 1; i <= n; i++) {
                        IO.print("Enter result URL " + i + ": ");
                        results.add(IO.readln());
                    }
                    engine.addSearch(keyword, results);
                    IO.println("Search results added successfully.");
                }
                case "2" -> {
                    IO.print("Enter keyword to search: ");
                    String keyword = IO.readln();
                    var results = engine.search(keyword);
                    if (results != null) {
                        IO.println("Results for " + keyword + ":");
                        results.forEach(url -> IO.println(" - " + url));
                    } else {
                        IO.println("No results found for: " + keyword);
                    }
                }
                case "3" -> {
                    IO.print("Enter keyword to delete: ");
                    String keyword = IO.readln();
                    if (engine.delete(keyword)) {
                        IO.println("Keyword deleted successfully.");
                    } else {
                        IO.println("Keyword not found.");
                    }
                }
                case "4" -> {
                    if (engine.isEmpty()) {
                        IO.println("No data available.");
                    } else {
                        IO.println("All Stored Search Data:");
                        engine.getAll().forEach((k, v) -> {
                            IO.println("Keyword: " + k);
                            v.forEach(url -> IO.println(" - " + url));
                        });
                    }
                }
                case "5" -> {
                    if (engine.isEmpty()) {
                        IO.println("No data to sort.");
                    } else {
                        IO.println("1. Sort by Keyword (Alphabetical)");
                        IO.println("2. Sort by Number of Results (Descending)");
                        IO.print("Enter choice: ");
                        String sortChoice = IO.readln();
                        if (sortChoice.equals("1")) {
                            engine.getAll().forEach((k, v) -> {
                                IO.println("Keyword: " + k);
                                v.forEach(url -> IO.println(" - " + url));
                            });
                        } else if (sortChoice.equals("2")) {
                            var sorted = engine.sortByResultCountDesc();
                            sorted.forEach(entry -> {
                                IO.println("Keyword: " + entry.getKey() + " (Results: " + entry.getValue().size() + ")");
                                entry.getValue().forEach(url -> IO.println(" - " + url));
                            });
                        } else {
                            IO.println("Invalid choice.");
                        }
                    }
                }
                case "6" -> IO.println("Exiting ... Goodbye!");
                default -> IO.println("Invalid choice, please try again.");
            }
        } catch (Exception e) {
            IO.println("Error: " + e.getMessage());
        }
    } while (!choice.equals("6"));
}
