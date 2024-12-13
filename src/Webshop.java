import utils.Server;

public class Webshop extends Server {
    public Webshop() {
        super(17);
    }

    @Override
    public void processNewConnection(String pClientIP, int pClientPort) {
        this.send(pClientIP, pClientPort, "Willkommen im Webshop. In welcher Größe willst du dein Einhornfurzkissen bestellen (S; M; L; XL) und welche Farbe soll es haben?");
    }

    @Override
    public void processMessage(String pClientIP, int pClientPort, String pMessage) {
        String nachrichtenpart_1 = pMessage.split(":")[0];

        switch (nachrichtenpart_1) {
            case "Einhornfurzkissen" -> {
                String einhornfurzkissen_groesse = pMessage.split(":")[1];
                if (einhornfurzkissen_groesse.equals("S") || einhornfurzkissen_groesse.equals("M") || einhornfurzkissen_groesse.equals("L") || einhornfurzkissen_groesse.equals("XL")) {
                    send(pClientIP, pClientPort, "Bitte Bestätige deine Bestellung eines Einhornfurzkissens in der Größe" + pMessage.split(":")[1]
                            + " und in der Farbe" + pMessage.split(":")[2] + " mit ja oder nein");
                } else {
                    this.send(pClientIP, pClientPort, "Bitte gebe eine Größe aus S;M;L;XL ein!");
                }
            }
            case "BESTÄTIGUNG" -> {
                if (pMessage.split(":")[1].equals("ja")) {
                    this.send(pClientIP, pClientPort, "Danke für deine Bestellung!");
                } else if (pMessage.split(":")[1].equals("nein")) {
                    this.send(pClientIP, pClientPort, "Du wirst nun abgemeldet und deine Daten werden gelöscht!");
                    this.closeConnection(pClientIP, pClientPort);
                } else {
                    this.send(pClientIP, pClientPort, "Bitte gebe ja oder nein ein!");
                }
            }
            case "ABMELDEN" -> {
                this.send(pClientIP, pClientPort, "Du wirst nun abgemeldet und deine Daten gelöscht!");
                this.closeConnection(pClientIP, pClientPort);
            }
            default -> this.send(pClientIP, pClientPort, "Bitte gebe eine valide Eingabe ein!");
        }



    }

    @Override
    public void processClosingConnection(String pClientIP, int pClientPort) {

    }

}
