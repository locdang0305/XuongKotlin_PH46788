package com.locdhph46788.xuongkotlin_comtamapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.locdhph46788.xuongkotlin_comtamapp.navigations.ROUTE_BOTTOM_NAV

@Composable
fun ManageTypeDishScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF252121))
    ) {
        Button(
            onClick = {
                navController.navigate(ROUTE_BOTTOM_NAV.ADDTYPEDISH.name)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF252121)
            )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier.size(48.dp)
                )

                Spacer(modifier = Modifier.width(5.dp))

                Text(
                    text = "Thêm loại món ăn",
                    fontSize = 17.sp,
                    fontWeight = FontWeight(700),
                    color = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                navController.navigate(ROUTE_BOTTOM_NAV.DELETEUPDATETYPEDISH.name)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF252121)
            )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier.size(48.dp)
                )

                Spacer(modifier = Modifier.width(5.dp))

                Text(
                    text = "Sửa/Xóa loại món ăn",
                    fontSize = 17.sp,
                    fontWeight = FontWeight(700),
                    color = Color.White
                )
            }
        }

    }

}

