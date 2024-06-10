package com.locdhph46788.xuongkotlin_comtamapp.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.locdhph46788.xuongkotlin_comtamapp.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddDishScreen(navController: NavController) {
    var context = LocalContext.current

    var expanded by remember {
        mutableStateOf(false)
    }
    var typeDish by remember {
        mutableStateOf("Món chính")
    }

    var price by remember {
        mutableStateOf("")
    }

    var name by remember {
        mutableStateOf("")
    }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF252121))
            .padding(start = 20.dp, end = 20.dp)
    ) {

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                elevation = null,
                modifier = Modifier.size(205.dp)
            ) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.size(205.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.addimg),
                        contentDescription = null,
                        modifier = Modifier.size(205.dp)
                    )

                }
            }
        }
        Text(
            text = "Loại món",
            fontSize = 14.sp,
            fontWeight = FontWeight(400),
            color = Color.White
        )
        Spacer(modifier = Modifier.height(6.dp))
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = it }
        ) {
            TextField(
                value = typeDish,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
            )
            ExposedDropdownMenu(expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(text = {
                    Text(text = "Món chính")
                }, onClick = {
                    typeDish = "Món chính"
                    expanded = false
                })
                DropdownMenuItem(text = {
                    Text(text = "Món thêm")
                }, onClick = {
                    typeDish = "Món thêm"
                    expanded = false
                })

                DropdownMenuItem(text = {
                    Text(text = "Topping")
                }, onClick = {
                    typeDish = "Topping"
                    expanded = false
                })
                DropdownMenuItem(text = {
                    Text(text = "Khác")
                }, onClick = {
                    typeDish = "Khác"
                    expanded = false
                })
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Giá",
            fontSize = 14.sp,
            fontWeight = FontWeight(400),
            color = Color.White
        )
        Spacer(modifier = Modifier.height(6.dp))
        OutlinedTextField(
            value = price,
            onValueChange = { price = it },
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White, shape = RoundedCornerShape(5.dp))
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Tên món ăn",
            fontSize = 14.sp,
            fontWeight = FontWeight(400),
            color = Color.White
        )
        Spacer(modifier = Modifier.height(6.dp))
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White, shape = RoundedCornerShape(5.dp))
        )
        Spacer(modifier = Modifier.height(60.dp))
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
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
}