package com.jduenas.semana2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity implements View.OnClickListener{

    TextView tvDate, tvName, tvPhone, tvEmail, tvDesc;
    Button btnEdit;
    String nombre = "";
    String fecha = "";
    String telefono = "";
    String email = "";
    String descripcion = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);
        btnEdit = (Button)findViewById(R.id.btn_edit);
        btnEdit.setOnClickListener(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle parametros = getIntent().getExtras();
        nombre = parametros.getString(getResources().getString(R.string.pnombres));
        fecha = parametros.getString(getResources().getString(R.string.pfecha));
        telefono = parametros.getString(getResources().getString(R.string.ptelefono));
        email = parametros.getString(getResources().getString(R.string.pemail));
        descripcion = parametros.getString(getResources().getString(R.string.pdescripcion));

        tvDate = (TextView)findViewById(R.id.tvFechaNacimiento);
        tvName = (TextView)findViewById(R.id.tvNombre);
        tvPhone = (TextView)findViewById(R.id.tvTelefono);
        tvEmail = (TextView)findViewById(R.id.tvEmail);
        tvDesc = (TextView)findViewById(R.id.tvDescripcion);

        tvName.setText(nombre);
        tvDate.setText(fecha);
        tvPhone.setText(telefono);
        tvEmail.setText(email);
        tvDesc.setText(descripcion);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_edit:
                Intent intent = new Intent(DetalleContacto.this, MainActivity.class);
                intent.putExtra(getResources().getString(R.string.pnombres), nombre);
                intent.putExtra(getResources().getString(R.string.pfecha), fecha);
                intent.putExtra(getResources().getString(R.string.ptelefono), telefono);
                intent.putExtra(getResources().getString(R.string.pemail), email);
                intent.putExtra(getResources().getString(R.string.pdescripcion), descripcion);
                startActivity(intent);
                finish();
        }
    }
}
