package com.crudsoap.soapapplication.Services;

import com.crudsoap.soapapplication.Entities.Client;

public interface IClientServices {
    void addClient(Client client);
    Client getClientById(Long Id);
    void updateClient(Client client);
    void deleteClient(Long id);
}
