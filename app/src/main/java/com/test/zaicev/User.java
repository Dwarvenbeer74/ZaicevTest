package com.test.zaicev;

//тут добавил конструктор для инициализации полей класса
public class User {
    private long id;
    private Vacancy vacancy;

    User(long id, Vacancy vacancy) {
        this.id = id;
        this.vacancy = vacancy;
    }

    String getVacancy() {
        return vacancy.getVacancy();
    }

    long getId() {
        return id;
    }

}
