package com.locdhph46788.xuongkotlin_comtamapp.screens

import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.locdhph46788.xuongkotlin_comtamapp.R
import com.locdhph46788.xuongkotlin_comtamapp.navigations.ROUTE_MAIN_NAV
import com.locdhph46788.xuongkotlin_comtamapp.viewmodels.AuthViewModel

@Composable
fun SignupScreen(navController: NavController, viewModel: AuthViewModel) {
    val context = LocalContext.current
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val repassword = remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff252121)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Đăng ký",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 32.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .size(200.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))
            CustomTextField(
                label = "Email",
                value = email.value,
                onValueChange = { email.value = it }
            )
            Spacer(modifier = Modifier.height(10.dp))
            CustomTextField(
                label = "Mật khẩu",
                value = password.value,
                onValueChange = { password.value = it }
            )
            Spacer(modifier = Modifier.height(10.dp))
            CustomTextField(
                label = "Nhập lại Mật khẩu",
                value = repassword.value,
                onValueChange = { repassword.value = it }
            )
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = {
                    if (email.value.isEmpty() || !isValidEmail(email.value)) {
                        Toast.makeText(
                            context,
                            "Vui lòng nhập email đúng định dạng!",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else if (password.value.isEmpty() || password.value.length < 6) {
                        Toast.makeText(
                            context,
                            "Vui lòng nhập mật khẩu có tối thiểu 6 kí tự!",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    } else if (repassword.value.isEmpty() || repassword.value.length < 6) {
                        Toast.makeText(
                            context,
                            "Vui lòng nhập lại mật khẩu có tối thiểu 6 kí tự!",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    } else if (!repassword.value.equals(password.value)) {
                        Toast.makeText(context, "Mật khẩu không trùng khớp!", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        viewModel.signup(email.value, password.value, context, navController)
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF5722)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp)
            ) {
                Text(text = "Đăng ký", color = Color.White)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    navController.navigate(ROUTE_MAIN_NAV.LOGIN.name)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF4CAF50)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp)
            ) {
                Text(text = "Trở về", color = Color.White)
            }
        }
    }
}

fun isValidEmail(email: String): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

