package com.teecode.challlenge2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private EditText edtTxtName,edtTxtEmail,edtTxtPassword,edtTxtPassRepeat;
    private Button btnPickImage,btnRegister;
    private TextView txtWarnName,txtWarnEmail,txtWarnPassword,txtWarnPassRepeat;
    private Spinner countriesSpinner;
    private CheckBox agreementCheck;
    private RadioGroup rgGender;
    private ConstraintLayout parent;

    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        
        btnPickImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Yet to be talk about", Toast.LENGTH_SHORT).show();
            }
        });


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initRegister();

            }
        });
    }

    private void initRegister(){

        Log.d(TAG, "initRegister: Started ");
        if(validateData()){
            if (agreementCheck.isChecked()){
                showSnackBar();
                
            }else {
                Toast.makeText(this, "You need to agree to Licence Agreement", Toast.LENGTH_SHORT).show();
            }

        }
        

    }
    private void showSnackBar(){
        Log.d(TAG, "showSnackBar: Started");
        txtWarnName.setVisibility(View.GONE);
        txtWarnEmail.setVisibility(View.GONE);
        txtWarnPassword.setVisibility(View.GONE);
        txtWarnPassRepeat.setVisibility(View.GONE);

        String name = edtTxtName.getText().toString();
        String email = edtTxtEmail.getText().toString();
        String country = countriesSpinner.getSelectedItem().toString();
        String gender = "";

        int checkedRadioButtonId = rgGender.getCheckedRadioButtonId();
        if (checkedRadioButtonId == R.id.rbMale) {
            gender = "Male";
        } else if (checkedRadioButtonId == R.id.rbFemale) {
            gender = "Female";
        } else if (checkedRadioButtonId == R.id.rbOther) {
            gender = "Other";
        } else {
            gender = "Unkown";
        }

        String snacktext ="Name: "+name +"\n"+
                "Email: "+ email +"\n"+
                "Gender: "+gender +"\n"+
                "Country: "+country;

        Log.d(TAG, "showSnackBar: Snack Bar Text:"+snacktext);

        Snackbar.make(parent,snacktext ,Snackbar.LENGTH_INDEFINITE)
                .setAction("Dismiss", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        edtTxtName.setText("");
                        edtTxtEmail.setText("");
                        edtTxtPassword.setText("");
                        edtTxtPassRepeat.setText("");

                    }
                })
                .show();

    }

    private boolean validateData(){
        Log.d(TAG, "validateData: Started ");

        if(edtTxtName.getText().toString().equals("")){
            txtWarnName.setVisibility(View.VISIBLE);
            txtWarnName.setText( "Enter your name!");
            return false;
        }

        if (edtTxtEmail.getText().toString().equals("")){
            txtWarnEmail.setVisibility(View.VISIBLE);
            txtWarnEmail.setText("Enter your email!");
            return false;

        }

        if (edtTxtPassword.getText().toString().equals("")){
            txtWarnPassword.setVisibility(View.VISIBLE);
            txtWarnPassword.setText("Enter your password!");
            return false;
        }

        if (edtTxtPassRepeat.getText().toString().equals("")){
            txtWarnPassRepeat.setVisibility(View.VISIBLE);
            txtWarnPassRepeat.setText("Re-enter your password!");
            return false;
        }

        if (!edtTxtPassword.getText().toString().equals(edtTxtPassRepeat.getText().toString())){
            txtWarnPassRepeat.setVisibility(View.VISIBLE);
            txtWarnPassRepeat.setText("Password doesn't match");
            return false;
        }
        return true;
    }
     private void initViews(){

        Log.d(TAG, "initViews: Started ");
        
        edtTxtName = findViewById(R.id.edtTxtName);
        edtTxtEmail = findViewById(R.id.edtTxtEmail);
        edtTxtPassword = findViewById(R.id.edtTxtPassword);
        edtTxtPassRepeat = findViewById(R.id.edtTxtPassRepeat);

        btnPickImage = findViewById(R.id.btnPickImage);
        btnRegister = findViewById(R.id.btnRegister);

        txtWarnName = findViewById(R.id.txtWarnName);
        txtWarnEmail = findViewById(R.id.txtWarnEmail);
        txtWarnPassword = findViewById(R.id.txtWarnPass);
        txtWarnPassRepeat = findViewById(R.id.txtWarnPassRepeat);

        countriesSpinner = findViewById(R.id.spinnerCountry);

        agreementCheck = findViewById(R.id.agreementCheck);

        rgGender = findViewById(R.id.rgGender);

        parent = findViewById(R.id.parent);
     }
}