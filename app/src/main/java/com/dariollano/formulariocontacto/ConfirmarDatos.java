package com.dariollano.formulariocontacto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {
    private TextView tvNombre;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvTFecha;
    private TextView tvDescripcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString(getResources().getString(R.string.pnombre_Completo));
        String telefono = parametros.getString(getResources().getString(R.string.ptelefono));
        String email = parametros.getString(getResources().getString(R.string.pemail));
        String fecha = parametros.getString(getResources().getString(R.string.pfecha_nacimiento));
        String descripcion = parametros.getString(getResources().getString(R.string.pdescripcion_Contacto));

        tvNombre = (TextView) findViewById(R.id.tvEl_nombre);
        tvTelefono = (TextView) findViewById(R.id.tvEl_telefono);
        tvEmail = (TextView) findViewById(R.id.tvEl_email);
        tvTFecha = (TextView) findViewById(R.id.tvLa_fecha_nacimiento);
        tvDescripcion = (TextView) findViewById(R.id.tvLa_descripcion);

        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvTFecha.setText(fecha);
        tvDescripcion.setText(descripcion);
    }

    public void editar(View v){

        finish();


       /* Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(getResources().getString(R.string.pnombre_Completo), String.valueOf(tvNombre));
        intent.putExtra(getResources().getString(R.string.ptelefono), String.valueOf(tvTelefono));
        intent.putExtra(getResources().getString(R.string.pemail), String.valueOf(tvEmail));
        intent.putExtra(getResources().getString(R.string.pdescripcion_Contacto), String.valueOf(tvTFecha));
        intent.putExtra(getResources().getString(R.string.pfecha_nacimiento), String.valueOf(tvDescripcion));
        startActivity(intent);*/

    }
}