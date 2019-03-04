package Model;

public class Client {
    private int client_id;
    private String client_name;
    private String adress;

    public Client(int clientid,String name,String adress){
        this.client_id =clientid;
        this.client_name=name;
        this.adress=adress;
    }
    public int getClient_id() {
        return client_id;
    }

    public String getClient_name() {
        return client_name;
    }

    public String getAdress() {
        return adress;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String toString(){
        return "Client ID: "+this.client_id+"; Client Name: "+this.client_name+"; Adress: "+this.adress;
    }
}
