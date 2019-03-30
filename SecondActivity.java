package com.example.task15;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.example.coffeeorder.Order.Chocolate;
import com.example.coffeeorder.Order.Cookies;
import com.example.coffeeorder.Order.IceCream;
import com.example.coffeeorder.Order.Order;

public class SecondActivity extends AppCompatActivity {

    private Button btnAddIce,btnLossIce;
    private Button btnAddChoc,btnLossChoc;
    private Button btnAddCook,btnLossCook;
    private TextView tvQuatityChoc, tvQuatityIce, tvQuatityCook;
    private Button btn_submit;
    private TextView iceCreamNumber,iceCreamPrice;
    private TextView cookieNumber,cookiePrice;
    private TextView chocolateNumber,chocolatePrice;
    private TextView tvSummary;

    private int ice;
    private IceCream iceCream = new IceCream();
    private Chocolate chocolate = new Chocolate();
    private Cookies cookies = new Cookies();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();

        OutButtonClick outButtonClick = new OutButtonClick();
        btnAddIce.setOnClickListener(outButtonClick);
        btnAddChoc.setOnClickListener(outButtonClick);
        btnAddCook.setOnClickListener(outButtonClick);
        btnLossIce.setOnClickListener(outButtonClick);
        btnLossChoc.setOnClickListener(outButtonClick);
        btnLossCook.setOnClickListener(outButtonClick);
        btn_submit.setOnClickListener(outButtonClick);


    }
    public void initView(){
        btnAddIce = (Button) findViewById(R.id.addIce);
        btnLossIce = (Button) findViewById(R.id.lossIce);
        tvQuatityIce = (TextView) findViewById(R.id.quantityIce);

        btnAddChoc = (Button) findViewById(R.id.addChoclate);
        btnLossChoc= (Button) findViewById(R.id.lossChoclate);
        tvQuatityChoc = (TextView) findViewById(R.id.quantityChoclate);

        btnAddCook = (Button) findViewById(R.id.addCookies);
        btnLossCook= (Button) findViewById(R.id.lossCookies);
        tvQuatityCook = (TextView) findViewById(R.id.quantityCookies);

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
        btn_submit = (Button)findViewById(R.id.btn_submit);
    }
    class OutButtonClick implements View.OnClickListener{
        //重载方法

        @Override
        public void onClick(View view) {
            Integer iceNumber ,chocNumber,cookNumber,sum;

            
            switch (view.getId()){
                //增加数量
                case R.id.addIce:{

                    iceCream.addNumber();
                    iceNumber = iceCream.getNumber();
                    tvQuatityIce.setText(iceNumber.toString());//返回数量
                    break;
                }

                case R.id.addChoclate:{
                    chocolate.addNumber();
                    chocNumber = chocolate.getNumber();
                  tvQuatityChoc.setText(chocNumber.toString());
                    tvQuatityChoc.setText(chocNumber+"");
                    break;
                }
                case R.id.addCookies:{
                    cookies.addNumber();
                    cookNumber = cookies.getNumber();
                    tvQuatityCook.setText(cookNumber.toString());
                    break;
                }

                //减少数量
                case R.id.lossIce:{
                    iceCream.lossNumber();
                    iceNumber = iceCream.getNumber();
                    tvQuatityIce.setText(iceNumber.toString());
                    break;//返回数量
                }

                case R.id.lossChoclate:
                {
                    chocolate.lossNumber();
                    chocNumber = chocolate.getNumber();
                    tvQuatityChoc.setText(chocNumber.toString());
                }
                break;
                case R.id.lossCookies:{
                    cookies.lossNumber();
                    cookNumber = cookies.getNumber();
                    tvQuatityCook.setText(cookNumber.toString());
                    break;
                }

                case R.id.btn_submit:{

                    //获取三者数量
                    iceNumber = iceCream.getNumber();
                    chocNumber = chocolate.getNumber();
                    cookNumber = cookies.getNumber();


                    iceCreamNumber.setText(iceNumber.toString());
                    chocolateNumber.setText(chocNumber.toString());
                    cookieNumber.setText(cookNumber.toString());

                    iceCreamPrice.setText("6");
                    chocolatePrice.setText("10");
                    cookiePrice.setText("8");

                    sum = 6 * iceNumber + chocNumber * 10 + cookNumber * 8;
                    tvSummary.setText(sum.toString());


                    Intent intent1 = new Intent(SecondActivity.this,ThirdActivity.class);
                    //Log.i("test",iceNumber+"页面2");
                    intent1.putExtra("iceCreamNumber",iceNumber);
                    intent1.putExtra("chocolateNumber",chocNumber);
                    intent1.putExtra("cookieNumber",cookNumber);
                    intent1.putExtra("summary",sum);
                    startActivity(intent1);
                    break;
                }
            }
        }
    }
    class ChechBoxListener implements CompoundButton.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            switch (compoundButton.getId()){
                case R.id.ck_iceCrean:{

                }
                case R.id.ck_choclate:{

                }
                case R.id.ck_cookies:{

                }
            }
        }
    }
}
