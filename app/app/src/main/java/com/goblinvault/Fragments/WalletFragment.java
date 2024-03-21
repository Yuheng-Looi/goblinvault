package com.goblinvault.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.goblinvault.R;

public class WalletFragment extends Fragment {

    public WalletFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_wallet, container, false);

        // init onclick listeners and UI functions here...
        // Example:
        /*
        Button edit_btn = view.findViewById(R.id.edit_btn);
        edit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ProfileEditingActivity.class);
                startActivityForResult(intent, 1);
            }
        });*/

        return view;
    }
}
