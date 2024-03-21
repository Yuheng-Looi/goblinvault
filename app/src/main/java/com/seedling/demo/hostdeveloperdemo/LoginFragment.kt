package com.seedling.demo.hostdeveloperdemo

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CompoundButton
import android.widget.EditText
import android.widget.TextView
import android.widget.ToggleButton
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import com.seedling.demo.hostdeveloperdemo.MainActivity

//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
class LoginFragment  //    private FirebaseAuth firebaseAuth;
    : Fragment() {
    private val mParam1: String? = null
    private val mParam2: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //        firebaseAuth = FirebaseAuth.getInstance();
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val emailEditText = view.findViewById<EditText>(R.id.LoginEmail)
        val passwordEditText = view.findViewById<EditText>(R.id.LoginPass)
        val toggleButton = view.findViewById<ToggleButton>(R.id.toggleButton)
        toggleButton.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked: Boolean ->
            if (isChecked) {
                // If the toggle button is checked, show the password
                passwordEditText.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            } else {
                // If the toggle button is not checked, hide the password
                passwordEditText.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
        }
        val BtnCNA = view.findViewById<Button>(R.id.CNABtn)
        BtnCNA.setOnClickListener { findNavController(view).navigate(R.id.DestRegister) }
        val TVForgotPassword = view.findViewById<TextView>(R.id.TVForgotPassword)
        TVForgotPassword.setOnClickListener { findNavController(view).navigate(R.id.DestForgotPassword) }
        val BtnLogin = view.findViewById<Button>(R.id.BtnLogin)
        BtnLogin.setOnClickListener {
            val intent = Intent(requireActivity(), MainActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"
        fun newInstance(param1: String?, param2: String?): LoginFragment {
            val fragment = LoginFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}