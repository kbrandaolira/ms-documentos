package br.com.boasaude.msdocumentos.application.handler

import br.com.boasaude.msdocumentos.application.dto.MedicalExamDTO
import br.com.boasaude.msdocumentos.domain.usecase.SaveMedicalExamUseCase
import com.google.gson.Gson
import org.springframework.stereotype.Component

@Component
class MedicalExamHandler(private val saveMedicalExamUseCase: SaveMedicalExamUseCase) {

    fun save(json: String) {
        this.saveMedicalExamUseCase.execute(Gson().fromJson(json, MedicalExamDTO::class.java))
    }

}