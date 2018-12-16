package com.example.myapp.mainFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.FragmentNavigator;

import com.example.myapp.R;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private View rootView;
    private ImageView imageView;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.main_fragment, container, false);

        imageView = rootView.findViewById(R.id.imageView2);
        rootView.findViewById(R.id.floatingActionButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainFragmentDirections.ActionMainFragmentToAddFragment toAddFragment = MainFragmentDirections.actionMainFragmentToAddFragment();
                toAddFragment.setQuery("Oussema");
                FragmentNavigator.Extras extras = new FragmentNavigator.Extras.Builder()
                        .addSharedElement(imageView, "trans")
                        .build();
                Navigation.findNavController(v).navigate(toAddFragment, extras);
            }
        });
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

}
