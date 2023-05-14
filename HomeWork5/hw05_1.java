package HomeWork5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что один человек может иметь несколько телефонов.
 */


public class hw05_1 {
    public static void main(String[] args) {
        Map<String, List<String>> phonBook = new HashMap<>();
        phonBook.put("Denis", List.of("+ 375 29 657 44 78", "+ 375 29 555 44 78"));
        phonBook.put("Sergey", List.of("+ 375 29 997 90 56", "+ 375 29 407 44 78"));
        phonBook.put("Alex", List.of("+ 375 33 657 54 78", "+ 375 29 235 12 78"));
        phonBook.put("Marina", List.of("+ 375 25 457 00 34", "+ 375 29 657 33 11"));
        phonBook.put("Oleg", List.of("+ 375 29 100 04 66", "+ 375 29 888 44 99"));

        menu(phonBook);

    }

    public static String scanner() {
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        // scanner.close();
        return scan;
    }

    public static void find(Map<String, List<String>> phonBook) {
        System.out.println("Введите имя: ");
        String name = scanner();
        System.out.println(phonBook.get(name));
    }

    public static void allBook(Map<String, List<String>> phonBook) {
        System.out.println(phonBook);

    }

    public static Map<String, List<String>> add(Map<String, List<String>> phonBook) {
        System.out.println("Если хотите выйте хотите перестать вводить номера введите 'stop'");
        System.out.println("Введите имя: ");
        String name = scanner();
        List<String> number = new ArrayList<>();
        while (true) {
            System.out.println("Введите номер: ");
            String phon = scanner();
            if (phon.equals("stop")) {
                break;
            } else {
                number.add(phon);
            }
        }
        phonBook.put(name, number);

        return phonBook;
    }

    public static Map<String, List<String>> menu(Map<String, List<String>> phonBook) {
        System.out.println(
                "Введите команду из списка: find - найти контакт, add - добавить контакт, all - показать всю телефонную книгу, exit - выйти");
        while (true) {
            String comands = scanner();
            if (comands.equals("exit")) {
                break;
            } else {
                switch (comands) {
                    case "find":
                        find(phonBook);
                        break;
                    case "add":
                        add(phonBook);
                        break;
                    case "all":
                        allBook(phonBook);
                        break;
                    default:
                        break;
                }
            }
        }
        return phonBook;
    }
}