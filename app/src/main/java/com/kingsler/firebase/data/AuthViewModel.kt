package com.kingsler.firebase.data

import android.R
import android.content.Context
import android.service.autofill.UserData
import android.widget.Toast
import androidx.navigation.NavHostController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class AuthViewModel (var navController:NavHostController,var context:Context){
    var mAuth: FirebaseAuth

    init {
        mAuth= FirebaseAuth.getInstance()

    }

    fun signup(email: String,pass: String,confpass: String){
        if (email.isBlank()|| pass.isBlank() ||confpass.isBlank()){
            Toast.makeText(context,"Please email and password cannot be blank ", Toast.LENGTH_LONG).show()
            return
        }else if (pass != confpass){
            Toast.makeText(context,"Password do not match", Toast.LENGTH_LONG).show()
            return
        }else{
            mAuth.createUserWithEmailAndPassword(email,pass)
                .addOnCompleteListener {
                    if (it.isSuccessful){
                        val userdata = User(email,pass,mAuth.currentUser!!.uid)
                        val regRef = FirebaseDatabase.getInstance().getReference()
                            .child("Users/"+mAuth.currentUser!!.uid)
                        regRef.setValue(userdata).addOnCompleteListener {
                            if (it.isSuccessful){
                                Toast.makeText(context,"Registered successfully", Toast.LENGTH_LONG).show()
                            }
                        }
                    }
                }
        }
    }
}