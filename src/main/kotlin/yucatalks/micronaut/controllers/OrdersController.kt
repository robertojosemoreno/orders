package yucatalks.micronaut.controllers

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import jakarta.inject.Inject
import yucatalks.micronaut.models.Order
import yucatalks.micronaut.services.OrdersService
import java.util.*

@Controller("/orders")
class OrdersController {
    @Inject
    lateinit var ordersService: OrdersService

    @Get
    fun listAll(): List<Order> = ordersService.listAll();

    @Get("/{id}")
    fun getOrderById(id: Long): Optional<Order> = ordersService.findById(id)

    @Put
    fun update(@Body order: Order): HttpResponse<Order> {
        return HttpResponse.ok(ordersService.update(order))
    }

    @Post
    fun save(@Body order: Order) : HttpResponse<Order> {
        return HttpResponse.created(ordersService.save(order))
    }

}