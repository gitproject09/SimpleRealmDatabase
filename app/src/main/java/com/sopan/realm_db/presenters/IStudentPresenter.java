package com.sopan.realm_db.presenters;

import com.sopan.realm_db.model.Student;

/**
 * Created by Sopan on 03.11.15.
 */
public interface IStudentPresenter extends IBasePresenter{

    void addStudent(Student student);

    void addStudentByUniversityId(Student student, String universityId);

    void deleteStudentByPosition(int position);

    void deleteStudentById(String studentId);

    void getAllStudents();

    void getAllStudentsByUniversityId(String id);

    void getStudentById(String id);

    void getUniversityById(String id);

}
