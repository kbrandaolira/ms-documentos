package br.com.boasaude.msdocumentos.application.dto

import br.com.boasaude.msdocumentos.domain.model.Document
import br.com.boasaude.msdocumentos.domain.model.DocumentType
import br.com.boasaude.msdocumentos.infrastructure.toLocalDateTime

data class MedicalExamDTO(
    val name: String,
    val observation: String,
    val doctorName: String,
    val date: String,
    val documentUrl: String,
    val associate: AssociateDTO
) {
    fun toDocument(): Document {
        return Document(
            type = DocumentType.MEDICAL_EXAM,
            observation = "Realizado por ${this.doctorName}. Observações: ${this.observation}.",
            realizationDate = this.date.toLocalDateTime(),
            url = this.documentUrl
        )
    }
}