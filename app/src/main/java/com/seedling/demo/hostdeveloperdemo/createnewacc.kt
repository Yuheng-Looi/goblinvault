package com.seedling.demo.hostdeveloperdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController

class createnewacc : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_createnewacc, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val BtnBTL = view.findViewById<Button>(R.id.BtnBTL)
        val OCLBTL = View.OnClickListener { findNavController(view).navigate(R.id.DestLogin) }
        BtnBTL.setOnClickListener(OCLBTL)
    }
}