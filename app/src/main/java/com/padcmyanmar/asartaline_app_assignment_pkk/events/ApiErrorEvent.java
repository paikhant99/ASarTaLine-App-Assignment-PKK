package com.padcmyanmar.asartaline_app_assignment_pkk.events;

/**
 * Created by paikhantko on 7/7/18.
 */

public class ApiErrorEvent {

    private String message;

    public ApiErrorEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
