package me.markrobbo

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.test.assertEquals

class Day5Test {

    val example = listOf("BFFFBBFRRR", "FFFBBBFRRR", "BBFFBBFRLL")
    val input = Files.readAllLines(Paths.get("src/main/resources/day5/day5.txt"))

    @Nested
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day5().solvePart1(example)
            assertEquals(820, answer)
        }

        @Test
        fun `Final answer`() {
            val answer = Day5().solvePart1(input)
            assertEquals(947, answer)
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `Final answer`() {
            val answer = Day5().solvePart2(input)
            assertEquals(636, answer)
        }
    }
}
