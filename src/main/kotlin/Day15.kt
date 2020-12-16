package me.markrobbo

class Day15 {

    fun solvePart1(input: List<Int>): Int = memoryGame(input).elementAt(2019)

    fun solvePart2(input: List<Int>): Int = memoryGame(input).elementAt(29999999)

    private fun memoryGame(startingNumbers: List<Int>): Sequence<Int> = sequence {
        yieldAll(startingNumbers)
        val lastSpokenIndex = startingNumbers.mapIndexed { i, value -> value to i }.toMap(mutableMapOf())
        var currentIndex = startingNumbers.size
        var nextNumber = 0
        while (true) {
            yield(nextNumber)
            val lastNumber = nextNumber
            nextNumber = currentIndex - lastSpokenIndex.getOrDefault(nextNumber, currentIndex)
            lastSpokenIndex[lastNumber] = currentIndex
            currentIndex++
        }
    }
}
