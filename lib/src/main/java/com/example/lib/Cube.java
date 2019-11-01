package com.example.lib;

import java.util.Scanner;

public class Cube {
    private Scanner scanner = new Scanner(System.in);
    private float lowrightx_1,lowrighty_1,upleftx_1,uplefty_1;
    private float lowrightx_2,lowrighty_2,upleftx_2,uplefty_2;
    private float lowrightx_3,lowrighty_3,upleftx_3,uplefty_3;
    private float lowrightx_4,lowrighty_4,upleftx_4,uplefty_4;
    private float lowrightx_5,lowrighty_5,upleftx_5,uplefty_5;
    private float lowrightx_6,lowrighty_6,upleftx_6,uplefty_6;
    private float lowrightx_7,lowrighty_7,upleftx_7,uplefty_7;
    private float lowrightx_8,lowrighty_8,upleftx_8,uplefty_8;
    private float lowrightx_9,lowrighty_9,upleftx_9,uplefty_9;
    private float lowrightx_10,lowrighty_10,upleftx_10,uplefty_10;
    private float cube[] = {lowrightx_1,lowrighty_1,upleftx_1,uplefty_1,
            lowrightx_2,lowrighty_2,upleftx_2,uplefty_2,lowrightx_3,lowrighty_3,upleftx_3,uplefty_3,
            lowrightx_4,lowrighty_4,upleftx_4,uplefty_4,lowrightx_5,lowrighty_5,upleftx_5,uplefty_5,
            lowrightx_6,lowrighty_6,upleftx_6,uplefty_6,lowrightx_7,lowrighty_7,upleftx_7,uplefty_7,
            lowrightx_8,lowrighty_8,upleftx_8,uplefty_8,lowrightx_9,lowrighty_9,upleftx_9,uplefty_9,
            lowrightx_10,lowrighty_10,upleftx_10,uplefty_10};
    private float pointx_1,pointy_1,pointx_2,pointy_2,pointx_3,pointy_3,pointx_4,pointy_4,pointx_5,pointy_5;
    private float pointx_6,pointy_6,pointx_7,pointy_7,pointx_8,pointy_8,pointx_9,pointy_9,pointx_10,pointy_10;
    private float point[] = {pointx_1,pointy_1,pointx_2,pointy_2,pointx_3,pointy_3,pointx_4,pointy_4,pointx_5,pointy_5,
            pointx_6,pointy_6,pointx_7,pointy_7,pointx_8,pointy_8,pointx_9,pointy_9,pointx_10,pointy_10};
    private int cubeN=0,cubeC=0,pointN=0,pointC=0;


    public void makemoreCube(){
        System.out.println("請輸入 r 建立矩形(最多建立10個)，或輸入 e 結束");
        String s =scanner.next();
        while ((s.matches("r")!=true)&&(s.matches("e")!=true)){
            System.out.println("請輸入 r 建立矩形(最多建立10個)，或輸入 e 結束");
            s =scanner.next();
        }
        if(s.matches("r")){
            cubeN++;
            makeCube(cubeN,cubeC);
            cubeC+=4;
            makemoreCube();
        }
        else if(s.matches("e")){
            System.out.println("結束");
        }
    }

    public void makemorePoint(){
        System.out.println("請輸入 p 建立點(最多建立10個)，或輸入 e 結束");
        String s =scanner.next();
        while ((s.matches("p")!=true)&&(s.matches("e")!=true)){
            System.out.println("請輸入 p 建立點(最多建立10個)，或輸入 e 結束");
            s =scanner.next();
        }
        if(s.matches("p")){
            pointN++;
            makePoint(pointN,pointC);
            pointC+=2;
            makemorePoint();
        }
        else if(s.matches("e")){
            System.out.println("結束");
        }
    }

    private void setLowRight(int cC,float LRx,float LRy){
        cube[cC]=LRx;
        cube[cC+1]=LRy;
    }
    private void setUpLeft(int cC,float ULx,float ULy){
        cube[cC+2]=ULx;
        cube[cC+3]=ULy;
    }

    public  void makeCube(int cN,int cC){
        while ((cube[cC]<=cube[cC+2])||(cube[cC+1]>=cube[cC+3])){
            System.out.printf("請輸入矩形 %d 之正確左上(格式:x y)\n",cN);
            setUpLeft(cC,scanner.nextFloat(),scanner.nextFloat());
            System.out.printf("請輸入矩形 %d 之正確右下(格式:x y)\n",cN);
            setLowRight(cC,scanner.nextFloat(),scanner.nextFloat());
        }
    }
    public void makePoint(int pN,int pC){
        System.out.printf("請輸入點 %d (格式:x y)\n",pN);
        point[pC]=scanner.nextFloat();
        point[pC+1]=scanner.nextFloat();
    }

    public void pointCheck(){
        for (int j=0;j<pointN;j++){
            for(int i=0;i<cubeN;i++){
                if ((point[(j*2)]<cube[(i*4)])&&(point[((j*2)+1)]>cube[((i*4)+1)])&&(point[((j*2))]>cube[((i*4)+2)])&&(point[((j*2)+1)]<cube[((i*4)+3)])){
                    System.out.printf("點%d在圖%d內\n",(j+1),(i+1));
                }
                else{
                    System.out.printf("點%d不在圖%d內\n",(j+1),(i+1));
                }
            }
        }
    }
}
