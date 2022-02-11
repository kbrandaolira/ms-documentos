package br.com.boasaude.msdocumentos.infrastructure.entity

import br.com.boasaude.msdocumentos.domain.model.Document
import br.com.boasaude.msdocumentos.domain.model.DocumentType
import br.com.boasaude.msdocumentos.domain.model.ReferenceEntity
import org.springframework.data.jpa.repository.Temporal
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "document")
@Table(name = "document", schema = "documentos")
class DocumentEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Enumerated(EnumType.STRING)
    val type: DocumentType,
    val observation: String,
    var referenceId: Long? = null,
    @Enumerated(EnumType.STRING)
    var referenceEntity: ReferenceEntity? = null,
    val url: String,
    @Temporal(TemporalType.TIMESTAMP)
    val realizationDate: LocalDateTime,
    @Temporal(TemporalType.TIMESTAMP)
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val createdBy: Long? = null
) {
    companion object {
        fun fromDomain(document: Document) = DocumentEntity(
            id = document.id,
            type = document.type,
            observation = document.observation,
            referenceId = document.referenceId,
            referenceEntity = document.referenceEntity,
            url = document.url,
            realizationDate = document.realizationDate,
            createdAt = document.createdAt,
            createdBy = document.createdBy
        )
    }
}