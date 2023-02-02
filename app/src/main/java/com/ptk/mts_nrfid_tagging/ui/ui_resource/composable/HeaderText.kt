package com.ptk.mts_nrfid_tagging.ui.ui_resource.composable

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun RowScope.HeaderText(text: String, textAlign: Boolean = false, modifier: Modifier = Modifier) {
    Text(
        text,
        textAlign = if (textAlign) TextAlign.Center else TextAlign.Start,
        color = Color.Black,
        fontSize = 12.sp,
        modifier = modifier
    )
}