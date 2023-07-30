package org.example;

public class Order {
    private Buyer buyer;
    private Product product;
    private int quantity;

    public Order(Buyer buyer, Product product, int quantity) {
        this.buyer = buyer;
        this.product = product;
        this.quantity = quantity;
    }

    // Статический метод для совершения покупки и создания объекта Order
    public static Order makePurchase(Buyer buyer, Product product, int quantity) {
        return new Order(buyer, product, quantity);
    }

    // Геттеры и сеттеры

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

