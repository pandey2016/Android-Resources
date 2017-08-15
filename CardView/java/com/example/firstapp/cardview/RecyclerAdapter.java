package com.example.firstapp.cardview;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ABHISHEK on 09-Feb-17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    int[] images={R.drawable.facebook,R.drawable.facebook,R.drawable.facebook,R.drawable.facebook,R.drawable.facebook};
    String[] details={"here is the card view","here is the card view","here is the card view","here is the card view","here is the card view"};
    String[] titles={"Hero","Hero","Hero","Hero","Hero",};

    class ViewHolder extends RecyclerView.ViewHolder {

        public int currentitems;
        public ImageView itemImage;
        public TextView itemDetail,itemTitle;
        public ViewHolder(View itemView) {
            super(itemView);
            itemImage=(ImageView)itemView.findViewById(R.id.item_image);
            itemDetail=(TextView)itemView.findViewById(R.id.item_detail);
            itemTitle=(TextView)itemView.findViewById(R.id.item_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final int position=getAdapterPosition();
                    Snackbar snackbar =Snackbar.make(view,"Click detect on item"+position,Snackbar.LENGTH_LONG).setAction("Action",null).
                            setActionTextColor(Color.BLUE).setAction("Undo", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Snackbar snackbar1 = Snackbar.make(view,"no internet connection"+position,Snackbar.LENGTH_SHORT);
                                    snackbar1.setActionTextColor(Color.RED).show();
                                }
                            });
                    snackbar.setActionTextColor(Color.RED).show();
                   /* View sbview = snackbar.getView();
                    TextView textView= (TextView) sbview.findViewById(android.support.design.R.id.snackbar_text);
                    textView.setTextColor(Color.YELLOW);
                    snackbar.show();*/
                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_layout,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.itemTitle.setText(titles[i]);
        viewHolder.itemDetail.setText(details[i]);
        viewHolder.itemImage.setImageResource(images[i]);

    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
