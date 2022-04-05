package com.example.trial1.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.trial1.databinding.FragmentCurrentdeliveriesBinding;
public class CurrentDeliveriesFragment extends Fragment {

    private FragmentCurrentdeliveriesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CurrentDeliveriesViewModel browseReqModel =
                new ViewModelProvider(this).get(CurrentDeliveriesViewModel.class);

        binding = FragmentCurrentdeliveriesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.currentdeliveriestv;
        browseReqModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}