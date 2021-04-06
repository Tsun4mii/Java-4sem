import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class GetUDP {
    private DatagramSocket socket;
    private byte[] messageUDP = new byte[10];

    public GetUDP(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }
    public void getMessages() throws IOException {
        socket.receive(new DatagramPacket(messageUDP,10));
        var message = new String(messageUDP);
        System.out.println(message);
    }

    public static void main(String[] args) throws IOException {
        GetUDP udpGet = new GetUDP(4321);
        while(true) {
            udpGet.getMessages();
        }
    }
}