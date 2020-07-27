package com.example.dogspot;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetViewHolder> {

    ArrayList<PetDataModel> list2;
    Context context;
    ArrayList<Integer> color;
    ArrayList<Integer> color2;

    public PetAdapter(ArrayList<PetDataModel> list3,Context context, ArrayList<Integer> color, ArrayList<Integer> color2){
        this.list2 = list3;
        this.context = context;
        this.color = color;
        this.color2= color2;
    }

    public class PetViewHolder extends RecyclerView.ViewHolder{
        TextView txtName,txtDes,txtPrice;
        ImageView imgPet;
        CardView cvPet;
        TextView btnWiki;
        public PetViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtRPetName);
            txtDes = itemView.findViewById(R.id.txtRPetDes);
            txtPrice = itemView.findViewById(R.id.txtRPetPrice);
            imgPet = itemView.findViewById(R.id.imgPet);
            cvPet = itemView.findViewById(R.id.cvPet);
            btnWiki = itemView.findViewById(R.id.txtWiki);
        }
    }


    @NonNull
    @Override
    public PetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_pets,parent,false);
        return new PetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PetViewHolder holder, final int position) {
        holder.txtName.setText(list2.get(position).getName());
        holder.txtDes.setText(list2.get(position).getDes());
        holder.txtPrice.setText(list2.get(position).getPrice());
        holder.imgPet.setImageDrawable(context.getResources().getDrawable(list2.get(position).getImage_path(),context.getTheme()));

        Random random = new Random();
        int ran = random.nextInt(color.size());

        if(position%2 == 0) {
            holder.cvPet.setCardBackgroundColor(context.getResources().getColor(color.get(ran)));
        }else{
            holder.cvPet.setCardBackgroundColor(context.getResources().getColor(color2.get(ran)));
        }

        holder.btnWiki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(list2.get(position).getLink()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list2.size();
    }

}
