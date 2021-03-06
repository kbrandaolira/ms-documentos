package br.com.boasaude.msdocumentos.infrastructure.adapter

import br.com.boasaude.msdocumentos.domain.model.Document
import br.com.boasaude.msdocumentos.domain.model.DocumentType
import br.com.boasaude.msdocumentos.domain.model.ReferenceEntity
import br.com.boasaude.msdocumentos.domain.repository.DocumentRepository
import br.com.boasaude.msdocumentos.infrastructure.entity.DocumentEntity
import br.com.boasaude.msdocumentos.infrastructure.jpa.DocumentJpa
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository

@Repository
class DocumentRepositoryAdapter(private val documentJpa: DocumentJpa) : DocumentRepository {
    private val logger: Logger = LoggerFactory.getLogger(DocumentRepositoryAdapter::class.java)

    override fun save(document: Document): Long? {
        return try {
            logger.info("Trying to save document $document.")
            this.documentJpa.save(DocumentEntity.fromDomain(document)).id
        } catch (e: Exception) {
            logger.error("Error when tried to save document ${document.url}: $e")
            null
        }
    }

    override fun findByTypeAndReferenceEntityAndReferenceIdOrderByRealizationDateDesc(
        type: String,
        referenceEntity: String,
        referenceId: Long
    ): List<Document> {
        val documents = mutableListOf<Document>()
        this.documentJpa.findByTypeAndReferenceEntityAndReferenceIdOrderByRealizationDateDesc(
            DocumentType.valueOf(type), ReferenceEntity.valueOf(referenceEntity), referenceId
        ).forEach {
            documents.add(it.toDocument())
        }
        return documents
    }
}