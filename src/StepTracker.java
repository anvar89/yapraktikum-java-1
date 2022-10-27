import java.util.ArrayList;

public class StepTracker {
    static int goalOfDay = 10000;

    MonthData[] monthData;

    public StepTracker() {
        monthData = new MonthData[12];
        for (MonthData m : monthData) {
            m = new MonthData();
        }
    }


    class MonthData {

        int[] stepsPerDay;

        MonthData() {
            stepsPerDay = new int[30];
        }

        // Вывод кол-ва шагов по дням
        public void printStatistics() {
            for (int i : stepsPerDay) {
                System.out.print((i + 1) + " день: " + stepsPerDay[i] + ", ");
            }
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
