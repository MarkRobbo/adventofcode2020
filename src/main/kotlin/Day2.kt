package me.markrobbo

private data class PasswordWithPolicy(val low: Int, val high: Int, val char: Char, val password: String) {

    fun passwordIsValidDownTheRoad(): Boolean {
        val charCounts = password.asSequence()
            .groupingBy { it }
            .eachCount()
        if (char !in charCounts) return false
        return charCounts[char] in low..high
    }

    fun passwordIsValid(): Boolean {
        val lowCharCorrect = if (password.length > low - 1) password[low - 1] == char else false
        val highCharCorrect = if (password.length > high - 1) password[high - 1] == char else false
        return lowCharCorrect xor highCharCorrect
    }

    companion object Factory {
        fun fromString(input: String): PasswordWithPolicy {
            val matches = """(?<low>\d+)-(?<high>\d+) (?<char>\w): (?<password>\w+)""".toRegex()
                .matchEntire(input)!!.groups
            val low = matches["low"]!!.value.toInt()
            val high = matches["high"]!!.value.toInt()
            val char = matches["char"]!!.value.toCharArray().first()
            val password = matches["password"]!!.value
            return PasswordWithPolicy(low, high, char, password)
        }
    }
}

class Day2 {

    fun solvePart1(input: List<String>): Int {
        return input.map { PasswordWithPolicy.fromString(it) }
            .map { it.passwordIsValidDownTheRoad() }
            .count { it }
    }

    fun solvePart2(input: List<String>): Int {
        return input.map { PasswordWithPolicy.fromString(it) }
            .map { it.passwordIsValid() }
            .count { it }
    }

}