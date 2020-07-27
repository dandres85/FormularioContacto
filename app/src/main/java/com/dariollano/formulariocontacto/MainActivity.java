package com.dariollano.formulariocontacto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout textInputEmail;
    private TextInputLayout textInputTelefono;
    private TextInputLayout textInputNombrecompleto;
    private TextInputLayout textInputDescripcion;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInputEmail = findViewById(R.id.text_input_email);
        textInputTelefono = findViewById(R.id.text_input_telefono);
        textInputNombrecompleto = findViewById(R.id.text_input_nombreCompleto);
        textInputDescripcion = findViewById(R.id.text_input_descripcion);

    }

    private boolean validateEmail(){
        String emailInput = textInputEmail.getEditText().getText().toString().trim();

        if (emailInput.isEmpty()){
            textInputEmail.setError("Este campo no puede estar vacio");
            return false;
            } else {
            textInputEmail.setError(null);
            return true;
        }

    }

    private boolean validateUsername(){
        String telefonoInput = textInputTelefono.getEditText().getText().toString().trim();

        if(telefonoInput.isEmpty()){
            textInputTelefono.setError("Este campo no puede estar vacio");
            return false;
            } else if(telefonoInput.length() > 15){
            textInputTelefono.setError("Username es demaciado largo");
            return false;
        } else {
            textInputTelefono.setError(null);
            return true;
        }
    }

    private boolean validatePassword(){
        String nombreCompletoInput = textInputNombrecompleto.getEditText().getText().toString().trim();

        if (nombreCompletoInput.isEmpty()){
            textInputNombrecompleto.setError("Este campo no puede estar vacio");
            return false;
        } else {
            textInputNombrecompleto.setError(null);
            return true;
        }

    }
    public void confirmInput(View v){
        if (!validateEmail() |!validateUsername() | !validatePassword()){
            return;
        }
        DatePicker miDatePicker = (DatePicker) findViewById(R.id.mi_Datepicker);
        int dia_mes_a_enviar = miDatePicker.getDayOfMonth();
        int mes_a_enviar = miDatePicker.getMonth();
        int año_a_enviar = miDatePicker.getYear();

        String email_input = "" + textInputEmail.getEditText().getText().toString();

        String telefono_input = "" + textInputTelefono.getEditText().getText().toString();

        String nombre_input = "" + textInputNombrecompleto.getEditText().getText().toString();

        String descripcion_input = "" + textInputDescripcion.getEditText().getText().toString();

        String fecha_input = "" + dia_mes_a_enviar + "/" + mes_a_enviar + "/" + año_a_enviar;


        Toast.makeText(this, nombre_input, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(MainActivity.this, ConfirmarDatos.class);
        intent.putExtra(getResources().getString(R.string.pnombre_Completo), nombre_input);
        intent.putExtra(getResources().getString(R.string.ptelefono), telefono_input);
        intent.putExtra(getResources().getString(R.string.pemail), email_input);
        intent.putExtra(getResources().getString(R.string.pdescripcion_Contacto), descripcion_input);
        intent.putExtra(getResources().getString(R.string.pfecha_nacimiento), fecha_input);
        startActivity(intent);
    }
}