package com.gcl.query.utils;

import java.io.*;

//封装读取图片的流
public class ImageUtil {
    //1.读取本地图片获取输入流
    public static FileInputStream readImage(String path) throws FileNotFoundException {
        return new FileInputStream(new File(path));
    }
    //2.读取表中图片获取输出流
    public static void readBin2Image(InputStream in, String targetPath) throws FileNotFoundException {
        File file=new File(targetPath);
        //subString(int begin,int end)表示返回一个新字符串，
        // 它是此字符串的一个子字符串。
        // 该子字符串从指定的 begin处开始， endIndex:到指定的 endI-1处结束。
        String path=targetPath.substring(0,targetPath.lastIndexOf("/"));
        if(!file.exists()){
            new File(path).mkdir();
        }
        FileOutputStream fos=null;
        try{
            fos=new FileOutputStream(file);
            int len=0;
            byte[] buf=new byte[1024];
            while((len=in.read(buf)) !=-1){
                fos.write(buf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
