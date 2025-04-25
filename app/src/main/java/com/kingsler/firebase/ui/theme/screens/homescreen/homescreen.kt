package com.kingsler.firebase.ui.theme.screens.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kingsler.firebase.navigation.ROUTE_ADD_PRODUCT
import com.kingsler.firebase.navigation.ROUTE_VIEW_PRODUCT
import com.kingsler.firebase.navigation.ROUTE_VIEW_UPLOAD
import com.kingsler.firebase.ui.theme.*

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(nightSky)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Title
        Text(
            text = "Welcome to Home Page",
            color = emeraldGreen,
            fontFamily = FontFamily.SansSerif,
            fontSize = 32.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Add Product Button
        Button(
            onClick = { navController.navigate(ROUTE_ADD_PRODUCT) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = emeraldGreen)
        ) {
            Text(
                text = "Add Product",
                fontSize = 18.sp,
                color = Color.White
            )
        }

        // View Product Button
        Button(
            onClick = { navController.navigate(ROUTE_VIEW_PRODUCT) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = sapphire)
        ) {
            Text(
                text = "View Product",
                fontSize = 18.sp,
                color = Color.White
            )
        }

        // View Uploads Button
        Button(
            onClick = { navController.navigate(ROUTE_VIEW_UPLOAD) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = rubyWine)
        ) {
            Text(
                text = "View Uploads",
                fontSize = 18.sp,
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
fun HomePreview() {
    HomeScreen(rememberNavController())
}