package com.ptk.mts_nrfid_tagging.ui.ui_state

import androidx.compose.runtime.mutableStateListOf
import com.ptk.mts_nrfid_tagging.data.RFIDTaggingModelInfo

data class HomeUIStates(
    val searchValue: String = "",
    val nRfidList : ArrayList<RFIDTaggingModelInfo> = ArrayList()
)