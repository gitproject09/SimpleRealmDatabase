package com.sopan.realm_db.view.dialogs;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.sopan.realm_db.R;
import com.sopan.realm_db.model.Student;
import com.sopan.realm_db.tools.DateFormatter;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Sopan on 04.11.15.
 */
public class AddStudentDialog extends DialogFragment implements View.OnClickListener {

    private EditText etName, etEmail, etBirthday;
    private Date date;
    private Button btAdd;

    private OnAddStudentClickListener listener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.AlertDialogStyle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_add_student, container);
        initComponents(view);
        return view;
    }

    private void initComponents(View view) {
        etName = (EditText) view.findViewById(R.id.et_name);
        etEmail = (EditText) view.findViewById(R.id.et_email);
        etBirthday = (EditText) view.findViewById(R.id.et_birthday);
        btAdd = (Button) view.findViewById(R.id.bt_add);
        etName.requestFocus();
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

        btAdd.setOnClickListener(this);
        etBirthday.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_add: {
                if (isUserInfoValidate()) {
                    Student student = new Student();
                    student.setName(etName.getText().toString());
                    student.setEmail(etEmail.getText().toString());
                    student.setBirthday(date);
                    listener.onAddStudentClickListener(student);
                }
                break;
            }
            case R.id.et_birthday: {
                Calendar now = Calendar.getInstance();
                final DatePickerDialog d = DatePickerDialog.newInstance(
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePickerDialog datePickerDialog, int year, int monthOfYear, int dayOfMonth) {
                                Calendar checkedCalendar = Calendar.getInstance();
                                checkedCalendar.set(year, monthOfYear, dayOfMonth);
                                date = checkedCalendar.getTime();
                                etBirthday.setText(DateFormatter.convertDateToString(date));
                            }
                        },
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                d.setMaxDate(now);
                d.show((getActivity()).getFragmentManager(), this.getClass().getName());
                break;
            }
        }
    }

    private boolean isUserInfoValidate() {
        return !etName.getText().toString().isEmpty() &&
                !etEmail.getText().toString().isEmpty() &&
                !etBirthday.getText().toString().isEmpty();
    }

    public void setListener(OnAddStudentClickListener listener) {
        this.listener = listener;
    }

    public interface OnAddStudentClickListener {
        void onAddStudentClickListener(Student student);
    }
}
