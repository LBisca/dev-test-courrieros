package com.courrieros

import com.courrieros.reader.CsvReader
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        CsvReader().readInput(javaClass.classLoader.getResourceAsStream("test.csv"))
    }

    @Test
    fun splitTest() {
        "1,2,3".split(",").forEach { println(it) }
    }

    @Test
    fun mapTest() {
        val list = listOf(
                "Chris Pratt,32,1.80",
                "Emma Watson,27,1.60",
                "Filth Frank,24,1.79"
        )

        list.map { line ->
            val arguments = line.split(",")
            val name = arguments[0]
            val age = arguments[1]
            val height = arguments[2]

            Person(name, age.toInt(), height.toFloat())
        }.forEach {
            println(it)
        }
    }

    data class Person(
            val name: String,
            val age: Int,
            val height: Float
    )
}
