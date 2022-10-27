import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userCommand = 0;

        System.out.println("Пришло время практики!");

        while (true) {
            printMenu();

            if (scanner.hasNextInt()) {
                userCommand = scanner.nextInt();

                if (userCommand == 1) { // Ввести количество шагов за определённый день

                    int month = askUserMonth(scanner);
                    

                } else if (userCommand == 2) {

                } else if (userCommand == 3) {

                } else if (userCommand == 4) {
                    break;
                } else {
                    System.out.println("Неизвестная команда");
                }
            } else {
                System.out.println("Выберите пункт согласно меню");
            }
        }
    }

    private static int askUserMonth(Scanner scanner) {
        System.out.println("Выберите месяц: 1 - Январь, 2 - Февраль, 3 - Март, 4 - Апрель, 5 - Май, 6 - Июнь, " +
                "7 - Июль, 8 - Август, 9 - Сентябрь, 10 - Октярь, 11 - Ноябрь, 12 - Декабрь");

        int month = scanner.nextInt();

        if (month >= 1 && month <= 12) {
            return month;
        }

        System.out.println("Вы ввели неверный номер месяца");
        return 0;
    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать");
        System.out.println("1. Ввести количество шагов за определённый день;");
        System.out.println("2. Напечатать статистику за определённый месяц;");
        System.out.println("3. Изменить цель по количеству шагов в день;");
        System.out.println("4. Выйти из приложения;");
    }
}
