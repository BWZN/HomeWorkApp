package lesson_11;

public class Exercise1 {
    public static class MyArraySizeException extends Exception {
        public MyArraySizeException(String message) {
            super(message);
        }
    }

    public static class MyArrayDataException extends Exception {
        public MyArrayDataException(String message) {
            super(message);
        }
    }

    public static int sumArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException("Неверный размер массива (4x4)");
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверный тип данных: [" + i + "][" + j + "]");
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        String[][] correctArray = {
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}
        };

        String[][] incorrectSizeArray = {
                {"1", "1", "1"},
                {"1", "1", "1"},
                {"1", "1", "1"}
        };

        String[][] incorrectDataArray = {
                {"1", "1", "avsdav", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}
        };

        try {
            System.out.println("Сумма: " + sumArray(correctArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Сумма: " + sumArray(incorrectSizeArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Сумма: " + sumArray(incorrectDataArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }
}




