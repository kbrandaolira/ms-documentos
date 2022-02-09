package br.com.boasaude.msdocumentos.domain.usecase

import br.com.boasaude.msdocumentos.application.dto.MedicalExamDTO
import br.com.boasaude.msdocumentos.domain.model.ReferenceEntity
import br.com.boasaude.msdocumentos.domain.repository.DocumentRepository
import org.springframework.stereotype.Service

@Service
class SaveMedicalExamUseCase(private val documentRepository: DocumentRepository) {

    fun execute(medicalExamDTO: MedicalExamDTO){
        val document = medicalExamDTO.toDocument()
        // TODO: Buscar id do associado pelo document number e preencher o objeto document
        document.referenceEntity = ReferenceEntity.ASSOCIATE
        this.documentRepository.save(document)
        // TODO: Tratar erros: associado não encontrado e erro de persistência
    }

}