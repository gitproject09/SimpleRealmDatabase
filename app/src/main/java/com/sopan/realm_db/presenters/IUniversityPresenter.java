package com.sopan.realm_db.presenters;

/**
 * Created by Sopan on 19.10.15.
 */
public interface IUniversityPresenter extends IBasePresenter {

    void addUniversity(String universityName);

    void deleteUniversity(int position);

    void deleteUniversityById(String Id);

    void getUniversityById(String id);

    void getAllUniversities();

}
