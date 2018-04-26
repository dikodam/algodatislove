package main.kotlin

import java.util.*
import kotlin.streams.asSequence


fun main(args: Array<String>) {
    val numbers = generateRandomNumbers(50000, 5)
    val (index, max) = searchMaximum(numbers, numbers.max()!!)
    println("Die Zahl $index kommt am häufigsten vor, nämlich $max mal")
}

/**
 * algo for l >> N
 */
fun searchMaximum(numbers: List<Int>, n: Int): Pair<Int, Int> {
    val counters = Array(n + 1, { 0 })
    var maxIndex = 0
    for (number in numbers) {
        counters[number]++
        if (counters[number] > counters[maxIndex]) {
            maxIndex = number
        }
    }
    return Pair(maxIndex, counters[maxIndex])
}

fun generateRandomNumbers(length: Int, exclusiveUpperBound: Int): List<Int> {
    return Random().ints(length.toLong(), 1, exclusiveUpperBound + 1)
        .asSequence()
        .toList()
}