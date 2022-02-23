package br.com.boasaude.msdocumentos.application.handler

import br.com.boasaude.msdocumentos.application.dto.MedicalExamDTO
import br.com.boasaude.msdocumentos.domain.model.DocumentType
import br.com.boasaude.msdocumentos.domain.repository.DocumentRepository
import br.com.boasaude.msdocumentos.domain.usecase.SaveMedicalExamUseCase
import com.google.gson.Gson
import org.springframework.stereotype.Component

@Component
class MedicalExamHandler(
    private val saveMedicalExamUseCase: SaveMedicalExamUseCase,
    private val documentRepository: DocumentRepository
) {

    fun save(json: String) {
        this.saveMedicalExamUseCase.execute(Gson().fromJson(json, MedicalExamDTO::class.java))
    }

    fun search(
        documentType: String,
        referenceType: String,
        referenceId: Long
    ): List<MedicalExamDTO> {
        val dtos = mutableListOf<MedicalExamDTO>()
        this.documentRepository.findByTypeAndReferenceEntityAndReferenceIdOrderByRealizationDateDesc(
            documentType,
            referenceType,
            referenceId
        ).forEach {
            dtos.add(MedicalExamDTO.fromDocument(it))
        }
        return dtos
    }

}