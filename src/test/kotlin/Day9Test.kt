package me.markrobbo

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class Day9Test {

    val example = File("src/main/resources/day9/day9_example.txt").readLines()
    val input = File("src/main/resources/day9/day9.txt").readLines()

    @Nested
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day9().solvePart1(example, 5)
            assertEquals(127, answer)
        }

        @Test
        fun `Final answer`() {
            val answer = Day9().solvePart1(input, 25)
            assertEquals(1212510616, answer)
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day9().solvePart2(example, 5)
            assertEquals(62, answer)
        }

        @Test
        fun `Final answer`() {
            val answer = Day9().solvePart2(input, 25)
            assertEquals(171265123, answer)
        }
    }
}
