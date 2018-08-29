package com.sopan.realm_db.realm.table;

/**
 * Created by Sopan on 16.10.15.
 */
public interface RealmTable {

    String ID = "id";

    interface University {
        String STUDENTS = "students";
        String NAME = "name";
    }

    interface Student{
        String NAME = "name";
        String AGE = "age";
        String EMAIL = "email";
        String BOOKS = "books";
        String LESSONS = "lessons";
    }
}
