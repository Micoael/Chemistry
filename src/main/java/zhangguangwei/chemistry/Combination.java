package zhangguangwei.chemistry;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

import zhangguangwei.chemistry.ChemistryObject.Valence;
import zhangguangwei.chemistry.ChemistryObject.chemist_generator;

public class Combination extends AppCompatActivity {


    private TextView first_e, second_e,together;
    private FloatingActionButton calc_btn;
    chemist_generator generator = new chemist_generator();
    Valence valence_1, valence_2;
    Button answer_view;
    String answer_str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combination);
        first_e = findViewById(R.id.first_element);
        second_e = findViewById(R.id.second_element);
        calc_btn = findViewById(R.id.calculate);
        answer_view = findViewById(R.id.answer_shower);
        together = findViewById(R.id.together);
        generator.initData();
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        calc_btn.setOnClickListener(new FloatingActionButton.OnClickListener() {
            @Override
            public void onClick(View view) {

                valence_1 = generator.RandomSummonPositive();
                valence_2 = generator.RandomSummonNegative();

                first_e.setText(valence_1.EnglishName);
                second_e.setText(valence_2.EnglishName);
                answer_str = generator.Generator(valence_1, valence_2);
                answer_view.setText("");
                Log.d("not-serious", "onClick: "+answer_str);
                final RotateAnimation animation = new RotateAnimation(0.0f, 360.0f,
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);
                animation.setDuration( 300 );
                calc_btn.startAnimation(animation);

                Animation loadAnimation = AnimationUtils.loadAnimation(Combination.this,
                        R.anim.alpha);
                together.startAnimation(loadAnimation);

                //TranslateAnimation translateAnimation = (TranslateAnimation) AnimationUtils.loadAnimation(Combination.this, R.anim.translate);
                //together.startAnimation(translateAnimation);

            }
        });

        answer_view.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer_str!=null) {
                    answer_view.setText(answer_str);

                }
                else {
                    answer_view.setText("");
                }
            }
        });




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
