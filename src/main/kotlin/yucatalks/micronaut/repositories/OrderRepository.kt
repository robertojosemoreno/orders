package yucatalks.micronaut.repositories

import io.micronaut.context.annotation.Executable
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import yucatalks.micronaut.entities.OrderEntity

@Repository
interface OrderRepository : CrudRepository<OrderEntity, Long> {

    @Executable
    fun find(status: String): OrderEntity
}