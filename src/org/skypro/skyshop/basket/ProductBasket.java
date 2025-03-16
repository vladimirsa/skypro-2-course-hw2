package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class ProductBasket {
    private final List<Product> products;

    public ProductBasket() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    private int calculateAndPrintBasketContents(boolean printBasketContents) {
        int total = 0;
        int specialCount = 0;
        int count = 0;
        for (Product product : products) {
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
        for (Product product : products) {
            if (product != null && product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        products.clear();
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name)) {
                removedProducts.add(product);
                iterator.remove();
            }
        }

        return removedProducts;
    }
}
