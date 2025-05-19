package com.samridhi.contactflow.presentation.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.samridhi.contactflow.alias.AppDrawable
import com.samridhi.contactflow.alias.AppString
import com.samridhi.contactflow.ui.theme.Purple40
import com.samridhi.contactflow.ui.theme.blue
import com.samridhi.contactflow.ui.theme.gray0
import com.samridhi.contactflow.ui.theme.gray5
import com.samridhi.contactflow.ui.theme.gray6
import com.samridhi.contactflow.ui.theme.lightPink
import com.samridhi.contactflow.ui.theme.red
import com.samridhi.contactflow.ui.theme.red50

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel(),
) {
    HomeScreenContent(
        uiState = viewModel.uiState,
        onEvent = viewModel::onEvent
    )
}

@Composable
fun HomeScreenContent(
    uiState: HomeScreenUiState,
    onEvent: (HomeScreenUiEvent) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = gray0)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp, vertical = 12.dp)
        ) {
            TextField(
                value = uiState.searchTextFieldValue,
                onValueChange = {
                  onEvent(HomeScreenUiEvent.SearchTextChanged(it))
                },
                placeholder = {
                    Text(
                        text = stringResource(AppString.search_contact),
                        color = Color.Gray
                    )
                },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = AppDrawable.ic_search_16px),
                        contentDescription = "Search"
                    )
                },
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            )

            Spacer(modifier = Modifier.size(24.dp))

            LazyColumn {
                items(uiState.contactInfoList) {
                    ContactItem(it)
                }
            }
        }
        Column(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp),
        ) {
            FloatingActionButton(
                onClick = {

                },
                modifier = Modifier.padding(bottom = 12.dp),
                containerColor = Purple40
            ) {
                Icon(
                    modifier = Modifier.height(20.dp),
                    painter = painterResource(id = AppDrawable.sync),
                    contentDescription = "Sync",
                    tint = Color.Black
                )
            }

            FloatingActionButton(
                onClick = {

                },
                containerColor = Purple40
            ) {
                Icon(
                    modifier = Modifier.height(20.dp),
                    painter = painterResource(id = AppDrawable.plus),
                    contentDescription = "Add",
                    tint = Color.Black
                )
            }
        }
    }
}


@Composable
fun ContactItem(
    data: ContactInfo,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(vertical = 6.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(data.color)
        ) {
            Text(
                text = data.initial,
                color = Color.White,
            )
        }
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = data.name,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        HomeScreenContent(
            uiState = HomeScreenUiState(
                contactInfoList = listOf(
                    ContactInfo(
                        id = "1",
                        name = "Ram",
                        initial = "R",
                        color = blue
                    ),
                    ContactInfo(
                        id = "2",
                        name = "Aris",
                        initial = "A",
                        color = red50
                    ),
                    ContactInfo(
                        id = "3",
                        name = "Farida",
                        initial = "F",
                        color = blue
                    ),
                    ContactInfo(
                        id = "4",
                        name = "Sundar",
                        initial = "S",
                        color = red
                    ),
                    ContactInfo(
                        id = "5",
                        name = "Eagle",
                        initial = "E",
                        color = lightPink
                    ),
                    ContactInfo(
                        id = "6",
                        name = "Dog",
                        initial = "D",
                        color = gray5
                    ),
                    ContactInfo(
                        id = "7",
                        name = "Cat",
                        initial = "C",
                        color = blue
                    ),
                    ContactInfo(
                        id = "8",
                        name = "Mat",
                        initial = "M",
                        color = lightPink
                    ),
                    ContactInfo(
                        id = "9",
                        name = "Tipu",
                        initial = "T",
                        color = gray6
                    ),
                    ContactInfo(
                        id = "10",
                        name = "Booy",
                        initial = "B",
                        color = blue
                    )
                )
            ),
            onEvent = {}
        )
    }
}