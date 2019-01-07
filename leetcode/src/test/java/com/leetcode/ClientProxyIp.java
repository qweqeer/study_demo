package com.leetcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;

/**
 * @Author: zhoux
 * @Email: zhouxiang@souche.com
 * @CreateDate: 2018/10/19
 * @Description:
 * @Modify :
 */
public class ClientProxyIp {

    static  HashMap<String,String> map = new HashMap <>();

    static {
        map.put("58","58.com");
        map.put("che168","icloud.che168.com");
        map.put("taoche","taoche.com");
    }

    private void forMattFileData(String filePath,String savePath) throws IOException {
        File file = new File(filePath);
        File savefile = new File(savePath);
        if(file.isDirectory()||!file.exists()){
            throw new RuntimeException("文件不存在或为文件夹");
        }
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        FileWriter fw = new FileWriter(savefile);
        BufferedWriter bw = new BufferedWriter(fw);

        String lineStr=br.readLine();
        while (null != lineStr && lineStr.length()>0){
            IpBean ipBean = lineLog(lineStr);
            String str = ipBean.toString()+"\r\n";
            bw.write(str);
            bw.flush();
            lineStr = br.readLine();
        }
        try {
            bw.close();
            br.close();
        }catch (Exception e){

        }

    }

    private IpBean lineLog(String str){
       String[] cloumns=str.split(",");
       String imageUrl = "";
       if(cloumns.length>1){
           imageUrl = cloumns[cloumns.length-1].substring("Screenshot:".length());
       }
        String ip = "";
        String[] clu2 = cloumns[0].split(" ");
        ip=clu2[clu2.length-1].substring(3);
        String time = clu2[1]+" "+clu2[2];
        String domain = clu2[8].substring(2);
        return new IpBean(time,map.get(domain),ip,imageUrl);
    }

    public static void main(String[] args) {
//        String strlog =  "[SYNC] 2018-10-18 23:42:31.702 [pool-2-thread-31][com.souche.sync.simulation.SimulatePushCarServiceTaocheDealerNewImpl-1667] DEBUG -  uid:d765ead38c9d483bb578592f30cb999e p:taoche carId:b6604403cd50440381e7cace96aec2a4 acc: net proxy ip happend a error! ip:117.63.127.30";
        ClientProxyIp client = new ClientProxyIp();
        try{
            client.forMattFileData("/Users/dasouche/Downloads/client_proxy_ips.txt","/Users/dasouche/Downloads/ips.txt");
        }catch (Exception e){

        }

    }




    class IpBean{
        private String userTime;

        private String domain;

        private String ip;

        private String image;

        public IpBean(String userTime, String domain, String ip, String image) {
            this.userTime = userTime;
            this.domain = domain;
            this.ip = ip;
            this.image = image;
        }

        @Override
        public String toString() {
            return String.format("使用时间:%s, 平台地址:%s, ip:%s, 截图:%s",userTime,domain,ip,image);
        }
    }

}
