package com.example.gradecalculator;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by jon on 12/21/17.
 */

public class CLASS1cg extends Fragment
{
    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        ((MainActivity) getActivity()).setActionBarTitle("COP4610 Class Grade");

        myView = inflater.inflate(R.layout.class1cg, container, false);


        Button calcButton = (Button) myView.findViewById(R.id.calcButton);
        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                double grade;

                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

                EditText attendanceET = (EditText) myView.findViewById(R.id.attendance);
                EditText quizAverageET = (EditText) myView.findViewById(R.id.quizAverage);
                EditText homeworkGradeET = (EditText) myView.findViewById(R.id.homeworkGrade);
                EditText projectsGradeET = (EditText) myView.findViewById(R.id.projectsGrade);
                EditText test1ET = (EditText) myView.findViewById(R.id.test1);
                EditText test2ET = (EditText) myView.findViewById(R.id.test2);
                EditText finalExamET = (EditText) myView.findViewById(R.id.finalExam);
                TextView calculatedGradeTV = (TextView) myView.findViewById(R.id.calculatedGrade);

                double attendance = ParseDouble(attendanceET.getText().toString());
                double quizAverage = ParseDouble(quizAverageET.getText().toString());
                double homeworkGrade = ParseDouble(homeworkGradeET.getText().toString());
                double projectsGrade = ParseDouble(projectsGradeET.getText().toString());
                double test1 = ParseDouble(test1ET.getText().toString());
                double test2 = ParseDouble(test2ET.getText().toString());
                double finalExam = ParseDouble(finalExamET.getText().toString());

                grade = ((.04 * attendance) + (.06 * quizAverage) + (.15 * homeworkGrade)
                        + (.25 * projectsGrade) + (.12 * test1) + (.13 * test2) + (.25 * finalExam));

                calculatedGradeTV.setText("Your Final Grade " + String.format("%.2f", grade));
            }
        });


        return myView;
    }

    double ParseDouble(String s)
    {
        if(s != null && s.length() > 0)
            return Double.parseDouble(s);
        else
            return 0;
    }
}
