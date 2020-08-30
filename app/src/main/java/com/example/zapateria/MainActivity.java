package com.example.zapateria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup RbgSexo, RbgTipoZapato,RbgMarca ;
    private RadioButton RbtSexo, RbtTipoZapato,RbtMarca;
    private EditText cantidad;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RbgSexo = findViewById(R.id.rbg_Sexo);
        RbgTipoZapato = findViewById(R.id.rbg_Tipo_Zapato);
        RbgMarca = findViewById(R.id.rbg_Marca);
        cantidad = findViewById(R.id.txtCantidad);
        resultado = findViewById(R.id.lbl_resultado);

    }

    public void calcular(View v){
        int sexoId, tipoZapatoId, marcaId, total=0;
        sexoId = RbgSexo.getCheckedRadioButtonId();
        RbtSexo = findViewById(sexoId);
        tipoZapatoId  = RbgTipoZapato.getCheckedRadioButtonId();
        RbtTipoZapato = findViewById(tipoZapatoId);
        marcaId  = RbgMarca.getCheckedRadioButtonId();
        RbtMarca = findViewById(marcaId);
        if(validar()){
            if(RbtSexo.getText().equals( getString(R.string.rbtHombre) )){
                if(RbtTipoZapato.getText().equals( getString(R.string.rbtZapatilla) )){
                    if(RbtMarca.getText().equals( getString(R.string.rbtNike) )){
                        total = 120000;
                    } if(RbtMarca.getText().equals( getString(R.string.rbtAdidas) )){
                        total= 140000;
                    } if(RbtMarca.getText().equals( getString(R.string.rbtPuma) )){
                        total = 130000;
                    }
                }
                if(RbtTipoZapato.getText().equals( getString(R.string.rbtClasico) )){
                    if(RbtMarca.getText().equals( getString(R.string.rbtNike)) ){
                        total = 50000;
                    }
                    if(RbtMarca.getText().equals( getString(R.string.rbtAdidas) )){
                        total = 80000;
                    }
                    if(RbtMarca.getText().equals( getString(R.string.rbtPuma) )){
                        total = 100000;
                    }
                }
            }
            if(RbtSexo.getText() == getString(R.string.rbtMujer)){
                if(RbtTipoZapato.getText().equals(getString(R.string.rbtZapatilla) )){
                    if(RbtMarca.getText().equals( getString(R.string.rbtNike) )){
                        total = 100000;
                    }
                    if(RbtMarca.getText().equals( getString(R.string.rbtAdidas) )){
                        total = 130000;
                    }
                    if(RbtMarca.getText().equals( getString(R.string.rbtPuma) )){
                        total = 110000;
                    }
                }
                if(RbtTipoZapato.getText().equals( getString(R.string.rbtClasico) )){
                    if(RbtMarca.getText().equals( getString(R.string.rbtNike) )){
                        total = 60000;
                    }
                    if(RbtMarca.getText().equals( getString(R.string.rbtAdidas) )){
                        total = 70000;
                    }
                    if(RbtMarca.getText().equals( getString(R.string.rbtPuma) )){
                        total = 120000;
                    }
                }
            }
            resultado.setText(""+total * Integer.parseInt( cantidad.getText().toString() ));
        }

    }

    public boolean validar(){
        if (RbgSexo.getCheckedRadioButtonId() == -1){
            Toast.makeText(this, getString(R.string.errorSexo), Toast.LENGTH_LONG).show();
            resultado.setText("0");
            return  false;
        }
        if (RbgTipoZapato.getCheckedRadioButtonId() == -1){
            Toast.makeText(this, getString(R.string.errorTipoZapato), Toast.LENGTH_LONG).show();
            resultado.setText("0");
            return  false;
        }
        if (RbgMarca.getCheckedRadioButtonId() == -1){
            Toast.makeText(this, getString(R.string.errorMarca), Toast.LENGTH_LONG).show();
            resultado.setText("0");
            return  false;
        }
        if(cantidad.getText().toString().isEmpty()){
            cantidad.setError(getString(R.string.errorCantidad));
            resultado.setText("0");
            cantidad.requestFocus();
            return  false;
        }
        return true;
    }



}