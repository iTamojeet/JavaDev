package com.example;
import java.util.*;
public class SearchEngine {
    private final TreeMap<String, List<String>> searchDB = new TreeMap<>();

    public void addSearch(String keyword, List<String> results) throws Exception {
        if (keyword == null || keyword.isBlank()) {
            throw new IllegalArgumentException("Keyword cannot be empty!");
        }
        searchDB.put(keyword.trim(), results);
    }

    public List<String> search(String keyword) {
        return searchDB.getOrDefault(keyword.trim(), null);
    }

    public boolean delete(String keyword) {
        return searchDB.remove(keyword.trim()) != null;
    }

    public Map<String, List<String>> getAll() {
        return searchDB;
    }

    public List<Map.Entry<String, List<String>>> sortByResultCountDesc() {
        var list = new ArrayList<>(searchDB.entrySet());
        list.sort((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()));
        return list;
    }

    public boolean isEmpty() {
        return searchDB.isEmpty();
    }
}

