package me.markrobbo.day1

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.test.assertEquals

class Day01Test {

    val example = listOf(1721, 979, 366, 299, 675, 1456)
    val input = Files.readAllLines(Paths.get("src/main/resources/day1/day1.csv"))
            .map { it.toInt() }

    @Nested
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day1().solvePart1(example)
            assertEquals(514579, answer)
        }

        @Test
        fun `Final answer`() {
            val answer = Day1().solvePart1(input)
            assertEquals(987339, answer)
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day1().solvePart2(example)
            assertEquals(241861950, answer);
        }

        @Test
        fun `Final answer`() {
            val answer = Day1().solvePart2(input)
            assertEquals(259521570, answer);
        }
    }
}