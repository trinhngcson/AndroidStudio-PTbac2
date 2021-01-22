package com.example.giaiptbac2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView tvThongBao;
    Button btnQuayLai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tvThongBao = (TextView) findViewById(R.id.tvThongBao);
        btnQuayLai = (Button) findViewById(R.id.btnQuayLai);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(MainActivity.DATA);

        tvThongBao.setText(bundle.getString(MainActivity.KETQUA));


        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}