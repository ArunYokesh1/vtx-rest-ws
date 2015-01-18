package com.sample.restws.vertx;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;
import org.vertx.java.core.Handler;
import org.vertx.java.core.http.HttpServer;
import org.vertx.java.core.http.HttpServerRequest;
import org.vertx.java.core.http.RouteMatcher;
import org.vertx.java.core.json.JsonObject;
import org.vertx.java.platform.Verticle;

/**
 * The Class ProvideTimeController.
 */

public class ProvideTimeController extends Verticle {

    public void start() {
        HttpServer server = vertx.createHttpServer();
        RouteMatcher routeMatcher = new RouteMatcher();
        routeMatcher.get("/localdatetime/:city", new Handler<HttpServerRequest>() {
            public void handle(HttpServerRequest req) {
                String city = req.params().get("city");
                req.response().setStatusCode(200);
                if (StringUtils.isBlank(city)) {
                    city = "UTC";
                }
                TimeResponse timeResp = localdatetime(city);
                JsonObject jsonResp = timeResp.toJson();
                req.response().headers().add("Content-Type", "application/json");
                req.response().end(jsonResp.encodePrettily());
            }
        });
        server.requestHandler(routeMatcher).listen(9081, "localhost");
    }

    /**
     * Localdatetime.
     *
     * @param city
     *            the city
     * @return the time response
     */

    public TimeResponse localdatetime(String city) {
        DateTimeZone stnZone = DateTimeZone.forID(city);
        LocalDateTime localdateTime = LocalDateTime.now(stnZone);
        TimeResponse timeres = new TimeResponse();
        timeres.setLocalDateTime(localdateTime);
        timeres.setCity(city);
        timeres.setTimeZone(stnZone);
        return timeres;
    }
}
