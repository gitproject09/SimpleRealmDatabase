package com.sopan.realm_db.presenters.impl;

import com.sopan.realm_db.model.Student;
import com.sopan.realm_db.model.University;
import com.sopan.realm_db.presenters.IStudentPresenter;
import com.sopan.realm_db.realm.repository.IStudentRepository;
import com.sopan.realm_db.realm.repository.IUniversityRepository;
import com.sopan.realm_db.realm.repository.impl.StudentRepository;
import com.sopan.realm_db.realm.repository.impl.UniversityRepository;
import com.sopan.realm_db.view.activity.StudentsActivity;

import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by Sopan on 03.11.15.
 */
public class StudentPresenter implements IStudentPresenter {

    private StudentsActivity view;

    private IStudentRepository.OnDeleteStudentCallback onDeleteStudentCallback;
    private IStudentRepository.OnSaveStudentCallback onSaveStudentCallback;
    private IStudentRepository.OnGetAllStudentsCallback onGetAllStudentsCallback;
    private IStudentRepository.OnGetStudentByIdCallback onGetStudentByIdCallback;
    private IStudentRepository.OnGetStudentsCallback onGetStudentsCallback;
    private IUniversityRepository.OnGetUniversityByIdCallback onGetUniversityByIdCallback;


    private IStudentRepository studentRepository;
    private IUniversityRepository universityRepository;

    public StudentPresenter(StudentsActivity view) {
        this.view = view;
        studentRepository = new StudentRepository();
        universityRepository = new UniversityRepository();
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.addStudent(student, onSaveStudentCallback);
    }

    @Override
    public void addStudentByUniversityId(Student student, String universityId) {
        studentRepository.addStudentByUniversityId(student, universityId, onSaveStudentCallback);
    }

    @Override
    public void deleteStudentByPosition(int position) {
        studentRepository.deleteStudentByPosition(position, onDeleteStudentCallback);
    }

    @Override
    public void deleteStudentById(String studentId) {
        studentRepository.deleteStudentById(studentId, onDeleteStudentCallback);
    }

    @Override
    public void getAllStudents() {
        studentRepository.getAllStudents(onGetAllStudentsCallback);
    }

    @Override
    public void getAllStudentsByUniversityId(String id) {
        studentRepository.getAllStudentsByUniversityId(id, onGetStudentsCallback);
    }

    @Override
    public void getStudentById(String id) {
        studentRepository.getStudentById(id, onGetStudentByIdCallback);
    }

    @Override
    public void getUniversityById(String id) {
        universityRepository.getUniversityById(id, onGetUniversityByIdCallback);
    }

    @Override
    public void subscribeCallbacks() {
        onSaveStudentCallback = new IStudentRepository.OnSaveStudentCallback() {
            @Override
            public void onSuccess() {
                view.showMessage("Added");
            }

            @Override
            public void onError(String message) {
                view.showMessage(message);
            }
        };
        onDeleteStudentCallback = new IStudentRepository.OnDeleteStudentCallback() {
            @Override
            public void onSuccess() {
                view.showMessage("Deleted");
            }

            @Override
            public void onError(String message) {
                view.showMessage(message);
            }
        };
        onGetAllStudentsCallback = new IStudentRepository.OnGetAllStudentsCallback() {
            @Override
            public void onSuccess(RealmResults<Student> students) {

            }

            @Override
            public void onError(String message) {
                view.showMessage(message);
            }
        };
        onGetStudentByIdCallback = new IStudentRepository.OnGetStudentByIdCallback() {
            @Override
            public void onSuccess(Student student) {

            }

            @Override
            public void onError(String message) {

            }
        };
        onGetStudentsCallback = new IStudentRepository.OnGetStudentsCallback() {
            @Override
            public void onSuccess(RealmList<Student> students) {
                view.showStudents(students);
            }

            @Override
            public void onError(String message) {
                view.showMessage(message);
            }
        };
        onGetUniversityByIdCallback = new IUniversityRepository.OnGetUniversityByIdCallback() {
            @Override
            public void onSuccess(University university) {
                view.updateToolbarTittle(university.getName());
            }

            @Override
            public void onError(String message) {
                view.showMessage(message);
            }
        };
    }

    @Override
    public void unSubscribeCallbacks() {
        onDeleteStudentCallback = null;
        onSaveStudentCallback = null;
        onGetAllStudentsCallback = null;
        onGetStudentByIdCallback = null;
    }
}
