package br.com.boasaude.msdocumentos.domain.model

import java.time.LocalDateTime

data class Document (
    val id: Long? = null,
    val type: DocumentType,
    val observation: String,
    var referenceId: Long? = null,
    var referenceEntity: ReferenceEntity? = null,
    val url: String,
    val realizationDate: LocalDateTime,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val createdBy: Long? = null

)

enum class DocumentType {
    MEDICAL_EXAM
}

enum class ReferenceEntity {
    ASSOCIATE
}