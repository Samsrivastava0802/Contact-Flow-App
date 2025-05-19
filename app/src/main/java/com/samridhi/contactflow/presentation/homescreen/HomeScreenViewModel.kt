package com.samridhi.contactflow.presentation.homescreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import com.samridhi.contactflow.ui.theme.blue
import com.samridhi.contactflow.ui.theme.gray5
import com.samridhi.contactflow.ui.theme.gray6
import com.samridhi.contactflow.ui.theme.lightPink
import com.samridhi.contactflow.ui.theme.red
import com.samridhi.contactflow.ui.theme.red50
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(

) : ViewModel() {
    var uiState by mutableStateOf(HomeScreenUiState())
        private set

    init {
        hitApi()
    }

private fun hitApi(){
    uiState = uiState.copy(
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
    )
}

    fun onEvent(event: HomeScreenUiEvent){
        when(event){
            HomeScreenUiEvent.AddContactButton -> {

            }
            HomeScreenUiEvent.SyncContactButton -> {

            }

            is HomeScreenUiEvent.SearchTextChanged -> {
                uiState = uiState.copy(searchTextFieldValue = event.searchText)
            }
        }
    }
}


data class HomeScreenUiState(
    val searchTextFieldValue: TextFieldValue = TextFieldValue(),
    val contactInfoList : List<ContactInfo> = emptyList()
)

data class ContactInfo(
    val id : String = "",
    val name: String = "",
    val initial: String = "",
    val color : Color = red
)

sealed class HomeScreenUiEvent{
    data class SearchTextChanged(val searchText: TextFieldValue) : HomeScreenUiEvent()
    data object AddContactButton : HomeScreenUiEvent()
    data object SyncContactButton : HomeScreenUiEvent()
}





