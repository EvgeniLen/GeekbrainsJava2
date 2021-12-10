package ru.geekbrains.homework.trails;

import ru.geekbrains.homework.interfaces.*;

public class RunningTrack implements Trails {
    private double width;

    public RunningTrack(double width) {
        this.width = width;
    }

    @Override
    public boolean start(Acting a) {
        return a.run(width);
    }
}
