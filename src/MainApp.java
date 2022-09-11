public class MainApp {

    static String[][] arrayNotExeption = {{"1","1","1","1"},{"1","1","1","1"},{"1","1","1","1"},{"1","1","1","1"}};
    static String[][] arraySizeExeption = {{"1","1"},{"1","1","1","1"},{"1","1"},{"1","1","1","1"}};
    static String[][] arrayDataExeption = {{"1","1","l","1"},{"1","1","1","1"},{"1","1","1","1"},{"1","1","1","1"}};



    static int sizeI = 4;
    static int sizeJ = 4;

    public static void main(String[] args) {

        try {
            System.out.println("Сумма масиива: " + getSum(arrayNotExeption) + "\n");
        } catch (MyArraySizeException | MyArrayDataException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            System.out.println("Сумма масиива: " + getSum(arraySizeExeption) + "\n");
        } catch (MyArraySizeException | MyArrayDataException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            System.out.println("Сумма масиива: " + getSum(arrayDataExeption) + "\n");
        } catch (MyArraySizeException | MyArrayDataException ex) {
            System.out.println(ex.getMessage());
        }
    }

    static void checkValue (String[][] array) throws MyArraySizeException {
        if(array.length != sizeI || array[0].length != sizeJ) throw new MyArraySizeException();
    }

    static Integer getSum(String[][] array) throws MyArraySizeException, MyArrayDataException{
        checkValue(array);
        Integer result = 0;
        int i = 0;
        int j = 0;
        try {
            for (; i < array.length; i++) {
                j = 0;
                for (; j < array.length; j++) {
                    result += Integer.parseInt(array[i][j]);
                }
            }
        } catch (NumberFormatException ex) {
            throw new MyArrayDataException("Ошибка в ячейке: " + i+","+j + "\nНекорректное значение: " + array[i][j] + "\n");
        }
        return result;
    }

    public static class MyArraySizeException extends Exception {
        public MyArraySizeException() {
            super("Некорректный размер\nТребуемый размер массива: " + sizeI +"x"+ sizeJ +"\n");
        }
    }

    public static class MyArrayDataException extends Exception {
        public MyArrayDataException(String message) {
            super(message);
        }
    }
}
