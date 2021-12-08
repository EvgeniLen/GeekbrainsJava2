package ru.geekbrains.homework.athletes;


import ru.geekbrains.homework.interfaces.Acting;

public class Cat implements Acting {
    private String name;
    private final double MAX_DISTANCE = 1;
    private final double MAX_HEIGHT = 2;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public boolean jump(double h) {
        if (h < MAX_HEIGHT){
            System.out.println("Кот " + name + " успешно перепрыгнул!");
            return true;
        } else {
            System.out.println("Кот " + name + " не смог перепрыгнуть!");
            return false;
        }

    }

    @Override
    public boolean run(double w) {
        if (w < MAX_DISTANCE){
            System.out.println("Кот " + name + " успешно пробежал!");
            return true;
        } else {
            System.out.println("Кот " + name + " не смог пробежать!");
            return false;
        }
    }

}
