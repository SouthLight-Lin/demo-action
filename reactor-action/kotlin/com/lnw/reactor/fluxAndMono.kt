package com.lnw.reactor

import reactor.core.publisher.Flux
import java.util.function.Consumer

/**
 * Reactor中的发布者（Publisher）由Flux和Mono两个类定义
 * Flux和Mono可以发出三种信号：元素值、错误信号、完成信号
 * @author SouthLight-Lin on 2019/12/27
 */
fun main() {
    val array = arrayOf(1, 2, 3, 4, 5, 6)
    Flux.fromArray(array)
            // subscribe订阅流数据的处理形式，这里只是将流元素输出
            .subscribe { println(it) }

    // subscribe 方法才会触发数据流，才会开始消费数据
    Flux.just(1, 2, 3, 4, 5, 6).subscribe({ println("I am processing $it") },
            { println("I am execute error when process $it") },
            { println("Complete!") }
    )


}

