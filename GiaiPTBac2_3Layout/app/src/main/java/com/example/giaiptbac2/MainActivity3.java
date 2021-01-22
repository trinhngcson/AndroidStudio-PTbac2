package com.example.giaiptbac2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity3 extends AppCompatActivity {
    Button btnHoanThanh;
    EditText txta,txtb,txtc;
    float a, b, c;
    final  static String DATA = "DATA";
    final  static String PHUONGTRINH = "PHUONGTRINH";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        btnHoanThanh = (Button) findViewById(R.id.btnHoanThanh);
        txta = (EditText) findViewById(R.id.txta);
        txtb = (EditText) findViewById(R.id.txtb);
        txtc = (EditText) findViewById(R.id.txtc);

        btnHoanThanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                Bundle bundle = new Bundle();

                a = Float.parseFloat(txta.getText().toString());
                b = Float.parseFloat(txtb.getText().toString());
                c = Float.parseFloat(txtc.getText().toString());

                bundle.putFloat("a", a);
                bundle.putFloat("b", b);
                bundle.putFloat("c", c);

                intent.putExtras(bundle);
                setResult(MainActivity.NHAPHS_RESULTCODE, intent);
                finish();


            }
        });
    }
}