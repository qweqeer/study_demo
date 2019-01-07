package com.leetcode;

import com.java8.util.ResolverXlsxsheet2Util;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @Author: zhoux
 * @Email: zhouxiang@souche.com
 * @CreateDate: 2018/8/21
 * @Description:
 * @Modify :
 */
public class CreateUpdateSql {

    public static final List<String> tables = new ArrayList <>();
//    public static final Map<String,String> storeMap = new HashMap <>();
    public static final List<String> list = new ArrayList <>();

    public static final String sqlFormatter = "update %s set store='%s' where  store = '%s';";
    static {
        tables.add("synchronous_bind_user");
        tables.add("synchronous_car_new");
        tables.add("synchronous_car_valid");
        tables.add("synchronous_car_new_bak");
        tables.add("synchronous_car_valid_bak");
        tables.add("synchronous_contact_info");
        tables.add("synchronous_store");
        tables.add("synchronous_white_list");
        tables.add("synchronous_platform_info");
        tables.add("synchronous_second_car_valid");
        tables.add("synchronous_manage");
        tables.add("synchronous_manage_bak");
        //key oldKey; value newKey
    }

    public static void main(String[] args) {
        System.out.println("#####tables size:"+tables.size());
        HashMap<String,String> storeMap = ResolverXlsxsheet2Util
            .getStoreMap("/Users/dasouche/Downloads/2018-09-25弹个车店铺迁移结果_汇总.xls");
        Set <Entry <String, String>> maps = storeMap.entrySet();
        List<String> result = new ArrayList <>();
        for (String table : tables) {
            System.out.println("#####create update sql:"+table);
            maps.forEach(item ->{
                result.add(String.format(sqlFormatter,table,item.getValue(),item.getKey()));
            });
        }
        System.out.println("#####create sql over");
        System.out.println("#####sql number:"+result.size());
        try{
            File file = new File("/Users/dasouche/Downloads/store.sql");
            FileWriter fw = new FileWriter(file);
            for (String s : result) {
                fw.write(s+"\r\n");
                fw.flush();
            }
            System.out.println("执行完成。。。");
        }catch (Exception e){

        }

    }

    public static void main2(String[] args) {
        Long number = Long.valueOf("01312570");
        String strFormat = "storeMap.put(\"%s\",\"%s\");";
        for (String s : list) {
            String str = getStr(number);
            System.out.println(String.format(strFormat,s.trim(),str));
            number++;
        }

    }

    private static String getStr(Long number){
        String str = number.toString();
        for (int i = 0; i<=8-str.length();i++){
            str = String.format("0%s",str);
        }
        return str;
    }


    public static String insertSql(){
        return null;
    }
}
