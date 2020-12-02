package me.markrobbo

class Day1 {

    fun solvePart1(input: List<Int>): Int? {
        val pairedValueMap = mutableMapOf<Int, Int>()
        input.forEach {
            val pairedValue = pairedValueMap[it]
            if (pairedValue != null) {
                return it * pairedValue
            }
            pairedValueMap[2020 - it] = it
        }
        return null
    }

    fun solvePart2(input: List<Int>): Int? {
        val pairedValueMap = input.map { 2020 - it to it }.toMap()

        val doublePairedValueMap = mutableMapOf<Int, Pair<Int, Int>>()
        input.forEach { value ->
            val pairedValues = doublePairedValueMap[value]
            if (pairedValues != null) {
                return value * pairedValues.first * pairedValues.second
            }

            pairedValueMap.forEach { (remainder, valueForRemainder) ->
                doublePairedValueMap[remainder - value] = Pair(valueForRemainder, value)
            }
        }

        return null
    }
}