package me.markrobbo

class Day5 {

    fun solvePart1(input: List<String>): Int? {
        return input.map { getSeatId(it) }.maxOrNull()
    }

    fun solvePart2(input: List<String>): Int? {
        val seatIds = input.map { getSeatId(it) }
        return (seatIds.minOrNull()!!..seatIds.maxOrNull()!!).find {
            it !in seatIds
        }
    }

    private fun getSeatId(seatSpec: String): Int {
        return seatSpec.fold(0) { acc, char ->
            acc * 2 + if (char == 'B' || char == 'R') 1 else 0
        }
    }
}
