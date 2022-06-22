package io.plagov.advent.aoc2015.day08

abstract class AbstractRule<T> : Rule<T> {

    private var nextRule: Rule<T>? = null

    override fun setNextRule(nextRule: Rule<T>): Rule<T> {
        this.nextRule = nextRule
        return this
    }

    fun applyNextRule(stringData: StringData): T {
        return nextRule?.apply(stringData) ?: error("Rule not implemented")
    }
}
