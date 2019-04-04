package com.example.mvpdemo.network;

public class ApiService {

    /**
     * 测试环境与正式环境切换
     */
    private static boolean isDebug = true;

    /**
     * 测试服务器地址
     */
    public static final String DEBUG_URL = "http://172.16.14.67:8080/";

    /**
     * 正式服务器地址
     */
    public static final String RELEASE_URL = "";

    /**
     * 服务器域名
     */
    public static final String BASE_URL = isDebug ? DEBUG_URL : RELEASE_URL;
}
