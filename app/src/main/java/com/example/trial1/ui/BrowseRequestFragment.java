package com.example.trial1.ui;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trial1.MainActivity2;
import com.example.trial1.R;
import com.example.trial1.databinding.FragmentBrowserequestsBinding;
import com.example.trial1.display_details;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;


public class BrowseRequestFragment extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    FirebaseDatabase database;
    DatabaseReference reqlist;
    private View reqView;

    private FragmentBrowserequestsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        reqView=inflater.inflate(R.layout.fragment_browserequests,container, false);
        database=FirebaseDatabase.getInstance();
        reqlist=database.getReference("Food");
        recyclerView=(RecyclerView) reqView.findViewById(R.id.recycler_browsereq);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        return reqView;
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseRecyclerOptions options=new FirebaseRecyclerOptions.Builder<Food>()
                .setQuery(reqlist.orderByChild("menuid").equalTo("10"),Food.class)
                .build();
        FirebaseRecyclerAdapter<Food,FoodViewHolder> adapter =new FirebaseRecyclerAdapter<Food, FoodViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FoodViewHolder holder, int position, @NonNull Food model) {
                String reqid=getRef(position).getKey();
                reqlist.child(reqid).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        String name= snapshot.child("Name").getValue().toString();
                        holder.reqid.setText(reqid);
                        holder.requser.setText(name);

                        holder.setItemClickListener(new ItemClickListener() {
                            @Override
                            public void onClick(View view, int position, boolean islongpress) {
                                Intent intent= new Intent(getActivity(), display_details.class);
                                startActivity(intent);



                            }
                        });


                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {


                    }
                });

            }

            @NonNull
            @Override
            public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.request_item,parent,false);
                FoodViewHolder viewHolder=new FoodViewHolder(view);
                return viewHolder;
            }
        };

        recyclerView.setAdapter(adapter);
        adapter.startListening();


        }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

