package thangvo.vvt.containslayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    CheckBox ck1,ck2,ck3;
    SeekBar sk1,sk2,sk3;
    TextView txtDiem , txtCuocdua;
    ImageButton bntplay , bntpause;
    Button bntagain;


    private  void batCheckbox(){
        ck1.setEnabled(true);
        ck2.setEnabled(true);
        ck3.setEnabled(true);
    }

    private  void tatCheckbox(){
        ck1.setEnabled(false);
        ck2.setEnabled(false);
        ck3.setEnabled(false);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ck1 =       (CheckBox) findViewById(R.id.checkBox1);
        ck2 =       (CheckBox) findViewById(R.id.checkBox2);
        ck3 =       (CheckBox) findViewById(R.id.checkBox3);
        sk1 =        (SeekBar) findViewById(R.id.seekBar1);
        sk2 =        (SeekBar) findViewById(R.id.seekBar2);
        sk3 =        (SeekBar) findViewById(R.id.seekBar3);
        txtDiem =    (TextView) findViewById(R.id.textviewdiem);
        txtCuocdua = (TextView) findViewById(R.id.textviewCuocduakithu);
        bntplay = (ImageButton) findViewById(R.id.imageButtonplay);
        bntpause =(ImageButton) findViewById(R.id.imageButtonpause);
        bntagain = (Button) findViewById(R.id.buttonchoilai);

        bntpause.setVisibility(View.INVISIBLE);
        bntagain.setVisibility(View.INVISIBLE);

        sk1.setEnabled(false);
        sk2.setEnabled(false);
        sk3.setEnabled(false);

        ck1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ck2.setChecked(false);
                ck3.setChecked(false);
            }
        });

        ck2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ck1.setChecked(false);
                ck3.setChecked(false);
            }
        });

        ck3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ck1.setChecked(false);
                ck2.setChecked(false);
            }
        });





        final CountDownTimer countDownTimer = new CountDownTimer(60000 , 10) {
            @Override
            public void onTick(long l) {
                Random random = new Random();
                int number = 2;
                sk1.setProgress(sk1.getProgress() + random.nextInt(number));
                sk2.setProgress(sk2.getProgress() + random.nextInt(number));
                sk3.setProgress(sk3.getProgress() + random.nextInt(number));

                int number2 = 100;

                if (sk1.getProgress() >= sk1.getMax()) {
                    if(ck1.isChecked()){
                        number2 += 10;
                        txtDiem.setText(number2+"");
                        Toast.makeText(MainActivity.this, "Số 1 thắng"+"\nBạn được cộng 10 điểm", Toast.LENGTH_SHORT).show();
                        this.cancel();
                    }
                    else{
                        number2 -= 10;
                        txtDiem.setText(number2+"");
                        Toast.makeText(MainActivity.this, "Bạn thua rồi " +"-10 point", Toast.LENGTH_SHORT).show();
                    }
                    bntagain.setVisibility(View.VISIBLE);
                    bntplay.setVisibility(View.INVISIBLE);
                    bntpause.setVisibility(View.INVISIBLE);
                }
                if (sk2.getProgress() >= sk2.getMax()) {

                    if(ck2.isChecked()){
                        number2 += 10;
                        txtDiem.setText(number2+"");
                        Toast.makeText(MainActivity.this, "Số 2 thắng"+"\nBạn được cộng 10 điểm", Toast.LENGTH_SHORT).show();
                        this.cancel();
                    }
                    else{
                        number2 -= 10;
                        txtDiem.setText(number2 +"");
                        Toast.makeText(MainActivity.this, "Bạn thua rồi " +"-10 point", Toast.LENGTH_SHORT).show();

                    }
                    this.cancel();
                    bntagain.setVisibility(View.VISIBLE);
                    bntplay.setVisibility(View.INVISIBLE);
                    bntpause.setVisibility(View.INVISIBLE);
                }

                if (sk3.getProgress() >= sk3.getMax()) {

                    if(ck3.isChecked()){
                        number2 += 10;
                        txtDiem.setText(number2+"");
                        Toast.makeText(MainActivity.this, "Số 3 thắng"+"\nBạn được cộng 10 điểm", Toast.LENGTH_SHORT).show();
                        this.cancel();
                    }
                    else{
                        number2 -= 10;
                        txtDiem.setText(number2+"");
                        Toast.makeText(MainActivity.this, "Bạn thua rồi " +"-10 point", Toast.LENGTH_SHORT).show();
                    }
                    this.cancel();
                    bntagain.setVisibility(View.VISIBLE);
                    bntplay.setVisibility(View.INVISIBLE);
                    bntpause.setVisibility(View.INVISIBLE);
                }

            }

            @Override
            public void onFinish() {

            }
        };
        bntplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ck1.isChecked() || ck2.isChecked() || ck3.isChecked()){
                    bntplay.setVisibility(View.INVISIBLE);
                    bntpause.setVisibility(View.VISIBLE);
                    countDownTimer.start();
                    tatCheckbox();
                }
                else {
                    Toast.makeText(MainActivity.this, "Vui lòng chọn checkbox", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bntpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                bntpause.setVisibility(View.INVISIBLE);
                bntplay.setVisibility(View.VISIBLE);
            }
        });

        bntagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                sk1.setProgress(0);
                sk2.setProgress(0);
                sk3.setProgress(0);
                bntplay.setVisibility(View.VISIBLE);
                bntpause.setVisibility(View.INVISIBLE);
                batCheckbox();
                bntagain.setVisibility(View.INVISIBLE);

            }
        });




    }
}