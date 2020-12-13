package me.markrobbo

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class Day12Test {

    val example = File("src/main/resources/day12/day12_example.txt").readLines()
    val input = File("src/main/resources/day12/day12.txt").readLines()

    @Nested
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day12().solvePart1(example)
            assertEquals(25, answer)
        }

        @Test
        fun `Final answer`() {
            val answer = Day12().solvePart1(input)
            assertEquals(820, answer)
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day12().solvePart2(example)
            assertEquals(286, answer)
        }

        @Test
        fun `Final answer`() {
            val answer = Day12().solvePart2(input)
            assertEquals(66614, answer)
        }
    }
}
