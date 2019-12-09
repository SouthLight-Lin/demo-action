// package com.lnw.consumer;
//
// import java.util.Collection;
// import java.util.HashMap;
// import java.util.Map;
//
// import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
// import org.apache.kafka.clients.consumer.OffsetAndMetadata;
// import org.apache.kafka.common.TopicPartition;
//
// /**
//  * @author linnanwei
//  * @version 1.0.0
//  * @since 1.0.0
//  * Date： 2019/11/22
//  */
// public class ConsumerWithListener {
//
//     private final Map<TopicPartition, OffsetAndMetadata> currentOffsets = new HashMap<TopicPartition, OffsetAndMetadata>();
//
//     private class Handle implements ConsumerRebalanceListener {
//
//         /**
//          * 重新分配分区之前，消费者停止读取消息之后
//          */
//         public void onPartitionsRevoked(final Collection<TopicPartition> partitions) {
//             System.out.println("Lost partitions in rebalance.Committing current offsets:"+ConsumerWithListener.this.currentOffsets);
//         }
//
//         public void onPartitionsAssigned(final Collection<TopicPartition> partitions) {
//
//         }
//     }
//
// }
