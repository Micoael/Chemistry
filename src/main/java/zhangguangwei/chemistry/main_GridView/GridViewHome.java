package zhangguangwei.chemistry.main_GridView;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import zhangguangwei.chemistry.R;

public class GridViewHome extends AppCompatActivity {
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_grid);
        gridView=findViewById(R.id.gv_main);
        gridView.setAdapter(new main_adapter(GridViewHome.this));


    }
}
