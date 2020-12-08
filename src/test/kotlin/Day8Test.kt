package me.markrobbo

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class Day8Test {

    val example = File("src/main/resources/day8/day8_example.txt").readLines()
    val input = File("src/main/resources/day8/day8.txt").readLines()

    @Nested
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day8().solvePart1(example)
            assertEquals(5, answer)
        }

        @Test
        fun `Final answer`() {
            val answer = Day8().solvePart1(input)
            assertEquals(1797, answer)
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day8().solvePart2(example)
            assertEquals(8, answer)
        }

        @Test
        fun `Final answer`() {
            val answer = Day8().solvePart2(input)
            assertEquals(1036, answer)
        }
    }
}
