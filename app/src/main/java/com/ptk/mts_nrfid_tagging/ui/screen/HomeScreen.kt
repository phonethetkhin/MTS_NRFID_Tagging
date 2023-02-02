package com.ptk.mts_nrfid_tagging.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ptk.mts_nrfid_tagging.R
import com.ptk.mts_nrfid_tagging.data.RFIDTaggingModelInfo
import com.ptk.mts_nrfid_tagging.ui.ui_resource.composable.HeaderText
import com.ptk.mts_nrfid_tagging.ui.ui_resource.composable.ListItemText
import com.ptk.mts_nrfid_tagging.ui.ui_resource.composable.MTSButton
import com.ptk.mts_nrfid_tagging.ui.ui_resource.theme.Green
import com.ptk.mts_nrfid_tagging.ui.ui_resource.theme.Grey
import com.ptk.mts_nrfid_tagging.ui.ui_resource.theme.LightBlue200
import com.ptk.mts_nrfid_tagging.ui.ui_resource.theme.Red
import com.ptk.mts_nrfid_tagging.ui.ui_state.HomeUIStates
import com.ptk.mts_nrfid_tagging.viewmodel.HomeViewModel
import kotlin.reflect.KFunction2


@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val uiStates by homeViewModel.uiStates.collectAsState()

    LaunchedEffect("") {
        homeViewModel.setNRfidList(dummyData())

    }
    HomeScreenContent(
        uiStates,
        navController,
        homeViewModel::onSearchChange,
        toggleAdded = homeViewModel::toggleAdded,
        increaseQty = homeViewModel::increaseQty,
        decreaseQty = homeViewModel::decreaseQty
    )

}


@Composable
fun HomeScreenContent(
    uiStates: HomeUIStates,
    navController: NavController,
    onSearchChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    toggleAdded: KFunction2<RFIDTaggingModelInfo, Boolean, Unit>,
    increaseQty: (RFIDTaggingModelInfo) -> Unit,
    decreaseQty: (RFIDTaggingModelInfo) -> Unit,
) {
    Column(modifier = modifier.fillMaxWidth()) {
        SearchView(uiStates, onSearchChanged)
        ListHeader()
        NRFDList(
            nRfidList = uiStates.nRfidList,
            navController = navController,
            toggleAdded = toggleAdded,
            increaseQty = increaseQty,
            decreaseQty = decreaseQty
        )
        MTSButton(
            text = "Save NRfid",
            textColor = Color.White,
            buttonColor = ButtonDefaults.buttonColors(backgroundColor = Red),
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

        }
    }
}


@Composable
fun SearchView(uiStates: HomeUIStates, onSearchChanged: (String) -> Unit) {

    TextField(
        value = uiStates.searchValue,
        onValueChange = onSearchChanged,
        singleLine = true,
        textStyle = TextStyle(fontSize = 17.sp),
        leadingIcon = {
            Icon(Icons.Filled.Search, null, tint = Color.Gray)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 32.dp, end = 32.dp)
            .background(Color(0xFFE7F1F1), RoundedCornerShape(32.dp)),
        placeholder = { Text(text = "Material") },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            backgroundColor = Color.Transparent,
            cursorColor = Color.DarkGray
        )
    )
}

@Composable
fun ListHeader(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(top = 16.dp, end = 8.dp, start = 8.dp)
            .background(color = LightBlue200)
    ) {
        HeaderText(
            text = "MatDoc", modifier = modifier
                .weight(1.2F)
                .padding(4.dp)
        )
        HeaderText(
            text = "Material", modifier = modifier
                .weight(1F)
                .padding(4.dp)
        )
        HeaderText(
            text = "Bin", modifier = modifier
                .weight(0.5F)
                .padding(4.dp)
        )
        HeaderText(
            text = "Batch", modifier = modifier
                .weight(0.5F)
                .padding(4.dp)
        )
        HeaderText(
            text = "Qty", textAlign = true, modifier = modifier
                .weight(0.8F)
                .padding(4.dp)
        )
        HeaderText(
            text = "", modifier = modifier
                .weight(0.3F)
                .padding(4.dp)
        )
    }
}

@Composable
fun ColumnScope.NRFDList(
    nRfidList: ArrayList<RFIDTaggingModelInfo>,
    navController: NavController,
    toggleAdded: KFunction2<RFIDTaggingModelInfo, Boolean, Unit>,
    increaseQty: (RFIDTaggingModelInfo) -> Unit,
    decreaseQty: (RFIDTaggingModelInfo) -> Unit,


    ) {
    LazyColumn(
        modifier = Modifier
            .weight(1F)
            .padding(8.dp)
    ) {
        items(items = nRfidList) { nRfidInfo ->
            NRFIDListItem(
                nRfidInfo,
                toggleAdded = toggleAdded,
                increaseQty = increaseQty,
                decreaseQty = decreaseQty,
            )
        }
    }
}

private fun dummyData() =
    arrayListOf<RFIDTaggingModelInfo>(
        RFIDTaggingModelInfo(
            "B0201",
            "00099393911",
            1,
            "Item1",
            "60000343",
            "G000942",
            "TTUUTTUUTTUU",
            1.0,
            11108,
            "MS"
        ), RFIDTaggingModelInfo(
            "B0201",
            "00099393911",
            2,
            "Item1",
            "60000343",
            "G000942",
            "TTUUTTUUTTUU",
            1.0,
            11108,
            "MS"
        ), RFIDTaggingModelInfo(
            "B0201",
            "00099393911",
            3,
            "Item1",
            "60000343",
            "G000942",
            "TTUUTTUUTTUU",
            1.0,
            11108,
            "MS"
        ), RFIDTaggingModelInfo(
            "B0201",
            "00099393911",
            4,
            "Item1",
            "60000343",
            "G000942",
            "TTUUTTUUTTUU",
            1.0,
            11108,
            "MS"
        ), RFIDTaggingModelInfo(
            "B0201",
            "00099393911",
            5,
            "Item1",
            "60000343",
            "G000942",
            "TTUUTTUUTTUU",
            1.0,
            11108,
            "MS"
        ), RFIDTaggingModelInfo(
            "B0201",
            "00099393911",
            6,
            "Item1",
            "60000343",
            "G000942",
            "TTUUTTUUTTUU",
            1.0,
            11108,
            "MS"
        )
    )

@Composable
fun NRFIDListItem(
    poModel: RFIDTaggingModelInfo,
    modifier: Modifier = Modifier,
    toggleAdded: KFunction2<RFIDTaggingModelInfo, Boolean, Unit>,
    increaseQty: (RFIDTaggingModelInfo) -> Unit,
    decreaseQty: (RFIDTaggingModelInfo) -> Unit,

    ) {
    Row(
        verticalAlignment = Alignment.Top,
        modifier = modifier
            .padding(vertical = 4.dp)
            .background(color = if (poModel.isAdded) Green else Grey)
    )

    {
        ListItemText(
            textColor = Color.Black,
            text = poModel.MatDoc, modifier = modifier
                .weight(1.2F)
                .padding(4.dp)
        )
        ListItemText(
            textColor = Color.Black,
            text = poModel.Material, modifier = modifier
                .weight(1F)
                .padding(4.dp)
        )
        ListItemText(
            textColor = Color.Black,

            text = poModel.StorBin, modifier = modifier
                .weight(0.5F)
                .padding(4.dp)
        )
        ListItemText(
            textColor = Color.Black,

            text = if (poModel.Batch != "") poModel.Batch else "NA", modifier = modifier
                .weight(0.5F)
                .padding(4.dp)
        )
        Image(
            painterResource(R.drawable.baseline_keyboard_arrow_left_24),
            "",
            modifier = modifier
                .weight(0.3F)
                .padding(4.dp)
                .clickable {
                    decreaseQty.invoke(poModel)
                }
        )
        ListItemText(
            textColor = Color.Black,
            text = poModel.currQty.toString(), modifier = modifier
                .weight(0.2F)
                .padding(4.dp)
        )
        Image(
            painterResource(R.drawable.baseline_keyboard_arrow_right_24),
            "",
            modifier = modifier
                .weight(0.3F)
                .padding(4.dp)
                .clickable {
                    increaseQty.invoke(poModel)
                }
        )
        Image(
            painterResource(if (poModel.isAdded) R.drawable.ic_close else R.drawable.ic_baseline_add_24),
            "",
            modifier = modifier
                .weight(0.3F)
                .padding(4.dp)
                .background(if (poModel.isAdded) Red else Color.Green, shape = CircleShape)
                .clickable {
                    toggleAdded.invoke(poModel, !poModel.isAdded)
                }
        )

    }
}

