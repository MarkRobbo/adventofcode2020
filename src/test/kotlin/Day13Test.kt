package me.markrobbo

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class Day13Test {

    val example = File("src/main/resources/day13/day13_example.txt").readLines()
    val input = File("src/main/resources/day13/day13.txt").readLines()

    @Nested
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day13().solvePart1(example)
            assertEquals(295, answer)
        }

        @Test
        fun `Final answer`() {
            val answer = Day13().solvePart1(input)
            assertEquals(4722, answer)
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day13().solvePart2(example)
            assertEquals(1068781, answer)
        }

        @Test
        fun `Final answer`() {
            val answer = Day13().solvePart2(input)
            assertEquals(825305207525452, answer)
        }
    }
}
