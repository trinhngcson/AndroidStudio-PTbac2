package com.example.giaiptbac2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnNhap,btnGiai,btnThoat;
    TextView tvPhuongTrinh;
    float a, b, c;
    float x1, x2;

    public final static String DATA = "DATA";
    public final static String KETQUA = "KETQUA";
    public static final int NHAPHS_REQUESTCODE = 111;
    public static final int NHAPHS_RESULTCODE = 112;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNhap = (Button) findViewById(R.id.btnNhap);
        btnGiai = (Button) findViewById(R.id.btnGiai);
        tvPhuongTrinh= (TextView) findViewById(R.id.tvPhuongTrinh);
        btnThoat = (Button) findViewById(R.id.btnThoat);


        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity3.class);
                startActivityForResult(intent, MainActivity.NHAPHS_REQUESTCODE);
            }
        });
        btnGiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                Bundle bundle = new Bundle();
                bundle.putString(MainActivity.KETQUA,giaiPTB2(a,b,c));
                intent.putExtra(MainActivity.DATA,bundle);
                startActivity(intent);
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == MainActivity.NHAPHS_REQUESTCODE && resultCode == MainActivity.NHAPHS_RESULTCODE)
        {
            Bundle bundle = data.getExtras();
            a = bundle.getFloat("a");
            b = bundle.getFloat("b");
            c = bundle.getFloat("c");

            String str = a + "x^2 + " + b + " x + " + c + " = 0";
            tvPhuongTrinh.setText(str);

            btnGiai.setEnabled(true);
        }
    }
    String giaiPTB2(float a, float b, float c) {
        if (a == 0) {
            if (b == 0) {
               return "Phương trình vô nghiệm!";
            } else {
                return "Phương trình có một nghiệm: " + "x = " + (-c / b);
            }
        }
        // tính delta
        float delta = b * b - 4 * a * c;
        // tính nghiệm
        if (delta > 0) {
            x1 = (float) ((-b + Math.sqrt(delta)) / (2 * a));
            x2 = (float) ((-b - Math.sqrt(delta)) / (2 * a));
            return "Phương trình có 2 nghiệm là: " + "x1 = " + x1+ " và x2 = " + x2;
        } else if (delta == 0) {
            x1 = (-b / (2 * a));
            return "Phương trình có nghiệm kép: " + "x1 = x2 = "+ x1;
        } else {
            return "Phương trình vô nghiệm!";
        }
    }

}