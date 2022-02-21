package br.com.boasaude.msdocumentos.infrastructure.adapter

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@ExperimentalSerializationApi
@Service
class MsAssociadosApi(
    private val restApi: RestApi
) {
    val baseUrl: String = "http://ms-associados:8090"
    private val logger: Logger = LoggerFactory.getLogger(MsAssociadosApi::class.java)

    fun getAssociateIdByDocumentNumber(documentNumber: String): Long? {
        return restApi.get("$baseUrl/associate/$documentNumber")?.let { response ->
            response.takeIf { it.isNotBlank() }?.let {
                logger.info("Response from getAssociateByDocumentNumber was $it.")
                Json { ignoreUnknownKeys = true }.decodeFromString<Long>(it)
            }
        }
    }
}