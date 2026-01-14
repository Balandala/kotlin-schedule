package com.example.schedule.data

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.temporal.TemporalAdjusters
import kotlin.random.Random

class ScheduleProvider {
    companion object{

        public val firstWeekSchedule : List<DayItem> by lazy { getWeekSchedule("Week I") }
        public val secondWeekSchedule : List<DayItem> by lazy { getWeekSchedule("Week II") }

        fun getTodaySchedule(schedule: List<DayItem>): List<DayItem>{
            val dateOfWeek = LocalDate.now().dayOfWeek
            val today = schedule.firstOrNull{it.dayOfWeek == dateOfWeek}
            today ?: return listOf()
            return listOf(today)
        }

        private  val pairsSet = listOf<SubjectItem>(
            SubjectItem(
                subjectNum = 1,
                startTime = "08:00",
                endTime = "09:30",
                name = "Subject 1",
                classroom = "Classroom 1",
                teacher = "Teacher 1"
            ),
            SubjectItem(
                subjectNum = 2,
                startTime = "09:40",
                endTime = "11:10",
                name = "Subject 2",
                classroom = "Classroom 2",
                teacher = "Teacher 2"
            ),
            SubjectItem(
                subjectNum = 3,
                startTime = "11:20",
                endTime = "12:50",
                name = "Subject 3",
                classroom = "Classroom 3",
                teacher = "Teacher 3"
            ),
            SubjectItem(
                subjectNum = 4,
                startTime = "13:15",
                endTime = "14:45",
                name = "Subject 4",
                classroom = "Classroom 4",
                teacher = "Teacher 4"
            ),
            SubjectItem(
                subjectNum = 5,
                startTime = "15:00",
                endTime = "16:30",
                name = "Subject 5",
                classroom = "Classroom 5",
                teacher = "Teacher 5"
            ),
            SubjectItem(
                subjectNum = 6,
                startTime = "16:40",
                endTime = "18:10",
                name = "Subject 6",
                classroom = "Classroom 6",
                teacher = "Teacher 6"
            ),
            SubjectItem(
                subjectNum = 7,
                startTime = "18:20",
                endTime = "19:50",
                name = "Subject 7",
                classroom = "Classroom 7",
                teacher = "Teacher 7"
            ),
            SubjectItem(
                subjectNum = 8,
                startTime = "19:55",
                endTime = "21:25",
                name = "Subject 8",
                classroom = "Classroom 8",
                teacher = "Teacher 8"
            ),

            ).toMutableList()

        private fun getRandomPairsSubset(min: Int, max: Int): MutableList<SubjectItem> {

            val pairCount = Random.nextInt(min, max)
            val todayPairs= arrayOfNulls<SubjectItem>(pairCount).toMutableList()
            for (i in 0..<pairCount) {
                todayPairs[i] = pairsSet[Random.nextInt(0, pairsSet.size-1)]
            }
            todayPairs.sortBy { it?.subjectNum }
            return todayPairs.filterNotNull().toMutableList()
        }

        private fun getWeekSchedule(week: String): List<DayItem> {

            val days = DayOfWeek.entries

            val list: MutableList<DayItem> = mutableListOf()

            for (day: DayOfWeek in days) {
                list.add(
                    DayItem(
                        day,
                        week,
                        getRandomPairsSubset(1, 4)
                    )
                )
            }
            return list
        }

    }
}