package com.sopan.realm_db.realm.module;

import com.sopan.realm_db.model.Student;
import com.sopan.realm_db.model.University;

import io.realm.annotations.RealmModule;

/**
 * Created by Sopan on 15.10.15.
 */
@RealmModule(classes = {Student.class, University.class})
public class SimpleRealmModule {

}
