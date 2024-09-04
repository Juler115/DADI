package com.name.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.name.R;
import com.name.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final EditText editText = binding.textInputEditText; // Updated
        Button button = binding.button;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = editText.getText().toString().trim(); // Trim whitespace from input

                // Get the NavController from the current view
                NavController navController = Navigation.findNavController(v);

                // Check if the input text is not empty
                if (!inputText.isEmpty()) {
                    // Pass the input text to the DashboardFragment using Bundle
                    Bundle bundle = new Bundle();
                    bundle.putString("name", inputText);

                    // Navigate to DashboardFragment
                    navController.navigate(R.id.action_homeFragment_to_dashboardFragment, bundle);
                }
            }

        });

        homeViewModel.getText().observe(getViewLifecycleOwner(), binding.textHome::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
