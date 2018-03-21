package com.example.android.japanhistoryquizmeijirestoration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String questionTwoAnswer = "Mutsuhito";

    RadioGroup questionOneRadioGroup;
    EditText questionTwoEdit;
    CheckBox questionThreeChoshu;
    CheckBox questionThreeTosa;
    CheckBox questionThreeSatsuma;
    CheckBox questionThreeAizu;
    RadioGroup questionFourRadioGroup;
    RadioGroup questionFiveRadioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Dont show keyboard on start app
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        questionOneRadioGroup = (RadioGroup) findViewById(R.id.question_1_radiogroup);
        questionTwoEdit = (EditText) findViewById(R.id.question_2_edit);
        questionThreeChoshu = (CheckBox) findViewById(R.id.question_3_check_choshu);
        questionThreeTosa = (CheckBox) findViewById(R.id.question_3_check_tosa);
        questionThreeSatsuma = (CheckBox) findViewById(R.id.question_3_check_satsuma);
        questionThreeAizu = (CheckBox) findViewById(R.id.question_3_check_aizu);
        questionFourRadioGroup = (RadioGroup) findViewById(R.id.question_4_radiogroup);
        questionFiveRadioGroup = (RadioGroup) findViewById(R.id.question_5_radiogroup);

    }


    public void testResults(View v) {
        int point = 0;
        //Check the 1 question
        int questionRadioId = questionOneRadioGroup.getCheckedRadioButtonId();
        if (questionRadioId == R.id.question_1_answ_1) {
            point += 2;
        }

        //Check the 2 question
        String emperorName = questionTwoEdit.getText().toString().toUpperCase();
        if (emperorName.equals(questionTwoAnswer.toUpperCase())) {
            point += 5;
        }

        //Check the 3 question
        boolean choshu = questionThreeChoshu.isChecked();
        boolean satsuma = questionThreeSatsuma.isChecked();
        boolean tosa = questionThreeTosa.isChecked();
        boolean aizu = questionThreeAizu.isChecked();
        if (choshu && satsuma && tosa && !aizu) {
            point += 2;
        }

        //Check the 4 question
        questionRadioId = questionFourRadioGroup.getCheckedRadioButtonId();
        if (questionRadioId == R.id.question_4_radio_edo) {
            point++;
        }

        //Check the 5 question
        questionRadioId = questionFiveRadioGroup.getCheckedRadioButtonId();
        if (questionRadioId == R.id.question_5_radio_1890) {
            point += 2;
        }

        //show test results
        Toast.makeText(getApplicationContext(), "Your points: " + point, Toast.LENGTH_SHORT).show();
    }
}
