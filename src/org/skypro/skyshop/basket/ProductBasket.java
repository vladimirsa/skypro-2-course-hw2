package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        int total = 0;
        int specialCount = 0;
        int count = 0;

        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                if (product != null) {
                    total += product.getCost();
                    if (printBasketContents) {
                        System.out.println(product.toString());
                    }
                    if (product.isSpecial()) {
                        specialCount++;
                    }
                    count++;
                }
            }
        }

        if (printBasketContents) {
            if (count == 0) {
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
}
