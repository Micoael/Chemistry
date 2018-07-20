package zhangguangwei.chemistry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ActionBar;
import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.sql.Ref;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import zhangguangwei.chemistry.ChemistryObject.Symbol;

public class SymbolPage extends AppCompatActivity {

    private Button numBtn;
    private Button ChineseBtn;
    private Button symBtn;
    private FloatingActionButton Refresh;
    private String r_num;
    private String r_ch;
    private String r_en;
    private TextView mTextView;
    private Button swtichState;
    private int starredID;
    public List<Symbol> SymbolList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symbol_page);
        numBtn=(Button) findViewById(R.id.or_number);
        ChineseBtn=(Button) findViewById(R.id.or_name_chinese);
        symBtn=(Button)findViewById(R.id.or_name_english);
        Refresh=  findViewById(R.id.or_refresh);
        mTextView = (TextView) findViewById(R.id.TitleText);



        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // 开始走马灯效果
        mTextView.setSelected(true);
        //氢，氦，锂，铍，硼，碳，氮，氧，氟，氖，钠，镁，铝，硅，磷，硫，氯，氩，钾，钙
        SymbolList = new ArrayList<Symbol>();
        AddToList();

        Refresh.setOnClickListener(new FloatingActionButton.OnClickListener() {
            @Override
            public void onClick(View view) {

                RandomSetName();
                numBtn.setText("");
                ChineseBtn.setText("");
                symBtn.setText("");
                final RotateAnimation animation = new RotateAnimation(0.0f, 360.0f,
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);
                animation.setDuration( 300 );
                Refresh.startAnimation( animation );
            }
        });

        numBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                numBtn.setText(r_num);
            }
        });

        ChineseBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChineseBtn.setText(r_ch);
            }
        });

        symBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                symBtn.setText(r_en);
            }
        });



    }

    public void AddToList(){
        SymbolList.add(new Symbol("氢","H","1"));
        SymbolList.add(new Symbol("氦","He","2"));
        SymbolList.add(new Symbol("锂","Li","3"));
        SymbolList.add(new Symbol("铍","Be","4"));
        SymbolList.add(new Symbol("硼","B","5"));
        SymbolList.add(new Symbol("碳","C","6"));
        SymbolList.add(new Symbol("氮","N","7"));
        SymbolList.add(new Symbol("氧","O","8"));
        SymbolList.add(new Symbol("氟","F","9"));
        SymbolList.add(new Symbol("氖","Ne","10"));
        SymbolList.add(new Symbol("钠","Na","11"));
        SymbolList.add(new Symbol("镁","Mg","12"));
        SymbolList.add(new Symbol("铝","Al","13"));
        SymbolList.add(new Symbol("硅","Si","14"));
        SymbolList.add(new Symbol("磷","P","15"));
        SymbolList.add(new Symbol("硫","S","16"));
        SymbolList.add(new Symbol("氯","Cl","17"));
        SymbolList.add(new Symbol("氩","Ar","18"));
        SymbolList.add(new Symbol("钾","K","19"));
        SymbolList.add(new Symbol("钙","Ca","20"));

    }

    public void RandomSetName(){
        Random rand = new Random();
        int number = rand.nextInt(20);
        if(number<=20||number>0){
            r_num= SymbolList.get(number).Number;
            r_ch= SymbolList.get(number).ChineseName;
            r_en= SymbolList.get(number).EnglishName;

        }else{
            Toast.makeText(this,"Ooh, something happened....",Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish(); // back button
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
