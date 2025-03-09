package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;
import org.skypro.skyshop.search.BestResultNotFound;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        SimpleProduct bread = new SimpleProduct("Хлеб", 50);
        try {
            SimpleProduct emptyNameProduct = new SimpleProduct("", 50);
            System.out.println("Created: " + emptyNameProduct);
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating SimpleProduct: " + e.getMessage());
        }

        try {
            DiscountedProduct nullNameProduct = new DiscountedProduct(null, 75, 10);
            System.out.println("Created: " + nullNameProduct);
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating DiscountedProduct: " + e.getMessage());
        }
        try {
            SimpleProduct invalidBread = new SimpleProduct("Хлеб", 0);
            System.out.println("Created: " + invalidBread);
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating SimpleProduct: " + e.getMessage());
        }
        DiscountedProduct milk = new DiscountedProduct("Молоко", 75, 10);
        try {
            DiscountedProduct invalidMilk1 = new DiscountedProduct("Молоко", -10, 20);
            System.out.println("Created: " + invalidMilk1);
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating DiscountedProduct: " + e.getMessage());
        }
        try {
            DiscountedProduct invalidMilk2 = new DiscountedProduct("Молоко", 100, 110);
            System.out.println("Created: " + invalidMilk2);
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating DiscountedProduct: " + e.getMessage());
        }
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

        try {
            Searchable bestMatch = searchEngine.findBestMatch("Молоко");
            System.out.println("Best match found: " + bestMatch.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            Searchable bestMatch = searchEngine.findBestMatch("Не существующий продукт");
            System.out.println("Best match found: " + bestMatch.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    private static void printSearchResults(Searchable[] results) {
        for (Searchable item : results) {
            if (item != null) {
                System.out.println(item.getStringRepresentation());
            }
        }
    }
}