package ru.geekbrains.homework.athletes;

import ru.geekbrains.homework.interfaces.Acting;

import java.sql.Struct;

public class Human implements Acting {
    private String name;
    private final double MAX_DISTANCE = 5;
    private final double MAX_HEIGHT = 1.5;

    public Human(String name) {
        this.name = name;
    }

    @Override
    public boolean jump(double h) {
        if (h < MAX_HEIGHT){
            System.out.println("Человек " + name + " успешно перепрыгнул!");
            return true;
        } else {
            System.out.println("Человек " + name + " не смог перепрыгнуть!");
            return false;
        }

    }

    @Override
    public boolean run(double w) {
        if (w < MAX_DISTANCE){
            System.out.println("Человек " + name + " успешно пробежал!");
            return true;
        } else {
            System.out.println("Человек " + name + " не смог пробежать!");
            return false;
        }
    }

}
