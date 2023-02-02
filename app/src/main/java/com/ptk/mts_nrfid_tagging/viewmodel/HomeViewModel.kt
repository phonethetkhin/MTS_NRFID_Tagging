package com.ptk.mts_nrfid_tagging.viewmodel

import androidx.lifecycle.ViewModel
import com.ptk.mts_nrfid_tagging.data.RFIDTaggingModelInfo
import com.ptk.mts_nrfid_tagging.ui.ui_state.HomeUIStates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _uiStates = MutableStateFlow(HomeUIStates())
    val uiStates = _uiStates.asStateFlow()

    fun onSearchChange(updatedValue: String) {
        _uiStates.update { it.copy(searchValue = updatedValue) }
    }

    fun setNRfidList(nRfidList: ArrayList<RFIDTaggingModelInfo>) {
        _uiStates.update { it.copy(nRfidList = nRfidList) }
    }

    fun toggleAdded(poModel: RFIDTaggingModelInfo, isAdded: Boolean) {
        _uiStates.update {
            it.copy(nRfidList = _uiStates.value.nRfidList.mapIndexed { index, details ->
                if (_uiStates.value.nRfidList.indexOf(poModel) == index) details.copy(isAdded = isAdded)
                else details
            } as ArrayList<RFIDTaggingModelInfo>)
        }
    }

    fun increaseQty(poModel: RFIDTaggingModelInfo) {
        _uiStates.update {
            it.copy(nRfidList = _uiStates.value.nRfidList.mapIndexed { index, details ->
                if (_uiStates.value.nRfidList.indexOf(poModel) == index) details.copy(currQty = details.currQty + 1)
                else details
            } as ArrayList<RFIDTaggingModelInfo>)
        }
    }

    fun decreaseQty(poModel: RFIDTaggingModelInfo) {
        _uiStates.update {
            it.copy(nRfidList = _uiStates.value.nRfidList.mapIndexed { index, details ->
                if (_uiStates.value.nRfidList.indexOf(poModel) == index) details.copy(currQty = details.currQty - 1)
                else details
            } as ArrayList<RFIDTaggingModelInfo>)
        }
    }
}
