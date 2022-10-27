import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userCommand = 0;

        System.out.println("Пришло время практики!");

        while (true) {
            printMenu();

            if (scanner.hasNextBigInteger()) {
                userCommand = scanner.nextInt();

                if (userCommand == 1) {

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

    private static void printMenu() {
        System.out.println("Что вы хотите сделать");
        System.out.println("1. Ввести количество шагов за определённый день;");
        System.out.println("2. Напечатать статистику за определённый месяц;");
        System.out.println("3. Изменить цель по количеству шагов в день;");
        System.out.println("4. Выйти из приложения;");
    }
}
