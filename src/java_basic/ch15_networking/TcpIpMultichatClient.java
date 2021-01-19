package java_basic.ch15_networking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TcpIpMultichatClient {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("USAGE: java TcpIpMultichatClient 대화명");
            System.exit(0);
        }

        try {
            String serverIp = "127.0.0.1";
            Socket socket = new Socket(serverIp, 7777);
            System.out.println("서버에 연결되었습니다.");
            Thread sender = new Thread(new ClientSender(socket, args[0]));
            Thread receiver = new Thread(new ClientReceiver(socket));

            sender.start();
            receiver.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientSender extends Thread {

        private Socket socket;
        private DataOutputStream out;
        private String name;

        ClientSender(Socket socket, String name) {
            this.socket = socket;
            this.name = name;
        }

        @Override
        public void run() {
            Scanner sc = new Scanner(System.in);
            try {
                if (out != null) {
                    out.writeUTF(name);
                }

                while (out != null) {
                    out.writeUTF("[" + name + "]" + sc.nextLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class ClientReceiver extends Thread {
        private Socket socket;
        private DataInputStream in;

        public ClientReceiver(Socket socket) {
            this.socket = socket;
            try {
                in = new DataInputStream(socket.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            while (in != null) {
                try {
                    System.out.println(in.readUTF());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
