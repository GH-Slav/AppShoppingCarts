package by.tms.appshoppingcarts.collections

import by.tms.appshoppingcarts.model.Product

class ProductList {
    val list = ArrayList<Product>()

    companion object {
        val instance = ProductList()
    }

}