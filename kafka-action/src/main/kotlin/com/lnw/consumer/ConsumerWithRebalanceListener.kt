package com.lnw.consumer

import org.apache.kafka.clients.consumer.Consumer
import org.apache.kafka.clients.consumer.ConsumerRebalanceListener
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.clients.consumer.OffsetAndMetadata
import org.apache.kafka.common.TopicPartition
import java.util.*

/**
 * 带有再均衡监听器的消费者
 * @author linnanwei
 * @version 1.0.0
 * @since 1.0.0
 * Date： 2019/11/22
 */
class ConsumerWithRebalanceListener {

    private val currentOffsets = mutableMapOf<TopicPartition, OffsetAndMetadata>()

    private inner class HandleRebalance : ConsumerRebalanceListener {
        override fun onPartitionsAssigned(partitions: MutableCollection<TopicPartition>?) {
        }

        override fun onPartitionsRevoked(partitions: MutableCollection<TopicPartition>?) {
            println("Lost partitions in rebalance.Committing current offsets:$currentOffsets")
        }
    }


    fun init(): Consumer<String, String> {
        val kafkaProps = Properties()
        kafkaProps["bootstrap.servers"] = "localhost:9092"
        kafkaProps["group.id"] = "helloKafka"
        kafkaProps["key.deserializer"] = "org.apache.kafka.common.serialization.StringDeserializer"
        kafkaProps["value.deserializer"] = "org.apache.kafka.common.serialization.StringDeserializer"
        val consumer = KafkaConsumer<String, String>(kafkaProps)
        // 订阅主题
        consumer.subscribe(listOf("test"))
        return consumer
    }


    fun consumingAndListen() {


    }

}