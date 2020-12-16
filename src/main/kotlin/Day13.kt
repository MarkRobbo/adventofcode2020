package me.markrobbo

class Day13 {

    fun solvePart1(input: List<String>): Int {
        val arrival = input[0].toInt()
        return input[1].split(",")
            .filterNot { it == "x" }
            .map(String::toInt)
            .minByOrNull { bus -> arrival + waitTime(arrival, bus) }!!
            .let { bus -> bus * waitTime(arrival, bus) }
    }

    private fun waitTime(arrival: Int, bus: Int) = bus - arrival % bus

    fun solvePart2(input: List<String>): Long {
        var time = 0L
        var lowestCommonMultiple = 1L
        input[1].split(",").withIndex()
            .filterNot { (_, bus) -> bus == "x" }
            .map { (i, bus) -> IndexedValue(i, bus.toInt()) }
            .forEach { (busPosition, bus) ->
                while ((time + busPosition) % bus != 0L) {
                    time += lowestCommonMultiple
                }
                lowestCommonMultiple *= bus // all provided buses are prime numbers
            }
        return time
    }
}
