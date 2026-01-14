package com.example.schedule.data

data class SubjectItem (
    val subjectNum: Int,
    val startTime: String,
    val endTime: String,
    val name: String,
    val classroom: String,
    val teacher: String,
) : MyItem