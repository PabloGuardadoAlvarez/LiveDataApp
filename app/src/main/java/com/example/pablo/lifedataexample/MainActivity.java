package com.example.pablo.lifedataexample;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    Switch simpleSwitch;
    Switch simpleSwitch2;
    TextView primertexto;
    TextView segundotexto;
    EditText tercertexto;
    TextView cuartotexto;
    Button btnEdad;

    private MutableLiveData<Boolean> trabajoLiveData = new MutableLiveData<>();

    private MutableLiveData<Boolean> aprueboLiveData = new MutableLiveData<>();

    private MutableLiveData<String> edadLiveData = new MutableLiveData<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleSwitch = findViewById(R.id.simpleSwitch);
        simpleSwitch2 = findViewById(R.id.simpleSwitch2);
        primertexto = findViewById(R.id.primertexto);
        segundotexto = findViewById(R.id.segundotexto);
        tercertexto = findViewById(R.id.tercertexto);
        cuartotexto = findViewById(R.id.cuartotexto);
        btnEdad = findViewById(R.id.btnEdad);

        trabajoLiveData.observe(this, new Observer<Boolean>() {

            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if (aBoolean == true) {
                    primertexto.setText("Si Trabajo En Casa");
                } else {
                    primertexto.setText("No Trabajo En Casa");

                }
            }

        });

        aprueboLiveData.observe(this, new Observer<Boolean>() {

            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if (aBoolean == true) {
                    segundotexto.setText("Si voy a aprobar");
                } else {
                    segundotexto.setText("No voy a aprobar");

                }
            }

        });

        edadLiveData.observe(this, new Observer<String>() {

            @Override
            public void onChanged(@Nullable String s) {

                cuartotexto.setText("Tengo "+s+" años");

            }


        });

        simpleSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {

                    trabajoLiveData.postValue(true);
                } else {

                    trabajoLiveData.postValue(false);
                }
            }
        });

        simpleSwitch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {

                    aprueboLiveData.postValue(true);
                } else {

                    aprueboLiveData.postValue(false);
                }
            }
        });

        btnEdad.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (btnEdad.isPressed()) {

                    edadLiveData.postValue(tercertexto.getText().toString());
                }

            }

        });
    }

}