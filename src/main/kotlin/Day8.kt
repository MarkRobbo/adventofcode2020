package me.markrobbo

import me.markrobbo.HandheldGamesConsole.ExitCode
import me.markrobbo.HandheldGamesConsole.Instruction.OpCode

class HandheldGamesConsole(private val instructions: List<Instruction>) {
    private var acc = 0
    private var pc = 0
    private var executed = mutableSetOf<Int>()

    fun run(): Pair<Int, ExitCode> {
        while (pc != instructions.size) {
            if (executed.contains(pc)) {
                return acc to ExitCode.INFINITE_LOOP
            }
            executed.add(pc)
            val ir = instructions[pc]
            when (ir.op) {
                OpCode.ACC -> { acc += ir.arg.also { pc++ } }
                OpCode.JMP -> { pc += ir.arg }
                OpCode.NOP -> { pc++ }
            }
        }
        return acc to ExitCode.SUCCESS
    }

    enum class ExitCode { INFINITE_LOOP, SUCCESS }
    data class Instruction(val op: OpCode, val arg: Int) {
        enum class OpCode { NOP, JMP, ACC }
    }
}

class Day8 {

    fun solvePart1(input: List<String>) = HandheldGamesConsole(parseInstructions(input)).run().first

    fun solvePart2(input: List<String>): Int {
        val instructions = parseInstructions(input)

        return instructions.withIndex()
            .filter { (_, instruction) -> instruction.op in listOf(OpCode.JMP, OpCode.NOP) }
            .map { (i, instruction) ->
                val newOp = when (instruction.op) {
                    OpCode.JMP -> OpCode.NOP
                    OpCode.NOP -> OpCode.JMP
                    else -> throw IllegalStateException()
                }
                val newInstructions = instructions.toMutableList().also { it[i] = it[i].copy(op = newOp) }
                HandheldGamesConsole(newInstructions).run()
            }
            .first { it.second == ExitCode.SUCCESS }
            .first
    }

    private fun parseInstructions(program: List<String>): List<HandheldGamesConsole.Instruction> {
        return program.map { instruction ->
            instruction.split(" ").let { (op, arg) ->
                HandheldGamesConsole.Instruction(OpCode.valueOf(op.toUpperCase()), arg.toInt())
            }
        }
    }
}
