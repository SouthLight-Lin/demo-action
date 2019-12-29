package com.lnw.reactor

import reactor.core.publisher.Flux
import java.time.Duration

/**
 * 数据流操作符
 * @author SouthLight-Lin on 2019/12/27
 */

// map
fun operatorMap() {
    Flux.range(1, 6)
            .map { it * it }       // 加工返回
            .subscribe { println(it) }
}

// flatMap
fun operatorFlatMap() {
    Flux.just("flux", "mono")
            .flatMap {
                // 异步,Kotlin 的 split相对于Java要做额外操作
                Flux.fromArray(it.split("\\s*".toRegex()).toTypedArray())
                        .delayElements(Duration.ofMillis(100))
            }
            .subscribe { println(it) }
    Thread.sleep(1000)
}

// filter
fun operatorFilter() =
        Flux.range(1, 6)
                .filter { it % 2 == 1 }
                .subscribe { println(it) }


fun main() {
//    operatorMap()
//    operatorFlatMap()
    operatorFilter()
}