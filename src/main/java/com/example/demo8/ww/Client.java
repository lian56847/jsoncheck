package com.example.demo8.ww;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @Auther: TianWei_18811580953
 * @Date: 2023/5/26 - 05 - 26 - 11:01
 * @Description: com.ruoyi.device.controller
 * @version: 1.0
 */
public class Client {
    public static void main(String[] args) {
        Client client=new Client();
        client.startAction();
    }

    void readSocketInfo(BufferedReader reader){
        new Thread(new MyRuns(reader)).start();
    }

    class MyRuns implements Runnable {

        BufferedReader reader;

        public MyRuns(BufferedReader reader) {
            super();
            this.reader = reader;
        }

        public void run() {
            try {
                String lineString="";
                while( (lineString = reader.readLine())!=null ){
                    System.out.println(lineString);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void startAction(){
        Socket socket=null;
        BufferedReader reader=null;
        BufferedWriter writer=null;
        BufferedReader reader2=null;
        try {
            System.out.println("tianwei  Client");
            socket=new Socket("127.0.0.1", 8889);
            reader = new BufferedReader(new InputStreamReader(System.in));
            reader2=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            readSocketInfo(reader2);
            String lineString="";
            while(!(lineString=reader.readLine()).equals("exit")){
                System.out.println("while---");
                writer.write(lineString+"\n");
                writer.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader!=null) {
                    reader.close();
                }
                if (writer!=null) {
                    writer.close();
                }
                if (socket!=null) {
                    socket.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

}
