package com.dream.tea.service.config.db;

/**
 * @author liyongfa
 */
public class DataSourceContentHolder {

    private static final ThreadLocal<String> HOLDER=new ThreadLocal<>();

    public static void setCurrentDataSource(String dataSource){
        HOLDER.set(dataSource);
    }

    public static String getCurrentDataSource(){
        return HOLDER.get();
    }

    public static void clear(){
        HOLDER.remove();
    }
}
