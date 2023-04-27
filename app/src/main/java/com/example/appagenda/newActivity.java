package com.example.appagenda;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appagenda.db.DbContactos;

public class newActivity extends AppCompatActivity {
    EditText txtNombre, txtTelefono, txtCorreoEletronico;
    Button btnGuarda;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        txtNombre = findViewById(R.id.txtNombre);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtCorreoEletronico = findViewById(R.id.txtCorreoElectronico);
        btnGuarda = findViewById(R.id.btnGuarda);

        btnGuarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    DbContactos dbContactos = new DbContactos(newActivity.this);
                    long id = dbContactos.insertarContacto(txtNombre.getText().toString(), txtTelefono.getText().toString(), txtCorreoEletronico.getText().toString());

                    if (id > 0) {
                        Toast.makeText(newActivity.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                        limpiar();
                    } else {
                        Toast.makeText(newActivity.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_LONG).show();
                    }
                }
        });

    }
    private void limpiar(){
        txtNombre.setText("");
        txtTelefono.setText("");
        txtCorreoEletronico.setText("");
    }
}


//if (!txtNombre.getText().toString().equals("") &&
  //      !txtTelefono.getText().toString().equals("")){