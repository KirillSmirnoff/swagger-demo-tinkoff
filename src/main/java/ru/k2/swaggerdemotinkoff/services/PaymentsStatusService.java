package ru.k2.swaggerdemotinkoff.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.k2.swaggerdemotinkoff.api.PaymentsStatusApiDelegate;
import ru.k2.swaggerdemotinkoff.model.PaymentStatusRequest;
import ru.k2.swaggerdemotinkoff.model.RelatedResponse;

import java.util.UUID;

@Service
public class PaymentsStatusService implements PaymentsStatusApiDelegate {

    @Override
    public ResponseEntity<RelatedResponse> postPaymentsStatus(PaymentStatusRequest paymentStatusRequest) {
        return new ResponseEntity(new RelatedResponse()
                .correllationID(paymentStatusRequest.getMessageID())
                .messageID(UUID.randomUUID().toString())
                .errorMessage("Test of java classes generated via OpenApi completed successfully")
                .errorCode("200"), HttpStatus.OK);
    }
}
