package ru.netology.products;

public class Repository {
    private Product[] goods = new Product[0];

    public void save(Product product) {
        Product[] tmp = new Product[goods.length + 1];
        for (int i = 0; i < goods.length; i++) {
            tmp[i] = goods[i];
        }
        tmp[tmp.length - 1] = product;
        goods = tmp;
    }

    public Product[] findAll() {
        return goods;
    }

    public Product findById(int id) {
        for (Product product : goods) {
            if (product.getById() == id) {
                return product;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        Product[] tmp = new Product[goods.length - 1];
        int i = 0;
        for (Product good : goods) {
            if (good.getById() != id) {
                tmp[i] = good;
                i++;
            }
        }
        goods = tmp;
    }

}

