package com.listfragment;

import androidx.fragment.app.Fragment;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.graphics.drawable.Drawable;
import android.widget.TextView;

public class ColorFragment extends Fragment {
    private String image = "";

    public ColorFragment() {
        super(R.layout.color_fragment);
    }

    public static ColorFragment newInstance(String path) {
        ColorFragment fragment = new ColorFragment();
        Bundle args = new Bundle();
        args.putString("image", path);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.color_fragment, container, false);

        if (getArguments() != null) {
            image = getArguments().getString("image", "");
        }

        Context context = getContext();
        TextView textView = view.findViewById(R.id.Name);
        Drawable drawable = null;
        if(image == "dragon"){
            drawable = ContextCompat.getDrawable(context, R.drawable.dragon);
            textView.setText("Dragon Force");
            textView.setTextColor(Color.parseColor("#FF2222"));
            textView.setBackgroundColor(Color.parseColor("#000000"));
        }
        else if (image == "water") {
            drawable = ContextCompat.getDrawable(context, R.drawable.water);
            textView.setText("Water Weed");
            textView.setTextColor(Color.parseColor("#00C4FF"));
            textView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
        view.setBackground(drawable);

        return view;
    }
}
