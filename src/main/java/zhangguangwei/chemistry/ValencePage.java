package zhangguangwei.chemistry;


import zhangguangwei.chemistry.ChemistryObject.Valence;
import android.content.DialogInterface;
import android.graphics.drawable.Icon;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ValencePage extends AppCompatActivity {

    private Button ChineseBtn;
    private Button SymbolBtn;
    private Button ValnceBtn;
    private FloatingActionButton Refresh;
    private String r_C;
    private String r_S;
    private String r_V;
    private FloatingActionButton switchState;
    private boolean isSelectedOnly=true;
    public List<Valence> VanlanceList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valence_page);

        try{
            //find controls
            Refresh=findViewById(R.id.refresh_btn);
            ChineseBtn=findViewById(R.id.or_chinese);
            SymbolBtn=findViewById(R.id.or_symbol);
            ValnceBtn=findViewById(R.id.or_valence);
            VanlanceList=new ArrayList<Valence>();
            //switchState=findViewById(R.id.switchState);
            switchState=findViewById(R.id.switch_btn);
            Refresh = findViewById(R.id.refresh_btn);
            AddToList();

            android.support.v7.app.ActionBar actionBar = getSupportActionBar();
            if(actionBar != null){
                actionBar.setHomeButtonEnabled(true);
                actionBar.setDisplayHomeAsUpEnabled(true);
            }

            ChineseBtn.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ChineseBtn.setText(r_C);
                }
            });

            switchState.setOnClickListener(new FloatingActionButton.OnClickListener() {
                @Override
                public void onClick(View view) {
                    isSelectedOnly=isSelectedOnly? false:true;
                    if(isSelectedOnly){
                        switchState.setImageResource(R.drawable.ic_assignment_returned_black_24dp);
                    }else{
                        switchState.setImageResource(R.drawable.ic_move_to_inbox_black_48dp);
                    }

                    ChineseBtn.setText("");
                    SymbolBtn.setText("");
                    ValnceBtn.setText("");
                    RandomSetName();
                    Toast.makeText(ValencePage.this,"切换完毕.",Toast.LENGTH_SHORT).show();
                }
            });

            SymbolBtn.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SymbolBtn.setText(r_S);
                }
            });

            ValnceBtn.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ValnceBtn.setText(r_V);
                }
            });

            Refresh.setOnClickListener(new FloatingActionButton.OnClickListener() {
                @Override
                public void onClick(View view) {
                    RandomSetName();
                    ChineseBtn.setText("");
                    SymbolBtn.setText("");
                    ValnceBtn.setText("");
                    final RotateAnimation animation = new RotateAnimation(0.0f, 360.0f,
                            Animation.RELATIVE_TO_SELF, 0.5f,
                            Animation.RELATIVE_TO_SELF, 0.5f);
                    animation.setDuration( 300 );
                    Refresh.startAnimation( animation );
                }
            });

        }catch(Exception e){
            new AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage(e.getMessage())

                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    })
                    .create().show();
        }


    }


    public void AddToList(){
        VanlanceList.add(new Valence("氢","H","+1"));
        VanlanceList.add(new Valence("锂","Li","+1"));
        VanlanceList.add(new Valence("钠","Na","+1"));
        VanlanceList.add(new Valence("钾","K","+1"));
        VanlanceList.add(new Valence("银","Ag","+1"));
        VanlanceList.add(new Valence("铜","Cu","+2"));
        VanlanceList.add(new Valence("锌","Zn","+2"));
        VanlanceList.add(new Valence("钙","Ca","+2"));
        VanlanceList.add(new Valence("镁","Mg","+2"));
        VanlanceList.add(new Valence("钡","Ba","+2"));
        VanlanceList.add(new Valence("铝","Al","+3"));
        VanlanceList.add(new Valence("铁","Fe","+3"));
        VanlanceList.add(new Valence("硅","Si","+4"));
        VanlanceList.add(new Valence("碳","C","+4"));
        VanlanceList.add(new Valence("氯","Cl","-1"));
        VanlanceList.add(new Valence("氟","F","-1"));
        VanlanceList.add(new Valence("碘","I","-1"));
        VanlanceList.add(new Valence("溴","Br","-1"));
        VanlanceList.add(new Valence("氧","O","-2"));
        VanlanceList.add(new Valence("硫","S","-2"));
        VanlanceList.add(new Valence("汞","Hg","+2"));
        VanlanceList.add(new Valence("亚铁","Fe","+2"));

        VanlanceList.add(new Valence("铵根","NH4","+1"));//22 No.
        VanlanceList.add(new Valence("氢氧根","OH","-1"));
        VanlanceList.add(new Valence("硝酸根","NO3","-1"));
        VanlanceList.add(new Valence("碳酸氢根","CHO3","-1"));
        VanlanceList.add(new Valence("高锰酸根","MnO4","-1"));
        VanlanceList.add(new Valence("氯酸根","ClO3","-1"));
        VanlanceList.add(new Valence("碳酸根","CO3","-2"));
        VanlanceList.add(new Valence("硫酸根","SO4","-2"));
        VanlanceList.add(new Valence("亚硫酸根","SO3","-2"));
        VanlanceList.add(new Valence("硅酸根","SiO3","-2"));
        VanlanceList.add(new Valence("锰酸根","MnO4","-2"));
        VanlanceList.add(new Valence("磷酸根","PO4","-3"));




    }


    public void RandomSetName(){
        Random rand = new Random();

        if(isSelectedOnly){
            int number = rand.nextInt(12)+22;
            if(number>=22||number<=33){
                try{
                    r_V= VanlanceList.get(number).Valence;
                    r_C= VanlanceList.get(number).ChineseName;
                    r_S= VanlanceList.get(number).EnglishName;
                    Toast.makeText(this,"生成完毕.",Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(this,"Error!",Toast.LENGTH_SHORT).show();
                }


            }else{
                Toast.makeText(this,"Ooh, something happened....",Toast.LENGTH_SHORT).show();


            }
        }else{
            int number = rand.nextInt(33);
            if(number<=33||number>0){
                try{
                    r_V= VanlanceList.get(number).Valence;
                    r_C= VanlanceList.get(number).ChineseName;
                    r_S= VanlanceList.get(number).EnglishName;
                    Toast.makeText(this,"生成完毕.",Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(this,"Error!",Toast.LENGTH_SHORT).show();
                }


            }else{
                Toast.makeText(this,"Ooh, something happened....",Toast.LENGTH_SHORT).show();


            }
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
