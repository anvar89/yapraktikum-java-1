import java.util.ArrayList;

public class StepTracker {
    static int goalOfDay = 10000;

    MonthData[] monthData;

    public StepTracker() {
        monthData = new MonthData[12];
        for (int i = 0; i < monthData.length; i++) {
            monthData[i] = new MonthData();
        }
    }

    public void setGoalOfDay(int number) {
        if (number > 0) {
            goalOfDay = number;
            System.out.println("Количество шагов для цели дня изменено!");
        }
        else {
            System.out.println("Количество шагов для цели дня должно быть больше ноля!");
        }
    }
    public void setStepsPerDay(int month, int day, int steps) {

        if (month >= 1 && month <= 12) {
            if (day >= 1 && day <= 30) {
                if (steps > 0) {
                    monthData[month - 1].stepsPerDay[day - 1] = steps;
                    System.out.println("Значение изменено!");
                } else {
                    System.out.println("Количество шагов должно быть больше ноля! Значение не изменено");
                }
            } else {
                System.out.println("Не верно указан день месяца! Значение не изменено");
            }
        } else {
            System.out.println("Не верно указан месяц! Значение не изменено");
        }
    }

    // Вывод кол-ва шагов по дням
    public void printStatistics(int month) {
        if (month >= 1 && month <= 12) {
            for (int i = 0; i < monthData[month - 1].stepsPerDay.length; i++) {
                System.out.print((i + 1) + " день: " + monthData[month - 1].stepsPerDay[i] + ", ");
            }
        } else {
            System.out.println("Неправильно выбран месяц!");
        }
    }

    class MonthData {

        private int[] stepsPerDay;

        MonthData() {
            stepsPerDay = new int[30];
        }


        // Кол-во шагов за месяц
        public int getStepsPerMonth() {
            int result = 0;
            for (int i : stepsPerDay) {
                result += i;
            }
            return result;
        }

        // Макс количество шагов
        public int getMaxSteps() {
            int max = stepsPerDay[0];
            for (int i = 1; i < stepsPerDay.length; i++) {
                max = stepsPerDay[i] > max ? stepsPerDay[i] : max;
            }
            return max;
        }

        // Среднее количество шагов
        public int getAverageSteps() {
            return getStepsPerMonth() / stepsPerDay.length;
        }

        //Пройденная дистанция
        public double getDistancePerMonth() {
            return Converter.calcDistance(getStepsPerMonth());
        }

        // Кол-во сожжёных килокалорий
        public double getCaloriesPerMonth() {
            return Converter.calcCalories(getStepsPerMonth());
        }

        //Лучшая серия
        public int getBestSeries() {
            int bestSeries = 0;
            int currentSeries = 0;
            ArrayList<Integer> seriesList = new ArrayList<>();

            for (int i : stepsPerDay) {
                if (i >= goalOfDay) {
                    currentSeries++;
                } else {
                    seriesList.add(currentSeries);
                    currentSeries = 0;
                }
            }

            for (Integer s : seriesList) {
                bestSeries = s > bestSeries ? s : bestSeries;
            }

            return bestSeries;
        }
    }
}
