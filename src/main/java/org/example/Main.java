package org.example;

public class Main {
    public static void main(String[] args) {
        // Создание массива покупателей (инициализация 2 элементами)
        Buyer[] buyers = new Buyer[2];
        buyers[0] = Buyer.createBuyer("Иванов Иван", 30, "+7 123-456-7890");
        buyers[1] = Buyer.createBuyer("Петров Петр", 25, "+7 987-654-3210");

        // Создание массива товаров (инициализация 5 элементами)
        Product[] products = new Product[5];
        products[0] = Product.createProduct("Ноутбук", 1000.0);
        products[1] = Product.createProduct("Смартфон", 500.0);
        products[2] = Product.createProduct("Наушники", 50.0);
        products[3] = Product.createProduct("Клавиатура", 70.0);
        products[4] = Product.createProduct("Мышь", 30.0);

        // Создание массива заказов (пустой на 5 элементов)
        Order[] orders = new Order[5];

        // Пример создания заказа с помощью статического метода makePurchase
        int quantity = 3;
        orders[0] = Order.makePurchase(buyers[0], products[1], quantity);

        // Пример создания еще одного заказа
        quantity = 1;
        orders[1] = Order.makePurchase(buyers[1], products[3], quantity);

        // Пример вывода информации о заказах
        for (Order order : orders) {
            if (order != null) {
                System.out.println("Заказ от: " + order.getBuyer().getFullName());
                System.out.println("Товар: " + order.getProduct().getName());
                System.out.println("Цена за единицу товара: $" + order.getProduct().getPrice());
                System.out.println("Количество: " + order.getQuantity());
                System.out.println("Общая стоимость заказа: $" + (order.getProduct().getPrice() * order.getQuantity()));
                System.out.println("-----------------------------");
            }
        }
    }
}


