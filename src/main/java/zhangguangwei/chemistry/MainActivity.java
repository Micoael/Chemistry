package zhangguangwei.chemistry;

import android.app.Notification;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import zhangguangwei.chemistry.main_GridView.GridViewHome;

public class MainActivity extends AppCompatActivity {

    private Button To_Vanlance_Btn,To_Symbol_Btn,To_Announcement_Btn,To_Combin_Btn,To_General_Name,To_Equals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        To_Symbol_Btn=findViewById(R.id.SymbolPage);
        To_Vanlance_Btn=findViewById(R.id.VanlencePage);
        To_Announcement_Btn=findViewById(R.id.AnnouncePage);
        To_Combin_Btn=findViewById(R.id.Combination);
        To_General_Name=findViewById(R.id.GeneralName);
        To_Equals=findViewById(R.id.ChemistryEquals);

        To_Symbol_Btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,SymbolPage.class);
                startActivity(intent);
            }
        });

        To_Vanlance_Btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,ValencePage.class);
                startActivity(intent);
            }
        });

        To_Announcement_Btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, AnnouncementPage.class);
                startActivity(intent);
            }
        });
        To_Combin_Btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Combination.class);
                startActivity(intent);
            }
        });

        To_General_Name.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, GeneralName.class);
                startActivity(intent);
            }
        });

        To_Equals.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, GridViewHome.class);
                startActivity(intent);
            }
        });





    }



}
