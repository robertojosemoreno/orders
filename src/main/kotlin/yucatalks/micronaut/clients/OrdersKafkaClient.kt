package yucatalks.micronaut.clients

import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.Topic
import yucatalks.micronaut.models.Order

@KafkaClient
interface OrdersKafkaClient {
    @Topic("orders")
    fun updateOrders(order: Order)
}