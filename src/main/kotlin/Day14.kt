package me.markrobbo

class Day14 {

    data class PortComputer(var bitmask: String = "X".repeat(36), val memory: MutableMap<Int, String> = mutableMapOf()) {

        fun setValue(memoryLocation: Int, value: Long) {
            memory[memoryLocation] = value.toString(2).padStart(36, '0')
                .zip(bitmask)
                .map { (valueChar, bitmaskChar) ->
                    if (bitmaskChar == 'X') {
                        valueChar
                    } else {
                        bitmaskChar
                    }
                }.joinToString("")
        }

        fun sumAllInMemory() = memory.values.sumOf { it.toLong(2) }
    }

    fun solvePart1(input: List<String>): Long {
        val computer = PortComputer()
        input.map {
            """(\w+)(?:\[(\d+)])? = (.*)""".toRegex().matchEntire(it)?.destructured?.let { (command, arrayIndex, value) ->
                when (command) {
                    "mask" -> computer.bitmask = value
                    "mem" -> computer.setValue(arrayIndex.toInt(), value.toLong())
                    else -> IllegalArgumentException()
                }
            }
        }
        return computer.sumAllInMemory()
    }
}
