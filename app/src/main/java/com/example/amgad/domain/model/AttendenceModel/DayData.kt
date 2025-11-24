package com.example.amgad.domain.model.AttendenceModel

import java.time.LocalDate

data class DayData(
    val date: LocalDate, val dayName: String, val dayNumber: Int
)