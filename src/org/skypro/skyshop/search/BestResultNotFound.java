package org.skypro.skyshop.search;

public class BestResultNotFound extends RuntimeException {
    public BestResultNotFound(String searchString) {
        super("Результатов не найдено для поискового запроса: " + searchString);
    }
}
