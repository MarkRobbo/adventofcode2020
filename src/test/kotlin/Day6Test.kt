package me.markrobbo

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.test.assertEquals

class Day6Test {

    val example = String(Files.readAllBytes(Paths.get("src/main/resources/day6/day6_example.txt")))
    val input = String(Files.readAllBytes(Paths.get("src/main/resources/day6/day6.txt")))

    @Nested
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day6().solvePart1(example)
            assertEquals(11, answer)
        }

        @Test
        fun `Final answer`() {
            val answer = Day6().solvePart1(input)
            assertEquals(6273, answer)
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day6().solvePart2(example)
            assertEquals(6, answer)
        }

        @Test
        fun `Final answer`() {
            val answer = Day6().solvePart2(input)
            assertEquals(3254, answer)
        }
    }
}
