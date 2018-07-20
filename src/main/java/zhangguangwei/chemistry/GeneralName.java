package zhangguangwei.chemistry;

import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import zhangguangwei.chemistry.ChemistryObject.General_name_class;
import zhangguangwei.chemistry.ChemistryObject.Symbol;

public class GeneralName extends AppCompatActivity {

    private Button general_name,name_en,name_cn,more_options;
    private SeekBar start_pos,end_pos;
    private List<General_name_class> general_name_list;
    private FloatingActionButton refresh;
    private int id_this;
    private General_name_class gen;
private LinearLayout more;
    private double start_posis,end_posis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try{
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_general_name);

            //find
            general_name=findViewById(R.id.general_name);
            //more.findViewById(R.id.MLOut); >> WENT WRONG
            more=findViewById(R.id.more_options); // >> Right
            name_en=findViewById(R.id.name_en);
            name_cn=findViewById(R.id.name_ch);
            start_pos=findViewById(R.id.beginning);
            end_pos = findViewById(R.id.ending);
            refresh = findViewById(R.id.refresh);
            more_options = findViewById(R.id.options);
            general_name_list = new ArrayList<General_name_class>();
            addToList();
            start_posis=start_pos.getProgress();
            end_posis=end_pos.getProgress();
            android.support.v7.app.ActionBar actionBar = getSupportActionBar();
            if(actionBar != null){
                actionBar.setHomeButtonEnabled(true);
                actionBar.setDisplayHomeAsUpEnabled(true);
            }
            end_pos.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    end_posis=end_pos.getProgress();

                }
            });
            start_pos.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    start_posis=start_pos.getProgress();
                }
            });
            refresh.setOnClickListener(new FloatingActionButton.OnClickListener() {
                @Override
                public void onClick(View view) {
                    summonRival();
                    general_name.setText("");
                    name_cn.setText("");
                    name_en.setText("");
                }
            });

            general_name.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    gen = general_name_list.get(id_this);
                    general_name.setText(gen.General_name);
                }
            });
            name_cn.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    gen = general_name_list.get(id_this);
                    name_cn.setText(gen.name_Chinese);
                }
            });
            name_en.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    gen = general_name_list.get(id_this);
                    name_en.setText(gen.name_English);
                }
            });

            more_options.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(more.getVisibility()==View.INVISIBLE){
                        more.setVisibility(View.VISIBLE);
                    }else{
                        more.setVisibility(View.INVISIBLE);
                    }

                }
            });





        }catch (Exception e){
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

    private void addToList(){
        general_name_list.add(new General_name_class("金刚石，石墨","碳","C"));
        general_name_list.add(new General_name_class("硫磺","硫","S"));
        general_name_list.add(new General_name_class("水银","汞","H"));
        general_name_list.add(new General_name_class("干冰","二氧化碳","CO₂"));
        general_name_list.add(new General_name_class("石英，沙子，玻璃","二氧化硅","SiO₂"));
        general_name_list.add(new General_name_class("烧碱，火碱，苛性钠","氢氧化钠","NaOH"));
        general_name_list.add(new General_name_class("食盐","氯化钠","NaCl"));
        general_name_list.add(new General_name_class("水玻璃","硅酸钠","Na₂SiO₃"));
        general_name_list.add(new General_name_class("纯碱，苏打，口碱，面碱","碳酸钠","Na₂CO₃"));
        general_name_list.add(new General_name_class("小苏打","碳酸氢钠","NaHCO₃"));
        general_name_list.add(new General_name_class("赤铁，铁锈","氧化铁","Fe₂O₃"));
        general_name_list.add(new General_name_class("磁铁矿","四氧化三铁","Fe₃O₄"));
        general_name_list.add(new General_name_class("绿矾","七氧和硫酸亚铁","FeSO₄·7H₂O"));
        general_name_list.add(new General_name_class("生石灰","氧化钙","CaO"));
        general_name_list.add(new General_name_class("石灰浆/乳/水，熟石灰，消石灰","氢氧化钙","Ca(OH)₂"));
        general_name_list.add(new General_name_class("石灰石，大理石","碳酸钙","CaCO₃"));
        general_name_list.add(new General_name_class("蓝帆，胆矾","五水合硫酸铜","CuSO₄·5H₂O"));
        general_name_list.add(new General_name_class("铜绿，孔雀石，铜锈","碱式碳酸铜","Cu₂(OH)₂CO₃"));
        general_name_list.add(new General_name_class("天然气，沼气，瓦斯","甲烷","CH₄"));
        general_name_list.add(new General_name_class("酒精","乙醇","C₂H₅OH"));
        general_name_list.add(new General_name_class("醋酸","乙酸","CH₃COOH"));
        general_name_list.add(new General_name_class("甲醇","甲醇","CH₃OH"));
        general_name_list.add(new General_name_class("明矾","十二水合硫酸亚钾","KAl(SO₄)₂·12H₂O"));
        general_name_list.add(new General_name_class("尿素","尿素","CO(NH₂)₂"));
        general_name_list.add(new General_name_class("草木灰","碳酸钾","K₂CO₃"));
        general_name_list.add(new General_name_class("葡萄糖","葡萄糖","C₆H₁₂O₆"));
        general_name_list.add(new General_name_class("波尔多液","硫酸铜和氢氧化钙","CuSO₄ 和 Ca(OH)₂"));

    }


    private void summonRival(){
        try{
            int totalSize=general_name_list.size();

            int start = (int)((double)totalSize*((double)start_posis/100.00));
            int end = (int)((double)totalSize*((double)end_posis/100.00));
            Log.d("error", "summonRival:"+start);
            Random rand = new Random();
            id_this=rand.nextInt((end-start))+start;
            if(id_this>general_name_list.size()){
                Toast.makeText(GeneralName.this, "无法应用设置！", Toast.LENGTH_LONG).show();
                id_this=0;
            }
        }catch (Exception e){
            Toast.makeText(GeneralName.this, "无法应用设置！", Toast.LENGTH_LONG).show();
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);//加载menu文件到布局

        return true;
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
