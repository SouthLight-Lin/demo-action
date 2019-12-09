package com.lnw.listener

import org.apache.kafka.clients.consumer.ConsumerRebalanceListener
import org.apache.kafka.common.TopicPartition

/**
 * 再均衡监听器
 * @author linnanwei
 * @version 1.0.0
 * @since 1.0.0
 * Date： 2019/11/22
 */
class HandleRebalance : ConsumerRebalanceListener {

    /**
     * 方法会在重新分配分区之后和消费者开始读取消息之前被调用
     */
    override fun onPartitionsAssigned(partitions: MutableCollection<TopicPartition>?) {

    }

    /**
     * 再均衡开始前和消费者停止读取消息之后开始执行
     * 如果在这里提交偏移量，下一个接管分区的消费者就知道从哪里开始消费
     */
    override fun onPartitionsRevoked(partitions: MutableCollection<TopicPartition>?) {

    }
}