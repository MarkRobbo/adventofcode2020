package me.markrobbo

private class Map(val terrain: List<String>) {

    fun numTreesOnSlope(right: Int, down: Int): Int {
        return (down until terrain.size step down).count {
            terrain[it][(right * (it / down)) % terrain[it].length] == '#'
        }
    }
}

class Day3 {

    fun solvePart1(input: List<String>): Int {
        val map = Map(input)
        return map.numTreesOnSlope(3, 1)
    }

    fun solvePart2(input: List<String>): Long {
        val map = Map(input)
        return map.numTreesOnSlope(1, 1).toLong() *
            map.numTreesOnSlope(3, 1) *
            map.numTreesOnSlope(5, 1) *
            map.numTreesOnSlope(7, 1) *
            map.numTreesOnSlope(1, 2)
    }
}
