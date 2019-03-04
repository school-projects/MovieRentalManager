package Model;

public class Client extends BaseObject<Integer>{
    private String client_name;
    private String adress;

    public Client(int clientid,String name,String adress){
        super(clientid);
        this.client_name=name;
        this.adress=adress;
    }

    public String getClient_name() {
        return client_name;
    }

    public String getAdress() {
        return adress;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String toString(){
        return "Client ID: "+this.getId()+"; Client Name: "+this.client_name+"; Adress: "+this.adress;
    }
}
