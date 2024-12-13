import utils.Client;

import javax.swing.JOptionPane;


public class QOTDCLient extends Client {
    public QOTDCLient(String pServerIP) {
        super(pServerIP, 17);
    }

    public void processMessage(String pMessage) {
        JOptionPane.showMessageDialog(null,"Server sendet:\n" + pMessage);
    }

    public static void main(String[] args) {
        QOTDCLient dtc = new QOTDCLient("djxmmx.net");
    }
}