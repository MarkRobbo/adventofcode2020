package me.markrobbo

class Day10 {

    fun solvePart1(input: List<String>): Int {
        return getAdapters(input.map { it.toInt() })
            .zipWithNext { a, b -> b - a }
            .groupingBy { it }
            .eachCount()
            .run { getOrDefault(3, 1) * getOrDefault(1, 1) }
    }

    fun solvePart2(input: List<String>): Long? {
        return getAdapters(input.map { it.toInt() })
            .drop(1)
            .fold(
                mapOf(0 to 1L),
                { waysToConnect, adapter ->
                    waysToConnect.plus(
                        adapter to (1..3).map { waysToConnect[adapter - it] ?: 0 }.sum()
                    )
                }
            )
            .run { get(keys.maxOrNull()!!) }
    }

    private fun getAdapters(input: List<Int>): List<Int> = input.plus(0).plus(input.maxOrNull()!! + 3).sorted()
}
