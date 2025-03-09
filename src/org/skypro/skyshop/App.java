package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        SimpleProduct bread = new SimpleProduct("Хлеб", 50);
        DiscountedProduct milk = new DiscountedProduct("Молоко", 75, 10);
        FixPriceProduct cheese = new FixPriceProduct("Сыр");
        SimpleProduct eggs = new SimpleProduct("Яйца", 120);
        SimpleProduct butter = new SimpleProduct("Масло", 180);

        basket.addProduct(bread);
        basket.addProduct(milk);
        basket.addProduct(cheese);
        basket.addProduct(eggs);
        basket.addProduct(butter);

        basket.printBasket();
        basket.getTotalCost();

        SearchEngine searchEngine = new SearchEngine(10);
        searchEngine.add(bread);
        searchEngine.add(milk);
        searchEngine.add(cheese);
        searchEngine.add(eggs);
        searchEngine.add(butter);

        Article cookingArticle = new Article("Кулинария", "Советы по приготовлению вкусных блюд");
        Article healthArticle = new Article("Здоровое питание", "Молочные продукты полезны для здоровья");
        Article bakingArticle = new Article("Выпечка", "Как испечь хлеб в домашних условиях");

        searchEngine.add(cookingArticle);
        searchEngine.add(healthArticle);
        searchEngine.add(bakingArticle);

        System.out.println("\nПоиск по запросу 'Молоко':");
        printSearchResults(searchEngine.search("Молоко"));

        System.out.println("\nПоиск по запросу 'Хлеб':");
        printSearchResults(searchEngine.search("Хлеб"));

        System.out.println("\nПоиск по запросу 'питание':");
        printSearchResults(searchEngine.search("питание"));

        System.out.println("\nПоиск по запросу 'о':");
        printSearchResults(searchEngine.search("о"));
    }

    private static void printSearchResults(Searchable[] results) {
        for (Searchable item : results) {
            if (item != null) {
                System.out.println(item.getStringRepresentation());
            }
        }
    }
}