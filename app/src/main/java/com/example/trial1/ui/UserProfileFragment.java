package com.example.trial1.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.trial1.databinding.FragmentUserprofileBinding;

public class UserProfileFragment extends Fragment {

    private FragmentUserprofileBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        UserProfileViewModel browseReqModel =
                new ViewModelProvider(this).get(UserProfileViewModel.class);

        binding = FragmentUserprofileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.userprofiletv;
        browseReqModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}