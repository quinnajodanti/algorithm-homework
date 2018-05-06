package org.buaa.algorithm;

import java.util.Random;

public class BellmanFord {

    /**
     * 随机生成权值-5-20的边
     *
     * @param vertexNumber 图顶点数
     * @return 矩阵存储的图
     */
    public static int[][] getGraph(int vertexNumber) {
        int[][] graph = new int[vertexNumber][vertexNumber];
        Random random = new Random();
        for (int i = 0; i < vertexNumber; i++) {
            for (int j = 0; j < vertexNumber; j++) {
                if (i == j)
                    graph[i][j] = 0;
                else{
                    graph[i][j] = random.nextInt(26)-5;
//                    若随机到0改为最大值(不可达)
                    if(graph[i][j]==0)
                        graph[i][j]=Integer.MAX_VALUE;
                }
                System.out.print(graph[i][j] + "\t");
            }
            System.out.println();
        }
        return graph;
    }

    public static void bellmanFord(int graph[][]) {
        int vertexNumber = graph[0].length;
        int min[] = new int[vertexNumber];
//        初始化
        int path[][] = new int[vertexNumber][vertexNumber];
        for (int i = 0; i < vertexNumber; i++) {
            for (int j = 0; j < vertexNumber; j++) {
                path[i][j] = Integer.MAX_VALUE;
            }
            min[i] = Integer.MAX_VALUE;
        }
        path[0][0] = 0;
        min[0] = 0;
//        松弛
        for (int i = 0; i < vertexNumber; i++) {
            for (int j = 0; j < vertexNumber; j++) {
                //保证不是不可达.不然加起来是min溢出变成极小的复数
                if (min[j] > min[i] + graph[i][j]&&graph[i][j]!=Integer.MAX_VALUE)
                    min[j] = min[i] + graph[i][j];
            }
        }
//        判断是否有负环
        boolean judge = false;
        for (int i = 0; i < vertexNumber; i++) {
            for (int j = 0; j < vertexNumber; j++) {
                if (min[j] > min[i] + graph[i][j])
                    judge = true;
            }
        }
        if (judge) System.out.println("图中有负环路，无法确定最短路径");
        else {
            System.out.println("最短路径");
            for (int i = 0; i < vertexNumber; i++) {
                System.out.print("\t" + min[i]);
            }
        }
    }

    public static void main(String[] args) {
        bellmanFord(getGraph(3));
    }

}
