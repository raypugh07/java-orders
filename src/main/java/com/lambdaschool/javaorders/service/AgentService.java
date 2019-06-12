package com.lambdaschool.javaorders.service;

import com.lambdaschool.javaorders.model.Agents;

import java.util.ArrayList;
import java.util.List;

public interface AgentService {

    List<Agents> findAll();

    Agents findById(long agentcode);
    Agents findByAgentname(String agentname);
    void delete(long agentcode);
    Agents save(Agents agents);
    Agents update(Agents agents,long agentcode);
}
