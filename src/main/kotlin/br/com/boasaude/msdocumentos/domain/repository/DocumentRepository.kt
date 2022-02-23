package br.com.boasaude.msdocumentos.domain.repository

import br.com.boasaude.msdocumentos.domain.model.Document

interface DocumentRepository {
    fun save(document: Document): Long?
    fun findByTypeAndReferenceEntityAndReferenceIdOrderByRealizationDateDesc(
        type: String,
        referenceEntity: String,
        referenceId: Long
    ): List<Document>
}