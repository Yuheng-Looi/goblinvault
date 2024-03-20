package com.seedling.demo.hostdeveloperdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController

/**
 * A simple [Fragment] subclass.
 * Use the [DestForgotPassword.newInstance] factory method to
 * create an instance of this fragment.
 */
class DestForgotPassword : Fragment() {
    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null
    private lateinit var btnReset: Button
    private lateinit var btnBack: Button
    private var edtEmail: EditText? = null

    //    private FirebaseAuth mAuth;
    private val strEmail: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = requireArguments().getString(ARG_PARAM1)
            mParam2 = requireArguments().getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_forgotpassword, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialization
        btnBack = view.findViewById(R.id.BtnBTL)
        btnReset = view.findViewById(R.id.BtnSubmit)
        edtEmail = view.findViewById(R.id.editTextText3)

//        mAuth = FirebaseAuth.getInstance();

        // Reset Button Listener
//        btnReset.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                strEmail = edtEmail.getText().toString().trim();
//                if (!TextUtils.isEmpty(strEmail)) {
//                    ResetPassword();
//                } else {
//                    edtEmail.setError("Email field can't be empty");
//                }
//            }
//        });

        // Back Button Code
        btnBack.setOnClickListener(View.OnClickListener { // Navigate back to login or handle as needed
            findNavController(view).navigate(R.id.DestLogin)
        })
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DestForgotPassword.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String?, param2: String?): DestForgotPassword {
            val fragment = DestForgotPassword()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}