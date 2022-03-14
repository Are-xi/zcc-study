package dynamicprogramming;

/**
 * 01背包问题
 * (1) v[i][0]=v[0][j]=0; //表示 填入表 第一行和第一列是 0
 * (2) 当 w[i]> j时：v[i][j]=v[i-1][j] // 当准备加入新增的商品的容量大于 当前背包的容量时，就直接使用上一个 单元格的装入策略
 * (3) 当 j>=w[i]时： v[i][j]=max{v[i-1][j], v[i]+v[i-1][j-w[i]]}
 * // 当准备加入的新增的商品的容量小于等于当前背包的容量
 * // 装入的方式:
 * v[i-1][j]： 就是上一个单元格的装入的最大值
 * v[i] : 表示当前商品的价值
 * v[i-1][j-w[i]] ： 装入 i-1 商品，到剩余空间 j-w[i]的最大值
 * 当j>=w[i]时： v[i][j]=max{v[i-1][j], v[i]+v[i-1][j-w[i]]} :
 *
 *
 */
public class DynamicPlanDemo {

    public static void main(String[] args) {

        int[] weight = {1,4,3};
        int[] price = {15,30,20};
        int bag = 4;
        int a = dynamicPlan(weight,price,bag);


    }

    public static int dynamicPlan(int[] weight,int[] price,int bag){

        int[][] ints = new int[weight.length+1][bag+1];

        int[][] path = new int[weight.length+1][bag+1];

        for (int i=1;i<ints.length;i++){

            for (int j=1;j<ints[0].length;j++){

               if (weight[i-1]>j){
                   ints[i][j]= ints[i-1][j];
               }

               if (weight[i-1]<=j){

                   if (price[i-1]+ints[i-1][j-weight[i-1]]>ints[i-1][j]){

                       ints[i][j] = price[i-1]+ints[i-1][j-weight[i-1]];

                       path[i][j] = 1;

                   }else {
                       ints[i][j]=ints[i-1][j];
                   }

               }
            }
        }

        for (int[] ints1:ints){
            for (int i: ints1){
                System.out.print(i+" ");
            }
            System.out.println();
        }

        System.out.println("----------");
        for (int[] ints1:path){
            for (int i: ints1){
                System.out.print(i+" ");
            }
            System.out.println();
        }

        System.out.println("------------");
        int i = path.length-1;
        int j = path[0].length-1;
        while (i>0 && j>0){
            if (path[i][j]==1){
                System.out.println("第"+i+"个商品放入背包");
                j =j - weight[i-1];
            }
            i--;
        }

        return 0;
    }






}
