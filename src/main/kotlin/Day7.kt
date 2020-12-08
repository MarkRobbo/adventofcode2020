package me.markrobbo

class Day7 {

    fun solvePart1(input: List<String>): Int {
        val bags = readBagInfo(input)
        return bags.count { containsShinyGold(it.key, bags) } - 1
    }

    fun solvePart2(input: List<String>): Int {
        val bags = readBagInfo(input)
        return countBagsOfColour("shiny gold", bags) - 1
    }

    private fun readBagInfo(input: List<String>): Map<String, Map<String, Int>> {
        return input.map { line ->
            line.split(" bags contain ")
                .let { (bag, containing) ->
                    bag to containing.split(", ").mapNotNull {
                        """(\d+) ([\w ]+) bags?\.?""".toRegex().matchEntire(it)?.destructured
                            ?.let { (number, colour) ->
                                colour to number.toInt()
                            }
                    }.toMap()
                }
        }.toMap()
    }

    private fun countBagsOfColour(colour: String, bags: Map<String, Map<String, Int>>): Int {
        return 1 + (bags[colour]?.entries?.sumBy { bag ->
            bag.value * countBagsOfColour(bag.key, bags)
        } ?: 0)
    }

    private fun containsShinyGold(colour: String, bags: Map<String, Map<String, Int>>): Boolean {
        if (colour == "shiny gold") return true
        return bags[colour]?.keys?.any {
            containsShinyGold(it, bags)
        } ?: false
    }
}
