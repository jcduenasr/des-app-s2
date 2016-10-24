package com.jduenas.semana2;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {

    Button btnDatePicker;
    Button btnNext;
    EditText txtDate, txtName, txtPhone, txtEmail, txtDesc;
    private int mYear, mMonth, mDay, mHour, mMinute;
    String nombre = "";
    String fecha = "";
    String telefono = "";
    String email = "";
    String descripcion = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDatePicker = (Button)findViewById(R.id.btn_date);
        btnNext = (Button)findViewById(R.id.btn_next);
        txtDate = (EditText)findViewById(R.id.edt_fecha);
        txtName = (EditText)findViewById(R.id.edt_nombres);
        txtPhone = (EditText)findViewById(R.id.edt_telefono);
        txtEmail = (EditText)findViewById(R.id.edt_email);
        txtDesc = (EditText)findViewById(R.id.edt_descripcion);

        btnDatePicker.setOnClickListener(this);
        btnNext.setOnClickListener(this);

        Bundle parametros = getIntent().getExtras();
        if (parametros!=null){
            nombre = parametros.getString(getResources().getString(R.string.pnombres));
            fecha = parametros.getString(getResources().getString(R.string.pfecha));
            telefono = parametros.getString(getResources().getString(R.string.ptelefono));
            email = parametros.getString(getResources().getString(R.string.pemail));
            descripcion = parametros.getString(getResources().getString(R.string.pdescripcion));

            txtName.setText(nombre);
            txtDate.setText(fecha);
            txtPhone.setText(telefono);
            txtEmail.setText(email);
            txtDesc.setText(descripcion);
        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_date:
                // Get Current Date
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
                break;
            case R.id.btn_next:
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pnombres), txtName.getText().toString());
                intent.putExtra(getResources().getString(R.string.pfecha), txtDate.getText().toString());
                intent.putExtra(getResources().getString(R.string.ptelefono), txtPhone.getText().toString());
                intent.putExtra(getResources().getString(R.string.pemail), txtEmail.getText().toString());
                intent.putExtra(getResources().getString(R.string.pdescripcion), txtDesc.getText().toString());
                startActivity(intent);
                break;
        }

    }

}
