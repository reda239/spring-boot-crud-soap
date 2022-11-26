package com.crudsoap.soapapplication.Controller;

import com.crudsoap.soapapplication.Entities.Client;
import com.crudsoap.soapapplication.Interfaces.*;
import com.crudsoap.soapapplication.ServicesImplementation.ClientServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ClientController {
    private static final String NAMESPACE_URI = "http://interfaces.soapapplication.crudsoap.com";
    @Autowired
    private ClientServices clientServices;
    @PayloadRoot(namespace = NAMESPACE_URI,localPart = "addClientRequest")
    @ResponsePayload
    public AddClientResponse addClient(@RequestPayload AddClientRequest req){
        AddClientResponse res = new AddClientResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        Client client = new Client();
        BeanUtils.copyProperties(req.getClient(),client);
        clientServices.addClient(client);
        serviceStatus.setStatus("SUCCESS");
        serviceStatus.setMessage("Content Added Successfully");
        res.setServiceStatus(serviceStatus);
        return res;
    }
    @PayloadRoot(namespace = NAMESPACE_URI,localPart = "getClientByIdRequest")
    @ResponsePayload
     public GetClientResponse getClient(@RequestPayload GetClientByIdRequest req){
        GetClientResponse res = new GetClientResponse();
        ClientInfo clientInfo = new ClientInfo();
        BeanUtils.copyProperties(clientServices.getClientById(req.getClientId()),clientInfo);
        res.setClient(clientInfo);
        return res;
    }
    @PayloadRoot(
            namespace = NAMESPACE_URI,
            localPart = "updateClientRequest"
    )
    @ResponsePayload
    public  UpdateClientResponse updateClient(@RequestPayload UpdateClientRequest req){
        Client client = new Client();
        BeanUtils.copyProperties(req.getClient(),client);
        clientServices.updateClient(client);
        ServiceStatus serviceStatus=new ServiceStatus();
        serviceStatus.setStatus("SUCCESS");
        serviceStatus.setMessage("Content Updated Successfully");
        UpdateClientResponse res = new UpdateClientResponse();
        res.setServiceStatus(serviceStatus);
        return res;
    }
    @PayloadRoot(namespace = NAMESPACE_URI,localPart = "deleteClientRequest")
    @ResponsePayload
    public  DeleteClientResponse deleteClient(@RequestPayload DeleteClientRequest req){
        clientServices.deleteClient(req.getClientId());
        ServiceStatus serviceStatus=new ServiceStatus();
        serviceStatus.setStatus("SUCCESS");
        serviceStatus.setMessage("Content deleted Successfully");
        DeleteClientResponse res = new DeleteClientResponse();
        res.setServiceStatus(serviceStatus);
        return  res;
    }
}
