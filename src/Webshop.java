import utils.Server;

public class Webshop extends Server {
    public Webshop() {
        super(17);
    }

    @Override
    public void processNewConnection(String pClientIP, int pClientPort) {
        send(pClientIP, pClientPort, "Willkommen im Webshop. In welcher Größe willst du dein Einhornfurzkissen bestellen (S; M; L; XL) und welche Farbe soll es haben?");
    }

    @Override
    public void processMessage(String pClientIP, int pClientPort, String pMessage) {
        String einhornfurzkissen_groesse = pMessage.split(":")[1];
        String einhornfurzkissen_farbe = pMessage.split(":")[2];
        if(einhornfurzkissen_groesse == "S" || einhornfurzkissen_groesse == "M" || einhornfurzkissen_groesse == "L" || einhornfurzkissen_groesse == "XL" ){

        }
    }

    @Override
    public void processClosingConnection(String pClientIP, int pClientPort) {

    }

}
