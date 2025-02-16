package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        basket.addProduct(new Product("Хлеб", 50));
        basket.addProduct(new Product("Молоко", 75));
        basket.addProduct(new Product("Сыр", 200));
        basket.addProduct(new Product("Яйца", 120));
        basket.addProduct(new Product("Масло", 180));

        basket.addProduct(new Product("Сок", 100));

        basket.printBasket();

        basket.getTotalCost();

        System.out.println("Корзина содержит 'Молоко'?: " + basket.checkProductByName("Молоко"));

        System.out.println("Корзина содержит 'Рис'?: " + basket.checkProductByName("Рис"));

        basket.clearBasket();

        basket.printBasket();

        System.out.println("Итого (пустая корзина): " + basket.getTotalCost());

        System.out.println("Корзина содержит 'Молоко' (пустая корзина)?: " + basket.checkProductByName("Молоко"));
    }
}