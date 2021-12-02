package util

import java.io.File

fun readInputFile(fileName: String) =
  File("src/test/resources/inputs/$fileName").readLines()
