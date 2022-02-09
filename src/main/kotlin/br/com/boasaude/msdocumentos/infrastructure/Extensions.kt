package br.com.boasaude.msdocumentos.infrastructure

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun String.toLocalDateTime(): LocalDateTime {
    return try {
        LocalDateTime.parse(this, DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"))
    } catch (ex: Exception) {
        LocalDateTime.now()
    }
}