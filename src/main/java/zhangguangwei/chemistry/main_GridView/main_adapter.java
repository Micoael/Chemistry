package zhangguangwei.chemistry.main_GridView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import zhangguangwei.chemistry.ChemistryObject.main_gridViewObj;
import zhangguangwei.chemistry.R;
import zhangguangwei.chemistry.SymbolPage;

public class main_adapter extends BaseAdapter {
    private List<main_gridViewObj> list_main = new ArrayList<main_gridViewObj>();
    private Context mContext;
    private LayoutInflater inflater;
    mainProj proj = new mainProj();
    public main_adapter(Context context){
        proj.addToList(list_main);
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list_main.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        final int positions=position;
        ViewHolder holder = null;
        if(view == null){

            view=inflater.inflate(R.layout.layout_gridview,null);
            holder = new ViewHolder();
            view.setTag(holder);

            holder.title_text = view.findViewById(R.id.titleId);
            holder.descs=view.findViewById(R.id.descId);

        }else{
            holder= (ViewHolder) view.getTag();
        }
        holder.title_text.setText(list_main.get(position).Title);
        holder.descs.setText(list_main.get(position).Descs);

        return view;
    }


    static class ViewHolder{

        public TextView title_text,descs;

    }

}
