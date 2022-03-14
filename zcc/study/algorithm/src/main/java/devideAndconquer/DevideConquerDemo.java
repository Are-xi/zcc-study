package devideAndconquer;

/**
 * 可使用分治法求解的一些经典问题
 *
 * （1）二分搜索
 * （2）大整数乘法
 * （3）Strassen矩阵乘法
 * （4）棋盘覆盖
 * （5）合并排序
 * （6）快速排序
 * （7）线性时间选择
 * （8）最接近点对问题
 * （9）循环赛日程表
 * （10）汉诺塔
 */
public class DevideConquerDemo {

    public static void main(String[] args) {
        int count = devideConquer(3,'a','b','c');
        System.out.println(count);
    }


    /**
     * 汉诺塔
     * @param num
     * @param a
     * @param b
     * @param c
     */
    static int count =0 ;
    public static int devideConquer(int num ,char a,char b ,char c){
        if (num <=0) return 0;


        if (num==1){
            System.out.println("第1个盘从"+a+"到"+c);
            count++;
        }else {
            devideConquer(num-1,a,c,b);
            System.out.println("第"+num+"个盘从"+a+"到"+c);
            count++;
            devideConquer(num-1,b,a,c);

        }

        return count;


    }

}
