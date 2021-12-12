package ru.geekbrains.homework;

public class MyMain {
    public static void main(String[] args) {
        String[][] arr = {
                {"1", "2" , "3", "4"},
                {"5", "6" , "7", "8"},
                {"7", "10" , "11", "1f"},
                {"13", "14" , "15", "16"}};
        try {
            System.out.println(getSum(arr));
        } catch (MyArraySizeException e){
            e.printStackTrace();
        } catch (MyArrayDataException e){
            System.out.println(e + ",  координаты [" + e.getX() + "][" + e.getY() + "]");
        }
    }

    public static int getSum(String[][] arr) throws MyArraySizeException, MyArrayDataException{
        for (String[] strings : arr) {
            if (arr.length != 4 || strings.length != 4)
                throw new MyArraySizeException("Передан массив размерностью не 4х4");
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try{
                    if (arr[i][j].equals("")) arr[i][j] = "0";
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e){
                    throw new MyArrayDataException("Не удалось преобразовать в число значение " + arr[i][j], i, j);
                }
            }
        }
        return sum;
    }
}
