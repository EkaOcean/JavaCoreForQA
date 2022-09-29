package lesson2;

public class Main {

        private static final int array_size = 4;

        public static void main(String[] args) {
            String[][] correctArray = new String[][] {{"9", "0", "10", "0"}, {"0", "0", "0", "10"}, {"0", "10", "0", "0"}, {"10", "0", "0", "0"}};
            String[][] wrongSizeArray = new String[][] {{"56", "32", "1", "3"}, {"6", "14", "19", "58"}, {"1", "2", "15", "1"}};
            String[][] wrongDataArray = new String[][] {{"7", "21", "1", "2"}, {"12", "7", "абв", "8"}, {"14", "7", "8", "18"}, {"15", "6", "5", "1"}};

            try {
                System.out.println(sum(correctArray));
                System.out.println(sum(wrongSizeArray));

            }  catch (MyArraySizeException | MyArrayDataException ex){
                System.out.println(ex.getMessage());
            }
            try {
                System.out.println(sum(wrongDataArray));
            }  catch (MyArraySizeException | MyArrayDataException ex){
                System.out.println(ex.getMessage());
            }
        }

        private static String sum(String[][] _array) throws MyArraySizeException, MyArrayDataException {
            checkSizeArray(_array);
            checkIntsArray(_array);
            return "Сумма элементов: " + _sum(_array);
        }

        private static int _sum(String[][] _array) {
            int result = 0;
            for (String[] strings : _array) {
                for (String string : strings) {
                    result += (int) Integer.parseInt(string);
                }
            }
            return result;
        }

        private static void checkIntsArray(String[][] _array) throws MyArrayDataException {
            int row;
            int col;
            for (row = 0; row < _array.length; row++) {
                for (col = 0; col < _array[row].length; col++) {
                    try {
                        Integer.parseInt(_array[row][col]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException("\nОшибка данных массива в позиции: " + row+","+ col + ".");
                    }
                }
            }
        }

        private static void checkSizeArray(String[][] _array) throws MyArraySizeException {
            if (_array.length != array_size) {
                throw new MyArraySizeException("\nОшибка размера массива. Нужный размер: 4x4.");
            }
            for (String[] strings : _array) {
                if (strings.length != array_size) {
                    throw new MyArraySizeException("\nОшибка размера массива. Нужный размер: 4x4.");
                }
            }
        }

    }




  /*  static String[][] arrayDataException = {{"1", "2", "3", "4"}, {"7", "6", "7", "8"}, {"9", "ш", "7", "8"}, {"5", "6", "7", "8"}};

    static String[][] arraySizeException = {{"1", "2"}, {"1", "6",}, {"9", "6"}, {"5", "6"}};

    static String[][] arrayWithNoError = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "6", "7", "8"}, {"5", "6", "7", "8"}};

    static int sizeA = 4;
    static int sizeB = 4;

    public static void main(String[] args) {

        try {
            System.out.println("Сумма массива: " + getSumm(arrayWithNoError));
        } catch (MyArraySizeException | MyArrayDataException ex){
            System.out.println(ex.getMessage());
        }

        try {
            System.out.println("Сумма массива: " + getSumm(arraySizeException));
        } catch (MyArraySizeException | MyArrayDataException ex){
            System.out.println(ex.getMessage());
        }

        try {
            System.out.println("Сумма массива: " + getSumm(arrayDataException));
        } catch (MyArraySizeException | MyArrayDataException ex){
            System.out.println(ex.getMessage());
        }
    }

    static void checkValue(String[][] array) throws MyArraySizeException{
        if(array.length!=sizeA || array[0].length!=sizeB) throw new MyArraySizeException();

    }

    static Integer getSumm(String[][] array) throws MyArrayDataException,MyArraySizeException{
        checkValue(array);
        Integer result = 0;
        int i =0;
        int j =0;
        try {
            for (; i < array.length; i++) {
                j =0;
                for (; j < array.length; j++) {
                    result = result + Integer.parseInt(array[i][j]);
                }
            }
        } catch (NumberFormatException ex){
            throw new  MyArrayDataException("Ошибка в позиции: " + i+","+j);
        }

        return result;
    }

    public static class MyArraySizeException extends Exception {
        public MyArraySizeException(){
            super("Ошибка размера");
        }
    }

    public static class MyArrayDataException extends Exception {
        public MyArrayDataException(String message){
            super(message);
        }
    }
    }*/

