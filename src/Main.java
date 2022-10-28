import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        int userCommand = 0;

        System.out.println("Пришло время практики!");

        while (true) {
            printMenu();

            if (scanner.hasNextInt()) {
                userCommand = scanner.nextInt();

                if (userCommand == 1) { // Ввести количество шагов за определённый день
                    System.out.println("Ввод количества шагов за день");
                    printMonths();
                    int month = askUserForInt(scanner);

                    if (month > 0) {
                        System.out.println("Выберите день месяца 1-30:");
                        int day = askUserForInt(scanner);

                        if (day > 0) {
                            System.out.println("Введите количество пройденных шагов за день:");
                            int steps = askUserForInt(scanner);

                            if (steps > 0) {
                                stepTracker.setStepsPerDay(month, day, steps);
                            }
                        }
                    }

                } else if (userCommand == 2) {
                    System.out.println("Статистика за месяц");
                    printMonths();
                    int month = askUserForInt(scanner);

                    if (month > 0) {
                        stepTracker.printStatistics(month);
                    }

                } else if (userCommand == 3) {
                    System.out.println("Изменить количество шагов для цели дня");
                    int newGoal = askUserForInt(scanner);
                    stepTracker.setGoalOfDay(newGoal);
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

    static void printMonths() {
        System.out.println("Выберите месяц: 1 - Январь, 2 - Февраль, 3 - Март, 4 - Апрель, 5 - Май, 6 - Июнь, " +
                "7 - Июль, 8 - Август, 9 - Сентябрь, 10 - Октябрь, 11 - Ноябрь, 12 - Декабрь");

    }

    static int askUserForInt(Scanner scanner) {
        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();

            if (number < 0 ) {
                System.out.println("Необходимо ввести положительное число!");
            }

            return number;
        }

        System.out.println("Нужно ввести целое число!");
        return -1;
    }

    static void printMenu() {
        System.out.println("Меню:");
        System.out.println("1. Ввести количество шагов за определённый день;");
        System.out.println("2. Напечатать статистику за определённый месяц;");
        System.out.println("3. Изменить цель по количеству шагов в день;");
        System.out.println("4. Выйти из приложения;");
        System.out.println("Что вы хотите сделать?");
    }
}
