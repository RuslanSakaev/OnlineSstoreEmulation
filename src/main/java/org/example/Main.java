package org.example;

import exceptions.AmountException;
import exceptions.CustomerException;
import exceptions.ProductException;

public class Main {
    public static void main(String[] args) throws ProductException, AmountException {
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

        // Пример вызова метода совершения покупки несколько раз с обработкой исключений в заданном порядке
        int quantity = 3;
        try {
            // Передаем неверный товар, должно вывести сообщение об ошибке
            orders[0] = Order.makePurchase(buyers[0], null, quantity);
        } catch (ProductException e) {
            System.out.println("Ошибка при создании заказа: " + e.getMessage());
        } catch (AmountException | CustomerException e) {
            // Ничего не делаем, так как это не ошибка связанная с неверным товаром
        }

        // Пример создания еще одного заказа с неверным количеством
        quantity = -5; // Передаем недопустимое количество товара
        try {
            orders[1] = Order.makePurchase(buyers[1], products[3], quantity);
        } catch (ProductException e) {
            System.out.println("Ошибка при создании заказа: " + e.getMessage());
        } catch (AmountException e) {
            System.out.println("Ошибка при создании заказа: " + e.getMessage() + ". Покупка будет совершена в количестве 1.");
            try {
                // Покупка в количестве 1, так как было передано неверное количество
                orders[1] = Order.makePurchase(buyers[1], products[3], 1);
            } catch (CustomerException ex) {
                System.out.println("Ошибка при создании заказа: " + ex.getMessage());
                System.exit(1); // Выход из программы с кодом ошибки 1
            }
        } catch (CustomerException e) {
            System.out.println("Ошибка при создании заказа: " + e.getMessage());
            System.exit(1); // Выход из программы с кодом ошибки 1
        }

        // Пример создания еще одного заказа с неверным пользователем
        quantity = 2;
        try {
            // Передаем неверного пользователя, должно вызвать исключение
            orders[2] = Order.makePurchase(null, products[1], quantity);
        } catch (ProductException | AmountException e) {
            System.out.println("Ошибка при создании заказа: " + e.getMessage());
        } catch (CustomerException e) {
            System.out.println("Ошибка при создании заказа: " + e.getMessage());
            System.exit(1); // Выход из программы с кодом ошибки 1
        }

        // Пример создания еще одного заказа с верными данными
        quantity = 2;
        try {
            orders[3] = Order.makePurchase(buyers[0], products[1], quantity);
        } catch (ProductException | AmountException | CustomerException e) {
            // Ничего не делаем, так как это не ошибка связанная с неверным товаром, количеством или пользователем
        }

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
        // Подсчет и вывод итогового количества совершенных покупок
        int totalPurchases = 0;
        for (Order order : orders) {
            if (order != null) {
                totalPurchases++;
            }
        }
        System.out.println("Итоговое количество совершенных покупок: " + totalPurchases);
    }
}



