package com.example.gradecalculator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

/**
 * Created by jon on 12/21/17.
 */

public class CLASS1fe extends Fragment
{
    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        ((MainActivity) getActivity()).setActionBarTitle("COP4610 Final Exam");

        myView = inflater.inflate(R.layout.class1fe, container, false);


        Button calcButton = (Button) myView.findViewById(R.id.calcButton);
        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                double finalExam;

                EditText attendanceET = (EditText) myView.findViewById(R.id.attendance);
                EditText quizAverageET = (EditText) myView.findViewById(R.id.quizAverage);
                EditText homeworkGradeET = (EditText) myView.findViewById(R.id.homeworkGrade);
                EditText projectsGradeET = (EditText) myView.findViewById(R.id.projectsGrade);
                EditText test1ET = (EditText) myView.findViewById(R.id.test1);
                EditText test2ET = (EditText) myView.findViewById(R.id.test2);
                EditText desiredGradeET = (EditText) myView.findViewById(R.id.desiredGrade);
                TextView calculatedFinalTV = (TextView) myView.findViewById(R.id.calculatedFinal);

                double attendance = ParseDouble(attendanceET.getText().toString());
                double quizAverage = ParseDouble(quizAverageET.getText().toString());
                double homeworkGrade = ParseDouble(homeworkGradeET.getText().toString());
                double projectsGrade = ParseDouble(projectsGradeET.getText().toString());
                double test1 = ParseDouble(test1ET.getText().toString());
                double test2 = ParseDouble(test2ET.getText().toString());
                double desiredGrade = ParseDouble(desiredGradeET.getText().toString());

                finalExam = ((desiredGrade) - ((.04 * attendance) + (.06 * quizAverage) + (.15 * homeworkGrade)
                        + (.25 * projectsGrade) + (.12 * test1) + (.13 * test2))) / (.25);

                calculatedFinalTV.setText("You need a " + String.format("%.2f", finalExam) + " on the Final");
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
