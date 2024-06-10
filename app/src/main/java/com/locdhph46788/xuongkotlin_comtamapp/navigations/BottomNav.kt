package com.locdhph46788.xuongkotlin_comtamapp.navigations

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.locdhph46788.xuongkotlin_comtamapp.R
import com.locdhph46788.xuongkotlin_comtamapp.screens.AddDishScreen
import com.locdhph46788.xuongkotlin_comtamapp.screens.AddTypeDishScreen
import com.locdhph46788.xuongkotlin_comtamapp.screens.ContactScreen
import com.locdhph46788.xuongkotlin_comtamapp.screens.DeleteUpdateDishScreen
import com.locdhph46788.xuongkotlin_comtamapp.screens.DeleteUpdateTypeDishScreen
import com.locdhph46788.xuongkotlin_comtamapp.screens.HomeScreen
import com.locdhph46788.xuongkotlin_comtamapp.screens.ManageDishScreen
import com.locdhph46788.xuongkotlin_comtamapp.screens.ManageScreen
import com.locdhph46788.xuongkotlin_comtamapp.screens.ManageTypeDishScreen
import com.locdhph46788.xuongkotlin_comtamapp.screens.NotificationScreen
import com.locdhph46788.xuongkotlin_comtamapp.screens.OrderDetailScreen


enum class ROUTE_BOTTOM_NAV {
    HOME,
    MANAGE,
    CONTACT,
    NOTIFICATION,
    ORDERDETAIL,
    MANAGEDISH,
    MANAGETYPEDISH,
    ADDDISH,
    ADDTYPEDISH,
    DELETEUPDATEDISH,
    DELETEUPDATETYPEDISH

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavHost(navController: NavHostController) {
    var isSelected by remember {
        mutableStateOf(ROUTE_BOTTOM_NAV.HOME.name)
    }
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Cum tứm đim",
                        color = Color.White,
                        fontWeight = FontWeight(700),
                        fontSize = 17.sp,
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                    }) {
                        Image(
                            painter = painterResource(id = R.drawable.logo),
                            contentDescription = null,
                            modifier = Modifier.size(60.dp, 50.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xff252121)
                ),
                actions = {
                    if (isSelected === ROUTE_BOTTOM_NAV.HOME.name) {
                        IconButton(onClick = {
                            navController.navigate(ROUTE_BOTTOM_NAV.NOTIFICATION.name)
                        }) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_noti),
                                contentDescription = null,
                                modifier = Modifier.size(30.dp, 30.dp)
                            )
                        }
                    } else {
                        @Suppress("UNUSED_EXPRESSION")
                        null
                    }

                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color(0xff312C2C),
            ) {
                NavigationBarItem(
                    selected = isSelected === ROUTE_BOTTOM_NAV.HOME.name,
                    onClick = {
                        isSelected = ROUTE_BOTTOM_NAV.HOME.name
                        navController.navigate(ROUTE_BOTTOM_NAV.HOME.name) {
                            popUpTo(0)
                        }
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = if (isSelected == ROUTE_BOTTOM_NAV.HOME.name) R.drawable.ic_home1 else R.drawable.ic_home),
                            contentDescription = null,
                            modifier = Modifier.size(25.dp, 25.dp)
                        )
                    },
                    label = {
                        Text(
                            text = "Trang chủ",
                            fontSize = 15.sp,
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xffFFB703),
                        selectedTextColor = Color(0xffFFB703),
                        unselectedIconColor = Color.White,
                        unselectedTextColor = Color.White,
                        indicatorColor = Color(0xff312C2C),

                        ),

                    )

                NavigationBarItem(
                    selected = isSelected === ROUTE_BOTTOM_NAV.MANAGE.name,
                    onClick = {
                        isSelected = ROUTE_BOTTOM_NAV.MANAGE.name
                        navController.navigate(ROUTE_BOTTOM_NAV.MANAGE.name) {
                            popUpTo(0)
                        }
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = if (isSelected == ROUTE_BOTTOM_NAV.MANAGE.name) R.drawable.ic_manage1 else R.drawable.ic_manage),
                            contentDescription = null,
                            modifier = Modifier.size(25.dp, 25.dp)
                        )
                    },
                    label = {
                        Text(
                            text = "Quản lý",
                            fontSize = 15.sp,
                        )

                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xffFFB703),
                        selectedTextColor = Color(0xffFFB703),
                        unselectedIconColor = Color.White,
                        unselectedTextColor = Color.White,
                        indicatorColor = Color(0xff312C2C)
                    ),
                )
                NavigationBarItem(
                    selected = isSelected === ROUTE_BOTTOM_NAV.CONTACT.name,
                    onClick = {
                        isSelected = ROUTE_BOTTOM_NAV.CONTACT.name
                        navController.navigate(ROUTE_BOTTOM_NAV.CONTACT.name) {
                            popUpTo(0)
                        }
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = if (isSelected == ROUTE_BOTTOM_NAV.CONTACT.name) R.drawable.ic_contact1 else R.drawable.ic_contact),
                            contentDescription = null,
                            modifier = Modifier.size(25.dp, 25.dp)
                        )
                    },
                    label = {
                        Text(
                            text = "Hỗ trợ",
                            fontSize = 15.sp,
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xffFFB703),
                        selectedTextColor = Color(0xffFFB703),
                        unselectedIconColor = Color.White,
                        unselectedTextColor = Color.White,
                        indicatorColor = Color(0xff312C2C)
                    ),
                )

            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color(0xff000000)
                )
                .padding(it)
        ) {
            NavHost(
                navController = navController,
                startDestination = ROUTE_BOTTOM_NAV.HOME.name
            ) {
                composable(ROUTE_BOTTOM_NAV.HOME.name) { HomeScreen(navController) }
                composable(ROUTE_BOTTOM_NAV.MANAGE.name) { ManageScreen(navController) }
                composable(ROUTE_BOTTOM_NAV.CONTACT.name) { ContactScreen(navController) }
                composable(ROUTE_BOTTOM_NAV.NOTIFICATION.name) { NotificationScreen(navController) }
                composable(ROUTE_BOTTOM_NAV.ORDERDETAIL.name) { OrderDetailScreen(navController) }
                composable(ROUTE_BOTTOM_NAV.MANAGEDISH.name) { ManageDishScreen(navController) }
                composable(ROUTE_BOTTOM_NAV.MANAGETYPEDISH.name) {
                    ManageTypeDishScreen(
                        navController
                    )
                }
                composable(ROUTE_BOTTOM_NAV.ADDDISH.name) { AddDishScreen(navController) }
                composable(ROUTE_BOTTOM_NAV.ADDTYPEDISH.name) { AddTypeDishScreen(navController) }
                composable(ROUTE_BOTTOM_NAV.DELETEUPDATEDISH.name) {
                    DeleteUpdateDishScreen(
                        navController
                    )
                }
                composable(ROUTE_BOTTOM_NAV.DELETEUPDATETYPEDISH.name) {
                    DeleteUpdateTypeDishScreen(
                        navController
                    )
                }


            }


        }
    }
}
