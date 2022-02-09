package br.com.boasaude.msdocumentos.infrastructure.adapter


import okhttp3.CacheControl
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class RestApi{
    private val logger: Logger = LoggerFactory.getLogger(RestApi::class.java)

    fun get(url: String, hasCache: Boolean = false): String? {
        return Request.Builder().let {
            if (hasCache) it.cacheControl(CacheControl.Builder().build())
            it.url(url)
                .build()
                .run {
                    execute(this)
                }
        }
    }

    fun post(url: String, body: String): String? {
        val requestBody = body.toRequestBody("application/json".toMediaTypeOrNull())
        Request.Builder()
            .url(url)
            .post(requestBody)
            .build()
            .run {
                return execute(this)
            }
    }

    private fun execute(request: Request): String? {
        val response = OkHttpClient().newCall(request).execute()

        when {
            response.isSuccessful -> {
                return response.body?.string()
            }
            else -> logger.error("Erro when tried to ${request.method} ${request.url}.")
        }
        return null
    }
}
