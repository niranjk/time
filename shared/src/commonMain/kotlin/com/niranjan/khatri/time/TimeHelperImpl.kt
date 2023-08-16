package com.niranjan.khatri.time

import io.github.aakira.napier.Napier
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

class TimeHelperImpl : TimeHelper {
    override fun getTimeZoneStrings(): List<String> {
        return TimeZone.availableZoneIds.sorted()
    }

    override fun currentTime(): String {
        val currentMoment : Instant = Clock.System.now()
        val dateTime: LocalDateTime = currentMoment.toLocalDateTime(kotlinx.datetime.TimeZone.currentSystemDefault())
        return formatDateTime(dateTime)
    }

    fun formatDateTime(dateTime: LocalDateTime): String{
        val stringBuilder = StringBuilder()
        val minute = dateTime.minute
        var hour = dateTime.hour % 12
        if (hour == 0) hour = 12
        val amPm = if (dateTime.hour < 12) "am" else "pm"
        stringBuilder.append(hour.toString())
        stringBuilder.append(":")
        if (minute < 10){
            stringBuilder.append("0")
        }
        stringBuilder.append(minute.toString())
        stringBuilder.append(amPm)
        return stringBuilder.toString()
    }
    override fun currentTimeZone(): String {
        val currentTimeZone = TimeZone.currentSystemDefault()
        return currentTimeZone.toString()
    }

    override fun hoursFromTimeZone(otherTimeZoneId: String): Double {
        val currentTimeZone = TimeZone.currentSystemDefault()
        val currentUTCInstant = Clock.System.now()
        // Date time in other timezone
        val otherTimeZone = TimeZone.of(otherTimeZoneId)
        val currentDateTime = currentUTCInstant.toLocalDateTime(currentTimeZone)
        val currentOtherDateTime = currentUTCInstant.toLocalDateTime(otherTimeZone)
        return abs((currentDateTime.hour.minus(currentOtherDateTime.hour))*1.0)
    }

    override fun getTime(timeZoneId: String): String {
        val timeZone = TimeZone.of(timeZoneId)
        val currentMoment = Clock.System.now()
        val dateTime = currentMoment.toLocalDateTime(timeZone)
        return formatDateTime(dateTime)
    }

    override fun getDate(timeZoneId: String): String {
        val timeZone = TimeZone.of(timeZoneId)
        val currentMoment = Clock.System.now()
        val dateTime = currentMoment.toLocalDateTime(timeZone)
        return "${dateTime.dayOfWeek.name.lowercase().replaceFirstChar {  it.uppercase() }}, " +
                "${dateTime.month.name.lowercase().replaceFirstChar { it.uppercase() }} ${dateTime.date.dayOfMonth}"
    }

    override fun search(startHour: Int, endHour: Int, timezoneStrings: List<String>): List<Int> {
        val goodHours = mutableListOf<Int>()
        val timeRange = IntRange(max(0, startHour), min(23, endHour))
        val currentTimeZone = TimeZone.currentSystemDefault()
        for( hour in timeRange){
            var isGoodHour = false
            for (zone in timezoneStrings){
                val timezone = TimeZone.of(zone)
                if (timezone == currentTimeZone){
                    continue
                }
                if (!isValid(timeRange = timeRange, hour = hour, currentTimeZone, timezone)){
                    Napier.d("Hour $hour is not valid for time range")
                    isGoodHour = false
                    break
                } else {
                    Napier.d("Hour $hour is Valid for time range")
                    isGoodHour = true
                }
            }
            if (isGoodHour){
                goodHours.add(hour)
            }
        }
        return goodHours
    }

    private fun isValid(
        timeRange: IntRange,
        hour: Int,
        currentTimeZone: TimeZone,
        otherTimeZone: TimeZone
    ): Boolean{
        if (hour !in timeRange){
            return false
        }
        // right now you are in UTC time
        val currentUTCInstant = Clock.System.now()
        // Date time in other timezone
        val currentOtherDateTime = currentUTCInstant.toLocalDateTime(otherTimeZone)
        // DateTime with given hour
        val otherDateTimeWithHour = LocalDateTime(
            currentOtherDateTime.year,
            currentOtherDateTime.monthNumber,
            currentOtherDateTime.dayOfMonth,
            hour,
            0,0,0
        )
        // convert that hour into the current timezone
        val localInstant = otherDateTimeWithHour.toInstant(currentTimeZone)
        // convert our timezone hour to other timezone
        val convertedTime = localInstant.toLocalDateTime(otherTimeZone)
        Napier.d("Hour $hour in Time Range ${otherTimeZone.id} is ${convertedTime.hour}")
        // see if it's in our time range
        return convertedTime.hour in timeRange
    }

}