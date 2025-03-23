package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {
    private final String name;

    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя продукта не может быть null или пустым");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getCost();

    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return name + ": " + getCost();
    }

    @Override
    public String getSearchTerm() {
        return getName();
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
