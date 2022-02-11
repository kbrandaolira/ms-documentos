package br.com.boasaude.msdocumentos.application.consumer

import br.com.boasaude.msdocumentos.application.handler.MedicalExamHandler
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.listener.ConsumerSeekAware
import org.springframework.stereotype.Component

@Component
class MedicalExamConsumer(private val medicalExamHandler: MedicalExamHandler) : ConsumerSeekAware {

    @KafkaListener(topicPattern = "medical.exam")
    fun onMessage(consumerRecord: ConsumerRecord<String, String>) {
        medicalExamHandler.save(consumerRecord.value())
    }

}