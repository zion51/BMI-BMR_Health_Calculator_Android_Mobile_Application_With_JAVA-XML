package com.example.healthcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView calculate,back,bmiDisplay;
    RelativeLayout Rlayout,Rlayout2;
    EditText editWeight,editHeightFeet,editHeightInches,editAge;
    CheckBox checkMale,checkFemale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editWeight = findViewById(R.id.editWeight);
        editHeightFeet = findViewById(R.id.editHeightFeet);
        editHeightInches = findViewById(R.id.editHeightInches);
        editAge = findViewById(R.id.editAge);
        checkMale = findViewById(R.id.checkMale);
        checkFemale = findViewById(R.id.checkFemale);
        bmiDisplay = findViewById(R.id.bmiDisplay);
        Rlayout  = findViewById(R.id.Rlayout);
        Rlayout2 = findViewById(R.id.Rlayout2);
        calculate= findViewById(R.id.calculate);
        back     = findViewById(R.id.back);




        //Calculate Button....
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //visibility....
                Rlayout.setVisibility(Rlayout.GONE);
                Rlayout2.setVisibility(Rlayout2.VISIBLE);

                //String to Float convert...
                String sweight =  editWeight.getText().toString();
                String hfeet =  editHeightFeet.getText().toString();
                String hinches =  editHeightInches.getText().toString();
                String sage = editAge.getText().toString();

                float weight = Float.parseFloat(sweight);
                float feet = Float.parseFloat(hfeet);
                float inch = Float.parseFloat(hinches);
                int age = Integer.parseInt(sage);
                //height calculation...
                double height = (0.3048*feet) + (0.0254*inch);
                //Bmi Calculation...
                double bmi= weight/(height*height);

                double heightcm = height * 100;


                if (checkMale.isChecked()){

                    //Male bmr=66.47 + ( 13.75 × weight in kg ) + ( 5.003 × height in cm ) − ( 6.755 × age in years )
                    double bmrm =66.47+(13.75*weight)+(5.003*heightcm)+(6.755*age);


                    //Output...
                    if(bmi>0 && bmi<18.5){
                        bmiDisplay.setText("Weight     : "+ weight+"kg\nheight        : "+ height +"m\n\nBMI            : "+bmi+"\n\nYour are considered as Under Weight\nYou need to increase it. "+"\n\n\n BMR            : "+ bmrm);
                    } else if (bmi>18.5 && bmi<24.9) {
                        bmiDisplay.setText("Weight      : "+ weight+"kg\nheight       : "+ height +"m\n\nBMI            : "+bmi+"\n\nYour are considered as Healthy Weight\nYou need to maintain it. "+"\n\n\n BMR          : "+ bmrm);
                    }else if (bmi>24.9 && bmi<29.9) {
                        bmiDisplay.setText("Weight      : "+ weight+"kg\nheight       : "+ height +"m\n\nBMI            : "+bmi+"\n\nYour are considered as Over Weight\nYou need to lose it. "+"\n\n\n BMR         : "+ bmrm);
                    }else if (bmi>29.9) {
                        bmiDisplay.setText("Weight     : "+ weight+"kg\nheight        : "+ height +"m\n\nBMI            : "+bmi+"\n\nYour are considered as Obese\nyou are in risk \nYou need to lose it immediately. "+"\n\n\n BMR         : "+ bmrm);
                    }


                } else if (checkFemale.isChecked()) {
                    //Female BMR = 655.1 + ( 9.563 × weight in kg ) + ( 1.85 × height in cm ) − ( 4.676 × age in years )
                    double bmrf =655.1+(9.563*weight)+(1.85*heightcm)+(4.676*age);


                    //Output...
                    if((bmi > 0) && (bmi < 18.5)){
                        bmiDisplay.setText("Weight     : "+ weight+"kg\nheight        : "+ height +"m\n\nBMI            : "+bmi+"\n\nYour are considered as Under Weight\nYou need to increase it. "+"\n\n\n BMR            : "+ bmrf);

                    } else if (bmi>18.5 && bmi<24.9) {
                        bmiDisplay.setText("Weight      : "+ weight+"kg\nheight       : "+ height +"m\n\nBMI            : "+bmi+"\n\nYour are considered as Healthy Weight\nYou need to maintain it. "+"\n\n\n BMR          : "+ bmrf);
                    }else if (bmi>24.9 && bmi<29.9) {
                        bmiDisplay.setText("Weight      : "+ weight+"kg\nheight       : "+ height +"m\n\nBMI            : "+bmi+"\n\nYour are considered as Over Weight\nYou need to lose it. "+"\n\n\n BMR         : "+ bmrf);
                    }else if (bmi>29.9) {
                        bmiDisplay.setText("Weight     : "+ weight+"kg\nheight        : "+ height +"m\n\nBMI            : "+bmi+"\n\nYour are considered as Obese\nyou are in risk \nYou need to lose it immediately. "+"\n\n\n BMR         : "+ bmrf);
                    }
                }

            }
        });


        //Back Button....
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //visibility....
                Rlayout2.setVisibility(Rlayout2.GONE);
                Rlayout.setVisibility(Rlayout.VISIBLE);

            }
        });


    }
}
