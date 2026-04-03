package org.example;

import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private final String title;

    public Task(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}

public class Main {
    // Создаем список и сканер как статические переменные, чтобы они были доступны везде
    private static final ArrayList<Task> tasks = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Цикл программы
        while (true) {
            System.out.println("\n--- Меню ---");
            System.out.println("1. Показать задачи");
            System.out.println("2. Добавить задачу");
            System.out.println("3. Удалить задачу");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");

            // Читаем ввод пользователя
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
                showTasks();
            } else if (choice == 2) {
                addTask();
            } else if (choice == 3) {
                deleteTask();
            } else if (choice == 0) {
                System.out.println("Выход...");
                break;
            } else {
                System.out.println("Неверный выбор!");
            }
        }
    }

    // Метод для просмотра задач
    private static void showTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Список пуст.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    // Метод для добавления
    private static void addTask() {
        System.out.print("Введите название задачи: ");
        String title = scanner.nextLine();
        tasks.add(new Task(title));
        System.out.println("Задача добавлена.");
    }

    // Метод для удаления
    private static void deleteTask() {
        showTasks();
        if (tasks.isEmpty()) return;
        System.out.print("Введите номер задачи для удаления: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Задача удалена.");
        } else {
            System.out.println("Неверный номер.");
        }
    }
}
