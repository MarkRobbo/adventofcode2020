package me.markrobbo

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.test.assertEquals

class Day3Test {

    val example = Files.readAllLines(Paths.get("src/main/resources/day3/day3_example.txt"))
    val input = Files.readAllLines(Paths.get("src/main/resources/day3/day3.txt"))

    @Nested
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day3().solvePart1(example)
            assertEquals(7, answer)
        }

        @Test
        fun `Final answer`() {
            val answer = Day3().solvePart1(input)
            assertEquals(173, answer)
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day3().solvePart2(example)
            assertEquals(336, answer)
        }

        @Test
        fun `Final answer`() {
            val answer = Day3().solvePart2(input)
            assertEquals(4385176320, answer)
        }
    }
}
