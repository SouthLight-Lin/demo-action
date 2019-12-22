package com.lnw.jvm

import net.sf.cglib.proxy.Enhancer
import net.sf.cglib.proxy.MethodInterceptor

/**
 * @author SouthLight-Lin on 2019/12/22
 */
open class OOMObject {}

class JavaVMStackSOF {
    public var stackLength = 1
    fun stackLeak() {
        stackLength++
        stackLeak()
    }
}
/**
 * OOM测试
 * vm args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 */
//fun main(args: Array<String>) {
//    println("oom")
//    val list = mutableListOf<OOMObject>()
//    while (true) {
//        list.add(OOMObject())
//    }
//}

/**
 * 虚拟机栈和本地方法栈OOM测试
 * vm args: -Xss128k
 */
//fun main(args: Array<String>) {
//    val oom = JavaVMStackSOF()
//    try {
//        oom.stackLeak()
//    }catch (e: Throwable) {
//        println("stack length:" + oom.stackLength)
//        throw e
//    }
//}

/**
 * 运行时常量池导致的OOM测试
 * vm args: -XX:PermSize=10M -XX:MaxPermSize=10M
 */
//fun main(args: Array<String>) {
//    // 使用List保持着常浪池引用，避免Full GC回收常量池行为
//    val list = mutableListOf<String>()
//    var i = 0
//    while (true) {
//        list.add("${i++}".intern())
//    }
//}

/**
 * String.intern() 返回引用测试
 * 从JDK1.7 开始，intern可能会返回堆对象的引用指针
 */
//fun main(args: Array<String>) {
//    val str1 = StringBuilder("计算机").append("软件").toString()
//    println(str1.intern() == str1)
//
//    val str2 = StringBuilder("ja").append("va").toString()
//    println(str2.intern() == str2)
//}

/**
 * 借助CGLib使方法区出现内存溢出异常
 * vm args: -XX:PermSize=10M -XX:MaxPermSize=10M
 */
fun main(args: Array<String>) {
    while (true) {
        val enhancer = Enhancer()
        enhancer.setSuperclass(OOMObject::class.java)
        enhancer.useCache = false
        enhancer.setCallback(MethodInterceptor { o, method, objects, methodProxy ->
            methodProxy.invokeSuper(o, objects)
        })
        enhancer.create()
    }
}
