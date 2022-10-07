package br.ulbra.appcalcsalariodt;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioGroup rgPercentual;
    Button btCalcular;
    EditText edSalario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edSalario = (EditText) findViewById(R.id.edSalario);
        rgPercentual = (RadioGroup) findViewById(R.id.rgPercentual);
        btCalcular = (Button) findViewById(R.id.btCalcular);
        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double salario = Double.parseDouble(edSalario.getText().toString());
                int pc = rgPercentual.getCheckedRadioButtonId();
                double novo_salario = 0;
                if (pc==R.id.rbP40) {
                    novo_salario = salario + (salario*0.4);
                }
                else if (pc==R.id.rbP45) {
                    novo_salario = salario + (salario*0.45);
                }
                else {
                    novo_salario = salario + (salario*0.5);
                }
                AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
                    dialogo.setTitle("Novo Salário:");
                    dialogo.setMessage("Seu novo salário é: " + String.valueOf(novo_salario));
                    dialogo.setNeutralButton("Ok",null);
                    dialogo.show();
            }
        });
    }
}