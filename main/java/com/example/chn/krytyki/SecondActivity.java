package com.example.chn.krytyki;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView desc,addon;
    String output,stars;
    int id;
    int starsid;
    byte effect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        stars="";
        setContentView(R.layout.activity_second);
        desc = (TextView) findViewById(R.id.tvDesc);
        addon = (TextView) findViewById(R.id.tvAddon);
        output = getIntent().getStringExtra("code");
        effect = getIntent().getByteExtra("effect", (byte) 5);

        if (output.equals("aa7")  || output.equals("aa8")  || output.equals("aa9")  || output.equals("aa10") || output.equals("aa11") || output.equals("aa12") || output.equals("aa13") || output.equals("ah10") || output.equals("ah11") || output.equals("aa12") || output.equals("ah13")) stars="aahg";
        if (output.equals("ab10") || output.equals("ab11") || output.equals("ab12") || output.equals("al7")  || output.equals("al8")  || output.equals("al9")  || output.equals("al10") || output.equals("al11") || output.equals("ah12") || output.equals("aa13") ) stars="ablg";
        if (output.equals("ab6")  || output.equals("ab7")  || output.equals("ab8")  || output.equals("ab9")  || output.equals("ab13") ) stars="ablg2";
        if (output.equals("fh10") || output.equals("fh11") || output.equals("fh12") || output.equals("fa8")  || output.equals("fa9")  || output.equals("fa10") || output.equals("fa11") || output.equals("fa12") || output.equals("fa13")) stars="fhag";
        if (output.equals("fb6")  || output.equals("fb7")  || output.equals("fb8")  || output.equals("fb9")  || output.equals("fb10") || output.equals("fb12")) stars="fblg2";
        if (output.equals("fb11") || output.equals("fb13") || output.equals("fl6")  || output.equals("fl7")  || output.equals("fl8")  || output.equals("fl9")  || output.equals("fl10") || output.equals("fl11") || output.equals("fl12") || output.equals("fl13") ) stars="fblg";

        id = getResources().getIdentifier(output,"string",getPackageName());
        desc.setText(getString(id));
        if (stars!=""){
            starsid = getResources().getIdentifier(stars,"string",getPackageName());
            addon.setText(getString(starsid));
        }
        else addon.setText("");
        switch (effect){
            case 0: desc.setTextColor(Color.WHITE); break;
            case 1: desc.setTextColor(Color.YELLOW); break;
            case 2: desc.setTextColor(Color.RED); break;
            default: break;
        }
    }
}
