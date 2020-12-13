package com.example.paywithbitcoin.ui.dashboard.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.NavHostFragment
import com.example.paywithbitcoin.R
import com.example.paywithbitcoin.ui.dashboard.dashboard.DashboardFragment
import com.example.paywithbitcoin.ui.dashboard.login.ui.login.LoginFragment
import kotlinx.android.synthetic.main.fragment_first.*
import androidx.navigation.fragment.findNavController

class FirstFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val navHostFragment = NavHostFragment()

        btnFragment1.setOnClickListener {
            navHostFragment.findNavController().navigate(
                R.id.action_firstFragment_to_barcodeFragment
            )
        }

        btnFragment2.setOnClickListener{
            navHostFragment.findNavController().navigate(
                R.id.action_firstFragment_to_barcodeFragment
            )
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

}