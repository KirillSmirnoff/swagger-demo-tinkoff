package ru.k2.swaggerdemotinkoff.ru.k2.swaggerdemotinkoff.services

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import ru.k2.swaggerdemotinkoff.api.PaymentsStatusApiDelegate
import ru.k2.swaggerdemotinkoff.model.PaymentStatusRequest
import ru.k2.swaggerdemotinkoff.model.RelatedResponse

import java.util.UUID

@Service
class PaymentsStatusService : PaymentsStatusApiDelegate{

    override fun postPaymentsStatus(paymentStatusRequest: PaymentStatusRequest): ResponseEntity<RelatedResponse> {
        return ResponseEntity(
                RelatedResponse(UUID.randomUUID().toString(), paymentStatusRequest.messageID,
                        "200", "Test of kotlin classes generated via OpenApi completed successfully"), HttpStatus.OK)
    }
}