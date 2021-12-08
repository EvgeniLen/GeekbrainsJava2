package ru.geekbrains.homework.athletes;

import ru.geekbrains.homework.interfaces.Acting;

public class Robot implements Acting {
    private String name;
    private final double MAX_DISTANCE = 10;
    private final double MAX_HEIGHT = 3;

    public Robot(String name) {
        this.name = name;
    }

    @Override
    public boolean jump(double h) {
        if (h < MAX_HEIGHT){
            System.out.println("Робот " + name + " успешно перепрыгнул!");
            return true;
        } else {
            System.out.println("Робот " + name + " не смог перепрыгнуть!");
            return false;
        }
    }

    @Override
    public boolean run(double w) {
        if (w < MAX_DISTANCE){
            System.out.println("Робот " + name + " успешно пробежал!");
            return true;
        } else {
            System.out.println("Робот " + name + " не смог пробежать!");
            return false;
        }
    }
}
