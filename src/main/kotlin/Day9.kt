package me.markrobbo

class Day9 {

    fun solvePart1(input: List<String>, preambleSize: Int): Long {
        return input.map { it.toLong() }
            .windowed(preambleSize + 1, 1, false)
            .find { !twoNumbersSumToValue(it.dropLast(1), it.last()) }!!
            .last()
    }

    fun solvePart2(input: List<String>, preambleSize: Int): Long? {
        val invalidNumber = solvePart1(input, preambleSize)
        val list = input.map { it.toLong() }
        for (startPos in list.indices) {
            for (endPos in startPos until list.size - 1) {
                val sublist = list.subList(startPos, endPos)
                if (sublist.sum() == invalidNumber) {
                    return sublist.minOrNull()!! + sublist.maxOrNull()!!
                }
            }
        }
        return null
    }

    /**
     * Pretty much the same as Day 1, copied here to make sure everything from the day is in one place
     */
    private fun twoNumbersSumToValue(numbers: List<Long>, targetValue: Long): Boolean {
        val pairedValueMap = mutableMapOf<Long, Long>()
        numbers.forEach {
            val pairedValue = pairedValueMap[it]
            if (pairedValue != null) {
                return true
            }
            pairedValueMap[targetValue - it] = it
        }
        return false
    }
}
