package mx.itson.usuariologin;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class LoginActivity extends AppCompatActivity {

    private EditText etCorreo;
    private EditText edContrasenia;
    private Button btnIniciar;

    private TextView tvRegistro;
    private ImageView imgLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        etCorreo = findViewById(R.id.etCorreo);
        edContrasenia = findViewById(R.id.edContrasenia);
        btnIniciar = findViewById(R.id.btnIniciar);
        tvRegistro = findViewById(R.id.tvRegistro);
        imgLogo = findViewById(R.id.imgLogo);

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String correo = etCorreo.getText().toString();
                String saludo = "Hola " + correo;
                Toast.makeText(LoginActivity.this, saludo, Toast.LENGTH_LONG).show();

                Intent intent = new Intent(LoginActivity.this, LoginActivity.class);
                intent.putExtra("CORREO", correo);
                //startActivity(intent);
                startActivityForResult(intent, 777);
            }
        });

        tvRegistro.setPaintFlags(tvRegistro.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        tvRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        Log.d("CicloVida", "onCreate");

        //https://sic.cultura.gob.mx/images/62898
        //https://www.itson.mx/micrositios/identidad/PublishingImages/potros-itson.jpg
        Picasso.get()
                .load("https://www.itson.mx/micrositios/identidad/PublishingImages/potros-itson.jpg")
                .into(imgLogo);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("CicloVida", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("CicloVida", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("CicloVida", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("CicloVida", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("CicloVida", "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("CicloVida", "onRestart");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 777 & resultCode == RESULT_OK) {
            String saludo = data.getStringExtra("VARIABLE_REGRESO");
            Toast.makeText(LoginActivity.this, saludo, Toast.LENGTH_LONG).show();
        }

    }
}