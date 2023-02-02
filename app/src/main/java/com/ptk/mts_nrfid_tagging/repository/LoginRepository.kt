package com.ptk.mts_nrfid_tagging.repository

import android.app.Application
import com.ptk.mts_nrfid_tagging.network.ApiService
import io.ktor.client.features.*
import io.ktor.network.sockets.*
import kotlinx.coroutines.flow.channelFlow
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val apiService: ApiService,
    private val application: Application,

    ) {
   /* fun login(sapID: String) = channelFlow {
        try {
            send(RemoteResource.Loading)
            val response = apiService.login(sapID)
            send(RemoteResource.Success(response))
        } catch (e: Exception) {
            when (e) {
                is HttpRequestTimeoutException -> {
                    send(RemoteResource.Failure(errorMessage = application.getString(R.string.connection_error_message)))
                }
                is ConnectTimeoutException -> {
                    send(RemoteResource.Failure(errorMessage = application.getString(R.string.connection_error_message)))
                }
                else -> {
                    val errorMessage = "Something went wrong: ${e.localizedMessage}"
                    send(RemoteResource.Failure(errorMessage = errorMessage))
                }
            }
        }
    }*/



}
