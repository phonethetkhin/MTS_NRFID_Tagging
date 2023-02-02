package com.ptk.mts_nrfid_tagging.data

@kotlinx.serialization.Serializable
data class RFIDTaggingModelInfo(
    val Batch: String,
    val GRNumber: String,
    val ID: Int,
    val Item: String,
    val MatDoc: String,
    val Material: String,
    val PONo: String,
    val Qty: Double,
    val Quant: Int,
    val StorBin: String,

    var isAdded: Boolean = false,
    var currQty: Int = 1,
)