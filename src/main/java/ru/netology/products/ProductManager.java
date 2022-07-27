package ru.netology.products;

public class ProductManager {
    private Repository repo;

    public ProductManager(Repository repo) {
        this.repo = repo;
    }

    public void add(Product good) {
        repo.save(good);
    }

    public Product[] getAll() {
        Product[] result = repo.findAll();
        return result;
    }

    public Product[] searchBy(String search) {
        Product[] result = new Product[0];
        for (Product good : repo.findAll()) {
            if (good.matches(search)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = good;
                result = tmp;
            }
        }
        return result;
    }

}
