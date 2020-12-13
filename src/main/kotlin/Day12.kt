package me.markrobbo

import kotlin.math.abs

class Day12 {

    abstract class Ship(var heading: Int = 90, var x: Int = 0, var y: Int = 0) {
        fun manhattanDistanceFromOrigin(): Int = abs(x) + abs(y)
        abstract fun navigate(command: Char, amount: Int)
    }

    class DirectNavigatedShip: Ship() {
        override fun navigate(command: Char, amount: Int) {
            when (command) {
                'N' -> { y -= amount }
                'S' -> { y += amount }
                'E' -> { x += amount }
                'W' -> { x -= amount }
                'L' -> { heading = (360 + heading - amount) % 360 }
                'R' -> { heading = (360 + heading + amount) % 360 }
                'F' -> when (heading) {
                    0 -> navigate('N', amount)
                    90 -> navigate('E', amount)
                    180 -> navigate('S', amount)
                    270 -> navigate('W', amount)
                    else -> throw IllegalArgumentException()
                }
                else -> throw IllegalArgumentException()
            }
        }
    }

    class WaypointNavigatedShip: Ship() {
        var waypointX: Int = 10
        var waypointY: Int = -1

        override fun navigate(command: Char, amount: Int) {
            when (command) {
                'N' -> { waypointY -= amount }
                'S' -> { waypointY += amount }
                'E' -> { waypointX += amount }
                'W' -> { waypointX -= amount }
                'L' -> turnAroundWaypoint((360 + amount) % 360)
                'R' -> turnAroundWaypoint((360 - amount) % 360)
                'F' -> {
                    x += waypointX * amount
                    y += waypointY * amount
                }
                else -> throw IllegalArgumentException()
            }
        }

        private fun turnAroundWaypoint(amount: Int) {
            when (amount) {
                0 -> {}
                90 -> waypointX = waypointY.also { waypointY = -waypointX }
                180 -> waypointX = -waypointX.also { waypointY = -waypointY }
                270 -> waypointX = -waypointY.also { waypointY = waypointX }
                else -> throw IllegalArgumentException()
            }
        }
    }

    fun solvePart1(input: List<String>): Int  {
        val ship = DirectNavigatedShip()
        input.forEach { ship.navigate(it[0], it.substring(1).toInt()) }
        return ship.manhattanDistanceFromOrigin()
    }

    fun solvePart2(input: List<String>): Int  {
        val ship = WaypointNavigatedShip()
        input.forEach { ship.navigate(it[0], it.substring(1).toInt()) }
        return ship.manhattanDistanceFromOrigin()
    }
}
