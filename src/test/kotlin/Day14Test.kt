package me.markrobbo

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class Day14Test {

    val example = File("src/main/resources/day14/day14_example.txt").readLines()
    val example_part2 = File("src/main/resources/day14/day14_example_part2.txt").readLines()
    val input = File("src/main/resources/day14/day14.txt").readLines()

    @Nested
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day14().solvePart1(example)
            assertEquals(165, answer)
        }

        @Test
        fun `Final answer`() {
            val answer = Day14().solvePart1(input)
            assertEquals(18630548206046, answer)
        }
    }
}
