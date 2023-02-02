package com.ptk.mts_nrfid_tagging.ui.ui_resource.composable

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MTSButton(
    text: String,
    textColor: Color,
    enable:Boolean = true,
    buttonColor: ButtonColors,
    modifier: Modifier = Modifier,
    buttonClick: () -> Unit,
) {
    Button(
        onClick = buttonClick,
        modifier = modifier,
        enabled = enable,
        shape = RoundedCornerShape(8.dp),
        colors = buttonColor

    ) {
        Text(text, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = textColor)
    }
}