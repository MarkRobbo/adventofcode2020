package me.markrobbo

class Day6 {

    fun solvePart1(input: String): Int {
        return input.split("\n\n")
            .map(::getUniqueLetters)
            .sumBy { it.size }
    }

    fun solvePart2(input: String): Int {
        return input.split("\n\n")
            .sumBy { groupAnswers ->
                groupAnswers.split("\n")
                    .map(::getUniqueLetters)
                    .reduce(Set<Char>::intersect)
                    .size
            }
    }

    private fun getUniqueLetters(str: String) = str.toCharArray().filter(Char::isLetter).toSet()
}
