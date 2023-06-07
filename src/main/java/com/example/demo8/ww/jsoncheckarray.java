package com.example.demo8.ww;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;


/**
 * @Auther: TianWei_18811580953
 * @Date: 2023/6/1 - 06 - 01 - 19:44
 * @Description: com.example.demo8.ww
 * @version: 1.0
 */
// 1. 检查json格式的正确性  2.将美化前的json压缩成字符串  3.解决大json无法压缩的问题
//针对json数组
public class jsoncheckarray {
    //这是一个main方法，是程序的入口:
    public static void main(String[] args) {
        // 指定磁盘，例如E盘
        File file = new File("F:\\testjson\\yaodudejson.txt");
        BufferedReader reader = null;
        //JavaBean对象转json字符串
        //JSONObject jsonObject = JSONObject.fromObject(result1);
        // 需要写入磁盘的字符串
        String stringToWrite = "这是需要写入磁盘的字符串 tianwei ";
        // 指定写入磁盘的文件路径
        String diskPath = "F:\\testjson\\tianweijsonout.txt";
        String folderPath = "F:\\testjson"; // 替换为你想要创建的文件夹路径
        File folder = new File(folderPath);
        Charset charset = Charset.forName("UTF-8"); // 指定编码格式
        if (!folder.exists()) {
            boolean created = folder.mkdirs(); // 创建文件夹
            if (created) {
                System.out.println("文件夹创建成功！");
            } else {
                System.out.println("文件夹创建失败！");
            }
        } else {
            System.out.println("文件夹已经存在！");
        }
        try {
            // 创建BufferedReader对象
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
            // 定义变量保存读取到的每一行内容
            String line = null;
            StringBuilder strBuilder = new StringBuilder();
            BufferedWriter writer = null;
            // 循环读取每一行内容
            while ((line = reader.readLine()) != null) {
                strBuilder.append(line);
                // 输出读取到的内容
                //System.out.println(line);
            }
            // 创建FileWriter对象，并指定写入磁盘的文件路径和文件名
            FileWriter fileWriter = new FileWriter(diskPath, true);
            //writer = new BufferedWriter(fileWriter, 1024*1024);
            // 创建BufferedWriter对象，并设置编码格式和缓存区大小
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(diskPath), true), StandardCharsets.UTF_8));
            //System.out.println("strBuilder = " + strBuilder);
            // 将字符串写入文件
            String ss = strBuilder.toString();
            //转为json对象
            JSONArray jsonArray1 = JSONArray.fromObject(ss);
            String s33 = jsonArray1.toString();
            System.out.println("s33 = " + s33);
            writer.write(s33);
            writer.newLine(); // 换行
            writer.close();

            System.out.println("字符串已经成功写入磁盘!: " + diskPath);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭BufferedReader对象
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
