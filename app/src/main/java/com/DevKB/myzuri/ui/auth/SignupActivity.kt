package com.DevKB.myzuri.ui.auth


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PatternMatcher
import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Patterns
import androidx.lifecycle.ViewModelProvider
import com.DevKB.myzuri.data.viewModel.AuthViewModel
import com.DevKB.myzuri.databinding.ActivitySignupBinding
import com.DevKB.myzuri.ui.dashboard.DashboardActivity
import com.DevKB.myzuri.utils.ViewUtils.Extension.toast
import com.google.android.gms.tasks.OnCompleteListener
import java.util.regex.Pattern

class SignupActivity : AppCompatActivity() {
    private lateinit var registerBinding: ActivitySignupBinding

    private val PASSWORD_PATTERN: Pattern = Pattern.compile(
        "^" +
                "(?=.*[0-9])" +         //at least 1 digit
                "(?=.*[a-z])" +         //at least 1 lower case letter
                "(?=.*[A-Z])" +         //at least 1 upper case letter
                //"(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{8,}" +               //at least 4 characters
                "$"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerBinding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(registerBinding.root)

        val authViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        authViewModel.getInstance(application)

        registerBinding.signInTv.setOnClickListener {
            val intent = Intent(this, SigningActivity::class.java)
            startActivity(intent)
            finish()
        }

        fun validateEmail(email: String): Boolean {

            if (email.isEmpty()){
                registerBinding.regEmail.error = "Email cannot be blank!"
                return false
            }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                registerBinding.regEmail.error = "Invalid Password"
                return false
            }else{
                registerBinding.regEmail.error = null
                return true
            }
        }



        fun validatePassword(password: String): Boolean{
            if (password.isEmpty()){
                registerBinding.regPass.error = "Password cannot be blank!"
                return false
            }else if (!PASSWORD_PATTERN.matcher(password).matches()){
                registerBinding.regPass.error = "Password is weak"
               return false
            }else{
                registerBinding.regPass.error = null
                return true
            }
        }

        registerBinding.btnRegister.setOnClickListener {

            if(validateEmail(registerBinding.regEmail.text.toString()) && validatePassword(registerBinding.regPass.text.toString())){

                authViewModel.email = registerBinding.regEmail.text.toString()
                authViewModel.password = registerBinding.regPass.text.toString()

                authViewModel.register(authViewModel.email!!, authViewModel.password!!)
                    .addOnCompleteListener(OnCompleteListener {
                        if(it.isSuccessful){
                            toast("Registration Successful!")
                            val intent = Intent(this, DashboardActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            toast("Registration Failed!")
                        }
                    })
            }

        }
    }
}