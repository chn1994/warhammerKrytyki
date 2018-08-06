package com.example.chn.krytyki;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {
    ImageButton sword,bow,gun,hammer,arm,head,body,leg;
    Button apply;
    EditText result,hp;
    String builder;
    byte chw,chp,cop,eff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        chw=0;chp=0;
        builder="";
        setContentView(R.layout.activity_main);
        result = (EditText) findViewById(R.id.etResult);
        hp = (EditText) findViewById(R.id.etHP);
        apply = (Button) findViewById(R.id.btnAccept);
        sword = (ImageButton) findViewById(R.id.ibSword);
        sword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sword.setEnabled(false);
                sword.setBackgroundColor(Color.BLACK);
                bow.setEnabled(true);
                bow.setBackgroundColor(Color.GRAY);
                gun.setBackgroundColor(Color.GRAY);
                hammer.setBackgroundColor(Color.GRAY);
                gun.setEnabled(true);
                hammer.setEnabled(true);
                chw=1;
            }
        });
        bow = (ImageButton) findViewById(R.id.ibBow);
        bow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sword.setEnabled(true);
                bow.setEnabled(false);
                bow.setBackgroundColor(Color.BLACK);
                sword.setBackgroundColor(Color.GRAY);
                gun.setBackgroundColor(Color.GRAY);
                hammer.setBackgroundColor(Color.GRAY);
                gun.setEnabled(true);
                hammer.setEnabled(true);
                chw=3;
            }
        });
        gun = (ImageButton) findViewById(R.id.ibGun);
        gun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sword.setEnabled(true);
                bow.setEnabled(true);
                gun.setEnabled(false);
                gun.setBackgroundColor(Color.BLACK);
                bow.setBackgroundColor(Color.GRAY);
                sword.setBackgroundColor(Color.GRAY);
                hammer.setBackgroundColor(Color.GRAY);
                hammer.setEnabled(true);
                chw=4;
            }
        });
        hammer = (ImageButton) findViewById(R.id.ibHammer);
        hammer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sword.setEnabled(true);
                bow.setEnabled(true);
                gun.setEnabled(true);
                hammer.setEnabled(false);
                hammer.setBackgroundColor(Color.BLACK);
                bow.setBackgroundColor(Color.GRAY);
                gun.setBackgroundColor(Color.GRAY);
                sword.setBackgroundColor(Color.GRAY);
                chw=2;
            }
        });
        arm = (ImageButton) findViewById(R.id.ibArm);
        arm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arm.setEnabled(false);
                arm.setBackgroundColor(Color.BLACK);
                head.setBackgroundColor(Color.GRAY);
                body.setBackgroundColor(Color.GRAY);
                leg.setBackgroundColor(Color.GRAY);
                head.setEnabled(true);
                body.setEnabled(true);
                leg.setEnabled(true);
                chp=1;
            }
        });
        head = (ImageButton) findViewById(R.id.ibHead);
        head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arm.setEnabled(true);
                head.setEnabled(false);
                head.setBackgroundColor(Color.BLACK);
                arm.setBackgroundColor(Color.GRAY);
                body.setBackgroundColor(Color.GRAY);
                leg.setBackgroundColor(Color.GRAY);
                body.setEnabled(true);
                leg.setEnabled(true);
                chp=2;
            }
        });
        body = (ImageButton) findViewById(R.id.ibBody);
        body.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arm.setEnabled(true);
                head.setEnabled(true);
                body.setBackgroundColor(Color.BLACK);
                head.setBackgroundColor(Color.GRAY);
                arm.setBackgroundColor(Color.GRAY);
                leg.setBackgroundColor(Color.GRAY);
                body.setEnabled(false);
                leg.setEnabled(true);
                chp=3;
            }
        });
        leg = (ImageButton) findViewById(R.id.ibLeg);
        leg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arm.setEnabled(true);
                head.setEnabled(true);
                body.setEnabled(true);
                leg.setBackgroundColor(Color.BLACK);
                head.setBackgroundColor(Color.GRAY);
                body.setBackgroundColor(Color.GRAY);
                arm.setBackgroundColor(Color.GRAY);
                leg.setEnabled(false);
                chp=4;
            }
        });
       apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (check())
                    generate();

            }
        });
    }
    public boolean check(){
        if (chp==0 || chw==0) return false;
        if (result.getText().length()==0 || hp.getText().length()==0) return false;
        if (Integer.parseInt(result.getText().toString())>100 || Integer.parseInt(result.getText().toString())==0) return false;
        if (Integer.parseInt(hp.getText().toString())>10 || Integer.parseInt(hp.getText().toString())==0) return false;

      return true;
    };
    public void generate(){
        boolean stop = false;

        byte res,minus;
        switch(chw){
            case 1: builder+="i"; break;
            case 2: builder+="b"; break;
            case 3: builder+="a"; break;
            case 4: builder+="f"; break;
            default: builder=""; stop=true; break;
        }
        switch (chp){
            case 1: builder+="a"; break;
            case 2: builder+="h"; break;
            case 3: builder+="b"; break;
            case 4: builder+="l"; break;
            default: builder=""; stop=true; break;
        }

        res=Byte.parseByte(result.getText().toString());
        minus=Byte.parseByte(hp.getText().toString());
        if (res<8){
            if (minus % 2 == 0) cop=14;
            else if (minus==1) cop=13;
            else cop=15;
        }
        else if (res<15 && res>7){
            if (minus==1) cop=12;
            else if (minus==2) cop=13;
            else if (minus % 2 == 0) cop=15;
            else cop=14;
        }
        else if (res<22 && res>14){
            if (minus==1) cop=11;
            else if (minus==2) cop=12;
            else if (minus==3) cop=13;
            else if (minus % 2 == 0) cop=14;
            else cop=15;
        }
        else if (res<29 && res>21){
            if (minus==1) cop=10;
            else if (minus==2) cop=11;
            else if (minus==3) cop=12;
            else if (minus==4) cop=13;
            else if (minus % 2 == 0) cop=15;
            else cop=14;
        }
        else if (res<36 && res>28){
            if (minus==1) cop=9;
            else if (minus==2) cop=10;
            else if (minus==3) cop=11;
            else if (minus==4) cop=12;
            else if (minus==5) cop=13;
            else if (minus % 2 == 0) cop=14;
            else cop=15;
        }
        else if (res<43 && res>35){
            if (minus==1) cop=8;
            else if (minus==2) cop=9;
            else if (minus==3) cop=10;
            else if (minus==4) cop=11;
            else if (minus==5) cop=12;
            else if (minus==6) cop=13;
            else if (minus % 2 == 0) cop=15;
            else cop=14;
        }
        else if (res<50 && res>42){
            if (minus==1) cop=7;
            else if (minus==2) cop=8;
            else if (minus==3) cop=9;
            else if (minus==4) cop=10;
            else if (minus==5) cop=11;
            else if (minus==6) cop=12;
            else if (minus==7) cop=13;
            else if (minus % 2 == 0) cop=14;
            else cop=15;
        }
        else if (res<57 && res>49){
            cop= (byte) (minus+5);
        }
        else if (res<64 && res>56){
            cop= (byte) (minus+4);
        }
        else if (res<71 && res>63){
            cop= (byte) (minus+3);
        }
        else if (res<77 && res>70){
            cop= (byte) (minus+2);
        }
        else if (res<83 && res>76){
            cop= (byte) (minus+1);
        }
        else if (res<89 && res>82){
            cop = minus;
        }
        else if (res<95 && res>88){
            if(minus==1) cop=1;
            else cop=(byte)(minus-1);
        }
        else if (res<101 && res>94){
            if(minus<3) cop=1;
            else cop=(byte)(minus-2);
        }

        if (cop<8) eff=0;
        else if (cop>7 && cop<13) eff=1;
        else eff=2;

        builder+=cop;
        if (!stop) {
            Intent i = new Intent(this, SecondActivity.class);
            i.putExtra("code",builder);
            i.putExtra("effect",eff);
            builder="";
            startActivity(i);
        }
    };
}
