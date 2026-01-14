package com.example.schedule.data

import java.time.DayOfWeek

data class DayItem(
    val dayOfWeek: DayOfWeek,
    val week: String,
    val subjectList: MutableList<SubjectItem> = mutableListOf()
) : MyItem