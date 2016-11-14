package com.hard.hardbase.utils;

import java.io.*;
import java.nio.Buffer;

/**
 * <h3></h3>
 * Created by root on 2016/11/11.
 */
public class FileUtils {

    private static final String TAG = "FileUtils";

    /**
     * 向文件中写入数据,如果文件存在，先删除再创建。
     * @param fileName 文件名
     * @param content 要写入的内容
     * note:适用于二进制文件，不支持中文字符
     */
    public static void writeBytes(String fileName, String content){
        try {
            //如果存在，删除原文件
            File file = new File(fileName);
            if (file.exists()) {
                file.delete();
            }

            // 打开一个随机访问文件流，按读写方式
            RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
            randomFile.writeBytes(content);
            randomFile.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 追加文件：使用RandomAccessFile
     * @param fileName 文件名
     * @param content 追加的内容
     * note:适用于二进制文件，不支持中文字符
     */
    public static void appendBytes(String fileName,String content){
        try {
            // 打开一个随机访问文件流，按读写方式
            RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            //将写文件指针移到文件尾。
            randomFile.seek(fileLength);
            randomFile.writeBytes(content);
            randomFile.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 按指定的字节数读取文件
     * @param fileName 文件名
     * @param length 读取的长度
     */
    public static byte[] readFileByByte(String fileName, int length){

        byte buffer[] = new byte[length];
        try {
            FileInputStream inputStream = new FileInputStream(fileName);
            inputStream.read(buffer, 0, length);
            inputStream.close();
        }catch (IOException e){
            e.printStackTrace();
            Log.e(TAG, "read file " + fileName + "failed.");
        }

        return buffer;
    }
}
