package chap10

import java.io.File
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardOpenOption

fun main() {
//    useFileWriter()
    writingFunction()
}

private fun writingFunction() {
    val outString: String = "안녕하세요!\tHello\r\nWorId!" // ①문자열의 구성
    val path = "C:\\Temp\\testfile.txt"

    val file = File(path)
    /*val printwriter = PrintWriter(file)
    printwriter.println(outString) // ② 파일에 출력한다는 것은 파일 쓰기를 하는 것임
    printwriter.close()*/
    file.printWriter().use {
        it.println(outString)
    }
}

private fun useFileWriter() {
    val path = "C:\\Temp\\hello.txt" // folder는 대소문자 구분하지 않는듯
    val text = "Hello, World!"

    try {
        Files.write(Paths.get(path), text.toByteArray(), StandardOpenOption.CREATE)
    } catch (e: IOException) {
        e.printStackTrace()
    }
}