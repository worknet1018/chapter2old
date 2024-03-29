package org.smart4j.chapter2.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropsUtil {
    private static final Logger LOGGER= LoggerFactory.getLogger(PropsUtil.class);

    /**
     * 加载属性文件
     */
    public static Properties loadProps(String fileName){
        Properties props=null;
        InputStream is=null;
        try{
            is=Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if (is==null){
                throw new FileNotFoundException(fileName+"file not found");
            }
            props=new Properties();
            props.load(is);
        } catch (IOException e){
            LOGGER.error("load properties file failure",e);
        } finally {
            {
                if (is !=null){
                    try {
                        is.close();
                    }catch (IOException e){
                        LOGGER.error("load input stream failure",e);
                    }
                }
            }
        }
        return props;
    }
    public static String getString(Properties props,String key,String defaultValue){
        String value=defaultValue;
        if(props.containsKey(key)){
            value=props.getProperty(key);
        }
        return value;
    }
    public  static int getInt(Properties props,String key){
        return getInt(props,key,0);
    }
    public static int getInt(Properties props,String key,int defaultValue){
        int value=defaultValue;
        if(props.containsKey(key)){
            value=CastUtil.castInt(props.getProperty(key));
        }
        return  value;
    }
}
