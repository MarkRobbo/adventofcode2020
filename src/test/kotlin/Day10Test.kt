package me.markrobbo

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class Day10Test {

    val example = File("src/main/resources/day10/day10_example.txt").readLines()
    val input = File("src/main/resources/day10/day10.txt").readLines()

    @Nested
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day10().solvePart1(example)
            assertEquals(35, answer)
        }

        @Test
        fun `Final answer`() {
            val answer = Day10().solvePart1(input)
            assertEquals(2232, answer)
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day10().solvePart2(example)
            assertEquals(8, answer)
        }

        @Test
        fun `Final answer`() {
            val answer = Day10().solvePart2(input)
            assertEquals(173625106649344, answer)
        }
    }
}
