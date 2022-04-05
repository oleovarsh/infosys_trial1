package com.example.trial1.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.trial1.Order;
import com.example.trial1.R;
import com.example.trial1.databinding.FragmentAddrequestsBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class AddRequestsFragment extends Fragment {

    private FragmentAddrequestsBinding binding;
    FirebaseDatabase database= FirebaseDatabase.getInstance();
    DatabaseReference order_table=database.getReference();
    String selectval;
    EditText restaurant;
    Button submit_order;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View addReqView =inflater.inflate(R.layout.fragment_addrequests, container, false);


        restaurant=addReqView.findViewById(R.id.newreq_restaurant);
        String[] locationVals = new String[]{"Changi City Point", "SUTD Canteen", "Simpang", "Eastpoint mall", "Changi Airport"};
        Spinner spinner = (Spinner) addReqView.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item,locationVals);
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectval= adapterView.getItemAtPosition(i).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        submit_order=addReqView.findViewById(R.id.submit_order);
        submit_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Order order=new Order(selectval,restaurant.getText().toString());
                order_table.child("order").setValue(order);
            }
        });





        return addReqView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
