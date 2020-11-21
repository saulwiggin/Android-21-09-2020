package com.example.paywithbitcoin.ui.dashboard.login

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.paywithbitcoin.MainActivity
import com.example.paywithbitcoin.R
import com.example.paywithbitcoin.databinding.FragmentLoginBinding
import com.firebase.ui.auth.AuthUI.getApplicationContext
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidUserException

import kotlinx.android.synthetic.main.fragment_login.button
import kotlinx.android.synthetic.main.fragment_login.password
import kotlinx.android.synthetic.main.fragment_login.username
import kotlin.properties.Delegates

class LoginFragment : Fragment() {

    private var mLogin by Delegates.notNull<Boolean>()
    private lateinit var mUsername : String
    private lateinit var mPassword : String
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var button: Button
    // Initialize firebase Auth - firebase application username and password have been triggered
    private lateinit var auth: FirebaseAuth


    companion object {
        private val TAG = "User Authentication"

        fun newInstance(): LoginFragment {
            return LoginFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentLoginBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // text input boxes and on click button
        val btn_click_me = button

        btn_click_me.setOnClickListener {
            firebaseAUTH()
        }
    }

    private fun firebaseAUTH(){
        val currentUser = auth.currentUser

        mUsername = username.getText().toString()
        mPassword = password.getText().toString()

        // email for username
        if(currentUser !== null){
            auth.createUserWithEmailAndPassword(mUsername, mPassword)
                .addOnCompleteListener(Activity()) { task ->
                    if (task.isSuccessful) {
                        Log.d(TAG, "createUserWithEmail:success")
                        val user = auth.currentUser
                        // progress to next screen
                        mLogin = true
                    } else {
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        Toast.makeText(context, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                        // error handling code
                        mLogin = false

                    }
                }

        }
    }

    private fun signOut(){
        auth.signOut()
    }

}





