package kmp;

/**
 * 是一种改进的字符串模式匹配算法，可以在O(n+m)的时间复杂度以内完成字符串的匹配操作，
 * 其核心思想在于：当一趟匹配过程中出现字符不匹配时，
 * 不需要回溯主串的指针，而是利用已经得到的“部分匹配”，将模式串尽可能多地向右“滑动”一段距离，然后继续比较。
 */
public class KpmDemo {

    public static void main(String[] args) {

        String s1 = "abaacababcac";
        String s2 = "ababc";
        int d = kmpSearch(s1,s2);
        System.out.println(d);
    }

    //暴力匹配
    public static int boali(String str1,String str2){
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        int i = 0;
        int j = 0;
        while (i<chars1.length && j<chars2.length){

            if (chars1[i] == chars2[j]){
                i++;
                j++;
            }else {
                i++;
            }

            if (j== chars2.length-1){
                return i-j;
            }
        }

        return -1;
    }

    /**
     * kmp匹配
     * 1、找出部分匹配值
     * “部分匹配值”就是”前缀”和”后缀”的最长的共有元素的长度
     * 2、匹配
     */

    public static int[] getNext(char[] chars){

        int[] next = new int[chars.length];

        next[0] = 0;
        int i,len;
        i = 1;
        len = 0;

        while (i<chars.length){
            if (chars[i] == chars[len]){
                len++;
                next[i] = len;
                i++;
            }else {
                if (len>0){
                    len = next[len-1];
                }else {
                    next[i] = 0;
                    i++;
                }
            }
        }


        return next;
    }

    /**
     * 为了方便后面kmp算法代码的实现，将前缀值表整体后移一位，第一位赋值为-1
     */
    public static int[] move(int[] a){
        for(int i=a.length-1;i>0;i--){
            a[i]=a[i-1];
        }
        a[0]=-1;
        return a;
    }

    public static int kmpSearch(String str1,String str2){
        if(str1==null||str2==null){
            return -1;
        }
        char[] ch1=str1.toCharArray();
        char[] ch2=str2.toCharArray();
        int [] prefix=move(getNext(str2.toCharArray()));

        int length1=ch1.length;
        int length2=ch2.length;

        int i=0,j=0;

        while(i<length1&&j<length2){
            if(ch1[i]==ch2[j]){
                i++;
                j++;
            }else{
                j=prefix[j];
                if(j==-1){
                    i++;
                    j++;
                }
            }
        }
        if(j==length2){
            return i-j;
        }else{
            return -1;
        }
    }



}
