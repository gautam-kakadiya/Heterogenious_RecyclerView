package com.example.sysadmin.heterogeniousrecyclerview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sysadmin on 18/7/16.
 */
public class RViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int MYITEM1 = 0;
    private static final int ITEM2 = 1;
    private ArrayList<Object> list;
    private Context context;
    public RViewAdapter(Context context,ArrayList<Object> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(context);
        switch (viewType){
            case MYITEM1 :  View v1 = inflater.inflate(R.layout.item_view1,parent,false);
                            viewHolder = new ViewHolder1(v1);
                            break;
            case ITEM2 :    View v2 =inflater.inflate(R.layout.item_view2_parent,parent,false);
                            viewHolder = new ViewHolder2(v2);
                            break;
            default :       View v = inflater.inflate(R.layout.item_view1,parent,false);
                            viewHolder = new ViewHolder1(v);
                            break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder.getItemViewType()==MYITEM1){
            ViewHolder1 v1 = (ViewHolder1) holder;
            configureV1(v1,position);
        }
        else{
            ViewHolder2 v2 = (ViewHolder2) holder;
            configureV2(v2,position);
        }
    }

    private void configureV2(ViewHolder2 v2, int position) {
        ChildRViewAdapter adapter = new ChildRViewAdapter(context);
        v2.child.setAdapter(adapter);
    }

    private void configureV1(ViewHolder1 v1, int position) {
        MyItem1 m1 = (MyItem1) list.get(position);
        v1.ptext.setText(m1.primaryText);
        v1.sText.setText(m1.secondaryText);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(list.get(position) instanceof MyItem1){
            return MYITEM1;
        }
        else{
            return ITEM2;
        }
    }

    class ViewHolder1 extends RecyclerView.ViewHolder{

        TextView ptext;
        TextView sText;

        public ViewHolder1(View itemView) {
            super(itemView);
            ptext = (TextView) itemView.findViewById(R.id.primaryText);
            sText = (TextView) itemView.findViewById(R.id.secondaryText);
        }
    }

    class ViewHolder2 extends RecyclerView.ViewHolder{
        RecyclerView child;
        LinearLayoutManager horizontalLayout;
        public ViewHolder2(View itemView) {
            super(itemView);
            child = (RecyclerView) itemView.findViewById(R.id.childRecyclerView);
            horizontalLayout = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
            child.setLayoutManager(horizontalLayout);
        }
    }
}
