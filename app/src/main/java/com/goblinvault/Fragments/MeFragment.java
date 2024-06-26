package com.goblinvault.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import com.goblinvault.ProfileEditingActivity;
import com.goblinvault.R;

public class MeFragment extends Fragment {
    public MeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_me, container, false);

        // init onclick listeners and UI functions here...
        // Example:

        ImageButton edit_btn = view.findViewById(R.id.BtnEditProfile);
        edit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ProfileEditingActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        return view;
    }
}
