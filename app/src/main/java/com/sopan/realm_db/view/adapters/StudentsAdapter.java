package com.sopan.realm_db.view.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sopan.realm_db.R;
import com.sopan.realm_db.app.SimpleRealmApp;
import com.sopan.realm_db.model.Student;
import com.sopan.realm_db.tools.DateFormatter;

import io.realm.RealmList;

/**
 * Created by Sopan on 03.11.15.
 */
public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.StudentViewHolder> {

    private RealmList<Student> students;

    public StudentsAdapter(RealmList<Student> students) {
        this.students = students;
    }

    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_student, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StudentViewHolder holder, int position) {
        holder.tvName.setText(students.get(position).getName());
        String birthday = SimpleRealmApp.getInstance().getString(R.string.birthday) + " " + DateFormatter.convertDateToString(students.get(position).getBirthday());
        holder.tvBirthday.setText(birthday);
        String email = SimpleRealmApp.getInstance().getString(R.string.email) + " " + students.get(position).getEmail();
        holder.tvEmail.setText(email);
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName;
        private TextView tvBirthday;
        private TextView tvEmail;

        public StudentViewHolder(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.tv_student_name);
            tvBirthday = (TextView) itemView.findViewById(R.id.tv_birthday);
            tvEmail = (TextView) itemView.findViewById(R.id.tv_email);
        }
    }

}
