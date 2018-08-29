package com.sopan.realm_db.realm.repository;

import com.sopan.realm_db.model.University;

import io.realm.RealmResults;

/**
 * Created by Sopan on 16.10.15.
 */
public interface IUniversityRepository extends IBaseRepository {

    interface OnAddUniversityCallback {
        void onSuccess();
        void onError(String message);
    }

    interface OnGetAllUniversityCallback {
        void onSuccess(RealmResults<University> universities);
        void onError(String message);
    }

    interface OnGetUniversityByIdCallback {
        void onSuccess(University university);
        void onError(String message);
    }

    interface OnDeleteUniversityCallback {
        void onSuccess();
        void onError(String message);
    }

    void addUniversity(University university, OnAddUniversityCallback callback);

    void deleteUniversityById(String Id, OnDeleteUniversityCallback callback);

    void deleteUniversityByPosition(int position, OnDeleteUniversityCallback callback);

    void getAllUniversities(OnGetAllUniversityCallback callback);

    void getUniversityById(String id, OnGetUniversityByIdCallback callback);
}
