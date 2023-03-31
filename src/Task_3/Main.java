package Task_3;

/*
В калькулятор добавьте возможность отменить последнюю операцию.
*/

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList<Double> results = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        results.add(sc.nextDouble());
        sc.nextLine();

        while(true) {
            System.out.print("Выбрать оператор (+, -, *, /, Отменить): ");
            String op = sc.nextLine();

            if ("".equals(op)) break;
            else if ("Отменить".equals(op) || "отменить".equals(op)) {
                results.removeFirst();

                if (results.size() == 0) results.add(0.0);
            }
            else {
                System.out.print("Введите второе число: ");
                double secNumber = sc.nextDouble();

                process(results, op, secNumber);
                sc.nextLine();
            }

            System.out.println("Результат: " + results.getFirst());
        }

        sc.close();
    }


    public static void process(LinkedList<Double> list, String op, double number) {
        switch (op) {
            case "+" -> list.add(0, list.getFirst() + number);
            case "-" -> list.add(0, list.getFirst() - number);
            case "*" -> list.add(0, list.getFirst() * number);
            case "/" -> {
                if (number == 0) {
                    System.out.println("не делится на 0!");
                    break;
                }
                list.add(0, list.getFirst() / number);
            }
            default -> System.out.println("Неправильный оператор!");
        }
    }
}