package Service;

import Exceptions.ValidatorException;
import Model.Client;
import Repository.Repository;
import Validation.ClientValidator;
import Validation.IValidator;
import Validation.MovieValidator;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Service for the Client class
 */
public class ClientService extends Service<Integer, Client> {
    /**
     * Creates a ClientService instance with an empty repository
     */
    public ClientService() {
        super(new ClientValidator());
    }

    /**
     * Adds a Client to the repository
     *
     * @param clientId      the id of the client
     * @param clientName    the name of the client
     * @param clientAddress the address of the client
     */
    public void addClient(int clientId, String clientName, String clientAddress) {
        Client newClient = new Client(clientId, clientName, clientAddress);
        super.add(newClient);
    }

    public Iterable<Client> sortAlpha(){
        return StreamSupport.stream(repo.findAll().spliterator(),false).sorted(Comparator.comparing(Client::getName)).collect(Collectors.toList());
    }
}
