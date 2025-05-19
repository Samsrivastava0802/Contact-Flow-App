package com.samridhi.contactflow.data.api

import retrofit2.http.GET

interface ContactsApi {
    @GET("api/contacts")
    suspend fun getContacts()
}
