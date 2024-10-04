package com.example.hm01_06m.models

import android.icu.text.IDNA
import com.google.gson.annotations.SerializedName


data class BaseResponse(
    @SerializedName("info")
    val info: IDNA.Info,
    @SerializedName("results")
    val characters: List<Character>
)