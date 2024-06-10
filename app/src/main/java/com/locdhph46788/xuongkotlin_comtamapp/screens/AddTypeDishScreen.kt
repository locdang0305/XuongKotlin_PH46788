package com.locdhph46788.xuongkotlin_comtamapp.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun AddTypeDishScreen(navController: NavController) {
    var context = LocalContext.current
    var name by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF252121)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
        ) {
            TextField(
                value = name,
                onValueChange = { name = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(
                        text = "Nhập loại món ăn",
                        color = Color.Black,
                        fontSize = 15.sp,
                    )
                },
                shape = RoundedCornerShape(size = 8.dp),
            )
        }
        Spacer(modifier = Modifier.fillMaxHeight(0.3f))
        Button(
            onClick = {
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xffFFB703),
                contentColor = Color.White
            ),
            modifier = Modifier.width(200.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = "Thêm",
                fontSize = 20.sp,
                fontWeight = FontWeight(700)
            )
        }
    }
}
