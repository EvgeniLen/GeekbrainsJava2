package ru.geekbrains.homework;

public class MyArrayDataException extends RuntimeException{
    private int x;
    private int y;

    public MyArrayDataException(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public MyArrayDataException(String message, int x, int y) {
        super(message);
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
