package org.skypro.skyshop.search;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Comparator;

public class SearchEngine {
    private final Set<Searchable> items;

        public SearchEngine() {
            this.items = new HashSet<>();
        }

    public void add(Searchable item) {
        items.add(item);
    }

    public SortedSet<Searchable> search(String query) {
        SortedSet<Searchable> results = new TreeSet<>(new SearchableComparator());

        for (Searchable item : items) {
            if (item.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results.add(item);
            }
        }

        return results;
    }

    public Searchable findBestMatch(String search) {
        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable item : items) {
            int count = countOccurrences(item.getSearchTerm().toLowerCase(), search.toLowerCase());
            if (count > maxCount) {
                maxCount = count;
                bestMatch = item;
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound(search);
        }

        return bestMatch;
    }

    private int countOccurrences(String str, String substring) {
        int count = 0;
        int index = 0;
        while ((index = str.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }
        return count;
    }

    private static class SearchableComparator implements Comparator<Searchable> {
        @Override
        public int compare(Searchable s1, Searchable s2) {
            int lengthComparison = Integer.compare(s2.getSearchTerm().length(), s1.getSearchTerm().length());
            if (lengthComparison != 0) {
                return lengthComparison;
            }
            return s1.getSearchTerm().compareTo(s2.getSearchTerm());
        }
    }


}
