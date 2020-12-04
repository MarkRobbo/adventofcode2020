package me.markrobbo

class Day4 {

    private val hairColour = "#[0-9a-f]{6}".toRegex()
    private val eyeColour = "amb|blu|brn|gry|grn|hzl|oth".toRegex()
    private val passportId = "[0-9]{9}".toRegex()
    private val height = "([0-9]+)(in|cm)".toRegex()

    private val requiredFields = mapOf(
        "byr" to { v: String -> v.toInt() in 1920..2002 },
        "iyr" to { v: String -> v.toInt() in 2010..2020 },
        "eyr" to { v: String -> v.toInt() in 2020..2030 },
        "hgt" to ::heightValid,
        "hcl" to { v: String -> hairColour.matches(v) },
        "ecl" to { v: String -> eyeColour.matches(v) },
        "pid" to { v: String -> passportId.matches(v) }
    )

    fun solvePart1(input: String): Int {
        return readPassports(input)
            .count { passport -> requiredFields.keys.all { passport.containsKey(it) } }
    }

    fun solvePart2(input: String): Int {
        return readPassports(input)
            .count { passport ->
                requiredFields.all { (field, validationFunction) ->
                    passport[field]?.let { validationFunction(it) } ?: false
                }
            }
    }

    private fun readPassports(input: String): List<Map<String, String>> {
        return input.split("\n\n")
            .map { passportString ->
                passportString.split("[ \n]".toRegex())
                    .filter(String::isNotBlank)
                    .map { kv -> kv.split(":").let { (k, v) -> k to v } }.toMap()
            }
    }

    private fun heightValid(heightString: String): Boolean {
        return height.matchEntire(heightString)?.destructured?.let { (value, units) ->
            if (units == "cm") {
                value.toInt() in 150..193
            } else {
                value.toInt() in 59..76
            }
        } ?: false
    }
}
