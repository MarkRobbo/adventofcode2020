package me.markrobbo

class Day6 {

    fun solvePart1(input: String): Int {
        return input.split("\n\n")
            .map(::uniqueLetters)
            .sumBy { it.size }
    }

    fun solvePart2(input: String): Int {
        return input.split("\n\n")
            .sumBy { groupAnswers ->
                groupAnswers.split("\n")
                    .map(::uniqueLetters)
                    .reduce(Set<Char>::intersect)
                    .size
            }
    }

    private fun uniqueLetters(str: String) = str.filter(Char::isLetter).toSet()
}
