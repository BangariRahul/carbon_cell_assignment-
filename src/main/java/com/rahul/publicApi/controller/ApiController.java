package com.rahul.publicApi.controller;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.rahul.publicApi.entities.Entry;
import com.rahul.publicApi.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {


    @Autowired
    private ApiService apiService;

    @GetMapping("/check")
    public String getAllPublicApis() {
        return "checking jwt";
    }

    @GetMapping("/publicapis")
    public ResponseEntity<List<Entry>> getPublicApis(@RequestParam(required = false) String category , @RequestParam(required = false) Integer entryLimit) throws IOException, URISyntaxException, InterruptedException {

        return new ResponseEntity<>(apiService.getEntries(category , entryLimit), HttpStatus.OK);
    }



}
