package com.au.rentalhubapi.mapper

interface Mapper<T, U> {

    fun map(t: T): U

}