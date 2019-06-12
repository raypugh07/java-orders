package com.lambdaschool.javaorders.controller;


import com.lambdaschool.javaorders.model.Agents;
import com.lambdaschool.javaorders.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private AgentService agentService;

    @GetMapping(value="/agents",
                produces={"application/json"})
    public ResponseEntity<?> listAllAgents(){
        List<Agents> list= agentService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @GetMapping(value = "/agents/{agentcode}",
            produces = {"application/json"})
    public ResponseEntity<?> getAgentById(
            @PathVariable
                    Long agentcode)
    {
        Agents a = agentService.findById(agentcode);
        return new ResponseEntity<>(a, HttpStatus.OK);
    }


    @GetMapping(value = "/agents/name/{agentname}",
            produces = {"application/json"})
    public ResponseEntity<?> getAgentByName(
            @PathVariable
                    String agentname)
    {
        Agents a = agentService.findByAgentname(agentname);
        return new ResponseEntity<>(a, HttpStatus.OK);
    }


    /*@PostMapping(value = "/agents",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> addNewAgent(@Valid
                                              @RequestBody
                                                      Agents newAgent) throws URISyntaxException
    {
        newAgent = agentService.save(newAgent);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newAgentURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{agentcode}").buildAndExpand(newAgent.getAgentcode()).toUri();
        responseHeaders.setLocation(newAgentURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }*/

    @PostMapping(value = "/agents",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> addNewRestaurant(@Valid
                                              @RequestBody Agents newAgent)
    {
        newAgent = agentService.save(newAgent);
        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newAgentURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{agentcode}").buildAndExpand(newAgent.getAgentcode()).toUri();
        responseHeaders.setLocation(newAgentURI);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }


    @PutMapping(value = "/agents/{agentcode}")
    public ResponseEntity<?> updateAgent(
            @RequestBody
                    Agents updateAgent,
            @PathVariable
                    long agentcode)
    {
        agentService.update(updateAgent, agentcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("/agents/{agentcode}")
    public ResponseEntity<?> deleteAgentbyId(
            @PathVariable
                    long agentcode)
    {
        agentService.delete(agentcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
