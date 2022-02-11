package br.com.boasaude.msdocumentos.infrastructure.jpa

import br.com.boasaude.msdocumentos.infrastructure.entity.DocumentEntity
import org.springframework.data.jpa.repository.JpaRepository

interface DocumentJpa : JpaRepository<DocumentEntity, Long> {

}