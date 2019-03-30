import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.example.coffeeorder.Order.Chocolate;
import com.example.coffeeorder.Order.Cookies;
import com.example.coffeeorder.Order.IceCream;
import com.example.coffeeorder.Order.Order;

public class ThirdActivity extends AppCompatActivity {
    private IceCream iceCream = new IceCream();
    private Chocolate chocolate = new Chocolate();
    private Cookies cookies = new Cookies();
    private Order order = new Order();//新建一个Order对象

    private EditText edt_name, edt_tel, edt_adress;
    private TextView tv_name, tv_tel, tv_adress;
    private Button btn_order;

    private TextView iceCreamNumber,iceCreamPrice;
    private TextView cookieNumber,cookiePrice;
    private TextView chocolateNumber,chocolatePrice;
    private TextView tvSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        initView();
        InfoButtonClick infoButtonClick = new InfoButtonClick();
        btn_order.setOnClickListener(infoButtonClick);

        Intent intent1 = getIntent();
        int ice_number = intent1.getIntExtra("iceCreamNumber",0);
        //Log.i("test", ice_number+"页面3");
        String ice = String.valueOf(ice_number);
        iceCreamNumber.setText(ice);
        iceCreamPrice.setText("6");

        int choc_number = intent1.getIntExtra("chocolateNumber",0);
        String cho = String.valueOf(choc_number);
        chocolateNumber.setText(cho);
        chocolatePrice.setText("10");

        int cook_number = intent1.getIntExtra("cookieNumber",0);
        String cook = String.valueOf(cook_number);
        cookieNumber.setText(cook);
        cookiePrice.setText("8");

        int sum = intent1.getIntExtra("summary",0);
        String su = String.valueOf(sum);
        tvSummary.setText(su);

    }

    private void initView() {
        edt_name = (EditText) findViewById(R.id.edt_name);
        edt_tel = (EditText) findViewById(R.id.edt_tel);
        edt_adress = (EditText) findViewById(R.id.edt_address);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_tel = (TextView) findViewById(R.id.tv_tel);
        tv_adress = (TextView) findViewById(R.id.tv_address);
        btn_order = (Button)findViewById(R.id.btn_order);

        iceCreamNumber = (TextView)findViewById(R.id.iceCreamNumber);
        iceCreamPrice = (TextView)findViewById(R.id.iceCreamPrice);

        chocolateNumber = (TextView)findViewById(R.id.chocolateNumber);
        chocolatePrice = (TextView)findViewById(R.id.chocolatePrice);

        cookieNumber = (TextView)findViewById(R.id.cookiesNumber);
        cookiePrice = (TextView)findViewById(R.id.cookiesPrice);


        iceCreamPrice = (TextView)findViewById(R.id.iceCreamPrice);
        chocolatePrice = (TextView)findViewById(R.id.chocolatePrice);
        cookiePrice = (TextView)findViewById(R.id.cookiesPrice);
        tvSummary = (TextView) findViewById(R.id.summary);

    }

    class InfoButtonClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_order:{
                    String name = edt_name.getText().toString();
                    tv_name.setText(name);
                    String tel = edt_tel.getText().toString();
                    tv_tel.setText(tel);
                    String adress = edt_adress.getText().toString();
                    tv_adress.setText(adress);

                }
            }
        }
    }
}
