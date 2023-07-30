package org.example;

import exceptions.AmountException;
import exceptions.CustomerException;
import exceptions.ProductException;

public class Main {
    public static void main(String[] args) {
        // Создание массива покупателей
        Buyer[] buyers = new Buyer[5];
        buyers[0] = Buyer.createBuyer("Иванов Иван Иванович", 30, "+7 123-456-7890");
        buyers[1] = Buyer.createBuyer("Петров Петр Семёнович", 25, "+7 987-654-3210");
        buyers[2] = Buyer.createBuyer("Николаев Иван Васильевич", 50, "+7 987-654-3210");
        buyers[3] = Buyer.createBuyer("Гаврилов Лев Николавеич", 43, "+7 987-654-3210");
        buyers[4] = Buyer.createBuyer("Семенова Анна Владимировна", 26, "+7 987-654-3210");

        // Создание массива товаров
        Product[] products = new Product[5];
        products[0] = Product.createProduct("Ноутбук", 1000.0);
        products[1] = Product.createProduct("Смартфон", 500.0);
        products[2] = Product.createProduct("Наушники", 50.0);
        products[3] = Product.createProduct("Клавиатура", 70.0);
        products[4] = Product.createProduct("Мышь", 30.0);

        // Создание массива заказов
        Order[] orders = new Order[5];

        // Вызов метода совершения покупки несколько раз и заполнение массива покупок возвращаемыми значениями
        try {
            orders[0] = makePurchase(buyers[0], products[1], 3);
            orders[1] = makePurchase(buyers[1], products[3], 5);
            orders[2] = makePurchase(buyers[4], products[1], 2);
            orders[3] = makePurchase(buyers[3], products[2], 2);
            orders[4] = makePurchase(buyers[3], products[2], 2);
        } catch (ProductException | AmountException | CustomerException e) {
            System.out.println("Ошибка при создании заказа: " + e.getMessage());
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

    public static Order makePurchase(Buyer buyer, Product product, int quantity) throws ProductException, AmountException, CustomerException {
        if (product == null) {
            throw new ProductException("Товар не найден.");
        }

        if (quantity <= 0 || quantity > 10) {
            throw new AmountException("Неверное количество товара.");
        }

        if (buyer == null) {
            throw new CustomerException("Пользователь не найден.");
        }

        return new Order(buyer, product, quantity);
    }
}



