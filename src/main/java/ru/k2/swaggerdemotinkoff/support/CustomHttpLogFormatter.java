package ru.k2.swaggerdemotinkoff.support;

import org.jetbrains.annotations.NotNull;
import org.zalando.logbook.*;

import java.io.IOException;
import java.util.Map;

public class CustomHttpLogFormatter implements StructuredHttpLogFormatter {

    @Override
    public String format(@NotNull Map<String, Object> content) {
        StringBuilder sb = new StringBuilder(2048);
        if (content.get("type").equals("request")) {
            sb.append("Raw request to server \n")
                    .append("================= Request Begin =================\n")
                    .append("URI          : ").append(content.get("uri")).append("\n")
                    .append("Method       : ").append(content.get("method")).append("\n")
                    .append("Headers      : ").append(content.get("headers")).append("\n")
                    .append("Request body : ").append(content.get("body")).append("\n")
                    .append("================= Request End =================");
            return sb.toString();
        } else {
            sb.append("Raw response from server:\n")
                    .append("================= Response Begin =================\n")
                    .append("Status code   : ").append(content.get("status")).append("\n")
//                    .append("Status text : ").append(response.getStatusText()).append("\n")
                    .append("Headers       : ").append(content.get("headers")).append("\n")
                    .append("Response body : ").append(content.get("body")).append("\n")
                    .append("================= Response End =================");
        }
        return sb.toString();
    }
}
