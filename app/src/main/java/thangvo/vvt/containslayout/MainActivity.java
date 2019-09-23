package thangvo.vvt.containslayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btn;
    ProgressBar prb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.buttondownload);
        prb = (ProgressBar) findViewById(R.id.progressBar2ngang);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CountDownTimer countDownTimer = new CountDownTimer(10000, 200) {
                    @Override
                    public void onTick(long l) {
                        int vitri =prb.getProgress();
                        if(vitri >= prb.getMax()){
                            vitri = 0;
                        }
                        prb.setProgress(vitri + 10);
                    }

                    @Override
                    public void onFinish() {
                        Toast.makeText(MainActivity.this, "Finished", Toast.LENGTH_SHORT).show();
                    }
                };
                countDownTimer.start();
            }
        });
    }
}