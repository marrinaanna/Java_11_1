package ru.netology.products;
public class Book extends Product{
    private String author;
    public Book(int id, String name, int cost, String author){
        super(id, name, cost);
        this.author=author;
    }
    @Override
    public boolean matches(String search){
        if(super.matches(search)){
            return true;
        }
        if(author.contains(search)){
            return true;
        }
        return false;
    }
}
