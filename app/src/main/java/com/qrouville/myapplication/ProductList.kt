package com.qrouville.myapplication

class ProductList {
    private val products: MutableList<Product> = arrayListOf()

    fun getList(): MutableList<Product> {
        return this.products
    }

    fun addProduct(product: Product) {
        this.products.add(product)
    }
}