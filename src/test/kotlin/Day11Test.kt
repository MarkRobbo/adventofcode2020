package me.markrobbo

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class Day11Test {

    val example = File("src/main/resources/day11/day11_example.txt").readLines()
    val input = File("src/main/resources/day11/day11.txt").readLines()

    @Nested
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day11().solvePart1(example)
            assertEquals(37, answer)
        }

        @Test
        fun `Final answer`() {
            val answer = Day11().solvePart1(input)
            assertEquals(2406, answer)
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day11().solvePart2(example)
            assertEquals(26, answer)
        }

        @Test
        fun `Final answer`() {
            val answer = Day11().solvePart2(input)
            assertEquals(2149, answer)
        }
    }
}
