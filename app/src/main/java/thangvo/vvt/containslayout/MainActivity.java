package thangvo.vvt.containslayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button bntRandom;
    TextView txtNumber;
    EditText edtMin , edtMax;

    private void cacView(){
        bntRandom = (Button) findViewById(R.id.buttonrandom);
        txtNumber = (TextView) findViewById(R.id.textview0);
        edtMin = (EditText) findViewById(R.id.editTextmin);
        edtMax = (EditText) findViewById(R.id.editTextmax);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cacView();


        bntRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chuoi1 = edtMin.getText().toString();
                String chuoi2 = edtMax.getText().toString();
                int number1 = Integer.parseInt(chuoi1);
                int number2 = Integer.parseInt(chuoi2);
                Random random = new Random();
                int number = random.nextInt(number2 - number1 + 1) + number1;
                txtNumber.setText(number +"");
            }
        });

    }
}