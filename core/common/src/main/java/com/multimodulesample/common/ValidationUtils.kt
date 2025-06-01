package com.picker.common

import android.content.Context
import com.google.i18n.phonenumbers.PhoneNumberUtil
import com.picker.common.ValidationConstants.EMAIL_MAX_LENGTH
import com.picker.common.ValidationConstants.EMAIL_VALID_CHARACTERS
import com.picker.common.ValidationConstants.FIRST_SPACE_REGEX_PATTERN
import com.picker.common.ValidationConstants.NAME_MAX_LENGTH
import com.picker.common.ValidationConstants.OTP_MAX_LENGTH
import com.picker.common.ValidationConstants.PHONE_NUMBER_MAX_LENGTH
import com.picker.common.ValidationConstants.SPACE_REGEX_PATTERN


object ValidationUtils {

    /**
     * Validates an email string against a specific regex pattern.
     *
     * @param email The email string to be validated.
     * @param requireNonEmpty If true, the email must be non-empty to be considered valid.
     * @return True if the email is valid according to the regex pattern, false otherwise.
     */
    fun isEmailValid(email: String, requireNonEmpty: Boolean = false): Boolean {
        val emailRegex =
            "^[a-zA-Z0-9][a-zA-Z0-9.%_+-]*@(?!triots\\.com)(?!uorak\\.com)(?!.*\\.{2})[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(?:\\.[a-zA-Z]{2,})?\$"
        return if (requireNonEmpty) {
            email.matches(emailRegex.toRegex())
        } else {
            email.isEmpty() || email.matches(emailRegex.toRegex())
        }
    }

    /**
     * Validates a phone number string against a specific regex pattern.
     *
     * @param phoneNumber The phone number string to be validated.
     * @param requireNonEmpty If true, the phone number must be non-empty to be considered valid.
     * @return True if the phone number is valid according to the regex pattern, false otherwise.
     */
    fun isPhoneNumberValid(
        phoneNumber: String,
        requireNonEmpty: Boolean = false,
        context: Context
    ): Boolean {
        return if (requireNonEmpty) {
            isPhoneNumberValids(phoneNumber, context)
        } else {
            phoneNumber.isEmpty() || isPhoneNumberValids(phoneNumber, context)
        }
    }

    fun isPhoneNumberValids(phoneNumber: String, context: Context): Boolean {
        return try {
            val number = PhoneNumberUtil.getInstance(context).parse(phoneNumber, null);
            return PhoneNumberUtil.getInstance().isValidNumber(number)
        } catch (e: Exception) {
            false
        }
    }

    /**
     * Validates the first name against a specific regex pattern.
     *
     * @param firstName The first name string to be validated.
     * @param isSubmit If true, the first name must be non-empty and match the regex pattern to be considered valid.
     * @return True if the first name is valid according to the regex pattern, false otherwise.
     */
    fun validateFirstName(firstName: String, isSubmit: Boolean = false): Boolean {
        val trimmedName = firstName.trim()
        val firstNameRegex = "^[A-Za-z]+(\\s[A-Za-z]+)*$"
        val regex = Regex(firstNameRegex)
        return if (isSubmit) {
            trimmedName.matches(regex) && trimmedName.length <= 50
        } else {
            trimmedName.isEmpty() || trimmedName.matches(regex) && trimmedName.length <= 50
        }
    }

    /**
     * Validates the last name against a specific regex pattern.
     *
     * @param lastName The last name string to be validated.
     * @param isSubmit If true, the last name must be non-empty and match the regex pattern to be considered valid.
     * @return True if the last name is valid according to the regex pattern, false otherwise.
     */
    fun validateLastName(lastName: String, isSubmit: Boolean = false): Boolean {
        val trimmedName = lastName.trim()
        val lastNameRegex = "^[A-Za-z]+(\\s[A-Za-z]+)*$"
        val regex = Regex(lastNameRegex)
        return if (isSubmit) {
            trimmedName.matches(regex) && trimmedName.length in 2..50
        } else {
            trimmedName.isEmpty() || trimmedName.matches(regex) && trimmedName.length in 2..50
        }
    }

    /**
     * Validates an OTP string against a specific regex pattern.
     *
     * @param otp The OTP string to be validated.
     * @param requireNonEmpty If true, the OTP must be non-empty to be considered valid.
     * @return True if the OTP is valid according to the regex pattern, false otherwise.
     */
    fun isOTPValid(otp: String, requireNonEmpty: Boolean = false): Boolean {
        val otpRegex = Regex("^[0-9]{6}$")
        return if (requireNonEmpty) {
            otp.matches(otpRegex)
        } else {
            otp.isEmpty() || otp.matches(otpRegex)
        }
    }


    /**
     * Removes the plus prefix from a string.
     *
     * @return The string without the plus prefix.
     */
    fun String.trimPlusPrefix(): String {
        return removePrefix("+")
    }

    /**
     * Masks an email address by replacing part of the name with 'X' characters.
     *
     * @param email The email address to be masked.
     * @return The masked email address.
     */
    fun maskEmail(email: String): String {
        val atIndex = email.indexOf("@")
        if (atIndex == -1 || atIndex == 0) return email // Return original if not a valid email

        val namePart = email.substring(0, atIndex)
        val domainPart = email.substring(atIndex)
        val maskLength = if (namePart.length > 4) 4 else if (namePart.length > 2) 2 else 1
        val visiblePart = namePart.substring(0, maskLength)
        val maskedPart = "X".repeat(namePart.length - maskLength)

        return visiblePart + maskedPart + domainPart
    }

    /**
     * Masks a phone number by replacing all but the last three digits with 'X' characters.
     *
     * @param phoneNumber The phone number to be masked.
     * @return The masked phone number.
     */
    fun maskPhoneNumber(phoneNumber: String): String {
        if (phoneNumber.length <= 3) return phoneNumber // Return original if 3 or fewer characters

        val maskedPart = "X".repeat(phoneNumber.length - 3)
        val visiblePart = phoneNumber.takeLast(3)

        return maskedPart + visiblePart
    }

    /**
     * Filters an email string by allowing only valid characters and limiting its length.
     *
     * @param email The email string to be filtered.
     * @return A filtered email string containing only valid characters up to a maximum length.
     */
    fun filterEmail(email: String): String {
        return email.filter { it in EMAIL_VALID_CHARACTERS }
            .take(EMAIL_MAX_LENGTH)
    }

    /**
     * Filters a phone number string by allowing only digit characters and limiting its length.
     *
     * @param phoneNumber The phone number string to be filtered.
     * @return A filtered phone number string containing only digits up to a maximum length.
     */
    fun filterPhoneNumber(phoneNumber: String): String {
        return phoneNumber.filter { it.isDigit() }
            .take(PHONE_NUMBER_MAX_LENGTH)
    }

    /**
     * Filters a name string by allowing only letter characters or whitespace, limiting its length,
     * and ensuring no starting spaces while allowing spaces between words.
     * It first removes the starting spaces, if any, then replaces multiple consecutive spaces with a single space,
     * and finally limits the length of the resulting string.
     *
     * @param name The name string to be filtered.
     * @return A filtered name string containing only letters or single spaces (except at the start) up to a maximum length.
     */
    fun filterName(name: String): String {
        return name.filter { it.isLetter() || it.isWhitespace() }
            .replaceFirst(FIRST_SPACE_REGEX_PATTERN.toRegex(), "")
            .replace(SPACE_REGEX_PATTERN.toRegex(), " ")
            .take(NAME_MAX_LENGTH)
    }

    /**
     * Filters an OTP string by allowing only digit characters and limiting its length.
     *
     * @param otp The OTP string to be filtered.
     * @return A filtered OTP string containing only digits up to a maximum length.
     */
    fun filterOTP(otp: String): String {
        return otp.filter { it.isDigit() }.take(OTP_MAX_LENGTH)
    }
}