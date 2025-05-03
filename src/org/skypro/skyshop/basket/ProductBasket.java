package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductBasket {
    private final Map<String, List<Product>> products;

    public ProductBasket() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        String name = product.getName();
        products.computeIfAbsent(name, k -> new ArrayList<>()).add(product);
    }

    private int calculateAndPrintBasketContents(boolean printBasketContents) {
        int total = products.values().stream()
                .flatMap(List::stream)
                .mapToInt(Product::getCost)
                .sum();

        if (printBasketContents) {
            products.values().stream()
                    .flatMap(List::stream)
                    .forEach(product -> System.out.println(product.toString()));

            int specialCount = getSpecialCount();
            if (products.isEmpty()) {
                System.out.println("в корзине пусто");
            } else {
                System.out.println("Итого: " + total);
                System.out.println("Специальных товаров: " + specialCount);
            }
        }
        return total;
    }

    public void printBasket() {
        calculateAndPrintBasketContents(true);
    }

    public int getTotalCost() {
        return calculateAndPrintBasketContents(false);
    }

    public boolean checkProductByName(String name) {
        return products.containsKey(name);
    }

    public void clearBasket() {
        products.clear();
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = products.remove(name);
        return removedProducts != null ? removedProducts : new ArrayList<>();
    }

    private int getSpecialCount() {
        return (int) products.values().stream()
                .flatMap(List::stream)
                .filter(Product::isSpecial)
                .count();
    }
}
