package com.lnw.jvm

/**
 * 为什么JVM没有使用引用计数算法管理内存？
 * 因为无法解决对象直接循环引用问题
 * @author SouthLight-Lin on 2019/12/22
 */
class ReferenceCountingGC {
    public var instance: Any? = null

    /** 意义：占用内存，以便在发生GC日志中看清是否被回收过 **/
    val bigSize = ByteArray(1024 * 1024)
}

fun main() {
    var objA: ReferenceCountingGC? = ReferenceCountingGC()
    var objB: ReferenceCountingGC? = ReferenceCountingGC()

    objA?.instance = objB
    objB?.instance = objA

    objA = null
    objB = null

    System.gc()
}
