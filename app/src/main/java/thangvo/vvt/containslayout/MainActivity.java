package thangvo.vvt.containslayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    RelativeLayout rltl;
    ImageView hinh1,hinh2,hinh3;
    Button bntchuyenHinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rltl = (RelativeLayout) findViewById(R.id.relativeLayout);
        bntchuyenHinh = (Button) findViewById(R.id.button3);

        final ArrayList<Integer> listHinhAnh = new ArrayList<>();
        listHinhAnh.add(R.drawable.hinhxe);
        listHinhAnh.add(R.drawable.hinhdep1);

        bntchuyenHinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int vitri = random.nextInt(listHinhAnh.size());
                rltl.setBackgroundResource(listHinhAnh.get(vitri));
            }
        });

    }
}