package yucatalks.micronaut.models

import io.micronaut.core.annotation.Introspected
import yucatalks.micronaut.entities.OrderEntity

@Introspected
data class Order(var id: Long? = 0,
                 var status: String? = "created",
                 var numProducts: Int? = 0,
                 var amount: Double? = 0.0
) {
    companion object {
        fun Order.toOrderEntity() = OrderEntity(
            id = id,
            status = status,
            numProducts = numProducts,
            amount = amount
        )
    }
}