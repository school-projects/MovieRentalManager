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
public class ClientService {
    private Repository<Integer, Client> repo;

    /**
     * Constructor
     * Creates a ClientService instance with an empty repository
     */
    public ClientService() {
        ClientValidator validator = new ClientValidator();
        this.repo = new Repository<>(validator);
    }

    /**
     * Constructor
     * Creates a ClientService instance based on a given Client Repository
     *
     * @param repo the given repository
     */
    public ClientService(Repository<Integer, Client> repo) {
        this.repo = repo;
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

        this.repo.add(newClient);

    }


    /**
     * Returns all clients in the repository
     *
     * @return an iterable containing the clients
     */
    public Iterable<Client> getAllClients() {
        return repo.findAll();
    }

    public Iterable<Client> sortAlfa(){
        return StreamSupport.stream(repo.findAll().spliterator(),false).sorted(Comparator.comparing(Client::getName)).collect(Collectors.toList());
    }
}
