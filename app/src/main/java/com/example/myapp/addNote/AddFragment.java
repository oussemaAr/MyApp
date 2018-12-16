package com.example.myapp.addNote;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapp.R;

import java.io.IOException;

import id.zelory.compressor.Compressor;

public class AddFragment extends Fragment {

    private AddViewModel mViewModel;
    private static final String TAG = AddFragment.class.getName();

    public static AddFragment newInstance() {
        return new AddFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.setDuration(5000);
        return inflater.inflate(R.layout.add_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AddViewModel.class);
        if (getArguments() != null) {
            AddFragmentArgs addFragmentArgs = AddFragmentArgs.fromBundle(getArguments());
            String query = addFragmentArgs.getQuery();
            Log.e(TAG, "onActivityCreated: " + query);
        }

    }

}
