package com.leetcode.array;

import com.sun.tools.javac.util.ArrayUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author: zhoux
 * @Email: zhouxiang@souche.com
 * @CreateDate: 2018/7/2
 * @Description:
 * @Modify :
 */
public class SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList <>();
        if(null == s || null == words || s.length() ==0 || words.length == 0) return result;

        Integer wordLen = 0;
        for (String word:words) {
            wordLen+=word.length();
        }
        if(wordLen>s.length()) {
            return result;
        }

        //生成单词组合
        List <String> list = createWord(null, Arrays.asList(words),len(words.length));
        Set<Integer> set = new TreeSet<Integer>();
        for (String str: list) {
            int num = 0;
            int fastIndex = s.indexOf(str);
            String compareS = s;
            while (fastIndex>=0){
                num += fastIndex;
                set.add(num);
                compareS = compareS.substring(str.length()+num);
                fastIndex = compareS.indexOf(str);
            }
        }
        result.addAll(set);
        return result;
    }

    private List<String> createWord(List<String> oldresult, List<String> words,int count){
        List<String> result = new ArrayList <>();
        if(null == oldresult||oldresult.isEmpty()){
            oldresult = new ArrayList <>();
            for (String l:words) {
                result.add(l);
            }
        }else{
            for (String oldWord: oldresult) {
                for (String world :words) {
                    if(!oldWord.contains(world)){
                        result.add(oldWord+world);
                    }
                }
            }
            oldresult.clear();
        }
        if(result.size() == count) {
            for (String oldWord : result) {
                boolean flag=false;
                for (String world : words) {
                    if (!oldWord.contains(world)||flag) {
                        oldresult.add(oldWord + world);
                    }
                }
            }
            return oldresult;
        }else {
            return createWord(result,words,count);
        }
    }

    private String createWord(String str, List<String> list){

        return null;
    }

    private Integer len(int size){
        if(size>1){
            return size * len(size-1);
        }else{
            return size;
        }

    }

    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords test = new SubstringWithConcatenationOfAllWords();
        test.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"});
    }



/**
 * "wordgoodgoodgoodbestword"
 ["word","good","best","word"]
 */
}
