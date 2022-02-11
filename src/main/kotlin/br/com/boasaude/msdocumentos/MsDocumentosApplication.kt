package br.com.boasaude.msdocumentos

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka

@SpringBootApplication
@EnableKafka
class MsDocumentosApplication

fun main(args: Array<String>) {
	runApplication<MsDocumentosApplication>(*args)
}
