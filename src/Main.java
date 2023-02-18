import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String purchase;

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> list = new ArrayList<>();

        while (true) {
            System.out.println("Выберите операцию:");
            System.out.println("1. Операция добавить");
            System.out.println("2. Операция показать");
            System.out.println("3. Операция удалить");
            System.out.println("4. Введите текст для поиска:");

            purchase= scanner.nextLine();

            if (purchase.equalsIgnoreCase("end")) {
                break;
            } else {
                switch (purchase) {
                    case ("1"): {
                        System.out.println("Какую покупку хотите добавить?");
                        purchase = scanner.nextLine();
                        list.add(purchase);
                        System.out.println("Итого в списке покупок: " + list.size());
                        break;
                    }
                    case ("2"): {
                        show(list);
                        break;
                    }
                    case ("3"): {
                        System.out.println("Какую хотите удалить? Введите номер или название");
                        show(list);
                        purchase = scanner.nextLine();
                        try {
                            list.remove(Integer.parseInt(purchase) - 1);
                        } catch (NumberFormatException e) {
                            for (int i = 0; i < list.size(); i++) {
                                if (list.get(i).equalsIgnoreCase(purchase)) {
                                    list.remove(i);
                                    System.out.println("Пункт покупки удален!");
                                } else {
                                    System.out.println("Такой элемент не найден!");
                                }
                            }
                        }
                        show(list);
                        break;
                    }
                    case ("4"): {
                        System.out.println("Введите текст для поиска:");
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
                        break;
                    }
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
