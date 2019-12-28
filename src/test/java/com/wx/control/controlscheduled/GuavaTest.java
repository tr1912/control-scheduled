package com.wx.control.controlscheduled;

import com.google.common.collect.Lists;
import com.wx.control.controlscheduled.utils.EmojiUtil;

import java.util.ArrayList;
import java.util.List;

public class GuavaTest {

    public static void main(String[] args){
//        List<String> sourceList = new ArrayList<>();
//        for (int i = 0; i < 3001; i++) {
//            sourceList.add(String.valueOf(i));
//        }
//
//        List<List<String>> partition = Lists.partition(sourceList, 1000);
//
//        System.out.println(partition);

        String res = "🧠来个老紫";

        String res1 = EmojiUtil.emojiConvert(res);
        String s = EmojiUtil.emojiConvert1(res);

        String s1 = EmojiUtil.emojiRecovery(res1);
        String s2 = EmojiUtil.emojiRecovery2(res1);

        System.out.println(s2);
        System.out.println(s1);
        System.out.println(s);
        System.out.println(res1);

    }

}
