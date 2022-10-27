public class Converter {
    static double stepLengthKm = 0.00075; // длина шага в километрах
    static double kilocaloriesPerStep = 0.05; // сжигаемые килокаллории за шаг

    public static double calcDistance(int steps) {
        return steps * stepLengthKm;
    }

    public static double calcCalories(int steps) {
        return steps * kilocaloriesPerStep;
    }
}
