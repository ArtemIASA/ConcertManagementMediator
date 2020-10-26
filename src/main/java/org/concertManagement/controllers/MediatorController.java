package org.concertManagement.controllers;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("mediator")
public class MediatorController {
    private static final RestTemplate restTemplate = new RestTemplate();


    @PostMapping
    public<T> ResponseEntity<Void> update(@RequestBody T entity){
        String serviceName = parseJsonEntityType(entity.toString());
        String URL = findUrlByService(serviceName);
        HttpEntity<T> postEntity = new HttpEntity<>(entity);
        ResponseEntity<Void> response = restTemplate.exchange(URL, HttpMethod.POST, postEntity, Void.class);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public<T> ResponseEntity<Void> delete(@RequestBody T entity){
        String serviceName = parseJsonEntityType(entity.toString());
        String URL = findUrlByService(serviceName);
        HttpEntity<T> deleteEntity = new HttpEntity<>(entity);
        ResponseEntity<Void> response = restTemplate.exchange(URL, HttpMethod.DELETE, deleteEntity, Void.class);
        return ResponseEntity.ok().build();
    }

    private String parseJsonEntityType(String json){
        try {
            String[] type = json.split("entities.");
            String[] type2 = type[1].split(",");
            String serviceName = type2[0].toUpperCase();
            return serviceName;
        }
        catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Entity type is not defined in json");
                throw e;
            }
    }

    private String findUrlByService(String serviceName){
        Service service = Service.valueOf(serviceName);
        return service.getURL();
    }


}
