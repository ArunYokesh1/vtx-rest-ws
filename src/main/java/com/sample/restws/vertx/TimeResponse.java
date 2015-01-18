/**
 * 
 */
package com.sample.restws.vertx;

import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;
import org.vertx.java.core.json.JsonObject;

/**
 * The Class TimeResponse.
 *
 * @author x075027
 */
public class TimeResponse {

    /** The station. */
    private String city;

    /** The local time. */
    private String localTime;

    /** The date. */
    private String date;

    /** The zone. */
    private String zoneId;

    private String offset;

    /**
     * Instantiates a new time response.
     */
    public TimeResponse() {
        super();
    }

    /**
     * Gets the station.
     *
     * @return the station
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the station.
     *
     * @param city
     *            the new city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the localTime
     */
    public String getLocalTime() {
        return localTime;
    }

    /**
     * @param localTime
     *            the localTime to set
     */
    public void setLocalTime(String localTime) {
        this.localTime = localTime;
    }

    /**
     * @param localTime
     *            the localTime to set
     */
    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.date = localDateTime.toLocalDate().toString();
        this.localTime = localDateTime.toLocalTime().toString();
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date
     *            the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    
    /**
     * @return the zoneId
     */
    public String getZoneId() {
        return zoneId;
    }

    
    /**
     * @param zoneId the zoneId to set
     */
    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    
    /**
     * @return the offset
     */
    public String getOffset() {
        return offset;
    }

    
    /**
     * @param offset the offset to set
     */
    public void setOffset(String offset) {
        this.offset = offset;
    }
    
    public void setTimeZone(DateTimeZone timeZone) {
        this.zoneId = timeZone.getID();
    }
    
    /**
     * To json.
     *
     * @return the json object
     */
    public JsonObject toJSON() {
        JsonObject jsonObj = new JsonObject();
        jsonObj.putString("city", this.city);
        jsonObj.putString("localTime", this.localTime);
        jsonObj.putString("date", this.date);
        jsonObj.putString("zoneId", this.zoneId);
        return jsonObj;
    }

}
