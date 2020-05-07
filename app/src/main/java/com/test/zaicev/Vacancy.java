package com.test.zaicev;

//тут добавил поле vacancyName и конструктор для его инициализации
public class Vacancy {
    private String vacancyName;

    Vacancy(String vacancyName) {
        this.vacancyName = vacancyName;
    }

    String getVacancy() {
        return vacancyName;
    }

}
