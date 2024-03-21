package com.goblinvault;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link createNewAccFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class createNewAccFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public createNewAccFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment creatNewAccFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static createNewAccFragment newInstance(String param1, String param2) {
        createNewAccFragment fragment = new createNewAccFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_creat_new_acc, container, false);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        TextView BtnBTL = view.findViewById(R.id.BtnBTL);
        View.OnClickListener OCLBTL = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.DestLogin);
            }
        };
        BtnBTL.setOnClickListener(OCLBTL);

        // Sign Up Button
        TextView BTNSU = view.findViewById(R.id.SignupBtn);

        BTNSU.setOnClickListener(v -> signUp(view));
    }

    private void signUp(View view) {
        Navigation.findNavController(view).navigate(R.id.DestLogin);
    }
}