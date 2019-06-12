package com.lambdaschool.javaorders.service;


import com.lambdaschool.javaorders.model.Agents;
import com.lambdaschool.javaorders.repos.AgentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value="agentsService")
public class AgentsServiceImpl implements AgentService {

    @Autowired
    private AgentsRepository agentrepos;

    @Override
    public List<Agents> findAll() {

        List<Agents> list=new ArrayList<>();

        agentrepos.findAll().iterator().forEachRemaining(list::add);

        return list;
    }

    @Override
    public Agents findById(long agentcode) {
        return agentrepos.findById(agentcode)
                .orElseThrow(()->new EntityNotFoundException(Long.toString(agentcode)));
    }

    @Override
    public Agents findByAgentname(String agentname) {
        Agents agent=agentrepos.findByAgentname(agentname);
        if (agent==null){
            throw new EntityNotFoundException("Agent "+ agentname + " not found");
        }
        return agent;
    }

    @Override
    public void delete(long agentcode) {

        if (agentrepos.findById(agentcode).isPresent()) {

            agentrepos.deleteById(agentcode);

        } else{

            throw new EntityNotFoundException(Long.toString(agentcode));
        }

    }

    @Override
    public Agents save(Agents agents) {

        Agents newAgent= new Agents();

        newAgent.setAgentname(agents.getAgentname());
        newAgent.setWorkingarea(agents.getWorkingarea());
        newAgent.setCommission(agents.getCommission());
        newAgent.setPhone(agents.getPhone());
        newAgent.setCountry(agents.getCountry());

        return agentrepos.save(newAgent);
    }

    @Transactional
    @Override
    public Agents update(Agents agents, long agentcode)
    {
        Agents currentAgents = agentrepos.findById(agentcode)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(agentcode)));

        if (agents.getAgentname() != null)
        {
            currentAgents.setAgentname(agents.getAgentname());
        }

        if (agents.getWorkingarea() != null)
        {
            currentAgents.setWorkingarea(agents.getWorkingarea());
        }

        if (agents.getCommission() != 0)
        {
            currentAgents.setCommission(agents.getCommission());
        }

        if (agents.getPhone() != null)
        {
            currentAgents.setPhone(agents.getPhone());
        }

        if (agents.getCountry() != null)
        {
            currentAgents.setCountry(agents.getCountry());
        }



        return agentrepos.save(currentAgents);
    }
}
