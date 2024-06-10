package com.locdhph46788.xuongkotlin_comtamapp.viewmodels

import android.content.Context
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.locdhph46788.xuongkotlin_comtamapp.navigations.ROUTE_MAIN_NAV

class AuthViewModel : ViewModel() {

    private val _authState = MutableLiveData<AuthState>()

    val authState: LiveData<AuthState> = _authState

    private val auth: FirebaseAuth = Firebase.auth

    fun login(email: String, password: String, context: Context, navController: NavController) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _authState.value = AuthState.AUTHENTICATED
                    Toast.makeText(context, "Đăng nhập thành công !", Toast.LENGTH_SHORT).show()
                    navController.navigate(ROUTE_MAIN_NAV.HOME.name)
                } else {
                    _authState.value = AuthState.UNAUTHENTICATED
                    Toast.makeText(context, "Email hoặc mật khẩu không chính xác !", Toast.LENGTH_SHORT)
                        .show()

                }
            }
    }

    fun signup(email: String, password: String, context: Context, navController: NavController) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _authState.value = AuthState.AUTHENTICATED
                    Toast.makeText(context, "Đăng ký thành công !", Toast.LENGTH_SHORT).show()
                    navController.navigate(ROUTE_MAIN_NAV.LOGIN.name)
                } else {
                    _authState.value = AuthState.UNAUTHENTICATED
                    Toast.makeText(context, "Đăng ký không thành công !", Toast.LENGTH_SHORT).show()

                }
            }
    }

}

enum class AuthState {
    AUTHENTICATED, UNAUTHENTICATED
}
