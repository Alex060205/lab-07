package com.example.lab_7

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

class DriverScreen {
}
@Composable
fun DriverScreen(navController: NavController) {
    var dlocation by remember {
        mutableStateOf("")
    }

    var drivers = remember {
        mutableStateListOf<String>()
    }

    var selectedDriver by remember {
        mutableStateOf<String?>(null)
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier.testTag("backButton")
        ) {
            Text("Back")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // title text
        Text(
            text = "Upcoming Drivers",
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextField(
                value = dlocation,
                onValueChange = {
                    dlocation = it
                },
                label = {
                    Text("Driver Name")
                },
                modifier = Modifier.testTag("locationInput")
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    if (dlocation.isNotBlank()) {
                        drivers.add(dlocation)
                        dlocation = ""
                    }
                },
                modifier = Modifier.testTag("addDRiverButton")
            ) {
                Text("Add")
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Button(
                onClick = {
                    val driver = selectedDriver

                    if (driver != null) {
                        drivers.remove(driver)
                        selectedDriver = null
                    }
                },
                modifier = Modifier.testTag("deleteDriverButton")
            ) {
                Text("Delete")
            }
        }
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(drivers) { driver ->
                Text(
                    text = driver,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            selectedDriver = driver
                        }
                        .padding(12.dp)
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Button(
                onClick = {
                    drivers.clear()
                    selectedDriver = null
                },
                modifier = Modifier.testTag("clearAllDriversButton")
            ) {
                Text("Clear All")
            }
        }
    }
}