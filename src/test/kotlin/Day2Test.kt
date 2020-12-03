package me.markrobbo

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.test.assertEquals

class Day2Test {

    val example = listOf("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc")
    val input = Files.readAllLines(Paths.get("src/main/resources/day2/day2.txt"))

    @Nested
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day2().solvePart1(example)
            assertEquals(2, answer)
        }

        @Test
        fun `Final answer`() {
            val answer = Day2().solvePart1(input)
            assertEquals(383, answer)
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day2().solvePart2(example)
            assertEquals(1, answer)
        }

        @Test
        fun `Final answer`() {
            val answer = Day2().solvePart2(input)
            assertEquals(272, answer)
        }
    }
}
