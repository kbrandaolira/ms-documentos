package br.com.boasaude.msdocumentos.application.controller

import br.com.boasaude.msdocumentos.application.dto.MedicalExamDTO
import br.com.boasaude.msdocumentos.application.handler.MedicalExamHandler
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/document")
class DocumentController(private val medicalExamHandler: MedicalExamHandler) {

    private val logger: Logger = LoggerFactory.getLogger(DocumentController::class.java)

    @GetMapping("/{documentType}/from/{referenceEntity}/{referenceId}/")
    fun search(
        @PathVariable documentType: String,
        @PathVariable referenceEntity: String,
        @PathVariable referenceId: Long
    ): List<MedicalExamDTO> {
        logger.info("Searching documents by $documentType, $referenceEntity and $referenceId.")
        return this.medicalExamHandler.search(documentType, referenceEntity, referenceId)
    }
}
