package com.locdhph46788.xuongkotlin_comtamapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.locdhph46788.xuongkotlin_comtamapp.R

@Composable
fun ContactScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF252121))
            .padding(top = 16.dp, start = 20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.zalo),
                contentDescription = null,
                modifier = Modifier.size(58.dp)
            )
            Spacer(modifier = Modifier.width(15.dp))
            Text(
                text = "0879175310",
                fontSize = 20.sp,
                fontWeight = FontWeight(400),
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(40.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.gmail),
                contentDescription = null,
                modifier = Modifier.size(58.dp)
            )

            Spacer(modifier = Modifier.width(15.dp))
            Text(
                text = "vuthanhnam2102@gmail.com",
                fontSize = 20.sp,
                fontWeight = FontWeight(400),
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.phone),
                contentDescription = null,
                modifier = Modifier.size(58.dp)
            )
            Spacer(modifier = Modifier.width(15.dp))

            Text(
                text = "0879175310",
                fontSize = 20.sp,
                fontWeight = FontWeight(400),
                color = Color.White
            )
        }
    }
}