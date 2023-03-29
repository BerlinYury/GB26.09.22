package Java2.lesson4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ChatClient {
    Socket socket;
    DataInputStream in;
    DataOutputStream out;
    WindowClient windowClient;
    private static final String HOST = "localhost";

    public ChatClient(WindowClient windowClient) {
        this.windowClient = windowClient;
        openSocketClient();
    }

    public void openSocketClient() {
        try {
            System.out.println("Клиент пытается подключиться");
            socket = new Socket(HOST, ChatServer.getPORT());
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            Thread threadClient = new Thread(() -> {
                try {
                    while (true) {
                        String msg = in.readUTF();
                        if (ChatServer.getEND().equals(msg)) {
                            out.writeUTF(msg);
                            break;
                        }
                        windowClient.addMessage("Server: "+msg);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    closeConnection();
                }
            });
            threadClient.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeConnection() {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Клиент закрыт");
        System.exit(0);
    }

    public void sendMessage(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
