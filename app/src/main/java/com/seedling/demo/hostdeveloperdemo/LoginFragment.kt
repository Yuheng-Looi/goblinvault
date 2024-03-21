package com.seedling.demo.hostdeveloperdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.ToggleButton;

//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;

public class LoginFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

//    private FirebaseAuth firebaseAuth;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        firebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        EditText emailEditText = view.findViewById(R.id.LoginEmail);
        EditText passwordEditText = view.findViewById(R.id.LoginPass);

        ToggleButton toggleButton = view.findViewById(R.id.toggleButton);

        toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // If the toggle button is checked, show the password
                passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            } else {
                // If the toggle button is not checked, hide the password
                passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            }
        });

        Button BtnCNA = view.findViewById(R.id.CNABtn);
        BtnCNA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.DestRegister);
            }
        });

        TextView TVForgotPassword = view.findViewById(R.id.TVForgotPassword);
        TVForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.DestForgotPassword);
            }
        });

        Button BtnLogin = view.findViewById(R.id.BtnLogin);
        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get user-entered email and password
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                // Validate email and password
                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                    Toast.makeText(requireContext(), "Email and password cannot be blank", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Authenticate with Firebase
//                firebaseAuth.signInWithEmailAndPassword(email, password)
//                        .addOnCompleteListener(requireActivity(), new OnCompleteListener<AuthResult>() {
//                            @Override
//                            public void onComplete(@NonNull Task<AuthResult> task) {
//                                if (task.isSuccessful()) {
//                                    // Sign in success
//                                    Log.d("LoginFragment", "signInWithEmail:success");
//                                    Toast.makeText(requireContext(), "Login successful", Toast.LENGTH_SHORT).show();
//
//                                    // Start the MainActivity
//                                    Intent intent = new Intent(requireActivity(), MainActivity.class);
//                                    startActivity(intent);
//
//                                    // Finish the LoginActivity to prevent going back to it from MainActivity
//                                    requireActivity().finish();
//
//                                } else {
//                                    if (isNetworkAvailable()) {
//                                        // If sign in fails, display a message to the user.
//                                        Log.w("LoginFragment", "signInWithEmail:failure", task.getException());
//                                        Toast.makeText(requireContext(), "Authentication failed.", Toast.LENGTH_SHORT).show();
//                                    } else {
//                                        // Display a message to the user indicating no internet connection
//                                        Toast.makeText(getContext(), "No internet connection available", Toast.LENGTH_SHORT).show();
//                                    }
//                                }
//                            }
//                        });
            }
        });
    }

    // check if network is available
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) requireContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
}