package com.ptk.mts_nrfid_tagging.ui.ui_resource.composable

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun RowScope.ListItemText(text: String, textColor: Color, modifier: Modifier = Modifier) {
    Text(
        text, color = textColor, fontSize = 11.sp, modifier = modifier

    )
}