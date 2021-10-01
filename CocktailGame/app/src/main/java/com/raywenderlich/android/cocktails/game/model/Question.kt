package com.raywenderlich.android.cocktails.game.model

import java.lang.IllegalArgumentException

class Question(val correctOption: String, val incorrectOption: String) {
    var answeredOption: String? = null
        private set

    val isAnsweredCorrectly: Boolean
        get() = answeredOption == correctOption

    fun answer(option: String): Boolean {
        if (option != correctOption && option != incorrectOption) {
            throw IllegalArgumentException("Not a valid option")
        }
        answeredOption = option

        return isAnsweredCorrectly
    }
}