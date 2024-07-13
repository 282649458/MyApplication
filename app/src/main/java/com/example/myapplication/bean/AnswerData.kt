package com.example.myapplication.bean

import androidx.fragment.app.Fragment

data class AnswerData(
    val list: List<String>
)

data class Data(
    val description_en: String,
    val description_zh: String,
    val title_en: String,
    val title_zh: String
)