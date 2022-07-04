package ru.netology.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductManager;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {
    ProductManager manager = new ProductManager(new ProductRepository());
    Product item1 = new Product(10, "Код Да Винчи", 1_000);
    Product item2 = new Product(11, "Ангелы и Демоны", 1_100);
    Product item3 = new Product(12, "Инферно", 1_200);
    Product item4 = new Product(13, "Xiaomi", 10_000);

    @Test
    public void shouldAddNewProducts() {                            // Добавление новых товаров

        manager.addNewProducts(item1);
        manager.addNewProducts(item2);
        manager.addNewProducts(item3);
        manager.addNewProducts(item4);

        Product[] expected = {item1, item2, item3, item4};
        Product[] actual = manager.getAddProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveProducts() {                           // Добавление и удаление новых товаров

        manager.addNewProducts(item1);
        manager.addNewProducts(item2);
        manager.addNewProducts(item3);
        manager.addNewProducts(item4);
        manager.removeProductsById(item1.getId());

        Product[] expected = {item2, item3, item4};
        Product[] actual = manager.getAddProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchItemBookByName() {     // Поиск товара (книги) в корзине по наименованию (товар в корзине)

        manager.addNewProducts(item1);
        manager.addNewProducts(item2);
        manager.addNewProducts(item3);
        manager.addNewProducts(item4);

        Product[] expected = {item3};
        Product[] actual = manager.searchBy("Инферно");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchItemSmartphoneByName() {    // Поиск товара (cмартфона) в корзине по наименованию (товар в корзине)

        manager.addNewProducts(item1);
        manager.addNewProducts(item2);
        manager.addNewProducts(item3);
        manager.addNewProducts(item4);
        manager.searchBy("Xiaomi");

        Product[] expected = {item4};
        Product[] actual = manager.searchBy("Xiaomi");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchItemByNameIfItemEmpty() {    // Поиск товара в корзине по наименованию (товара нет в корзине)

        Product[] expected = {};
        Product[] actual = manager.searchBy("Утраченный символ");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchItemNameIfItem1() {            // Поиск товара которого нет в корзине (в корзине один товар)

        manager.addNewProducts(item1);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Утраченный символ");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchItemNameIfItem3() {            // Поиск товара которого нет в корзине (в корзине несколько товаров)

        manager.addNewProducts(item1);
        manager.addNewProducts(item2);
        manager.addNewProducts(item3);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Утраченный символ");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchItemNameIfSeveral() {           // Поиск нескольких одинаковых товаров в корзине

        manager.addNewProducts(item1);
        manager.addNewProducts(item2);
        manager.addNewProducts(item3);
        manager.addNewProducts(item1);

        Product[] expected = {item1, item1};
        Product[] actual = manager.searchBy("Код Да Винчи");

        Assertions.assertArrayEquals(expected, actual);
    }

}

