package com.example.reactapp

import retrofit2.http.GET

interface Service {

    @GET
    fun getPerson(): List<PersonApp>
}