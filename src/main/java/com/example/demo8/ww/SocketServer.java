package com.example.demo8.ww;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * @Auther: TianWei_18811580953
 * @Date: 2023/5/26 - 05 - 26 - 10:57
 * @Description: com.ruoyi.device.controller
 * @version: 1.0
 */
public class SocketServer {
    private final static Logger LOGGER = LoggerFactory.getLogger(SocketServer.class);
    //这是一个main方法，是程序的入口：
    public static void main(String[] args) {
        System.out.println("服务器启动了");
        //1.创建套接字： 指定服务器的端口号
        ServerSocket  serverSocket=null;
        Socket socket= null;
        int count = 0;//定义一个计数器，用来计数  客户端的请求
        try {
            System.out.println("tainwei SocketServer");
            serverSocket=new ServerSocket(Constants.SOCKET_PORT);  //端口号
            LOGGER.info("服务端服务启动监听：");
            //通过死循环开启长连接，开启线程去处理消息
            while(true){
                   socket=serverSocket.accept();
                new  Thread(new ServerThread(socket)).start();
               // new Thread(new MyRuns(socket)).start();
                count++;
                System.out.println("当前是第"+count+"个用户访问我们的服务器,对应的用户是："+socket.getInetAddress());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket!=null) {
                    serverSocket.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    public void startAction(){


    }



}
