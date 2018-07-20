package com.courrieros.reader

import java.io.*

class CsvReader {
    fun readInput(inputStream: InputStream) {
        val reader = InputStreamReader(inputStream)
        val bufferedReader = BufferedReader(reader)

        val text = read(bufferedReader, "")
        println(text)

    }

    private fun read(bufferedReader: BufferedReader, accumulator: String): String {
        val newLine = bufferedReader.readLine()
        return if (newLine != null) {
            val newText = if (accumulator == "") {
                newLine
            } else {
                accumulator + "\n" + newLine
            }
            read(bufferedReader, newText)
        } else accumulator
    }
}

