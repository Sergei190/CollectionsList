import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static String purchase;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> list = new ArrayList<>();

        while (true) {
            mainMenu(scanner);

            if (purchase.equalsIgnoreCase("end")) {
                break;
            } else {
                switch (purchase) {
                    case ("1"): {
                        itemToBuy(scanner, list);
                        break;
                    }
                    case ("2"): {
                        show(list);
                        break;
                    }
                    case ("3"): {
                        deleteItem(scanner, list);
                        show(list);
                        break;
                    }
                    case ("4"): {
                        findItem(scanner, list);
                        break;
                    }

                }
            }
        }
    }

    private static void mainMenu(Scanner scanner) {
        System.out.println("Выберите операцию или ведите end для завершения:");
        System.out.println("1. Операция добавить");
        System.out.println("2. Операция показать");
        System.out.println("3. Операция удалить");
        System.out.println("4. Операция найти");

        purchase = scanner.nextLine();
    }

    private static void deleteItem(Scanner scanner, ArrayList<String> list) {
        System.out.println("Какую хотите удалить? Введите название покупки");
        show(list);
        purchase = scanner.nextLine();
        try {
            list.remove(Integer.parseInt(purchase) - 1);
        } catch (NumberFormatException e) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equalsIgnoreCase(purchase)) {
                    list.remove(i);
                    System.out.println("Покупка удалена, список покупок:");
                }
            }
        }
    }


    private static void itemToBuy(Scanner scanner, ArrayList<String> list) {
        System.out.println("Какую покупку хотите добавить?");
        purchase = scanner.nextLine();
        list.add(purchase);
        System.out.println("Итого в списке покупок: " + list.size());
    }

    private static void findItem(Scanner scanner, ArrayList<String> list) {
        System.out.println("Введите текст для поиска: ");
        purchase = scanner.nextLine();
        try {
            System.out.println("Найдено: " + purchase + ". " + list.get(Integer.parseInt(purchase) - 1));
        } catch (NumberFormatException e) {
            String lowerCase;
            String scanLow = purchase.toLowerCase();
            for (int i = 0; i < list.size(); i++) {
                lowerCase = list.get(i).toLowerCase();
                if (lowerCase.contains(scanLow)) {
                    System.out.println((list.indexOf(list.get(i)) + 1) + ". " + list.get(i));
                }
            }
        }
    }

    public static void show(ArrayList<String> list) {
        for (String i : list) {
            System.out.println(list.indexOf(i) + 1 + ". " + i);
        }
    }
}
