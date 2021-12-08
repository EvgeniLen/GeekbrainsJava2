package ru.geekbrains.homework.trails;

import ru.geekbrains.homework.interfaces.*;

public class Wall implements Trails {
    private double height;

    public Wall(double height) {
        this.height = height;
    }

    @Override
    public boolean start(Acting j) {
        return j.jump(height);
    }
}
