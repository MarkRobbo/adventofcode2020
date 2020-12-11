package me.markrobbo

class Day11 {

    fun solvePart1(input: List<String>) = simulateAndCountOccupied(input, 4, ::countAdjacentOccupied)

    fun solvePart2(input: List<String>) = simulateAndCountOccupied(input, 5, ::countLineOfSightOccupied)

    private fun countOccupied(seats: List<String>) = seats.sumBy { row -> row.count { seat -> seat == '#' } }

    private fun simulateAndCountOccupied(input: List<String>, occupiedThreshold: Int, countNearbyOccupied: (List<String>, Int, Int) -> Int): Int {
        return generateSequence(input, { seats -> runSeatingIteration(seats, occupiedThreshold, countNearbyOccupied) })
            .zipWithNext()
            .takeWhile { (current, next) -> current != next }
            .last().second
            .let(::countOccupied)
    }

    private fun runSeatingIteration(seats: List<String>, occupiedThreshold: Int, countNearbyOccupied: (List<String>, Int, Int) -> Int): List<String> {
        return seats.mapIndexed { y, row ->
            row.mapIndexed { x, seat ->
                when {
                    seat == 'L' && countNearbyOccupied(seats, x, y) == 0 -> '#'
                    seat == '#' && countNearbyOccupied(seats, x, y) >= occupiedThreshold -> 'L'
                    else -> seat
                }
            }.joinToString("")
        }
    }

    private fun countAdjacentOccupied(seats: List<String>, x: Int, y: Int): Int {
        return (-1..1).sumBy { yOffset ->
            (-1..1).count { xOffset ->
                if (!(xOffset == 0 && yOffset == 0)) {
                    seats.getOrNull(y + yOffset)?.getOrNull(x + xOffset) == '#'
                } else {
                    false
                }
            }
        }
    }

    private fun countLineOfSightOccupied(seats: List<String>, x: Int, y: Int): Int {
        return (-1..1).sumBy { yOffsetIncrement ->
            (-1..1).count { xOffsetIncrement ->
                if (!(xOffsetIncrement == 0 && yOffsetIncrement == 0)) {
                    var xOffset = xOffsetIncrement
                    var yOffset = yOffsetIncrement
                    var seatInDirection: Char? = null
                    while (seatInDirection == null && y + yOffset in seats.indices && x + xOffset in seats[y + yOffset].indices) {
                        val seat = seats[y + yOffset][x + xOffset]
                        seatInDirection = if (seat != '.') seat else null
                        xOffset += xOffsetIncrement
                        yOffset += yOffsetIncrement
                    }
                    seatInDirection == '#'
                } else {
                    false
                }
            }
        }
    }
}
