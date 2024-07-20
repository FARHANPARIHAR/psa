package com.psa.PsaDto;

import java.util.Date;

public class ErrorDetails {
    private String message;
    private Date date;
    private String webRequest;
    public ErrorDetails(String message, Date date, String webRequest)
    {
        this.message=message;
        this.date=date;
        this.webRequest=webRequest;
    }

    public String getMessage() {
        return message;
    }
    public Date getDate() {
        return date;
    }
    public String getWebRequest() {
        return webRequest;
    }
}
