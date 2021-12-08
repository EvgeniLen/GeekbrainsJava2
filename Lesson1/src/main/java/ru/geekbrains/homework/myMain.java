package ru.geekbrains.homework;

import ru.geekbrains.homework.athletes.*;
import ru.geekbrains.homework.interfaces.*;
import ru.geekbrains.homework.trails.*;

public class myMain {
    public static void main(String[] args) {
        Acting[] athletes = new Acting[3];
        athletes[0] = new Robot("Бендер");
        athletes[1] = new Human("Павел");
        athletes[2] = new Cat("Баркик");

        Trails[] arrTr = new Trails[6];
        arrTr[0] = new RunningTrack(3);
        arrTr[1] = new Wall(1);
        arrTr[2] = new RunningTrack(5);
        arrTr[3] = new Wall(2);
        arrTr[4] = new RunningTrack(9);
        arrTr[5] = new Wall(2.5);

        for (Acting ath: athletes) {
            System.out.println("Атлет начал прохождение дистанции!");
            for (Trails t : arrTr) {
               if (!t.start(ath)){
                   System.out.println("Атлет не смог закончить дистанцию!");
                   break;
               }
            }
        }
    }
}
