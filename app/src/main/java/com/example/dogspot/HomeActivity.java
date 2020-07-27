package com.example.dogspot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    PetAdapter petsAdapter;
    ArrayList<PetDataModel> list;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        searchView = findViewById(R.id.searchView);
        recyclerView = findViewById(R.id.recyclerPets);
        layoutManager = new LinearLayoutManager(HomeActivity.this);

        final ArrayList<Integer> colors = new ArrayList<>();

        colors.add(R.color.yellow);
        colors.add(R.color.light_pink);

        final ArrayList<Integer> colors2 = new ArrayList<>();
        colors2.add(R.color.light_teal);
        colors2.add(R.color.light_purple);


        list = new ArrayList<>();
        list.add(new PetDataModel("Golden Retriever","The Golden Retriever is a medium-large gun dog that was bred to retrieve shot waterfowl, such as ducks and upland game birds, during hunting and shooting parties.",
                "₹25000",R.drawable.dog1,"https://en.wikipedia.org/wiki/Golden_Retriever"));
        list.add(new PetDataModel("Pug","Pugs love kids. Though small, the Pug is not delicate like some toy breeds, so he is a good breed choice for families with children. ... Properly trained and socialized, the Pug enjoys the companionship of dogs, and can be trusted with cats, rabbits, and other animals.",
                "₹16000",R.drawable.dog3,"https://en.wikipedia.org/wiki/Pug"));
        list.add(new PetDataModel("Havenese","Although the Havanese is a small breed, he has a fair amount of energy to burn. ... Although they're not overly yappy, they do bark at passersby, so if your home has noise restrictions, this may not be the breed for you. His eagerness to please his owners makes the Havanese fairly easy to train in most cases.",
                "₹50000",R.drawable.dog4,"https://en.wikipedia.org/wiki/Havanese_dog"));
        list.add( new PetDataModel("Corgi","Corgis do well in obedience training. They can be taught to drop some habits that they can exhibit due to their herding background such as nipping at heels, barking or chasing other animals. Corgi's temperament is another factor that makes them excellent pets."
                ,"₹10000",R.drawable.dog2,"https://en.wikipedia.org/wiki/Corgi"));
        list.add(new PetDataModel("Golden Retriever","The Golden Retriever is a medium-large gun dog that was bred to retrieve shot waterfowl, such as ducks and upland game birds, during hunting and shooting parties.",
                "₹25000",R.drawable.dog1,"https://en.wikipedia.org/wiki/Golden_Retriever"));
        list.add(new PetDataModel("Pug","Pugs love kids. Though small, the Pug is not delicate like some toy breeds, so he is a good breed choice for families with children. ... Properly trained and socialized, the Pug enjoys the companionship of dogs, and can be trusted with cats, rabbits, and other animals.",
                "₹16000",R.drawable.dog3,"https://en.wikipedia.org/wiki/Pug"));
        list.add(new PetDataModel("Havenese","Although the Havanese is a small breed, he has a fair amount of energy to burn. ... Although they're not overly yappy, they do bark at passersby, so if your home has noise restrictions, this may not be the breed for you. His eagerness to please his owners makes the Havanese fairly easy to train in most cases.",
                "₹50000",R.drawable.dog4,"https://en.wikipedia.org/wiki/Havanese_dog"));
        list.add( new PetDataModel("Corgi","Corgis do well in obedience training. They can be taught to drop some habits that they can exhibit due to their herding background such as nipping at heels, barking or chasing other animals. Corgi's temperament is another factor that makes them excellent pets."
                ,"₹10000",R.drawable.dog2,"https://en.wikipedia.org/wiki/Corgi"));

        petsAdapter = new PetAdapter(list,HomeActivity.this,colors,colors2);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(petsAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                String userInput = s.toLowerCase();
                ArrayList<PetDataModel> searchFilter = new ArrayList<>();
                for(int i =0;i<list.size();i++){
                    if(list.get(i).getName().toLowerCase().contains(userInput)){
                        searchFilter.add(list.get(i));
                    }
                }

                petsAdapter = new PetAdapter(searchFilter,HomeActivity.this,colors,colors2);

                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(petsAdapter);
                return true;
            }
        });


    }
}