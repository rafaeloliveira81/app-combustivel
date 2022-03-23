package br.edu.unis.combustivel_app;

import static java.lang.String.valueOf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtAlcool, edtGasolina;
    TextView txtResultado;
    Button btnCalcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.loadWidgets();
    }

    private void loadWidgets() {
        this.edtAlcool = findViewById(R.id.edt_alcool);
        this.edtGasolina = findViewById(R.id.edt_gasolina);
        this.txtResultado = findViewById(R.id.txt_resultado);
        this.btnCalcular = findViewById(R.id.btn_calcular);
        this.btnCalcular.setOnClickListener(this);
    }

    public void onClick(View view) {
        float alc = Float.parseFloat(edtAlcool.getText().toString());
        float gas = Float.parseFloat(edtGasolina.getText().toString());
        float result = calculaPorcentagem(alc, gas);
        verificaResultado(result);
    }

    private Float calculaPorcentagem(float alcool, float gasolina) {
        return (alcool / gasolina) * 100;
    }

    private void verificaResultado(float percent) {
        if (percent < 70.0) {
            txtResultado.setText("Abasteça com álcool!");
        }
        else {
            txtResultado.setText("Abasteça com gasolina!");
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}