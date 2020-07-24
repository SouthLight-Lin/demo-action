package com.lnw

import java.lang.StringBuilder
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.ThreadFactory
import java.util.function.Function

/**
 * @author linnanwei
 * @since 1.0.0
 */
fun main() {
    //    action1()
    //    action2()
    //    action3()
    //    action4()
    //    action5()
    //    action6()
    //    action7()

    val linkedHashMap = LinkedHashMap<String, String>(4, 0.75f, true)
    linkedHashMap["1"] = "1"
    linkedHashMap["2"] = "2"
    linkedHashMap["3"] = "3"
    linkedHashMap["4"] = "4"

    println(linkedHashMap["4"])
    println(linkedHashMap["3"])
    println(linkedHashMap["2"])
    println(linkedHashMap["1"])
    println("=====================")
    println(linkedHashMap)
}

// 启动异步计算
fun action1() {
    val cf = CompletableFuture.completedFuture("message")
    println(cf.isDone)
    println(cf.getNow(null))
}

// 运行简单的异步场景
fun action2() {
    val cf2 = CompletableFuture.runAsync {
        // 使用了demon线程执行Runnable任务
        println("current thread is daemon? ${Thread.currentThread().isDaemon}")
        println("current thread name is ${Thread.currentThread().name}")
        Thread.sleep(2000)
    }
    println("main thread sleep....")
    Thread.sleep(3000)
    println(cf2.isDone)
}

// 同步执行动作
fun action3() {
    val cf3 = CompletableFuture.completedFuture("message").thenAccept {
        println("current thread name is ${Thread.currentThread().name}")
        Thread.sleep(2000)
        it.toUpperCase()
    }
    println("main thread running")
    println(cf3.getNow(null))
}

// 异步执行动作
fun action4() {
    val cf4 = CompletableFuture.completedFuture("message").thenApplyAsync {
        println("current thread name is ${Thread.currentThread().name}")
        Thread.sleep(2000)
        it.toUpperCase()
    }
    println("main thread is waiting....")
    println(cf4.getNow(null)) //print null
    println(cf4.join())
}

// 使用固定的线程池完成异步执行动作
var count = 1
val executor: ExecutorService = Executors.newFixedThreadPool(3) {
    Thread(it, "custom-executor-${count++}").also { thread ->
        thread.isDaemon = true
    }
}

fun action5() {
    val cf5 = CompletableFuture.completedFuture("message").thenApplyAsync(Function<String, String> {
        println(Thread.currentThread().name)
        println(Thread.currentThread().isDaemon)
        Thread.sleep(2000)
        it.toUpperCase()
    }
        , executor)
    println(cf5.getNow(null)) //print null
    println("main thread is waiting....")
    println(cf5.join())
}

// 使用消费者同步消费计算结果
fun action6() {
    val result = StringBuilder()
    val cf6 = CompletableFuture.completedFuture("thenAccept message")
        .thenAccept { result.append(it) }
    cf6.join()
    println("Result was empty ${result.isNotEmpty()}")
}

// 使用消费者异步消费计算结果
fun action7() {
    val result = StringBuilder()
    val cf7 = CompletableFuture.completedFuture("thenAcceptAsync message")
        .thenAcceptAsync { result.append(it) }
    cf7.join()
    println("Result was empty ${result.isNotEmpty()}")
}
