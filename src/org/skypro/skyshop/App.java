package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        basket.addProduct(new SimpleProduct("Хлеб", 50));
        basket.addProduct(new DiscountedProduct("Молоко", 75, 10));
        basket.addProduct(new FixPriceProduct("Сыр"));
        basket.addProduct(new SimpleProduct("Яйца", 120));
        basket.addProduct(new SimpleProduct("Масло", 180));


        basket.printBasket();

        basket.getTotalCost();
    }
}