package com.hx.NLP;

public class OneTest {
    public static void main(String[] args) {
        int i= EditDistance("致22死28伤 内蒙古银漫矿业“2·23”重大事故22人获刑","内蒙古银漫矿业22人获刑 致22死28伤 “2·23”重大事故");
        System.out.println(i);
    }

    /**
     * 采用动态规划的方法（字符串匹配相似度）
     * @param source 源c
     * @param target 要匹配的字符串
     * @return
     */
    public static int EditDistance(String source, String target) {
        char[] sources = source.toCharArray();
        char[] targets = target.toCharArray();
        int sourceLen = sources.length;
        int targetLen = targets.length;
        int[][] d = new int[sourceLen + 1][targetLen + 1];
        for (int i = 0; i <= sourceLen; i++) {
            d[i][0] = i;
        }
        for (int i = 0; i <= targetLen; i++) {
            d[0][i] = i;
        }

        for (int i = 1; i <= sourceLen; i++) {
            for (int j = 1; j <= targetLen; j++) {
                if (sources[i - 1] == targets[j - 1]) {
                    d[i][j] = d[i - 1][j - 1];
                } else {
                    //插入
                    int insert = d[i][j - 1] + 1;
                    //删除
                    int delete = d[i - 1][j] + 1;
                    //替换
                    int replace = d[i - 1][j - 1] + 1;
                    d[i][j] = Math.min(insert, delete) > Math.min(delete, replace) ? Math.min(delete, replace) :
                            Math.min(insert, delete);
                }
            }
        }
        return d[sourceLen][targetLen];
    }

}
