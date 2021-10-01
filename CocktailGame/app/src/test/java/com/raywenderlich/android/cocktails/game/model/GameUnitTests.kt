package com.raywenderlich.android.cocktails.game.model

import org.junit.Test
import org.junit.Assert

class GameUnitTests {
    @Test
    fun whenIncrementingScore_shouldIncrementCurrentScore() {
        val game = Game()

        game.incrementScore()

        Assert.assertEquals(1, game.currentScore)
    }

    @Test
    fun whenIncrementingScore_aboveHighScore_shouldAlsoIncrementHighScore() {
        val game = Game()

        game.incrementScore()

        Assert.assertEquals(1, game.highestScore)
    }

    @Test
    fun whenIncrementingScore_belowHighScore_shouldNotIncrementHighScore() {
        val game = Game(10)

        game.incrementScore()

        Assert.assertEquals(10, game.highestScore)
    }
}