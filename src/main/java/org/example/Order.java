package org.example;

import exceptions.AmountException;
import exceptions.CustomerException;
import exceptions.ProductException;

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
    public static Order makePurchase(Buyer buyer, Product product, int quantity) throws CustomerException, ProductException, AmountException {
        // Проверяем, что переданный покупатель существует
        if (buyer == null) {
            throw new CustomerException("Несуществующий покупатель!");
        }

        // Проверяем, что переданный товар существует
        if (product == null) {
            throw new ProductException("Несуществующий товар!");
        }

        // Проверяем, что количество товара неотрицательное и не слишком большое
        if (quantity <= 0 || quantity > 10) { // В данном примере ограничим до 10 для демонстрации
            throw new AmountException("Недопустимое количество товара!");
        }

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

