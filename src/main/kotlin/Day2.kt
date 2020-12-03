package me.markrobbo

private data class PasswordWithPolicy(val low: Int, val high: Int, val char: Char, val password: String) {

    fun passwordIsValidDownTheRoad(): Boolean {
        val charCount = password.asSequence()
            .filter { it == char }
            .count()
        return charCount in low..high
    }

    fun passwordIsValid(): Boolean {
        val lowCharCorrect = if (password.length > low - 1) password[low - 1] == char else false
        val highCharCorrect = if (password.length > high - 1) password[high - 1] == char else false
        return lowCharCorrect xor highCharCorrect
    }

    companion object Factory {
        fun fromString(input: String): PasswordWithPolicy {
            return """(\d+)-(\d+) (\w): (\w+)""".toRegex()
                .matchEntire(input)!!.destructured
                .let { (low, high, char, password) -> PasswordWithPolicy(low.toInt(), high.toInt(), char.first(), password) }
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
