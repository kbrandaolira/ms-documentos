package br.com.boasaude.msdocumentos.infrastructure.adapter

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.springframework.stereotype.Service

@ExperimentalSerializationApi
@Service
class MsAssociadosApi(
    private val restApi: RestApi
) {
    val baseUrl: String = "http://localhost:8090"

    fun getAssociateIdByDocumentNumber(documentNumber: String): Long? {
        return restApi.get("$baseUrl/associate/$documentNumber")?.let { response ->
            response.takeIf { it.isNotBlank() }?.let {
                Json { ignoreUnknownKeys = true }.decodeFromString<Long>(it)
            }
        }
    }

}