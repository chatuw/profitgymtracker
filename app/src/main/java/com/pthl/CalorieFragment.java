package com.pthl;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import okhttp3.OkHttpClient;

public class CalorieFragment extends Fragment {


    EditText weight, height, age, name;
    double bmi;
    double bmr;
    RadioButton radioGender;
    RadioButton stars;
    int selectedId;
    int radioId;
    private String resulttext;
    private TextView txtresult;
    Spinner spgoals;
    String sgoals;
    TextView result;




    String goals[] = {"Maintain Weight", "Gain 0.5kg per week", "Gain 1kg per week", "Lose 0.5kg per week",
        "Lose 1kg per week"};
    ArrayAdapter<String> adaptergoals;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.tab_calorie, container, false);

     spgoals =  root.findViewById(R.id.spinner);


        //adaptergoals = new ArrayAdapter<String>(android.R.layout.simple_spinner_item, goals);


      //  adaptergoals.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

     //   spgoals.setAdapter(adaptergoals);

        Button one = root.findViewById(R.id.calc);
        one.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                weight = (EditText) root.findViewById(R.id.weight);
                height = (EditText) root.findViewById(R.id.height);
                age = (EditText) root.findViewById(R.id.age);
                name = (EditText) root.findViewById(R.id.namevar);
                String ass;

                int Gender, starss;

                RadioGroup rg =  root.findViewById(R.id.radioGroup);
                RadioButton male =  root.findViewById(R.id.Male);
                RadioButton female =  root.findViewById(R.id.Female);

                selectedId = rg.getCheckedRadioButtonId();
                radioGender = (RadioButton) root.findViewById(selectedId);

                if (male.isChecked()) {
                    Gender = 1;
                } else {
                    Gender = 2;
                }


                String namevr = name.getText().toString();
                double weightvr = Double.parseDouble(weight.getText().toString());
                double heightvr = Double.parseDouble(height.getText().toString());
                int agevr = Integer.parseInt(age.getText().toString());


                //a.putString("name", String.valueOf(namevr));


                RadioGroup rg1 = (RadioGroup) root.findViewById(R.id.radioGroup1);

                radioId = rg1.getCheckedRadioButtonId();
                stars =  root.findViewById(radioId);
                RadioButton r1 =  root.findViewById(R.id.r1);
                RadioButton r2 = root.findViewById(R.id.r2);
                RadioButton r3 =  root.findViewById(R.id.r3);
                RadioButton r4 =  root.findViewById(R.id.r4);
                RadioButton r5 = root.findViewById(R.id.r5);

                if (r1.isChecked()) {
                    starss = 1;
                } else if (r2.isChecked()) {
                    starss = 2;

                } else if (r3.isChecked()) {
                    starss = 3;
                } else if (r4.isChecked()) {
                    starss = 4;
                } else {
                    starss = 5;
                }


                if (radioId == R.id.r1) {
                    bmr = bmr * 1.2;
                } else if (radioId == R.id.r2) {
                    bmr = bmr * 1.375;
                } else if (radioId == R.id.r3) {
                    bmr = bmr * 1.55;
                } else if (radioId == R.id.r4) {
                    bmr = bmr * 1.725;
                } else {
                    bmr = bmr * 1.9;
                }


                bmi = (float) (weightvr / ((heightvr / 100) * (heightvr / 100)));

                if (bmi < 16) {
                    ass = "Severely underweight";
                } else if (bmi < 18.5) {

                    ass = "Underweight";
                } else if (bmi < 25) {

                    ass = "Normal";
                } else if (bmi < 30) {

                    ass = "Overweight";
                } else {
                    ass = "Obese";
                }
                sgoals = spgoals.getSelectedItem().toString();

                if (sgoals == "Maintain Weight") {
                    bmr = bmr;
                    result.setText("To maintain weight you need to take ".concat(Double.toString(bmr)).concat(". Calorie"));
                } else if (sgoals == "Gain 0.5kg per week") {
                    bmr = bmr + 500;
                } else if (sgoals == "Gain 1kg per week") {
                    bmr = bmr + 1000;
                } else if (sgoals == "Lose 0.5kg per week") {
                    bmr = bmr - 500;
                } else if (sgoals == "Lose 1kg per week") {
                    bmr = bmr - 1000;
                }

                txtresult = (TextView) root.findViewById(R.id.result1);
                resulttext = "Your BMI is: " + String.format("%.2f", bmi) + "\nYou are " + ass;
                double daily = bmr;
                String results = resulttext;
                double calories = bmr;
                double tempo = 0.0;
                Calendar calendar = Calendar.getInstance();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


                Date today = calendar.getTime();

                String dates = dateFormat.format(today);
            }




                //SQLiteHandler db = new SQLiteHandler(getApplicationContext());
                //db.addUser(namevr, Gender, agevr, weightvr, heightvr, starss, results, calories, dates, daily, tempo);
                  /* if (db.isUserEmpty()) {
                         db.addUser(namevr, Gender, agevr, weightvr, heightvr, starss, results);
                        db.updatetable(namevr, Gender, agevr, weightvr, heightvr, starss, results);
                    }
                    else {
                        db.updatetable(namevr, Gender, agevr, weightvr, heightvr, starss, results);
                   }
                // db.close();
                // startActivity(i);
                // finish();
            }

        });*/

                });

                return root;
    }

}





