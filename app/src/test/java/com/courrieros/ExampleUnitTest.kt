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
}
