package org.concertManagement.controllers;

public enum Service {
    ARENA("http://localhost:8082/services/arenas"),
    LESSEE("http://localhost:8083/services/lessees"),
    CONCERT("http://localhost:8084/services/concerts"),
    TICKET("http://localhost:8085/services/tickets"),
    VISITOR("http://localhost:8086/services/visitors"),
    FINANCES("http://localhost:8087/services/finances");

    private String URL;

    Service(String URL){
        this.URL = URL;
    }

    public String getURL() {
        return URL;
    }
}
