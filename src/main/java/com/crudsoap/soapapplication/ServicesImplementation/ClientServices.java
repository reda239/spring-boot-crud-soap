package com.crudsoap.soapapplication.ServicesImplementation;

import com.crudsoap.soapapplication.Entities.Client;
import com.crudsoap.soapapplication.Repositories.ClientRepository;
import com.crudsoap.soapapplication.Services.IClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ClientServices  implements IClientServices {

    @Autowired
    ClientRepository clientRepository ;

    @Override
    public void addClient(Client client) {
         clientRepository.save(client);
    }

    @Override
    public Client getClientById(Long Id) {
        Client obj = clientRepository.findClientById(Id);
        return obj;
    }

    @Override
    public void updateClient(Client client) {
            clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
           clientRepository.deleteById(id);
    }
}
