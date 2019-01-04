package sj.app.view.activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Date;
import sj.app.R;
import sj.app.model.entry.Purchase;

//新增页面采购单（例子）
public class Act_Page1_0_add_purchase extends AppCompatActivity {
    int index = 0;
    private String name;
    private int price;
    private int quity;
    private EditText et_name;
    private EditText et_price;
    private EditText et_quity;
    private TextView tv_amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act__page1_0_add_purchase);
//        TextView tv_name = findViewById(R.id.purchase_name);
//        TextView tv_quity = findViewById(R.id.purchase_quity);
//        TextView tv_price = findViewById(R.id.purchase_price);
        tv_amount = findViewById(R.id.purchase_amount);
        TextView tv_date = findViewById(R.id.purchase_date);
        TextView tv_user = findViewById(R.id.purchase_user);
        TextView tv_number = findViewById(R.id.purchase_number);

        et_name = findViewById(R.id.purchase_name_edit);
        et_price = findViewById(R.id.purchase_price_et);
        et_quity = findViewById(R.id.purchase_quity_et);

        Button button = findViewById(R.id.purchase_save);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        final String date = sdf.format(new Date());
        final String purNumber =  sdf.format(new Date())+"-"+index;
        tv_number.setText("单号:"+purNumber);
        tv_date.setText("订单日期:"+date);
        tv_user.setText("采购人：获取登陆账号user");

        //保存到数据库
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    name = et_name.getText().toString();
                    price = Integer.parseInt(et_price.getText().toString());
                    quity = Integer.parseInt(et_quity.getText().toString());
                }catch (Exception e){
                    Toast.makeText(Act_Page1_0_add_purchase.this, "请检查输入数据", Toast.LENGTH_SHORT).show();
                }
                Purchase purchase = new Purchase();
                purchase.setPur_num(purNumber);
                purchase.setDate(date);
                purchase.setUser("user");
                purchase.setName(name);
                purchase.setQuity(quity);
                purchase.setPrice(price);
                purchase.setAmount(price*quity);
                tv_amount.setText("总额:"+price*quity);
                purchase.save();
            }
        });
        et_name.getText();
//计算
        tv_amount.setText("总额:");
    }
}
