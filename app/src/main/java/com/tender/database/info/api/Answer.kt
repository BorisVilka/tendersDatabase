package com.tender.database.info.api

import java.io.Serializable

data class Answer(
    val id: String,
    val title: String?,
    val deadline_date: String?,
    val date: String?,
    val purchaser: Purchaser?,
    var purchaser_name: String?
): Serializable