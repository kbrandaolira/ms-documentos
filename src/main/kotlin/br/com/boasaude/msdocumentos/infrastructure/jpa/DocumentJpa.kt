package br.com.boasaude.msdocumentos.infrastructure.jpa

import br.com.boasaude.msdocumentos.domain.model.DocumentType
import br.com.boasaude.msdocumentos.domain.model.ReferenceEntity
import br.com.boasaude.msdocumentos.infrastructure.entity.DocumentEntity
import org.springframework.data.jpa.repository.JpaRepository

interface DocumentJpa : JpaRepository<DocumentEntity, Long> {

    fun findByTypeAndReferenceEntityAndReferenceIdOrderByRealizationDateDesc(
        type: DocumentType,
        referenceEntity: ReferenceEntity,
        referenceId: Long
    ): List<DocumentEntity>

}