package ru.netology.products;

public class Smartphone extends Product {
    private String madeBy;

    public Smartphone(int id, String name, int cost, String madeBy) {
        super(id, name, cost);
        this.madeBy = madeBy;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        if (madeBy.contains(search)) {
            return true;
        }
        return false;
    }
}
