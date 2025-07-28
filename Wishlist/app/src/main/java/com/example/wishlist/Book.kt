package com.example.wishlist

class Book(val bookname:String, val booktype:String, val price:Double, val date:Int, val minimumage:Int) {
    override fun toString(): String {
        return "$bookname ($booktype)\nRelease date: $date                                  ${price}€"
    }
}
