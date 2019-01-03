package sj.app.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import sj.app.R;

public class Act_Page1_0 extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act__page1_0);
        LinearLayout btn_back = findViewById(R.id.btn_page1_0_back);
        LinearLayout btn_delete = findViewById(R.id.btn_page1_0_delete);
        LinearLayout btn_edit = findViewById(R.id.btn_page1_0_edit);
        LinearLayout btn_add = findViewById(R.id.btn_page1_0_add);

        btn_add.setOnClickListener(this);
        btn_edit.setOnClickListener(this);
        btn_back.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_page1_0_add:
                startActivity(new Intent(this,Act_Page1_0_add.class));
                break;
            case R.id.btn_page1_0_delete:

                break;
            case R.id.btn_page1_0_back:
                finish();
                break;
            case R.id.btn_page1_0_edit:

                break;
        }
    }
}
