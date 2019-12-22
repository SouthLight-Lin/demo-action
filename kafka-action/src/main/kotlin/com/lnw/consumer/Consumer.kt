package com.lnw.consumer

import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.common.serialization.Serializer
import java.time.Duration
import java.util.*

/**
 * @author linnanwei
 * @version 1.0.0
 * @since 1.0.0
 * Date： 2019/11/13
 */
fun main(args: Array<String>) {
    val kafkaProps = Properties()
    kafkaProps["bootstrap.servers"] = "localhost:9092"
    kafkaProps["group.id"] = "helloKafka"
    kafkaProps["key.deserializer"] = "org.apache.kafka.common.serialization.StringDeserializer"
    kafkaProps["value.deserializer"] = "org.apache.kafka.common.serialization.StringDeserializer"
    val consumer = KafkaConsumer<String, String>(kafkaProps)
    // 订阅主题
    consumer.subscribe(Collections.singleton("test"))

    // use关键字和自动关闭consumer连接
    consumer.use {
        // 轮询
        while (true) {
            val records = consumer.poll(Duration.ofMillis(100)); // 消费者必须持续对kafka进行轮询，否则就会被认为死亡
            for (record in records) {
                println("topic = ${record.topic()}, partition = ${record.partition()}, offset = ${record.offset()}, key = ${record.key()}, value = ${record.value()}")
            }
        }
    }
}