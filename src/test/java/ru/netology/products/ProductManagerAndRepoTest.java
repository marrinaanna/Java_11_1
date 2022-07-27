package ru.netology.products;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerAndRepoTest {
    Repository repo = new Repository();
    ProductManager manager = new ProductManager(repo);
    Book book1 = new Book(11, "Captain's daughter", 200, "Pushkin");
    Smartphone phone1 = new Smartphone(21, "Blue", 10, "Apple");
    Book book2 = new Book(12, "Anna Karenina", 40, "Tolstoy");
    Smartphone phone2 = new Smartphone(22, "A2", 10, "Sumsung");

    @Test
    void managerShouldAddProducts() {
        manager.add(book1);
        manager.add(phone1);
        Product[] actual = manager.getAll();
        Product[] expected = {book1, phone1};
        assertArrayEquals(expected, actual);
    }

    @Test
    void repositoryShouldRemoveProductById() {
        manager.add(book1);
        manager.add(phone1);
        manager.add(book2);
        repo.removeById(21);
        Product[] actual = manager.getAll();
        Product[] expected = {book1, book2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void repositoryShouldNotRemoveProductById() {
        manager.add(book1);
        manager.add(phone1);
        manager.add(book2);
        assertThrows(NotFoundException.class, () -> {
            repo.removeById(0);
        });
    }

    @Test
    void repositoryShouldAddProducts() {
        repo.save(phone1);
        repo.save(phone2);
        Product[] actual = repo.findAll();
        Product[] expected = {phone1, phone2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void managerShouldSearch() {
        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);
        manager.add(phone2);
        Product[] actual = manager.searchBy("s");
        Product[] expected = {book1, book2, phone2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void managerShouldSearchSuper() {
        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);
        manager.add(phone2);
        Product[] actual = manager.searchBy("ue");
        Product[] expected = {phone1};
        assertArrayEquals(expected, actual);
    }

    @Test
    void managerShouldNotSearch() {
        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);
        manager.add(phone2);
        Product[] actual = manager.searchBy("get");
        Product[] expected = {};
        assertArrayEquals(expected, actual);
    }
}
