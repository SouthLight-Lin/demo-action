package com.lnw.quickzip

import java.io.BufferedInputStream
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.nio.channels.Channels
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

/**
 * @author linnanwei
 * @version 1.0.0
 * @since 1.0.0
 * Date： 2019/12/9
 */

const val ZIP_FILE = "F:\\Code\\demo-action\\other-action\\doc\\zipFile"
const val ZIPED_FILE = "C:\\Users\\Administrator\\Desktop\\work\\词条检验\\not.txt"
const val FILE_NAME = "zipFileName"
fun zipFileNoBuffer() {
    val zipFile = File(ZIP_FILE)
    val zipOut = ZipOutputStream(FileOutputStream(zipFile))
    val beginStartTime = System.currentTimeMillis()
    val input = FileInputStream(ZIPED_FILE)
    zipOut.putNextEntry(ZipEntry(FILE_NAME))
    var tmp = 0
    while ({ tmp = input.read();tmp }() > 0) {
        zipOut.write(tmp)
    }
    // 耗时(毫秒)：13342
    println("耗时(毫秒)：${System.currentTimeMillis() - beginStartTime}")
}


fun zipFileBuffer() {
    val zipFile = File(ZIP_FILE)
    val zipOut = ZipOutputStream(FileOutputStream(zipFile))
    val beginStartTime = System.currentTimeMillis()
    val input = BufferedInputStream(FileInputStream(ZIPED_FILE))
    zipOut.putNextEntry(ZipEntry(FILE_NAME))
    input.copyTo(zipOut)
    // 耗时(毫秒)：1743
    println("耗时(毫秒)：${System.currentTimeMillis() - beginStartTime}")
}

fun zipFileChannel() {
    val zipFile = File(ZIP_FILE)
    val beginStartTime = System.currentTimeMillis()

    val zipOut = ZipOutputStream(FileOutputStream(zipFile))
    val writeableByteCloneable = Channels.newChannel(zipOut)
    val fileChannel = FileInputStream(ZIPED_FILE).channel
    zipOut.putNextEntry(ZipEntry(FILE_NAME))
    fileChannel.transferTo(0, 1024 * 10000, writeableByteCloneable)
    // 耗时(毫秒)：356
    println("耗时(毫秒)：${System.currentTimeMillis() - beginStartTime}")
}

fun main(args: Array<String>) {
    // 文件压缩后大小 1886 kb

    zipFileNoBuffer()
}