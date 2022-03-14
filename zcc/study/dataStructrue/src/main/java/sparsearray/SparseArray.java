package main.java.sparsearray;

//课后练习，将稀疏数组保存到磁盘上，比如map.data，在从磁盘删读取进行恢复

//二维数据与稀疏数组
public class SparseArray {

    public static void main(String[] args) {
        //创建一个原始的二维数组
        //0表示该位置没有棋子，1表示该位置有棋子
        int chessArr1[][]  = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 1;
        for (int[] row : chessArr1){
            for (int data: row){
                System.out.print(data+" ");
            }
            System.out.println();
        }

        //将二维数组转换成稀疏数组

        //1、先统计出二维数组中1的个数；
        int num = 0;
        for (int i=0;i<11;i++){
            for (int j =0;j<11;j++){
                if (chessArr1[i][j]>0) num++;
            }
        }

        //2、创建稀疏数组
        int sparseArr[][] = new int[num+1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = num;

        int n = 0;
        for (int i=0;i<11;i++){
            for (int j=0;j<11;j++){
                if (chessArr1[i][j]>0){
                    n++;
                    sparseArr[n][0] = i;
                    sparseArr[n][1] = j;
                    sparseArr[n][2] = chessArr1[i][j];
                }
            }
        }

        for (int[] row : sparseArr){
            for (int data: row){
                System.out.print(data+" ");
            }
            System.out.println();
        }


        //将稀疏数组转换成二维数组
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1;i<sparseArr.length;i++){
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        for (int[] row : chessArr2){
            for (int data: row){
                System.out.print(data+" ");
            }
            System.out.println();
        }


    }














}
