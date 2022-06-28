package yucatalks.micronaut.services

import jakarta.inject.Inject
import jakarta.inject.Singleton
import yucatalks.micronaut.clients.OrdersKafkaClient
import yucatalks.micronaut.entities.OrderEntity.Companion.toOrder
import yucatalks.micronaut.models.Order
import yucatalks.micronaut.models.Order.Companion.toOrderEntity
import yucatalks.micronaut.repositories.OrderRepository
import java.util.*

@Singleton
class OrdersService {

    @Inject
    lateinit var orderRepository: OrderRepository

    @Inject
    lateinit var ordersKafkaClient: OrdersKafkaClient

    fun listAll(): List<Order> =  orderRepository.findAll().map { orderEntity -> orderEntity.toOrder() }

    fun findById(id: Long): Optional<Order> {
        var orderOptional = orderRepository.findById(id)
        return if(orderOptional.isPresent) {
                    Optional.of(orderOptional.get().toOrder())
                } else {
                    Optional.empty();
                }
    }

    fun save(order: Order): Order {
        var persistedOrder = orderRepository.save(order.toOrderEntity()).toOrder()
        ordersKafkaClient.updateOrders(persistedOrder);
        return persistedOrder;
    }

    fun update(order:Order): Order {
        var updatedOrder = orderRepository.update(order.toOrderEntity()).toOrder()
        ordersKafkaClient.updateOrders(updatedOrder)
        return  updatedOrder;
    }

    fun delete(order:Order) {
        orderRepository.delete(order.toOrderEntity());
    }
}