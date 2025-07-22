package com.example.wishlist

class User(val username:String, val password:String, val name:String, val age:Int) {
    override fun toString(): String {
        return "$username"
    }
}
