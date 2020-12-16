package me.markrobbo

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day15Test {

    val example = listOf(0, 3, 6)
    val input = listOf(9, 3, 1, 0, 8, 4)

    @Nested
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day15().solvePart1(example)
            assertEquals(436, answer)
        }

        @Test
        fun `Final answer`() {
            val answer = Day15().solvePart1(input)
            assertEquals(371, answer)
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day15().solvePart2(example)
            assertEquals(175594, answer)
        }

        @Test
        fun `Final answer`() {
            val answer = Day15().solvePart2(input)
            assertEquals(352, answer)
        }
    }
}
