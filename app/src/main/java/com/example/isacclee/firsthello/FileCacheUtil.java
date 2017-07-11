package com.example.isacclee.firsthello;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Swallow on 2017/7/10.
 * From http://www.jianshu.com/p/29491fbd8e05
 */

class FileCacheUtil {
    //定义缓存文件的名字，方便外部调用
    static final String docCache = "docs_cache.txt";//缓存文件
    //缓存超时时间
    private static final int CACHE_SHORT_TIMEOUT=1000 * 60 * 5; // 5 分钟

    /**设置缓存
     content是要存储的内容，可以是任意格式的，不一定是字符串。
     */
    static void setCache(String content, Context context, String cacheFileName, int mode) {
        FileOutputStream fos = null;
        try {
            //打开文件输出流，接收参数是文件名和模式
            fos = context.openFileOutput(cacheFileName,mode);
            fos.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //读取缓存，返回字符串（JSON）
    String getCache(Context context, String cacheFileName) {
        FileInputStream fis = null;
        StringBuilder sBuf = new StringBuilder();
        try {
            fis = context.openFileInput(cacheFileName);
            int len;
            byte[] buf = new byte[1024];
            while ((len = fis.read(buf)) != -1) {
                sBuf.append(new String(buf,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sBuf.toString();
    }

    private static String getCachePath(Context context) {
        return context.getFilesDir().getAbsolutePath();
    }

    //判断缓存是否过期,比较文件最后修改时间
    boolean cacheIsOutDate(Context context, String cacheFileName) {
        File file = new File(FileCacheUtil.getCachePath(context) + "/"
                + cacheFileName);
        //获取缓存文件最后修改的时间，判断是是否从缓存读取
        long date = file.lastModified();
        long time_out = (System.currentTimeMillis() - date);
        return time_out > FileCacheUtil.CACHE_SHORT_TIMEOUT;
    }
}
