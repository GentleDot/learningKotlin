package chap10

import java.io.FileOutputStream
import java.io.PrintWriter

fun main() {
    // 파일 닫기에 대한 처리
    PrintWriter(FileOutputStream("c:\\workspace\\output.txt")).use {
        it.println("hello")
    }
}