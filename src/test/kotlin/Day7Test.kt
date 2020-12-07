package me.markrobbo

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class Day7Test {

    val example = File("src/main/resources/day7/day7_example.txt").readLines()
    val input = File("src/main/resources/day7/day7.txt").readLines()

    @Nested
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day7().solvePart1(example)
            assertEquals(4, answer)
        }

        @Test
        fun `Final answer`() {
            val answer = Day7().solvePart1(input)
            assertEquals(169, answer)
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day7().solvePart2(example)
            assertEquals(32, answer)
        }

        @Test
        fun `Final answer`() {
            val answer = Day7().solvePart2(input)
            assertEquals(82372, answer)
        }
    }
}
