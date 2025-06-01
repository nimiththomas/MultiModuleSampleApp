package com.picker.common

import com.multimodulesample.common.DateConstants.DATE_TIME_FORMAT_MMMM_DD_YYYYY_HH_MM_A
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.Locale

object DateUtils {

    fun getCurrentDateUtc(): Long {
        val date = LocalDate.now()
        return date.atStartOfDay(ZoneId.of("UTC")).toInstant().toEpochMilli()
    }

    fun getDateAfterMonths(numberOfMonths: Long): Long {
        val date = LocalDate.now().plusMonths(numberOfMonths)
        return date.atStartOfDay(ZoneId.of("UTC")).toInstant().toEpochMilli()
    }

    fun combineDateAndTime(dateInUtc: Long, hours: Int, minutes: Int): Long {
        // Step 1: Convert long to Instant
        val instant = Instant.ofEpochMilli(dateInUtc)

        // Step 2: Add hours and minutes
        val updatedInstant = instant.plus(hours.toLong(), ChronoUnit.HOURS)
            .plus(minutes.toLong(), ChronoUnit.MINUTES)

        // Step 3: Return the updated Instant as milliseconds since epoch
        return updatedInstant.toEpochMilli()
    }

    fun formatDateFromLong(dateInUtc: Long, format: String): String {
        // Convert long to ZonedDateTime in UTC
        val zonedDateTime =
            ZonedDateTime.ofInstant(Instant.ofEpochMilli(dateInUtc), ZoneId.of("UTC"))

        // Define the formatter for the desired output
        val formatter = DateTimeFormatter.ofPattern(format)

        // Format the ZonedDateTime to the desired string format
        return zonedDateTime.format(formatter)
    }

    fun getDateTimeInIsoFormat(dateTime: Long): String? {
        return Instant.ofEpochMilli(dateTime)
            .atZone(ZoneId.of("UTC"))
            .format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
    }

    fun formatDate(
        dateString: String?,
        format: String = DATE_TIME_FORMAT_MMMM_DD_YYYYY_HH_MM_A
    ): String {
        try {
            val inputFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME
            val outputFormatter =
                DateTimeFormatter.ofPattern(format, Locale.getDefault())
            val localDateTime = LocalDateTime.parse(dateString, inputFormatter)
            return localDateTime.format(outputFormatter)
        } catch (e: Exception) {
            return ""
        }
    }

}