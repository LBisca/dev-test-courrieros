package com.courrieros.reader

import com.courrieros.Constant
import com.courrieros.model.ClientOrder
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class CsvReader {
    fun readInput(inputStream: InputStream): String {
        val reader = InputStreamReader(inputStream)
        val bufferedReader = BufferedReader(reader)

        return read(bufferedReader, "")
    }

    fun readInputIntoList(inputStream: InputStream): List<ClientOrder> {
        val reader = InputStreamReader(inputStream)
        val bufferedReader = BufferedReader(reader)
        val list = readLines(bufferedReader, mutableListOf())

        return list.map {
            val arguments = it.split(",")
            val clientName = arguments[0]
            val order = arguments[1]
            val distance = arguments[2].toDouble()

            val co2Saved = (distance / 1000) * Constant.CO2_SAFE_PER_KM
            ClientOrder(clientName, order.toInt(), distance, co2Saved)
        }
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

    private fun readLines(bufferedReader: BufferedReader, list: MutableList<String>): List<String> {
        val newLine = bufferedReader.readLine()
        return if (newLine != null) {
            list.add(newLine)
            readLines(bufferedReader, list)
        } else {
            list
        }
    }
}



