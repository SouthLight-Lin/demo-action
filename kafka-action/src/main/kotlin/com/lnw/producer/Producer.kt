package com.lnw.producer

import org.apache.kafka.clients.producer.Callback
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.clients.producer.RecordMetadata
import java.lang.Exception
import java.util.*

/**
 * Kafka 生产者
 * @author linnanwei
 * @version 1.0.0
 * @since 1.0.0
 * Date： 2019/11/13
 */
class Producer {
}


fun main(args: Array<String>) {
    val kafkaProps = Properties()
    kafkaProps["bootstrap.servers"] = "localhost:9092"
    kafkaProps["key.serializer"] = "org.apache.kafka.common.serialization.StringSerializer"
    kafkaProps["value.serializer"] = "org.apache.kafka.common.serialization.StringSerializer"
    val producer = KafkaProducer<String, String>(kafkaProps)
    val record1 = ProducerRecord("test","Products", "Hello, I am Java producer 1")
    val record2 = ProducerRecord("test","Products", "Hello, I am Java producer 5")
    // 同步发送
//    println(producer.send(record2).get())

    // 异步发送，带上callback
//    println(producer.send(record2, DemoProducerCallback()).get())
    producer.send(record2, DemoProducerCallback()).get()
    println("-----Done-----")
}

class DemoProducerCallback: Callback {
    override fun onCompletion(metadata: RecordMetadata?, exception: Exception?) {
        exception?.printStackTrace()
    }
}