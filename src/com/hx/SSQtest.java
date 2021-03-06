package com.hx;

import java.util.ArrayList;
import java.util.Random;

public class SSQtest {
    public static void main(String[] args) {

        /*
        //获取质数
        for (int i = 2; i <= 10; i++) {
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.print(" " + i);
            }
        }*/
//        Random random = new Random();
//        System.out.println(random.nextInt(16));

//        System.out.println("这是：");

//        getzs(100);

        /*for(int i=0;i<100000;i++){
            if(i%){

            }
        }*/


        getssq();
    }

    /*
    求质数个数
     */
    public static void getzs(int n){
        long start = System.currentTimeMillis();    //取开始时间
        //素数总和
        int sum = 0;
        //1000万以内的所有素数
        //用数组将1000万以内的数分为两大派系，素数用0代替数值，合数用1代替数值；
        //一开始默认全部为素数，所以值全部为0，等到开始筛选的时候再把为合数的赋值为1
        int num[] = new int[n];
        num[0] = 1;          //由于1规定不是素数，所以要提前用1标值
        //根据埃氏筛法的结论，要得到自然数  N 以内的全部素数，必须把不大于" 二次根号  N "的所有素数的倍数剔除，剩下的就是素数
        double prescription = Math.sqrt(n);
        for (int i = 2; i <= prescription; i++) {
            //开始把所有素数的倍数剔除，剩下的就是素数
            for (int j = i*i; j <= n; j+=i) {
                //从i*i开始去除，因为比i*i小的倍数，已经在前面去除过了
                //例如：i=5
                //5的2倍（10），3倍（15），在i=2的时候，已经去除过了

                num[j-1] = 1;   //把素数的倍数剔除，也就是赋值为1，不是素数就是合数
            }
        }
        //遍历数组，把值为0的数全部统计出来，得到素数之和
        for (int i = 0; i < num.length; i++) {
            if(num[i]==0)
                sum++;
        }
        System.out.println(n+"以内的素数有"+sum+"个");
        long end = System.currentTimeMillis();
        System.out.println("The time cost is " + (end - start));
        System.out.println("");
    }

    /*
    双色球算法
     */
    public static void getssq(){
        // 获取红球
        ArrayList<Integer> redBalls = getBalls(1, 33, 6);

        // 获取蓝球
        ArrayList<Integer> buleBalls = getBalls(1, 16, 1);

        // 打印输出
        System.out.println("本期中奖号码为：" + redBalls + ", " + buleBalls);
    }


    private static ArrayList<Integer> getBalls(int min, int max, int size) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<Integer> stores = new ArrayList<Integer>();
        for (int i = min; i <= max; i++) {
            stores.add(i);
        }

        for (int i = 0; i < size; i++) {
            int index = getRandomIndex(stores.size() - i);
            result.add(stores.get(index));
            swapNumbers(stores, index, stores.size() - i - 1);
        }

        return result;
    }

    private static int getRandomIndex(int max) {
        Random random = new Random(System.currentTimeMillis());
        return random.nextInt(max);
    }

    private static void swapNumbers(ArrayList<Integer> stores, int index, int last) {
        int tmp = stores.get(index);
        stores.set(index, stores.get(last));
        stores.set(last, tmp);
    }
}
