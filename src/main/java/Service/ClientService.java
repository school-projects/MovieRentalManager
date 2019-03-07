package Service;

import Exceptions.ValidatorException;
import Model.Client;
import Repository.Repository;
import Validation.ClientValidator;
import Validation.IValidator;

/**
 * Service for the Client class
 */
public class ClientService {
    private Repository<Integer, Client> repo;
    private IValidator<Client> validator;

    /**
     * Constructor
     * Creates a ClientService instance with an empty repository
     */
    public ClientService() {
        this.repo = new Repository<Integer, Client>();
        this.validator = new ClientValidator();
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
        try {
            this.validator.validate(newClient);
            this.repo.add(newClient);
        } catch (ValidatorException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    /**
     * Returns all clients in the repository
     *
     * @return an iterable containing the clients
     */
    public Iterable<Client> getAllClients() {
        return repo.findAll();
    }
}
