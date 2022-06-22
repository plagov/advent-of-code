package io.plagov.advent.aoc2015.day08

interface Rule<T> {

    fun setNextRule(nextRule: Rule<T>): Rule<T>

    fun apply(stringData: StringData): T
}
