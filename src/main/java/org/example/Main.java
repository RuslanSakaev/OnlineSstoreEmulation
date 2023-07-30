package org.example;

public class Main {
    public static void main(String[] args) {
        // Создание покупателя
        Buyer buyer = new Buyer("Иванов Иван", 30, "+7 123-456-78-90");

        // Создание товара
        Product product = new Product("Ноутбук", 1000.0);

        // Создание заказа
        int quantity = 2;
        Order order = new Order(buyer, product, quantity);

        // Вывод информации о заказе
        System.out.println("Заказ от: " + order.getBuyer().getFullName());
        System.out.println("Товар: " + order.getProduct().getName());
        System.out.println("Цена за единицу товара: $" + order.getProduct().getPrice());
        System.out.println("Количество: " + order.getQuantity());
        System.out.println("Общая стоимость заказа: $" + (order.getProduct().getPrice() * order.getQuantity()));
    }
}
