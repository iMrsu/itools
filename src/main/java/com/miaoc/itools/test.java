package com.miaoc.itools;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;


public class test{


    /**
     * @param htmlStr
     * @return
     *  删除Html标签
     *  用于短的数据，直接将文档复制粘贴，写入，但是每一个引号之前需要加“\”转义符，用起来不方便
     */
    public static String htmlDecodeByRegExp(String htmlStr) {
        if(StringUtils.isBlank(htmlStr)){
            return  " ";
        }
        String temp = "";
                    temp = htmlStr.replaceAll("&amp;","&");
                      temp = temp.replaceAll("&lt;","<");
                      temp = temp.replaceAll("&gt;",">");
                      temp = temp.replaceAll("&nbsp;"," ");
                      temp = temp.replaceAll("&#39;","\'");
                      temp = temp.replaceAll("&quot;","\"");

        return temp; // 返回文本字符串
    }



    public static void main(String[] args) {

        String str = "&lt;p&gt;&lt;img&nbsp;src=&quot;http://hasjwt.test.cairenhui.com/opration/um/umrightsbizicon/202007/D33AA598BFF643E8B8CDEEC1DF728F46.png&quot;&nbsp;title=&quot;智能选股内容@2x.png&quot;&nbsp;alt=&quot;智能选股内容@2x.png&quot;/&gt;&lt;/p&gt;";
        System.out.println(htmlDecodeByRegExp(str));
        System.out.println(StringEscapeUtils.unescapeHtml4(str));


    }
}
