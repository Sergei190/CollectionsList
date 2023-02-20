import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String purchase;

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> list = new ArrayList<>();

        while (true) {
            getPrintln("Выберите операцию:");
            getPrintln("1. Операция добавить");
            getPrintln("2. Операция показать");
            getPrintln("3. Операция удалить");
            getPrintln("4. Введите текст для поиска:");

            purchase= scanner.nextLine();

            if (purchase.equalsIgnoreCase("end")) {
                break;
            } else {
                switch (purchase) {
                    case ("1"): {
                        getPrintln("Какую покупку хотите добавить?");
                        purchase = scanner.nextLine();
                        list.add(purchase);
                        getPrintln("Итого в списке покупок: " + list.size());
                        break;
                    }
                    case ("2"): {
                        show(list);
                        break;
                    }
                    case ("3"): {
                        getPrintln("Какую хотите удалить? Введите номер или название");
                        show(list);
                        purchase = scanner.nextLine();
                        try {
                            list.remove(Integer.parseInt(purchase) - 1);
                        } catch (NumberFormatException e) {
                            for (int i = 0; i < list.size(); i++) {
                                if (list.get(i).equalsIgnoreCase(purchase)) {
                                    list.remove(i);
                                    getPrintln("Пункт покупки удален!");
                                } else {
                                    getPrintln("Такой элемент не найден!");
                                }
                            }
                        }
                        show(list);
                        break;
                    }
                    case ("4"): {
                        getPrintln("Введите текст для поиска:");
                        purchase = scanner.nextLine();
                        try {
                            getPrintln("Найдено: " + purchase + ". " + list.get(Integer.parseInt(purchase) - 1));
                        } catch (NumberFormatException e) {
                            String lowerCase;
                            String scanLow = purchase.toLowerCase();
                            for (int i = 0; i < list.size(); i++) {
                                lowerCase = list.get(i).toLowerCase();
                                if (lowerCase.contains(scanLow)) {
                                    getPrintln((list.indexOf(list.get(i)) + 1) + ". " + list.get(i));
                                }
                            }
                        }
                        break;
                    }
                }
            }
        }
    }

    private static void getPrintln(String x) {
        System.out.println(x);
    }

    public static void show(ArrayList<String> list) {
        for (String i : list) {
            getPrintln(list.indexOf(i) + 1 + ". " + i);
        }
    }
}
