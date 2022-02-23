package br.com.boasaude.msdocumentos.application.dto

import br.com.boasaude.msdocumentos.domain.model.Document
import br.com.boasaude.msdocumentos.domain.model.DocumentType
import br.com.boasaude.msdocumentos.infrastructure.toLocalDateTime
import java.time.format.DateTimeFormatter

data class MedicalExamDTO(
    val name: String,
    val place: String,
    val doctorName: String,
    val date: String,
    val documentUrl: String,
    val associate: AssociateDTO? = null
) {
    companion object {
        fun fromDocument(document: Document) = MedicalExamDTO(
            name = document.name,
            place = document.responsible,
            doctorName = document.observation,
            date = document.realizationDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss")),
            documentUrl = document.url,
        )
    }

    fun toDocument(): Document {
        return Document(
            name = this.name,
            responsible = this.place,
            type = DocumentType.MEDICAL_EXAM,
            observation = "${this.doctorName}",
            realizationDate = this.date.toLocalDateTime(),
            url = this.documentUrl
        )
    }

}