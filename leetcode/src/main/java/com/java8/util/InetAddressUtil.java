package com.java8.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * @Author: zhoux
 * @Email: zhouxiang@souche.com
 * @CreateDate: 2019/1/7
 * @Description: 网络地址处理
 * @Modify :
 */
public class InetAddressUtil {

    /**
     * 获取服务器公网地址，未配置返回空
     */
    public static String getPublicAddress() {
        Enumeration <NetworkInterface> networks = null;
        try {
            networks = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        if (null == networks) {
            return "";
        }
        while (networks.hasMoreElements()) {
            NetworkInterface netWork = networks.nextElement();
            Enumeration <InetAddress> ips = netWork.getInetAddresses();
            while (ips.hasMoreElements()) {
                InetAddress ip = ips.nextElement();
                if (!ip.isSiteLocalAddress() && !ip.isLoopbackAddress()
                    && ip.getHostAddress().indexOf(":") == -1) {
                    return ip.getHostAddress();
                }
            }
        }
        return "";
    }

    /**
     *
     * @return
     */
    public static String getIntranetAddress() {
        Enumeration <NetworkInterface> networks = null;
        try {
            networks = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        if (null == networks) {
            return "";
        }
        while (networks.hasMoreElements()) {
            NetworkInterface netWork = networks.nextElement();
            Enumeration <InetAddress> ips = netWork.getInetAddresses();
            while (ips.hasMoreElements()) {
                InetAddress ip = ips.nextElement();
                if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress()
                    && ip.getHostAddress().indexOf(":") == -1) {
                    return ip.getHostAddress();
                }
            }
        }
        return "";
    }



    public static void main(String[] args) {
        System.out.println(getIntranetAddress());
    }

}
