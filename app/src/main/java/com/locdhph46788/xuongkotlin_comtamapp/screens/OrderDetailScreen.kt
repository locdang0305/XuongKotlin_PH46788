package com.locdhph46788.xuongkotlin_comtamapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.IconButton
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController

import com.locdhph46788.xuongkotlin_comtamapp.R


data class FoodItem(val id: String, val name: String, val price: String, val quantity: String)

@Composable
fun OrderDetailScreen(navController: NavHostController) {
    val context = LocalContext.current
    val mainDish = listOf(
        FoodItem("1", "Cơm sườn bì", "56k", "02"),
        FoodItem("2", "Cơm bì chả", "25k", "01"),
        FoodItem("3", "Cơm bì trứng", "25k", "01")
    )
    val extraDish = listOf(
        FoodItem("1", "Sườn cây", "30k", "01"),
        FoodItem("2", "Sườn cốt lết", "20k", "01")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xff252121)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                onClick = { },
                modifier = Modifier
                    .background(color = Color(0xFF2F2D2D), shape = RoundedCornerShape(10.dp))
                    .weight(1f)
            ) {
                Text(
                    "Xác nhận",
                    color = Color.White,
                )
            }
            Spacer(modifier = Modifier.width(20.dp))
            IconButton(
                onClick = { },
                modifier = Modifier
                    .background(
                        color = Color(0xFF2F2D2D),
                        shape = RoundedCornerShape(10.dp)
                    )
                    .weight(1f)
            ) {
                Text(
                    "Hủy bỏ", color = Color.White
                )
            }
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, top = 30.dp, end = 20.dp)
        ) {
            item {
                Text(
                    text = "Món chính",
                    color = Color.White,
                    fontSize = 24.sp,
                )
            }
            items(mainDish) { main ->
                FoodItemRow(main)
            }

            item {
                Spacer(modifier = Modifier.height(30.dp))
                Divider(color = Color.Gray, thickness = 1.dp)
                Spacer(modifier = Modifier.height(10.dp))
            }
            item {
                Text(
                    text = "Món thêm",
                    color = Color.White,
                    fontSize = 24.sp,
                    modifier = Modifier.offset(y = -10.dp),
                )
            }
            items(extraDish) { extra ->
                FoodItemRow(extra)
            }
            item {
                Spacer(modifier = Modifier.height(30.dp))
                Divider(color = Color.Gray, thickness = 1.dp)
                Spacer(modifier = Modifier.height(80.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = -40.dp, x = 10.dp)
                ) {
                    Text(
                        text = "Số nhà: 54",
                        color = Color.White,
                        fontSize = 20.sp,
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Đường: 14",
                        color = Color.White,
                        fontSize = 20.sp,
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Phường: Đông Hưng Thuận",
                        color = Color.White,
                        fontSize = 20.sp,
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Quận: 12",
                        color = Color.White,
                        fontSize = 20.sp,
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Thành Phố: Hồ Chí Minh",
                        color = Color.White,
                        fontSize = 20.sp,
                    )
                }
            }
            item {
                Divider(color = Color.Gray, thickness = 1.dp)
                Spacer(modifier = Modifier.height(80.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = -50.dp, x = 10.dp)
                ) {
                    Text(
                        text = "Giờ: 13h45",
                        color = Color.White,
                        fontSize = 20.sp,
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "SDT: 0344758585",
                        color = Color.White,
                        fontSize = 20.sp,
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Tổng số lượng món ăn: 3",
                        color = Color.White,
                        fontSize = 20.sp,
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Tổng số lượng topping: 2",
                        color = Color.White,
                        fontSize = 20.sp,
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Tổng tiền: 153k",
                        color = Color.White,
                        fontSize = 20.sp,
                    )
                }
            }
        }
    }

}

@Composable
fun FoodItemRow(foodItem: FoodItem) {
    Row(
        modifier = Modifier
            .width(366.dp)
            .height(100.dp)
            .padding(top = 10.dp)
            .background(color = Color(0xFF2F2D2D), shape = RoundedCornerShape(16.dp)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.padding(6.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = foodItem.id,
                modifier = Modifier.padding(end = 16.dp),
                color = Color.White,
            )
            Image(
                painter = painterResource(id = R.drawable.suon),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp, 60.dp)
                    .offset(x = 10.dp),


                )
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = foodItem.name,
                color = Color.White,
            )
            Text(
                text = foodItem.price,
                color = Color("#e46948".toColorInt()),
            )
        }
        Text(
            text = foodItem.quantity,
            modifier = Modifier.padding(16.dp),
            color = Color.White,
        )
    }
}
