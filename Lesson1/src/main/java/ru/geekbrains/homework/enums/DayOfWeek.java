package ru.geekbrains.homework.enums;

public enum DayOfWeek {
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday,
    Sunday;

    public static String getWorkingHours(DayOfWeek day){
        if (day.ordinal() < 5) {
            return String.valueOf((5 - day.ordinal()) * 8);
        } else {
            return "Сегодня выходной";
        }
        //или можно создать поле и напрямую в нем прописать
   }
}
