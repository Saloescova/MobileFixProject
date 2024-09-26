package co.com.myapp.cesde;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registro extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();

    DatabaseReference reference = database.getReference().child("usuario");

    Button btnVolverDesdeRegistroAhome;
    EditText inputIdusario;
    EditText inputNombreUsuario;
    EditText inputApellidoUsuario;
    EditText inputCorreoUsuario;
    EditText inputTelefonusario;
    EditText inputContrasena;
    Button btnGuardarUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro);



            btnVolverDesdeRegistroAhome = findViewById(R.id.btn_volver_reg);
            inputIdusario = findViewById(R.id.input_user_name);
            inputIdusario = findViewById(R.id.input_user_lastname);
            inputIdusario = findViewById(R.id.input_user_email);
            inputIdusario = findViewById(R.id.input_user_phone);
            inputIdusario = findViewById(R.id.input_user_password);
            btnGuardarUsuario = findViewById(R.id.btn_registrar);


            btnGuardarUsuario.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    crearUsuario();
                }
            });
    }

    public void crearUsuario(){
        String idUsuario = inputIdusario.getText().toString();

        DatabaseReference nuevoUsuario = reference.child(idUsuario);

        String nombre = inputNombreUsuario.getText().toString();

        nuevoUsuario.child("Nombre").setValue(nombre);

        String apellido = inputApellidoUsuario.getText().toString();

        nuevoUsuario.child("Apellido").setValue(apellido);

        String correo = inputCorreoUsuario.getText().toString();

        nuevoUsuario.child("Correo").setValue(correo);

        String telefono = inputTelefonusario.getText().toString();

        nuevoUsuario.child("Telefono").setValue(telefono);

        String contrasena = inputContrasena.getText().toString();

        nuevoUsuario.child("Contraseña").setValue(contrasena);

        Toast.makeText(getApplicationContext(),"Usuario Creado Exitosamente", Toast.LENGTH_LONG).show();

    }
}