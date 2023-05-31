package com.example.demo8.ww;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;

/**
 * @author : msb-zhaoss
 */
public class ServerThread   implements Runnable  {//线程：专门处理客户端的请求
    private final static Logger LOGGER = LoggerFactory.getLogger(SocketServer.class);
    Socket socket;
    BufferedReader reader;
    BufferedWriter writer;

/*    public ServerThread(Socket socket) {
        super();
        this.socket = socket;
    }*/
    public ServerThread(Socket socket){
        this.socket = socket;
    }
    public void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));//读取客户端消息
            writer=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));//向客户端写消息
            String lineString="";

            while(!(lineString=reader.readLine()).equals("bye")){
                System.out.println("run tianwei---");
                LOGGER.info("收到来自客户端的发送的消息是：" + lineString);
                writer.write("服务器返回："+lineString+"\n");
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
