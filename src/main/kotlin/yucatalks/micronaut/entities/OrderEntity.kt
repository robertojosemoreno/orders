package yucatalks.micronaut.entities

import yucatalks.micronaut.models.Order
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "orders")
data class OrderEntity(@Id @GeneratedValue var id: Long? = 0,
                       var status: String? =  "created",
                       var numProducts: Int? = 0,
                       var amount: Double? = 0.0
){
    companion object {
        fun OrderEntity.toOrder() = Order(
            id = id,
            status = status,
            numProducts = numProducts,
            amount = amount
        )
    }
}
