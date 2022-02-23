package br.com.boasaude.msdocumentos.domain.usecase

import br.com.boasaude.msdocumentos.application.dto.MedicalExamDTO
import br.com.boasaude.msdocumentos.domain.model.ReferenceEntity
import br.com.boasaude.msdocumentos.domain.repository.DocumentRepository
import br.com.boasaude.msdocumentos.infrastructure.adapter.MsAssociadosApi
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class SaveMedicalExamUseCase(
    private val documentRepository: DocumentRepository,
    private val msAssociadosApi: MsAssociadosApi
) {
    private val logger: Logger = LoggerFactory.getLogger(SaveMedicalExamUseCase::class.java)

    fun execute(medicalExamDTO: MedicalExamDTO) {
        val document = medicalExamDTO.toDocument()
        document.referenceId = this.msAssociadosApi.getAssociateIdByDocumentNumber(medicalExamDTO.associate!!.documentNumber)
        document.referenceEntity = ReferenceEntity.ASSOCIATE
        this.documentRepository.save(document)
    }

}