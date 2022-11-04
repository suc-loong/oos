package com.hctel.oos;

import com.hctel.oos.netconf.utils.ODLNetconfChannelUtils;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/10/26 16:58
 * @Version 0.1.0
 */
public class StringTest {

    public String isMatch(String str, String sub) {
        int length = sub.length();
        for (int i = 0; i <= (str.length() - sub.length()); i++) {
            // 实际实现是每个字符串做字符比较 ，需要循环子串
            if (str.substring(i, i + sub.length()).equals(sub)) {
                System.out.println("匹配开始 位置：" + i);
                System.out.println("匹配最末位置：" + (i + sub.length() - 1));
                return str.substring(i + sub.length(), str.length());

            }
        }
        return null;
    }

    @Test
    public void t1() {
        String t1 = "EQ=/shelf=1/slot=1/subslot=1/EQ=PWDC";
            String match = isMatch(t1, "/slot=");
        //得到索引的位置
        int index = match.indexOf("/");
        // 获取第一个"_"前面所有字符
        String slot = match.substring(0, index);
        System.out.println(slot);
    }

    @Test
    public void testJson() {

        String customerAddress = "城西-4号楼-1-0801";
        //得到索引的位置
        int index = customerAddress.indexOf("-");
        // 获取第一个"_"前面所有字符
        String communityName = customerAddress.substring(0, index);
        //获取第一个"_"后面所有字符
        String roomCode = customerAddress.substring(index + 1);


        //获取第二个"_"及后面所有字符，举例：

        String a = "abc_def_Ghi";
        String str3 = a.substring(a.indexOf("_", a.indexOf("_") + 1));//包含本身位置
        System.out.println("第二个_及后面字符串为：" + str3);//_Ghi
        //获取第二个"_"前面所有字符，举例：

        String a1 = "abc_def_Ghi";
        String str4 = a1.substring(0, a1.indexOf("_", a1.indexOf("_") + 1));//不包含本身位置
        System.out.println("第二个_前面字符串为：" + str4);//abc_def
    }

    @Test
    public void testUrl(){
        ODLNetconfChannelUtils odlNetconfChannelUtils = new ODLNetconfChannelUtils();
//        odlNetconfChannelUtils.getMixUrl(null,null,null);
//        odlNetconfChannelUtils.getMixUrl("hclink",null,null);
//        odlNetconfChannelUtils.getMixUrl("kc","acc-pp:mm","all");
        odlNetconfChannelUtils.getMixUrl("hclink3",null,"all");
    }
}
