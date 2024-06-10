package com.locdhph46788.xuongkotlin_comtamapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.locdhph46788.xuongkotlin_comtamapp.models.OrderModel
import com.locdhph46788.xuongkotlin_comtamapp.navigations.ROUTE_BOTTOM_NAV
import com.locdhph46788.xuongkotlin_comtamapp.navigations.ROUTE_MAIN_NAV

val ListOrder = listOf(
    OrderModel("CT2E22E", 162.000, false),
    OrderModel("CT2E206", 157.000, false),
    OrderModel("CT2E23E", 160.000, true),
    OrderModel("CT2E12E", 160.000, true),
)

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF252121))
    ) {
        Box(
            modifier = Modifier.padding(vertical = 10.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 0.dp, vertical = 25.dp)
            ) {
                Text(
                    text = "Today: 19 - 05 - 2023",
                    fontSize = 20.sp,
                    fontWeight = FontWeight(600),
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Số lượng đơn: 2",
                    fontSize = 20.sp,
                    fontWeight = FontWeight(600),
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight(600)
                        )
                    ) {
                        append("Doanh thu : ")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xffFE724C),
                            fontSize = 20.sp,
                            fontWeight = FontWeight(600)
                        )
                    ) {
                        append("320.000 đ")
                    }
                })
            }
        }


        LazyColumn(
            state = rememberLazyListState(),
        ) {
            items(ListOrder) { order ->
                ItemOrder(
                    nameTitle = order.nameOrder,
                    totalAmount = order.totalAmount,
                    status = order.status,
                    navController
                )
            }
        }


    }

}

@Composable
fun ItemOrder(
    nameTitle: String,
    totalAmount: Double,
    status: Boolean,
    navController: NavController
) {
    Box {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .background(color = Color(0xFF2F2D2D), shape = RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .clickable {
                    navController.navigate(ROUTE_BOTTOM_NAV.ORDERDETAIL.name)
                }
                .height(100.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 5.dp)
                ) {
                    Text(
                        text = "Đơn hàng: $nameTitle",
                        fontSize = 17.sp,
                        fontWeight = FontWeight(600),
                        color = Color.White
                    )
                    Box {
                        Text(
                            text = "||",
                            fontSize = 17.sp,
                            fontWeight = FontWeight(600),
                            color = Color.White,
                            modifier = Modifier.padding(end = 40.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = String.format("%.3f", totalAmount) + "đ",
                            fontSize = 17.sp,
                            fontWeight = FontWeight(600),
                            color = Color.White,
                            modifier = Modifier.padding(start = 35.dp)
                        )
                    }

                }
            }
            Box {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 0.dp)
                ) {
                    Text(
                        text = "Trạng thái",
                        fontSize = 17.sp,
                        fontWeight = FontWeight(500),
                        color = Color.White
                    )
                    Text(
                        text = if (status == false) "Từ chối" else "Chấp nhận",
                        fontSize = 17.sp,
                        fontWeight = FontWeight(500),
                        color = if (status == false) Color.Red else Color.Green
                    )
                }
            }

        }
    }
}
