package ru.netology.repository;

import ru.netology.product.Product;

public class ProductManager {
    private final ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void addNewProducts(Product product) {
        repository.addProducts(product);
    }

    public void removeProductsById(int id) {
        repository.removeProductsById(id);
    }

    public Product[] getAddProducts() {
        return repository.getAddProducts();
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[1];
        for (Product product : repository.getAddProducts()) {
            if (matches(product, text)) {
                result[0] = product;
                return result;
            } else {
                result[0] = null;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
