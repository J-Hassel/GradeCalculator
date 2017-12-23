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

public class CLASS2cg extends Fragment
{
    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        ((MainActivity) getActivity()).setActionBarTitle("CDA3101 Class Grade");

        myView = inflater.inflate(R.layout.class2cg, container, false);


        Button calcButton = (Button) myView.findViewById(R.id.calcButton);
        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                double grade;

                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

                EditText assignmentsET = (EditText) myView.findViewById(R.id.assignments);
                EditText quizAverageET = (EditText) myView.findViewById(R.id.quizAverage);
                EditText test1ET = (EditText) myView.findViewById(R.id.test1);
                EditText finalExamET = (EditText) myView.findViewById(R.id.finalExam);
                TextView calculatedGradeTV = (TextView) myView.findViewById(R.id.calculatedGrade);

                double assignments = ParseDouble(assignmentsET.getText().toString());
                double quizAverage = ParseDouble(quizAverageET.getText().toString());
                double test1 = ParseDouble(test1ET.getText().toString());
                double finalExam = ParseDouble(finalExamET.getText().toString());

                grade = ((.30 * assignments) + (.10 * quizAverage) + (.30 * test1)
                         + (.30 * finalExam));

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
