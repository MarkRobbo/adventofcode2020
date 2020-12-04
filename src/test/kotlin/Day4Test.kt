package me.markrobbo

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.test.assertEquals

class Day4Test {

    val example = Files.readString(Paths.get("src/main/resources/day4/day4_example.txt"))
    val input = Files.readString(Paths.get("src/main/resources/day4/day4.txt"))

    @Nested
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day4().solvePart1(example)
            assertEquals(2, answer)
        }

        @Test
        fun `Final answer`() {
            val answer = Day4().solvePart1(input)
            assertEquals(250, answer)
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day4().solvePart2(example)
            assertEquals(2, answer)
        }

        @Test
        fun `Final answer`() {
            val answer = Day4().solvePart2(input)
            assertEquals(158, answer)
        }
    }
}
