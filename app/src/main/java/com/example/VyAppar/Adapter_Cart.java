package com.example.VyAppar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_Cart extends RecyclerView.Adapter<Adapter_Cart.newViewHolder> {

    private ArrayList<Class_Cart> carts=new ArrayList<>();
    int totalcount;
    int height;

    public Adapter_Cart(Context context, ArrayList<Class_Cart> list){
        carts = list;

    }


    public class newViewHolder extends RecyclerView.ViewHolder {

        public ImageView iwdisp,add,remove;
        public TextView title,desc,price,quantity;

        public newViewHolder(@NonNull final View itemView) {
            super(itemView);

            WindowManager.LayoutParams layoutParams=new WindowManager.LayoutParams();
            layoutParams.height=height/4;
            itemView.setLayoutParams(layoutParams);
            add=itemView.findViewById(R.id.add);
            remove=itemView.findViewById(R.id.subtract);
            iwdisp=itemView.findViewById(R.id.imageView2);
            title=itemView.findViewById(R.id.tvTitle);
            desc=itemView.findViewById(R.id.tvDesc);
            price=itemView.findViewById(R.id.price);
            quantity=itemView.findViewById(R.id.numberofitems);

            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int i=carts.indexOf(itemView.getTag());
                    carts.get(i).setQuantity((Integer.toString(Integer.parseInt(quantity.getText().toString())+1)));
                    notifyDataSetChanged();

                }
            });

            remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int i=carts.indexOf(itemView.getTag());
                    if(Integer.parseInt(quantity.getText().toString())==1)
                    {
                        carts.remove(i);
                        notifyDataSetChanged();
                    }
                    else {
                        carts.get(i).setQuantity((Integer.toString(Integer.parseInt(quantity.getText().toString()) - 1)));
                        notifyDataSetChanged();
                    }

                }
            });



        }

    }


    @NonNull
    @Override
    public Adapter_Cart.newViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_cart,parent,false);
        height=parent.getContext().getResources().getDisplayMetrics().heightPixels;
        return new newViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Adapter_Cart.newViewHolder holder, int position) {

        holder.itemView.setTag(carts.get(position));
        holder.iwdisp.setImageResource(carts.get(position).getIwl());
        holder.title.setText(carts.get(position).getTitle());
        holder.desc.setText(carts.get(position).getDesc());
        holder.price.setText(carts.get(position).getPrice());
        holder.quantity.setText(carts.get(position).getQuantity());




    }

    @Override
    public int getItemCount() {
        return carts.size();
    }
     private void GetTotalCount(){
        for(Class_Cart temp:carts)
        {

        }
    }



}