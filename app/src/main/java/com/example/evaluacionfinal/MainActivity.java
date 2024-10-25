package com.example.evaluacionfinal;

import static com.example.evaluacionfinal.R.*;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.evaluacionfinal.entity.pelicula;
import com.example.evaluacionfinal.util.ConectionRest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.example.evaluacionfinal.api.ServicePeliculaApi;


public class MainActivity extends AppCompatActivity {

    private EditText editTextNombre, editTextCalificacion;
    private Spinner spinnerGenero;
    private DatePicker datePickerAnio;
    private Button buttonEnviar;

   ServicePeliculaApi apiPelicula ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextCalificacion = findViewById(R.id.editTextCalificacion);
        spinnerGenero = findViewById(R.id.spinnerGenero);
        datePickerAnio = findViewById(R.id.datePickerAnio);
        buttonEnviar = findViewById(R.id.buttonEnviar);



        apiPelicula = ConectionRest.getConnection().create(ServicePeliculaApi.class);

        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombrePelicula = editTextNombre.getText().toString();
                String genero = spinnerGenero.getSelectedItem().toString();
                String calificacion = editTextCalificacion.getText().toString();
                int año = datePickerAnio.getYear()+ datePickerAnio.getDayOfMonth()+datePickerAnio.getDayOfMonth();

                pelicula obj = new pelicula();
                obj.setNombre(nombrePelicula);
                obj.setGenero(genero);
                obj.setNombre(calificacion);
                obj.setAnio(año);
                insertarpelicula(obj);
            }
        });
    }


    void insertarpelicula(pelicula obj) {
        Call<pelicula> call= apiPelicula.registrar(obj);
        call.enqueue(new Callback<pelicula>() {
            @Override
            public void onResponse(Call<pelicula> call, Response<pelicula> response) {
            }


            @Override
            public void onFailure(Call<pelicula> call, Throwable t) {

            }
        });

    }
}
