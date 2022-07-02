package ru.netology.repository;

import ru.netology.product.Product;

public class ProductRepository {
    private Product[] items = new Product[0];

    public void addProducts(Product product) {
        Product[] tmp = new Product[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = product;
        items = tmp;
    }

    public void removeProductsById(int id) {
        Product[] tmp = new Product[items.length - 1];
        int copyToIndex = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        items = tmp;
    }

    public Product[] getAddProducts() {
        return items;
    }
}