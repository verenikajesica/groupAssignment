/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group_project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author User
 */
public class Group_project extends JFrame{
    JButton b_dit2x2, b_dit4x4, b_histogram, b_convolution, b_lowpass, 
            b_lowpass5x5, b_highpass, b_highboost, b_median, b_mean, b_edge, 
            b_edgeSobel, b_enlarge, b_shrinking;
    JButton am_dit2x2, am_dit4x4, am_histogram, am_convolution, am_lowpass, 
            am_lowpass5x5, am_highpass, am_highboost, am_median, am_mean, am_edge, 
            am_edgeSobel, am_enlarge, am_shrinking;
    JButton img_dit2x2, img_dit4x4, img_histogram, img_convolution, img_lowpass, 
            img_lowpass5x5, img_highpass, img_highboost, img_median, img_mean, img_edge, 
            img_edgeSobel, img_enlarge, img_shrinking;
    JButton yd_dit2x2, yd_dit4x4, yd_histogram, yd_convolution, yd_lowpass, 
            yd_lowpass5x5, yd_highpass, yd_highboost, yd_median, yd_mean, yd_edge, 
            yd_edgeSobel, yd_enlarge, yd_shrinking;
    
    JLabel label, b_label, amidala2, imgpro, yoda;
    
    public Group_project(){
        JFrame frame = new JFrame("Mini Photoshop");
    //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //frame.setSize(700,500);
       
    //super("Set Picture Into A JLabel Using JFileChooser In Java");
    b_label = new JLabel("Bedroom");
    b_label.setBounds(65,1,100,30);
    add(b_label);
    
    b_dit2x2 = new JButton("Dithering2x2");//1
    b_dit2x2.setBounds(20,30,150,30);
    add(b_dit2x2);
    
    b_dit4x4 = new JButton("Dithering4x4");//2
    b_dit4x4.setBounds(20,65,150,30);
    add(b_dit4x4);
    
    b_histogram = new JButton("Histogram");//3
    b_histogram.setBounds(20,100,150,30);
    add(b_histogram);
    
    b_convolution = new JButton("Convolution");//4
    b_convolution.setBounds(20,135,150,30);
    add(b_convolution);
    
    b_lowpass = new JButton("Low-Pass Filter");//5
    b_lowpass.setBounds(20,170,150,30);
    add(b_lowpass);  
    
    b_lowpass5x5 = new JButton("Low-PassFilter 5x5");//6
    b_lowpass5x5.setBounds(20,205,150,30);
    add(b_lowpass5x5);
    
    b_highpass = new JButton("High-Pass Filter");//7
    b_highpass.setBounds(20,240,150,30);
    add(b_highpass);
    
    b_highboost = new JButton("High-Boost Filter");//8
    b_highboost.setBounds(20,275,150,30);
    add(b_highboost);
    
    b_median = new JButton("Median Filter");//9
    b_median.setBounds(20,310,150,30);
    add(b_median);
    
    b_mean = new JButton("Mean Filter");//10
    b_mean.setBounds(20,345,150,30);
    add(b_mean);
    
    b_edge = new JButton("Prewitt Edge Detection");//11
    b_edge.setBounds(20,380,150,30);
    add(b_edge);   
    
    b_edgeSobel = new JButton("Sobel Edge Detection");//12
    b_edgeSobel.setBounds(20,415,150,30);
    add(b_edgeSobel);
    
    b_enlarge = new JButton("Enlarge");//13
    b_enlarge.setBounds(20,450,150,30);
    add(b_enlarge);
    
    b_shrinking = new JButton("Shrinking");//14
    b_shrinking.setBounds(20,485,150,30);
    add(b_shrinking);
    
    label = new JLabel("");
    label.setBounds(20,20,370,150);    
    add(label);
    
    b_dit2x2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 600;
            int width = 600; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/bedroom.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
                    
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                int[][] dithering2x2 ={
                    {0, 128},
                    {192, 64}
                };
                
                int count = 0, a = 0, b = 0;
                while (count != height){
                    if (count % 2 == 0){
                        for(int j = 0; j < width; j++){
                            if (j % 2 ==0){
                                a = 0;
                            }else{
                                a = 1;
                            }

                            if(newImageSize[count][j] > dithering2x2[0][a]){
                                newImageSize[count][j] = 255;
                            }else{
                                newImageSize[count][j] = 0;
                            }
                        }
                    }
                    else{
                        for(int j = 0; j < width; j++){
                            if(j % 2 == 0){
                                a = 0;
                            }else{
                                a = 1;
                            }

                            if(newImageSize[count][j] > dithering2x2[1][a]){
                                newImageSize[count][j] = 255;
                            }else{
                                newImageSize[count][j] = 0;
                            }
                        }
                    } count++;
                }
                
                FileOutputStream output = new FileOutputStream("output/Bedroom_dithering2x2.raw"); 
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newImageSize[i][j]);
                    }
                }
                
            }
            catch (Exception ex){
                    System.out.println("Exception: " + ex);
            }    
        }
    });
    
    b_dit4x4.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 600;
            int width = 600; 
            int countHeight = 0 , countWidth = 0;
            int[][] newImageSize = new int[height][width];
            
            try{
                File fileName = new File("Images/bedroom.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
                
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                int[][] dithering4x4 ={
                    { 0 , 128 , 32 , 160},
                    { 192 , 64 , 224 , 96},
                    { 48 , 176 , 16 , 144},
                    { 240 , 112 , 208 , 80}
                };
                
                int count = 0, a = 0, b = 0;
                boolean onOff = true;
                while(onOff){
                    for(int i = 0; i < width; i++){
                        if(a == 4){
                            a = 0;
                        }
                        if(newImageSize[count][i] > dithering4x4[0][a]){
                            newImageSize[count][i] = 225;
                        }
                        else{
                            newImageSize[count][i] = 0;
                        } a++;  
                    }
                    
                    //1
                    count++;
                    if(count == height){
                        break;
                    }
                    a = 0;
                    
                    //2
                    for(int i = 0; i < width; i++){
                        if(a == 4){
                            a = 0;
                        }
                        if(newImageSize[count][i] > dithering4x4[1][a]){
                            newImageSize[count][i] = 225;
                        }
                        else{
                            newImageSize[count][i] = 0;
                        } a++;
                    }
                    count++;
                    if (count == height){
                        break;
                    }
                    a = 0;
                    
                    //3
                    for(int i = 0; i < width; i++){
                        if(a == 4){
                            a = 0;
                        }
                        if(newImageSize[count][i] > dithering4x4[2][a]){
                            newImageSize[count][i] = 225;
                        }
                        else{
                            newImageSize[count][i] = 0;
                        } a++;
                    }
                    count++;
                    if(count == height){
                        break;
                    }
                    a = 0;
                    
                    //4
                    for(int i = 0; i < width; i++){
                        if(a == 4){
                            a = 0;
                        }
                        if(newImageSize[count][i] > dithering4x4[3][a]){
                            newImageSize[count][i] = 225;
                        }
                        else{
                            newImageSize[count][i] = 0;
                        } a++;
                    }
                    count++;
                    if(count == height){
                        break;
                    }
                    a = 0;
                }
                
                FileOutputStream output = new FileOutputStream("output/Bedroom_dithering4x4.raw");  
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newImageSize[i][j]);
                    }
                }
                output.close();
            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
    b_histogram.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 600;
            int width = 600;
            int countHeight = 0 , countWidth = 0;
            //int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/bedroom.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
                    
                int[] array = new int[256];
                int value;
                    
                int[] newImageSize = new int[(int)fileName.length()];
                int count = 0;
                while((value = myInputFile.read()) != -1){
                    newImageSize[count] = value;
                    array[value]++;
                    count++;
                }
                    
                int a = 0, b;
                int[] newArray = new int[256];
                for(int i = 0; i < 256; i++){
                    a = array[i] + a;
                    b = (a * 255)/(width * height);
                    newArray[i] = b;
                }
                FileOutputStream output = new FileOutputStream("output/BEDROOM_HISTOGRAM.raw");
                for(int i = 0; i < fileName.length(); i++){
                    output.write(newArray[newImageSize[i]]);
                }
                output.close();
                    
                    //convert to Image
                    
            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
    b_convolution.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 600;
            int width = 600; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            
            try{
                File fileName = new File("Images/bedroom.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
                
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                int[][] kernal = {
                    {-1 , 0 , 1},
                    {-2 , 0 , 2},
                    {-1 , 0 , 1}
                };
                
                int[][] newSize = new int[height][width];
                int count = 0;
                for(int i = 0; i < height; i++){
                    for (int j = 0; j < width; j++){
                        newSize[i][j] = newImageSize[i][j];
                        if(i == 0 || j  % width == 0 || j == width-1 || i == height-1){
                            newSize[i][j] = 255;
                        }
                    }
                }
                
                int sum = 0;
                for(int i = 1; i < height - 1; i++){
                    for(int j = 1; j < width - 1; j++){
                        sum = 0;
                        for(int a = -1; a < 2; a++){
                            for(int b = -1; b < 2; b++){
                                sum = (kernal[a + 1][b + 1] * newImageSize[i - a][j - b]) + sum;
                            }
                        }
                        if(sum < 0){
                            newSize[i][j] = 0;
                        }
                        else if(sum > 255){
                            newSize[i][j] = 255;
                        }
                        else {
                            newSize[i][j] = sum;
                        }
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/Bedroom_CONVOLUTION.raw");
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newSize[i][j]);
                    }
                }
                output.close(); 

            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
    b_lowpass.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 600;
            int width = 600; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/bedroom.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
            
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                float[][] data = {
                    {0.111f , 0.111f , 0.111f},
                    {0.111f , 0.111f , 0.111f},
                    {0.111f , 0.111f , 0.111f}
                };
                
                int[][] newSize = new int [height][width];
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        newSize[i][j] = newImageSize[i][j];
                        if(i == 0 || j % width == 0 || j == width-1 || i == height-1){
                            newSize[i][j] = 255;
                        }
                    }
                }
                
                int sum = 0;
                for(int i = 1; i < height - 1; i++){
                    for(int j = 1; j < width - 1; j++){
                        sum = 0;
                        for(int a = -1; a < 2; a++){
                            for(int b = -1; b < 2; b++){
                                sum = (int)(data[a + 1][b + 1] * newImageSize[i - a][j - b]) + sum;
                            }
                        }
                        if(sum < 0){
                            newSize[i][j] = 0;
                        }
                        else if(sum > 255){
                            newSize[i][j] = 255;
                        }
                        else {
                            newSize[i][j] = sum;
                        }
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/Bedroom_LowPass3x3.raw");  
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newSize[i][j]);
                    }
                }
                output.close();

            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
    b_lowpass5x5.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 600;
            int width = 600; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/bedroom.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
            
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                double[][] data = {
                    {0.04 , 0.04 , 0.04 , 0.04 , 0.04}, // 0
                    {0.04 , 0.04 , 0.04 , 0.04 , 0.04}, // 1
                    {0.04 , 0.04 , 0.04 , 0.04 , 0.04}, // 2
                    {0.04 , 0.04 , 0.04 , 0.04 , 0.04}, // 3
                    {0.04 , 0.04 , 0.04 , 0.04 , 0.04}  // 4
                };
                
                int[][] newSize = new int [height][width];
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        newSize[i][j] = newImageSize[i][j];
                        if(i == 0 || j % width == 0 || j == width-1 || i == height-1){
                            newSize[i][j] = 255;
                        }
                    }
                }
                
                int sum = 0;
                double temp;
                int num_1 , num_2 , num_3;
                for(int i = 1; i < height - 1; i++){
                    for(int j = 1; j < width - 1; j++){
                        sum = 0;

                        for(int a = -3; a < 2; a++){
                            for(int b = -3; b < 2; b++){
                                num_1 = i - a;
                                num_2 = j - b;

                                if(num_1 >= width){
                                    num_3 = 0;
                                }
                                else if(num_2 >= height){
                                    num_3 = 0;
                                }
                                else if(num_1 >= height || num_2 >= width){
                                    num_3 = 0;
                                }
                                else{
                                    num_3 = newImageSize[i - a][j - b];
                                }
                                sum = (int)(data[a + 3][b + 3] * num_3) + sum;
                            }
                        }
                        if(sum < 0){
                            newSize[i][j] = 0;
                        }
                        else if(sum > 255){
                            newSize[i][j] = 255;
                        }
                        else {
                            newSize[i][j] = sum;
                        }
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/Bedroom_LowPass5x5.raw");  
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newSize[i][j]);
                    }
                }
                output.close();

            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
    b_highpass.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 600;
            int width = 600; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/bedroom.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
            
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                int[][] kernel3x3 = {
                    {-1 , -1 , -1},
                    {-1 , 8 , -1},
                    {-1 , -1 , -1}
                };
                
                int[][] newSize = new int[height][width];
                int count = 0;
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        newSize[i][j] = newImageSize[i][j];
                        if(i == 0 || j % width == 0 || j == width-1 || i == height-1){
                            newSize[i][j] = 255;
                        }
                    }
                }
                
                int sumZero, max = 0, min = 0;
                for(int i = 1; i < height - 1; i++){
                    for(int j = 1; j < width - 1; j++){
                        sumZero = 0;
                        for(int a = -1; a < 2; a++){
                            for(int b = -1; b < 2; b++){
                                sumZero = (kernel3x3[a + 1][b + 1] * newImageSize[i - a][j - b]) + sumZero;
                                if(sumZero > max){
                                    max = sumZero;
                                }
                                if(sumZero < min){
                                    min = sumZero;
                                }
                            }
                        }
                    }
                }
                
                int sum;
                int total;
                total = max + min;
                Math.abs(total);
                for(int i = 1; i < height - 1; i++){
                    for(int j = 1; j < width - 1; j++){
                        sum = 0;
                        for(int a = -1; a < 2; a++){
                            for(int b = -1; b < 2; b++){
                                sum = (kernel3x3[a + 1][b + 1] * newImageSize[i - a][j - b]) + sum;
                            }
                        }
                        if(sum < 0){
                            newSize[i][j] = (255 * (sum + Math.abs(min))/total);
                        }
                        else {
                            newSize[i][j] = sum;
                        }
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/Bedroom_highPass3x3.raw");  
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newSize[i][j]);
                    }
                }
                output.close();
                }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
    b_highboost.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {  
            Scanner in = new Scanner(System.in);
            int height = 600;
            int width = 600; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/bedroom.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
            
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                
                int c = 0;
                boolean onOff = true;
                while(onOff){
                    System.out.print("Input a number bigger than 8: ");
                    c = in.nextInt();
                    if(c < 8){
                        System.out.print("Invalid Input! Input bigger than 8");
                        System.out.println("Insert a number(must bigger than 8): ");
                    }else{
                        onOff = false;
                    }
                }
                
                int[][] kernelC = {
                    {-1 , -1 , -1},
                    {-1 , c , -1},
                    {-1 , -1 , -1}
                };
                
                int[][] newSize = new int[height][width];
                int count = 0;
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        newSize[i][j] = newImageSize[i][j];
                        if(i == 0 || j % width == 0 || j == width-1 || i == height-1){
                            newSize[i][j] = 255;
                        }
                    }
                }
                
                int sum = 0;
                for(int i = 1; i < height - 1; i++){
                    for(int j = 1; j < width - 1; j++){
                        //System.out.print(data[i][j] + " ");
                        sum = 0;
                        for(int a = -1; a < 2; a++){
                            for(int b = -1; b < 2; b++){
                                sum = (kernelC[a + 1][b + 1] * newImageSize[i - a][j - b]) + sum;
                            }
                        }
                        if(sum < 0){
                            newSize[i][j] = 0;
                        }
                        else if(sum > 255){
                            newSize[i][j] = 255;
                        }
                        else {
                            newSize[i][j] = sum;
                        }
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/Bedroom_highBoost" + c + ".raw");  
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newSize[i][j]);
                    }
                }
                output.close();
                }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
    b_median.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 600;
            int width = 600; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/bedroom.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
            
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                int[][] newSize = new int[height][width];
                int count = 0;
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        newSize[i][j] = newImageSize[i][j];
                        if(i == 0 || j % width == 0 || j == width-1 || i == height-1){
                            newSize[i][j] = 255;
                        }
                    }
                }
                
                int[] sum = new int[9];
                for(int i = 1; i < height - 1; i++){
                    for(int j = 1; j < width - 1; j++){
                        count = 0;
                        for(int a = -1; a < 2; a++){
                            for(int b = -1; b < 2; b++){
                                sum[count] = newImageSize[i - a][j - b];
                                count++;
                            }
                        }
                        Arrays.sort(sum);
                        newSize[i][j] = sum[4];
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/Bedroom_Median Filter.raw");  
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newSize[i][j]);
                    }
                }
                output.close();
            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
    b_mean.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 600;
            int width = 600; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/bedroom.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
            
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                int[][] newSize = new int[height][width];
                int count = 0;
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        newSize[i][j] = newImageSize[i][j];
                        if(i == 0 || j % width == 0 || j == width-1 || i == height-1){
                            newSize[i][j] = 255;
                        }
                    }
                }
                
                int sum = 0;
                for(int i = 1; i < height - 1; i++){
                    for(int j = 1; j < width - 1; j++){
                        sum = 0;
                        for(int a = -1; a < 2; a++){
                            for(int b = -1; b < 2; b++){
                                sum = (newImageSize[i - a][j - b]) + sum;
                            }
                        }
                        newSize[i][j] = (sum / 9);
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/Bedroom_Mean Filter.raw");  
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newSize[i][j]);
                    }
                }
                output.close();
            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
    //prewitt
    b_edge.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 600;
            int width = 600; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/bedroom.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
            
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                int[][] newSize = new int[height][width];
                int count = 0;
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        newSize[i][j] = newImageSize[i][j];
                        if(i == 0 || j % width == 0 || j == width-1 || i == height-1){
                            newSize[i][j] = 255;
                        }
                    }
                }
                
                int[] sum = new int [9];
                for(int i = 1; i < height - 1; i++){
                    for(int j = 1; j < width - 1; j++){
                        count = 0;
                        for(int a = -1; a < 2; a++){
                            for(int b = -1; b < 2; b++){
                                sum[count] = newImageSize[i - a][j - b];
                                count++;
                            }
                        }
                        newSize[i][j] = ((sum[8] + sum[7] + sum[6]) - (sum[0] 
                                        + sum[1] + sum[2])) + ((sum[2] + sum[5] 
                                        + sum[8]) - (sum[0] - sum[3] - sum[6]));
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/Bedroom_Edge Detection PrewittOperator.raw");  
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newSize[i][j]);
                    }
                }
                output.close();
            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
     b_edgeSobel.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 600;
            int width = 600; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/bedroom.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
            
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                int[][] newSize = new int[height][width];
                int count = 0;
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        newSize[i][j] = newImageSize[i][j];
                        if(i == 0 || j % width == 0 || j == width-1 || i == height-1){
                            newSize[i][j] = 255;
                        }
                    }
                }
                
                int[] sum = new int [9];
                for(int i = 1; i < height - 1; i++){
                    for(int j = 1; j < width - 1; j++){
                        count = 0;
                        for(int a = -1; a < 2; a++){
                            for(int b = -1; b < 2; b++){
                                sum[count] = newImageSize[i - a][j - b];
                                count++;
                            }
                        }
                        newSize[i][j] = ((sum[6] + (2 * sum[7]) + sum[8]) - (sum[0] 
                                          + (2 * sum[1]) + sum[2])) + ((sum[2] + (2 * sum[5]) 
                                          + sum[8]) - (sum[0] - (2 * sum[3]) - sum[6]));
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/Bedroom_Edge Detection SobelGradient.raw");  
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newSize[i][j]);
                    }
                }
                output.close();
            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
     
    //from 600x600 doubled to 1200x1200
    b_enlarge.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 600;
            int width = 600; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/bedroom.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
            
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                int[][] newSize = new int[height*2][width*2];
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        for(int a = 0; a < 2; a++){
                            for(int b = 0; b < 2; b++){
                                newSize[(i * 2) + a][(j * 2) + b] = newImageSize[i][j];
                            }
                        }
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/Bedroom_Enlarged.raw");  
                for(int i = 0; i < (height * 2); i++){
                    for(int j = 0; j < (width * 2); j++){
                        output.write(newSize[i][j]);
                    }
                }
                output.close();
            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
    b_shrinking.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 600;
            int width = 600; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/bedroom.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
            
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                int[][] newSize = new int[height/2][width/2];
                int temp;
                for(int i = 0; i < height/2; i++){
                    for(int j = 0; j < width/2; j++){
                        temp = 0;
                        for(int a = 0; a < 2; a++){
                            for(int b = 0; b < 2; b++){
                                //new_data[(i * 2) + a][(j * 2) + b] = data[(i * 2) + a][(j * 2) + b];
                                temp = newImageSize[(i * 2) + a][(j * 2) + b] + temp;
                                //System.out.println((i * 2) + a);
                            }
                        }
                        //System.out.println("j: " + j);
                        newSize[i][j] = (temp / 4);
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/Bedroom_Shrinking.raw");  
                for(int i = 0; i < height/2; i++){
                    for(int j = 0; j < width/2; j++){
                        output.write(newImageSize[i][j]);
                    }
                }
                output.close();
            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    

    //amaidala2
    amidala2 = new JLabel("amidala2");
    amidala2.setBounds(235,1,100,30);
    add(amidala2);
    
    am_dit2x2 = new JButton("Dithering2x2");//1
    am_dit2x2.setBounds(180,30,150,30);
    add(am_dit2x2);
    
    am_dit4x4 = new JButton("Dithering4x4");//2
    am_dit4x4.setBounds(180,65,150,30);
    add(am_dit4x4);
    
    am_histogram = new JButton("Histogram");//3
    am_histogram.setBounds(180,100,150,30);
    add(am_histogram);
    
    am_convolution = new JButton("Convolution");//4
    am_convolution.setBounds(180,135,150,30);
    add(am_convolution);
    
    am_lowpass = new JButton("Low-Pass Filter");//5
    am_lowpass.setBounds(180,170,150,30);
    add(am_lowpass);  
    
    am_lowpass5x5 = new JButton("Low-PassFilter 5x5");//6
    am_lowpass5x5.setBounds(180,205,150,30);
    add(am_lowpass5x5);
    
    am_highpass = new JButton("High-Pass Filter");//7
    am_highpass.setBounds(180,240,150,30);
    add(am_highpass);
    
    am_highboost = new JButton("High-Boost Filter");//8
    am_highboost.setBounds(180,275,150,30);
    add(am_highboost);
    
    am_median = new JButton("Median Filter");//9
    am_median.setBounds(180,310,150,30);
    add(am_median);
    
    am_mean = new JButton("Mean Filter");//10
    am_mean.setBounds(180,345,150,30);
    add(am_mean);
    
    am_edge = new JButton("Prewitt Edge Detection");//11
    am_edge.setBounds(180,380,150,30);
    add(am_edge);   
    
    am_edgeSobel = new JButton("Sobel Edge Detection");//12
    am_edgeSobel.setBounds(180,415,150,30);
    add(am_edgeSobel);
    
    am_enlarge = new JButton("Enlarge");//13
    am_enlarge.setBounds(180,450,150,30);
    add(am_enlarge);
    
    am_shrinking = new JButton("Shrinking");//14
    am_shrinking.setBounds(180,485,150,30);
    add(am_shrinking);
    
    am_dit2x2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 50;
            int width = 50; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/amidala2.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
                    
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                int[][] dithering2x2 ={
                    {0, 128},
                    {192, 64}
                };
                
                int count = 0, a = 0, b = 0;
                while (count != height){
                    if (count % 2 == 0){
                        for(int j = 0; j < width; j++){
                            if (j % 2 ==0){
                                a = 0;
                            }else{
                                a = 1;
                            }

                            if(newImageSize[count][j] > dithering2x2[0][a]){
                                newImageSize[count][j] = 255;
                            }else{
                                newImageSize[count][j] = 0;
                            }
                        }
                    }
                    else{
                        for(int j = 0; j < width; j++){
                            if(j % 2 == 0){
                                a = 0;
                            }else{
                                a = 1;
                            }

                            if(newImageSize[count][j] > dithering2x2[1][a]){
                                newImageSize[count][j] = 255;
                            }else{
                                newImageSize[count][j] = 0;
                            }
                        }
                    } count++;
                }
                
                FileOutputStream output = new FileOutputStream("output/amidala2_dithering2x2.raw"); 
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newImageSize[i][j]);
                    }
                }
                
            }
            catch (Exception ex){
                    System.out.println("Exception: " + ex);
            }    
        }
    });
    
    am_dit4x4.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 50;
            int width = 50; 
            int countHeight = 0 , countWidth = 0;
            int[][] newImageSize = new int[height][width];
            
            try{
                File fileName = new File("Images/amidala2.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
                
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                int[][] dithering4x4 ={
                    { 0 , 128 , 32 , 160},
                    { 192 , 64 , 224 , 96},
                    { 48 , 176 , 16 , 144},
                    { 240 , 112 , 208 , 80}
                };
                
                int count = 0, a = 0, b = 0;
                boolean onOff = true;
                while(onOff){
                    for(int i = 0; i < width; i++){
                        if(a == 4){
                            a = 0;
                        }
                        if(newImageSize[count][i] > dithering4x4[0][a]){
                            newImageSize[count][i] = 225;
                        }
                        else{
                            newImageSize[count][i] = 0;
                        } a++;  
                    }
                    
                    //1
                    count++;
                    if(count == height){
                        break;
                    }
                    a = 0;
                    
                    //2
                    for(int i = 0; i < width; i++){
                        if(a == 4){
                            a = 0;
                        }
                        if(newImageSize[count][i] > dithering4x4[1][a]){
                            newImageSize[count][i] = 225;
                        }
                        else{
                            newImageSize[count][i] = 0;
                        } a++;
                    }
                    count++;
                    if (count == height){
                        break;
                    }
                    a = 0;
                    
                    //3
                    for(int i = 0; i < width; i++){
                        if(a == 4){
                            a = 0;
                        }
                        if(newImageSize[count][i] > dithering4x4[2][a]){
                            newImageSize[count][i] = 225;
                        }
                        else{
                            newImageSize[count][i] = 0;
                        } a++;
                    }
                    count++;
                    if(count == height){
                        break;
                    }
                    a = 0;
                    
                    //4
                    for(int i = 0; i < width; i++){
                        if(a == 4){
                            a = 0;
                        }
                        if(newImageSize[count][i] > dithering4x4[3][a]){
                            newImageSize[count][i] = 225;
                        }
                        else{
                            newImageSize[count][i] = 0;
                        } a++;
                    }
                    count++;
                    if(count == height){
                        break;
                    }
                    a = 0;
                }
                
                FileOutputStream output = new FileOutputStream("output/amidala2_dithering4x4.raw");  
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newImageSize[i][j]);
                    }
                }
                output.close();
            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
    am_histogram.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 50;
            int width = 50;
            int countHeight = 0 , countWidth = 0;
            //int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/amidala2.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
                    
                int[] array = new int[256];
                int value;
                    
                int[] newImageSize = new int[(int)fileName.length()];
                int count = 0;
                while((value = myInputFile.read()) != -1){
                    newImageSize[count] = value;
                    array[value]++;
                    count++;
                }
                    
                int a = 0, b;
                int[] newArray = new int[256];
                for(int i = 0; i < 256; i++){
                    a = array[i] + a;
                    b = (a * 255)/(width * height);
                    newArray[i] = b;
                }
                FileOutputStream output = new FileOutputStream("output/amidala2_HISTOGRAM.raw");
                for(int i = 0; i < fileName.length(); i++){
                    output.write(newArray[newImageSize[i]]);
                }
                output.close();
                    
                    //convert to Image
                    
            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
    am_convolution.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 50;
            int width = 50; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            
            try{
                File fileName = new File("Images/amidala2.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
                
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                int[][] kernal = {
                    {-1 , 0 , 1},
                    {-2 , 0 , 2},
                    {-1 , 0 , 1}
                };
                
                int[][] newSize = new int[height][width];
                int count = 0;
                for(int i = 0; i < height; i++){
                    for (int j = 0; j < width; j++){
                        newSize[i][j] = newImageSize[i][j];
                        if(i == 0 || j  % width == 0 || j == width-1 || i == height-1){
                            newSize[i][j] = 255;
                        }
                    }
                }
                
                int sum = 0;
                for(int i = 1; i < height - 1; i++){
                    for(int j = 1; j < width - 1; j++){
                        sum = 0;
                        for(int a = -1; a < 2; a++){
                            for(int b = -1; b < 2; b++){
                                sum = (kernal[a + 1][b + 1] * newImageSize[i - a][j - b]) + sum;
                            }
                        }
                        if(sum < 0){
                            newSize[i][j] = 0;
                        }
                        else if(sum > 255){
                            newSize[i][j] = 255;
                        }
                        else {
                            newSize[i][j] = sum;
                        }
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/amidala2_CONVOLUTION.raw");
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newSize[i][j]);
                    }
                }
                output.close(); 

            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
    am_lowpass.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 50;
            int width = 50; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/amidala2.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
            
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                float[][] data = {
                    {0.111f , 0.111f , 0.111f},
                    {0.111f , 0.111f , 0.111f},
                    {0.111f , 0.111f , 0.111f}
                };
                
                int[][] newSize = new int [height][width];
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        newSize[i][j] = newImageSize[i][j];
                        if(i == 0 || j % width == 0 || j == width-1 || i == height-1){
                            newSize[i][j] = 255;
                        }
                    }
                }
                
                int sum = 0;
                for(int i = 1; i < height - 1; i++){
                    for(int j = 1; j < width - 1; j++){
                        sum = 0;
                        for(int a = -1; a < 2; a++){
                            for(int b = -1; b < 2; b++){
                                sum = (int)(data[a + 1][b + 1] * newImageSize[i - a][j - b]) + sum;
                            }
                        }
                        if(sum < 0){
                            newSize[i][j] = 0;
                        }
                        else if(sum > 255){
                            newSize[i][j] = 255;
                        }
                        else {
                            newSize[i][j] = sum;
                        }
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/amidala2_LowPass3x3.raw");  
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newSize[i][j]);
                    }
                }
                output.close();

            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
    am_lowpass5x5.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 50;
            int width = 50; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/amidala2.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
            
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                double[][] data = {
                    {0.04 , 0.04 , 0.04 , 0.04 , 0.04}, // 0
                    {0.04 , 0.04 , 0.04 , 0.04 , 0.04}, // 1
                    {0.04 , 0.04 , 0.04 , 0.04 , 0.04}, // 2
                    {0.04 , 0.04 , 0.04 , 0.04 , 0.04}, // 3
                    {0.04 , 0.04 , 0.04 , 0.04 , 0.04}  // 4
                };
                
                int[][] newSize = new int [height][width];
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        newSize[i][j] = newImageSize[i][j];
                        if(i == 0 || j % width == 0 || j == width-1 || i == height-1){
                            newSize[i][j] = 255;
                        }
                    }
                }
                
                int sum = 0;
                double temp;
                int num_1 , num_2 , num_3;
                for(int i = 1; i < height - 1; i++){
                    for(int j = 1; j < width - 1; j++){
                        sum = 0;

                        for(int a = -3; a < 2; a++){
                            for(int b = -3; b < 2; b++){
                                num_1 = i - a;
                                num_2 = j - b;

                                if(num_1 >= width){
                                    num_3 = 0;
                                }
                                else if(num_2 >= height){
                                    num_3 = 0;
                                }
                                else if(num_1 >= height || num_2 >= width){
                                    num_3 = 0;
                                }
                                else{
                                    num_3 = newImageSize[i - a][j - b];
                                }
                                sum = (int)(data[a + 3][b + 3] * num_3) + sum;
                            }
                        }
                        if(sum < 0){
                            newSize[i][j] = 0;
                        }
                        else if(sum > 255){
                            newSize[i][j] = 255;
                        }
                        else {
                            newSize[i][j] = sum;
                        }
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/amidala2_LowPass5x5.raw");  
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newSize[i][j]);
                    }
                }
                output.close();

            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
    am_highpass.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 50;
            int width = 50; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/amidala2.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
            
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                int[][] kernel3x3 = {
                    {-1 , -1 , -1},
                    {-1 , 8 , -1},
                    {-1 , -1 , -1}
                };
                
                int[][] newSize = new int[height][width];
                int count = 0;
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        newSize[i][j] = newImageSize[i][j];
                        if(i == 0 || j % width == 0 || j == width-1 || i == height-1){
                            newSize[i][j] = 255;
                        }
                    }
                }
                
                int sumZero, max = 0, min = 0;
                for(int i = 1; i < height - 1; i++){
                    for(int j = 1; j < width - 1; j++){
                        sumZero = 0;
                        for(int a = -1; a < 2; a++){
                            for(int b = -1; b < 2; b++){
                                sumZero = (kernel3x3[a + 1][b + 1] * newImageSize[i - a][j - b]) + sumZero;
                                if(sumZero > max){
                                    max = sumZero;
                                }
                                if(sumZero < min){
                                    min = sumZero;
                                }
                            }
                        }
                    }
                }
                
                int sum;
                int total;
                total = max + min;
                Math.abs(total);
                for(int i = 1; i < height - 1; i++){
                    for(int j = 1; j < width - 1; j++){
                        sum = 0;
                        for(int a = -1; a < 2; a++){
                            for(int b = -1; b < 2; b++){
                                sum = (kernel3x3[a + 1][b + 1] * newImageSize[i - a][j - b]) + sum;
                            }
                        }
                        if(sum < 0){
                            newSize[i][j] = (255 * (sum + Math.abs(min))/total);
                        }
                        else {
                            newSize[i][j] = sum;
                        }
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/amidala2_highPass3x3.raw");  
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newSize[i][j]);
                    }
                }
                output.close();
                }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
    am_highboost.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {  
            Scanner in = new Scanner(System.in);
            int height = 50;
            int width = 50; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/amidala2.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
            
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                
                int c = 0;
                boolean onOff = true;
                while(onOff){
                    System.out.print("Input a number bigger than 8: ");
                    c = in.nextInt();
                    if(c < 8){
                        System.out.print("Invalid Input! Input bigger than 8");
                        System.out.println("Insert a number(must bigger than 8): ");
                    }else{
                        onOff = false;
                    }
                }
                
                int[][] kernelC = {
                    {-1 , -1 , -1},
                    {-1 , c , -1},
                    {-1 , -1 , -1}
                };
                
                int[][] newSize = new int[height][width];
                int count = 0;
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        newSize[i][j] = newImageSize[i][j];
                        if(i == 0 || j % width == 0 || j == width-1 || i == height-1){
                            newSize[i][j] = 255;
                        }
                    }
                }
                
                int sum = 0;
                for(int i = 1; i < height - 1; i++){
                    for(int j = 1; j < width - 1; j++){
                        //System.out.print(data[i][j] + " ");
                        sum = 0;
                        for(int a = -1; a < 2; a++){
                            for(int b = -1; b < 2; b++){
                                sum = (kernelC[a + 1][b + 1] * newImageSize[i - a][j - b]) + sum;
                            }
                        }
                        if(sum < 0){
                            newSize[i][j] = 0;
                        }
                        else if(sum > 255){
                            newSize[i][j] = 255;
                        }
                        else {
                            newSize[i][j] = sum;
                        }
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/amidala2_highBoost" + c + ".raw");  
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newSize[i][j]);
                    }
                }
                output.close();
                }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
    am_median.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 50;
            int width = 50; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/amidala2.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
            
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                int[][] newSize = new int[height][width];
                int count = 0;
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        newSize[i][j] = newImageSize[i][j];
                        if(i == 0 || j % width == 0 || j == width-1 || i == height-1){
                            newSize[i][j] = 255;
                        }
                    }
                }
                
                int[] sum = new int[9];
                for(int i = 1; i < height - 1; i++){
                    for(int j = 1; j < width - 1; j++){
                        count = 0;
                        for(int a = -1; a < 2; a++){
                            for(int b = -1; b < 2; b++){
                                sum[count] = newImageSize[i - a][j - b];
                                count++;
                            }
                        }
                        Arrays.sort(sum);
                        newSize[i][j] = sum[4];
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/amidala2_Median Filter.raw");  
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newSize[i][j]);
                    }
                }
                output.close();
            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
    am_mean.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 50;
            int width = 50; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/amidala2.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
            
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                int[][] newSize = new int[height][width];
                int count = 0;
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        newSize[i][j] = newImageSize[i][j];
                        if(i == 0 || j % width == 0 || j == width-1 || i == height-1){
                            newSize[i][j] = 255;
                        }
                    }
                }
                
                int sum = 0;
                for(int i = 1; i < height - 1; i++){
                    for(int j = 1; j < width - 1; j++){
                        sum = 0;
                        for(int a = -1; a < 2; a++){
                            for(int b = -1; b < 2; b++){
                                sum = (newImageSize[i - a][j - b]) + sum;
                            }
                        }
                        newSize[i][j] = (sum / 9);
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/amidala2_Mean Filter.raw");  
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newSize[i][j]);
                    }
                }
                output.close();
            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
    //prewitt
    am_edge.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 50;
            int width = 50; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/amidala2.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
            
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                int[][] newSize = new int[height][width];
                int count = 0;
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        newSize[i][j] = newImageSize[i][j];
                        if(i == 0 || j % width == 0 || j == width-1 || i == height-1){
                            newSize[i][j] = 255;
                        }
                    }
                }
                
                int[] sum = new int [9];
                for(int i = 1; i < height - 1; i++){
                    for(int j = 1; j < width - 1; j++){
                        count = 0;
                        for(int a = -1; a < 2; a++){
                            for(int b = -1; b < 2; b++){
                                sum[count] = newImageSize[i - a][j - b];
                                count++;
                            }
                        }
                        newSize[i][j] = ((sum[8] + sum[7] + sum[6]) - (sum[0] 
                                        + sum[1] + sum[2])) + ((sum[2] + sum[5] 
                                        + sum[8]) - (sum[0] - sum[3] - sum[6]));
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/amidala2_Edge Detection PrewittOperator.raw");  
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newSize[i][j]);
                    }
                }
                output.close();
            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
     am_edgeSobel.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 50;
            int width = 50; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/amidala2.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
            
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                int[][] newSize = new int[height][width];
                int count = 0;
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        newSize[i][j] = newImageSize[i][j];
                        if(i == 0 || j % width == 0 || j == width-1 || i == height-1){
                            newSize[i][j] = 255;
                        }
                    }
                }
                
                int[] sum = new int [9];
                for(int i = 1; i < height - 1; i++){
                    for(int j = 1; j < width - 1; j++){
                        count = 0;
                        for(int a = -1; a < 2; a++){
                            for(int b = -1; b < 2; b++){
                                sum[count] = newImageSize[i - a][j - b];
                                count++;
                            }
                        }
                        newSize[i][j] = ((sum[6] + (2 * sum[7]) + sum[8]) - (sum[0] 
                                          + (2 * sum[1]) + sum[2])) + ((sum[2] + (2 * sum[5]) 
                                          + sum[8]) - (sum[0] - (2 * sum[3]) - sum[6]));
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/amidala2_Edge Detection SobelGradient.raw");  
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newSize[i][j]);
                    }
                }
                output.close();
            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
     
    //size will be doubled
    am_enlarge.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 50;
            int width = 50; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/amidala2.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
            
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                int[][] newSize = new int[height*2][width*2];
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        for(int a = 0; a < 2; a++){
                            for(int b = 0; b < 2; b++){
                                newSize[(i * 2) + a][(j * 2) + b] = newImageSize[i][j];
                            }
                        }
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/amidala2_Enlarged.raw");  
                for(int i = 0; i < (height * 2); i++){
                    for(int j = 0; j < (width * 2); j++){
                        output.write(newSize[i][j]);
                    }
                }
                output.close();
            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
    am_shrinking.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 50;
            int width = 50; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/amidala2.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
            
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                int[][] newSize = new int[height/2][width/2];
                int temp;
                for(int i = 0; i < height/2; i++){
                    for(int j = 0; j < width/2; j++){
                        temp = 0;
                        for(int a = 0; a < 2; a++){
                            for(int b = 0; b < 2; b++){
                                //new_data[(i * 2) + a][(j * 2) + b] = data[(i * 2) + a][(j * 2) + b];
                                temp = newImageSize[(i * 2) + a][(j * 2) + b] + temp;
                                //System.out.println((i * 2) + a);
                            }
                        }
                        //System.out.println("j: " + j);
                        newSize[i][j] = (temp / 4);
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/amidala2_Shrinking.raw");  
                for(int i = 0; i < height/2; i++){
                    for(int j = 0; j < width/2; j++){
                        output.write(newImageSize[i][j]);
                    }
                }
                output.close();
            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    //Imgpro
    imgpro = new JLabel("Imgpro");
    imgpro.setBounds(390,1,100,30);
    add(imgpro);
    
    img_dit2x2 = new JButton("Dithering2x2");//1
    img_dit2x2.setBounds(340,30,150,30);
    add(img_dit2x2);
    
    img_dit4x4 = new JButton("Dithering4x4");//2
    img_dit4x4.setBounds(340,65,150,30);
    add(img_dit4x4);
    
    img_histogram = new JButton("Histogram");//3
    img_histogram.setBounds(340,100,150,30);
    add(img_histogram);
    
    img_convolution = new JButton("Convolution");//4
    img_convolution.setBounds(340,135,150,30);
    add(img_convolution);
    
    img_lowpass = new JButton("Low-Pass Filter");//5
    img_lowpass.setBounds(340,170,150,30);
    add(img_lowpass);  
    
    img_lowpass5x5 = new JButton("Low-PassFilter 5x5");//6
    img_lowpass5x5.setBounds(340,205,150,30);
    add(img_lowpass5x5);
    
    img_highpass = new JButton("High-Pass Filter");//7
    img_highpass.setBounds(340,240,150,30);
    add(img_highpass);
    
    img_highboost = new JButton("High-Boost Filter");//8
    img_highboost.setBounds(340,275,150,30);
    add(img_highboost);
    
    img_median = new JButton("Median Filter");//9
    img_median.setBounds(340,310,150,30);
    add(img_median);
    
    img_mean = new JButton("Mean Filter");//10
    img_mean.setBounds(340,345,150,30);
    add(img_mean);
    
    img_edge = new JButton("Prewitt Edge Detection");//11
    img_edge.setBounds(340,380,150,30);
    add(img_edge);   
    
    img_edgeSobel = new JButton("Sobel Edge Detection");//12
    img_edgeSobel.setBounds(340,415,150,30);
    add(img_edgeSobel);
    
    img_enlarge = new JButton("Enlarge");//13
    img_enlarge.setBounds(340,450,150,30);
    add(img_enlarge);
    
    img_shrinking = new JButton("Shrinking");//14
    img_shrinking.setBounds(340,485,150,30);
    add(img_shrinking);
    
    img_dit2x2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 100;
            int width = 122; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/Imgpro.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
                    
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                int[][] dithering2x2 ={
                    {0, 128},
                    {192, 64}
                };
                
                int count = 0, a = 0, b = 0;
                while (count != height){
                    if (count % 2 == 0){
                        for(int j = 0; j < width; j++){
                            if (j % 2 ==0){
                                a = 0;
                            }else{
                                a = 1;
                            }

                            if(newImageSize[count][j] > dithering2x2[0][a]){
                                newImageSize[count][j] = 255;
                            }else{
                                newImageSize[count][j] = 0;
                            }
                        }
                    }
                    else{
                        for(int j = 0; j < width; j++){
                            if(j % 2 == 0){
                                a = 0;
                            }else{
                                a = 1;
                            }

                            if(newImageSize[count][j] > dithering2x2[1][a]){
                                newImageSize[count][j] = 255;
                            }else{
                                newImageSize[count][j] = 0;
                            }
                        }
                    } count++;
                }
                
                FileOutputStream output = new FileOutputStream("output/Imgpro_dithering2x2.raw"); 
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newImageSize[i][j]);
                    }
                }
                
            }
            catch (Exception ex){
                    System.out.println("Exception: " + ex);
            }    
        }
    });
    
    img_dit4x4.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 100;
            int width = 122; 
            int countHeight = 0 , countWidth = 0;
            int[][] newImageSize = new int[height][width];
            
            try{
                File fileName = new File("Images/Imgpro.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
                
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                int[][] dithering4x4 ={
                    { 0 , 128 , 32 , 160},
                    { 192 , 64 , 224 , 96},
                    { 48 , 176 , 16 , 144},
                    { 240 , 112 , 208 , 80}
                };
                
                int count = 0, a = 0, b = 0;
                boolean onOff = true;
                while(onOff){
                    for(int i = 0; i < width; i++){
                        if(a == 4){
                            a = 0;
                        }
                        if(newImageSize[count][i] > dithering4x4[0][a]){
                            newImageSize[count][i] = 225;
                        }
                        else{
                            newImageSize[count][i] = 0;
                        } a++;  
                    }
                    
                    //1
                    count++;
                    if(count == height){
                        break;
                    }
                    a = 0;
                    
                    //2
                    for(int i = 0; i < width; i++){
                        if(a == 4){
                            a = 0;
                        }
                        if(newImageSize[count][i] > dithering4x4[1][a]){
                            newImageSize[count][i] = 225;
                        }
                        else{
                            newImageSize[count][i] = 0;
                        } a++;
                    }
                    count++;
                    if (count == height){
                        break;
                    }
                    a = 0;
                    
                    //3
                    for(int i = 0; i < width; i++){
                        if(a == 4){
                            a = 0;
                        }
                        if(newImageSize[count][i] > dithering4x4[2][a]){
                            newImageSize[count][i] = 225;
                        }
                        else{
                            newImageSize[count][i] = 0;
                        } a++;
                    }
                    count++;
                    if(count == height){
                        break;
                    }
                    a = 0;
                    
                    //4
                    for(int i = 0; i < width; i++){
                        if(a == 4){
                            a = 0;
                        }
                        if(newImageSize[count][i] > dithering4x4[3][a]){
                            newImageSize[count][i] = 225;
                        }
                        else{
                            newImageSize[count][i] = 0;
                        } a++;
                    }
                    count++;
                    if(count == height){
                        break;
                    }
                    a = 0;
                }
                
                FileOutputStream output = new FileOutputStream("output/Imgpro_dithering4x4.raw");  
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newImageSize[i][j]);
                    }
                }
                output.close();
            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
    img_histogram.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 100;
            int width = 122;
            int countHeight = 0 , countWidth = 0;
            //int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/Imgpro.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
                    
                int[] array = new int[256];
                int value;
                    
                int[] newImageSize = new int[(int)fileName.length()];
                int count = 0;
                while((value = myInputFile.read()) != -1){
                    newImageSize[count] = value;
                    array[value]++;
                    count++;
                }
                    
                int a = 0, b;
                int[] newArray = new int[256];
                for(int i = 0; i < 256; i++){
                    a = array[i] + a;
                    b = (a * 255)/(width * height);
                    newArray[i] = b;
                }
                FileOutputStream output = new FileOutputStream("output/Imgpro_HISTOGRAM.raw");
                for(int i = 0; i < fileName.length(); i++){
                    output.write(newArray[newImageSize[i]]);
                }
                output.close();
                    
                    //convert to Image
                    
            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
    img_convolution.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 100;
            int width = 122; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            
            try{
                File fileName = new File("Images/Imgpro.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
                
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                int[][] kernal = {
                    {-1 , 0 , 1},
                    {-2 , 0 , 2},
                    {-1 , 0 , 1}
                };
                
                int[][] newSize = new int[height][width];
                int count = 0;
                for(int i = 0; i < height; i++){
                    for (int j = 0; j < width; j++){
                        newSize[i][j] = newImageSize[i][j];
                        if(i == 0 || j  % width == 0 || j == width-1 || i == height-1){
                            newSize[i][j] = 255;
                        }
                    }
                }
                
                int sum = 0;
                for(int i = 1; i < height - 1; i++){
                    for(int j = 1; j < width - 1; j++){
                        sum = 0;
                        for(int a = -1; a < 2; a++){
                            for(int b = -1; b < 2; b++){
                                sum = (kernal[a + 1][b + 1] * newImageSize[i - a][j - b]) + sum;
                            }
                        }
                        if(sum < 0){
                            newSize[i][j] = 0;
                        }
                        else if(sum > 255){
                            newSize[i][j] = 255;
                        }
                        else {
                            newSize[i][j] = sum;
                        }
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/Imgpro_CONVOLUTION.raw");
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newSize[i][j]);
                    }
                }
                output.close(); 

            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
    img_lowpass.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 100;
            int width = 122; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/Imgpro.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
            
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                float[][] data = {
                    {0.111f , 0.111f , 0.111f},
                    {0.111f , 0.111f , 0.111f},
                    {0.111f , 0.111f , 0.111f}
                };
                
                int[][] newSize = new int [height][width];
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        newSize[i][j] = newImageSize[i][j];
                        if(i == 0 || j % width == 0 || j == width-1 || i == height-1){
                            newSize[i][j] = 255;
                        }
                    }
                }
                
                int sum = 0;
                for(int i = 1; i < height - 1; i++){
                    for(int j = 1; j < width - 1; j++){
                        sum = 0;
                        for(int a = -1; a < 2; a++){
                            for(int b = -1; b < 2; b++){
                                sum = (int)(data[a + 1][b + 1] * newImageSize[i - a][j - b]) + sum;
                            }
                        }
                        if(sum < 0){
                            newSize[i][j] = 0;
                        }
                        else if(sum > 255){
                            newSize[i][j] = 255;
                        }
                        else {
                            newSize[i][j] = sum;
                        }
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/Imgpro_LowPass3x3.raw");  
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newSize[i][j]);
                    }
                }
                output.close();

            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
    img_lowpass5x5.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 100;
            int width = 122; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/Imgpro.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
            
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                double[][] data = {
                    {0.04 , 0.04 , 0.04 , 0.04 , 0.04}, // 0
                    {0.04 , 0.04 , 0.04 , 0.04 , 0.04}, // 1
                    {0.04 , 0.04 , 0.04 , 0.04 , 0.04}, // 2
                    {0.04 , 0.04 , 0.04 , 0.04 , 0.04}, // 3
                    {0.04 , 0.04 , 0.04 , 0.04 , 0.04}  // 4
                };
                
                int[][] newSize = new int [height][width];
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        newSize[i][j] = newImageSize[i][j];
                        if(i == 0 || j % width == 0 || j == width-1 || i == height-1){
                            newSize[i][j] = 255;
                        }
                    }
                }
                
                int sum = 0;
                double temp;
                int num_1 , num_2 , num_3;
                for(int i = 1; i < height - 1; i++){
                    for(int j = 1; j < width - 1; j++){
                        sum = 0;

                        for(int a = -3; a < 2; a++){
                            for(int b = -3; b < 2; b++){
                                num_1 = i - a;
                                num_2 = j - b;

                                if(num_1 >= width){
                                    num_3 = 0;
                                }
                                else if(num_2 >= height){
                                    num_3 = 0;
                                }
                                else if(num_1 >= height || num_2 >= width){
                                    num_3 = 0;
                                }
                                else{
                                    num_3 = newImageSize[i - a][j - b];
                                }
                                sum = (int)(data[a + 3][b + 3] * num_3) + sum;
                            }
                        }
                        if(sum < 0){
                            newSize[i][j] = 0;
                        }
                        else if(sum > 255){
                            newSize[i][j] = 255;
                        }
                        else {
                            newSize[i][j] = sum;
                        }
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/Imgpro_LowPass5x5.raw");  
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newSize[i][j]);
                    }
                }
                output.close();

            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
    img_highpass.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 100;
            int width = 122; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/Imgpro.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
            
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                int[][] kernel3x3 = {
                    {-1 , -1 , -1},
                    {-1 , 8 , -1},
                    {-1 , -1 , -1}
                };
                
                int[][] newSize = new int[height][width];
                int count = 0;
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        newSize[i][j] = newImageSize[i][j];
                        if(i == 0 || j % width == 0 || j == width-1 || i == height-1){
                            newSize[i][j] = 255;
                        }
                    }
                }
                
                int sumZero, max = 0, min = 0;
                for(int i = 1; i < height - 1; i++){
                    for(int j = 1; j < width - 1; j++){
                        sumZero = 0;
                        for(int a = -1; a < 2; a++){
                            for(int b = -1; b < 2; b++){
                                sumZero = (kernel3x3[a + 1][b + 1] * newImageSize[i - a][j - b]) + sumZero;
                                if(sumZero > max){
                                    max = sumZero;
                                }
                                if(sumZero < min){
                                    min = sumZero;
                                }
                            }
                        }
                    }
                }
                
                int sum;
                int total;
                total = max + min;
                Math.abs(total);
                for(int i = 1; i < height - 1; i++){
                    for(int j = 1; j < width - 1; j++){
                        sum = 0;
                        for(int a = -1; a < 2; a++){
                            for(int b = -1; b < 2; b++){
                                sum = (kernel3x3[a + 1][b + 1] * newImageSize[i - a][j - b]) + sum;
                            }
                        }
                        if(sum < 0){
                            newSize[i][j] = (255 * (sum + Math.abs(min))/total);
                        }
                        else {
                            newSize[i][j] = sum;
                        }
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/Imgpro_highPass3x3.raw");  
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newSize[i][j]);
                    }
                }
                output.close();
                }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
    img_highboost.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {  
            Scanner in = new Scanner(System.in);
            int height = 100;
            int width = 122; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/Imgpro.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
            
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                
                int c = 0;
                boolean onOff = true;
                while(onOff){
                    System.out.print("Input a number bigger than 8: ");
                    c = in.nextInt();
                    if(c < 8){
                        System.out.print("Invalid Input! Input bigger than 8");
                        System.out.println("Insert a number(must bigger than 8): ");
                    }else{
                        onOff = false;
                    }
                }
                
                int[][] kernelC = {
                    {-1 , -1 , -1},
                    {-1 , c , -1},
                    {-1 , -1 , -1}
                };
                
                int[][] newSize = new int[height][width];
                int count = 0;
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        newSize[i][j] = newImageSize[i][j];
                        if(i == 0 || j % width == 0 || j == width-1 || i == height-1){
                            newSize[i][j] = 255;
                        }
                    }
                }
                
                int sum = 0;
                for(int i = 1; i < height - 1; i++){
                    for(int j = 1; j < width - 1; j++){
                        //System.out.print(data[i][j] + " ");
                        sum = 0;
                        for(int a = -1; a < 2; a++){
                            for(int b = -1; b < 2; b++){
                                sum = (kernelC[a + 1][b + 1] * newImageSize[i - a][j - b]) + sum;
                            }
                        }
                        if(sum < 0){
                            newSize[i][j] = 0;
                        }
                        else if(sum > 255){
                            newSize[i][j] = 255;
                        }
                        else {
                            newSize[i][j] = sum;
                        }
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/Imgpro_highBoost" + c + ".raw");  
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newSize[i][j]);
                    }
                }
                output.close();
                }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
    img_median.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 100;
            int width = 122; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/Imgpro.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
            
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                int[][] newSize = new int[height][width];
                int count = 0;
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        newSize[i][j] = newImageSize[i][j];
                        if(i == 0 || j % width == 0 || j == width-1 || i == height-1){
                            newSize[i][j] = 255;
                        }
                    }
                }
                
                int[] sum = new int[9];
                for(int i = 1; i < height - 1; i++){
                    for(int j = 1; j < width - 1; j++){
                        count = 0;
                        for(int a = -1; a < 2; a++){
                            for(int b = -1; b < 2; b++){
                                sum[count] = newImageSize[i - a][j - b];
                                count++;
                            }
                        }
                        Arrays.sort(sum);
                        newSize[i][j] = sum[4];
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/Imgpro_Median Filter.raw");  
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newSize[i][j]);
                    }
                }
                output.close();
            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
    img_mean.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 100;
            int width = 122; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/Imgpro.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
            
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                int[][] newSize = new int[height][width];
                int count = 0;
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        newSize[i][j] = newImageSize[i][j];
                        if(i == 0 || j % width == 0 || j == width-1 || i == height-1){
                            newSize[i][j] = 255;
                        }
                    }
                }
                
                int sum = 0;
                for(int i = 1; i < height - 1; i++){
                    for(int j = 1; j < width - 1; j++){
                        sum = 0;
                        for(int a = -1; a < 2; a++){
                            for(int b = -1; b < 2; b++){
                                sum = (newImageSize[i - a][j - b]) + sum;
                            }
                        }
                        newSize[i][j] = (sum / 9);
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/Imgpro_Mean Filter.raw");  
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newSize[i][j]);
                    }
                }
                output.close();
            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
    //prewitt
    img_edge.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 100;
            int width = 122; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/Imgpro.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
            
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                int[][] newSize = new int[height][width];
                int count = 0;
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        newSize[i][j] = newImageSize[i][j];
                        if(i == 0 || j % width == 0 || j == width-1 || i == height-1){
                            newSize[i][j] = 255;
                        }
                    }
                }
                
                int[] sum = new int [9];
                for(int i = 1; i < height - 1; i++){
                    for(int j = 1; j < width - 1; j++){
                        count = 0;
                        for(int a = -1; a < 2; a++){
                            for(int b = -1; b < 2; b++){
                                sum[count] = newImageSize[i - a][j - b];
                                count++;
                            }
                        }
                        newSize[i][j] = ((sum[8] + sum[7] + sum[6]) - (sum[0] 
                                        + sum[1] + sum[2])) + ((sum[2] + sum[5] 
                                        + sum[8]) - (sum[0] - sum[3] - sum[6]));
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/Imgpro_Edge Detection PrewittOperator.raw");  
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newSize[i][j]);
                    }
                }
                output.close();
            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
     img_edgeSobel.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 100;
            int width = 122; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/Imgpro.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
            
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                int[][] newSize = new int[height][width];
                int count = 0;
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        newSize[i][j] = newImageSize[i][j];
                        if(i == 0 || j % width == 0 || j == width-1 || i == height-1){
                            newSize[i][j] = 255;
                        }
                    }
                }
                
                int[] sum = new int [9];
                for(int i = 1; i < height - 1; i++){
                    for(int j = 1; j < width - 1; j++){
                        count = 0;
                        for(int a = -1; a < 2; a++){
                            for(int b = -1; b < 2; b++){
                                sum[count] = newImageSize[i - a][j - b];
                                count++;
                            }
                        }
                        newSize[i][j] = ((sum[6] + (2 * sum[7]) + sum[8]) - (sum[0] 
                                          + (2 * sum[1]) + sum[2])) + ((sum[2] + (2 * sum[5]) 
                                          + sum[8]) - (sum[0] - (2 * sum[3]) - sum[6]));
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/Imgpro_Edge Detection SobelGradient.raw");  
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newSize[i][j]);
                    }
                }
                output.close();
            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
     
   //size will be doubled
    img_enlarge.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 100;
            int width = 122; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/Imgpro.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
            
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                int[][] newSize = new int[height*2][width*2];
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        for(int a = 0; a < 2; a++){
                            for(int b = 0; b < 2; b++){
                                newSize[(i * 2) + a][(j * 2) + b] = newImageSize[i][j];
                            }
                        }
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/Imgpro_Enlarged.raw");  
                for(int i = 0; i < (height * 2); i++){
                    for(int j = 0; j < (width * 2); j++){
                        output.write(newSize[i][j]);
                    }
                }
                output.close();
            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
    img_shrinking.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 100;
            int width = 122; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/Imgpro.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
            
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                int[][] newSize = new int[height/2][width/2];
                int temp;
                for(int i = 0; i < height/2; i++){
                    for(int j = 0; j < width/2; j++){
                        temp = 0;
                        for(int a = 0; a < 2; a++){
                            for(int b = 0; b < 2; b++){
                                //new_data[(i * 2) + a][(j * 2) + b] = data[(i * 2) + a][(j * 2) + b];
                                temp = newImageSize[(i * 2) + a][(j * 2) + b] + temp;
                                //System.out.println((i * 2) + a);
                            }
                        }
                        //System.out.println("j: " + j);
                        newSize[i][j] = (temp / 4);
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/Imgpro_Shrinking.raw");  
                for(int i = 0; i < height/2; i++){
                    for(int j = 0; j < width/2; j++){
                        output.write(newImageSize[i][j]);
                    }
                }
                output.close();
            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    //yoda
    yoda = new JLabel("yoda");
    yoda.setBounds(560,1,100,30);
    add(yoda);
    
    yd_dit2x2 = new JButton("Dithering2x2");//1
    yd_dit2x2.setBounds(500,30,150,30);
    add(yd_dit2x2);
    
    yd_dit4x4 = new JButton("Dithering4x4");//2
    yd_dit4x4.setBounds(500,65,150,30);
    add(yd_dit4x4);
    
    yd_histogram = new JButton("Histogram");//3
    yd_histogram.setBounds(500,100,150,30);
    add(yd_histogram);
    
    yd_convolution = new JButton("Convolution");//4
    yd_convolution.setBounds(500,135,150,30);
    add(yd_convolution);
    
    yd_lowpass = new JButton("Low-Pass Filter");//5
    yd_lowpass.setBounds(500,170,150,30);
    add(yd_lowpass);  
    
    yd_lowpass5x5 = new JButton("Low-PassFilter 5x5");//6
    yd_lowpass5x5.setBounds(500,205,150,30);
    add(yd_lowpass5x5);
    
    yd_highpass = new JButton("High-Pass Filter");//7
    yd_highpass.setBounds(500,240,150,30);
    add(yd_highpass);
    
    yd_highboost = new JButton("High-Boost Filter");//8
    yd_highboost.setBounds(500,275,150,30);
    add(yd_highboost);
    
    yd_median = new JButton("Median Filter");//9
    yd_median.setBounds(500,310,150,30);
    add(yd_median);
    
    yd_mean = new JButton("Mean Filter");//10
    yd_mean.setBounds(500,345,150,30);
    add(yd_mean);
    
    yd_edge = new JButton("Prewitt Edge Detection");//11
    yd_edge.setBounds(500,380,150,30);
    add(yd_edge);   
    
    yd_edgeSobel = new JButton("Sobel Edge Detection");//12
    yd_edgeSobel.setBounds(500,415,150,30);
    add(yd_edgeSobel);
    
    yd_enlarge = new JButton("Enlarge");//13
    yd_enlarge.setBounds(500,450,150,30);
    add(yd_enlarge);
    
    yd_shrinking = new JButton("Shrinking");//14
    yd_shrinking.setBounds(500,485,150,30);
    add(yd_shrinking);
    
    yd_dit2x2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 62;
            int width = 123; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/yoda.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
                    
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                int[][] dithering2x2 ={
                    {0, 128},
                    {192, 64}
                };
                
                int count = 0, a = 0, b = 0;
                while (count != height){
                    if (count % 2 == 0){
                        for(int j = 0; j < width; j++){
                            if (j % 2 ==0){
                                a = 0;
                            }else{
                                a = 1;
                            }

                            if(newImageSize[count][j] > dithering2x2[0][a]){
                                newImageSize[count][j] = 255;
                            }else{
                                newImageSize[count][j] = 0;
                            }
                        }
                    }
                    else{
                        for(int j = 0; j < width; j++){
                            if(j % 2 == 0){
                                a = 0;
                            }else{
                                a = 1;
                            }

                            if(newImageSize[count][j] > dithering2x2[1][a]){
                                newImageSize[count][j] = 255;
                            }else{
                                newImageSize[count][j] = 0;
                            }
                        }
                    } count++;
                }
                
                FileOutputStream output = new FileOutputStream("output/yoda_dithering2x2.raw"); 
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newImageSize[i][j]);
                    }
                }
                
            }
            catch (Exception ex){
                    System.out.println("Exception: " + ex);
            }    
        }
    });
    
    yd_dit4x4.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 62;
            int width = 123; 
            int countHeight = 0 , countWidth = 0;
            int[][] newImageSize = new int[height][width];
            
            try{
                File fileName = new File("Images/yoda.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
                
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                int[][] dithering4x4 ={
                    { 0 , 128 , 32 , 160},
                    { 192 , 64 , 224 , 96},
                    { 48 , 176 , 16 , 144},
                    { 240 , 112 , 208 , 80}
                };
                
                int count = 0, a = 0, b = 0;
                boolean onOff = true;
                while(onOff){
                    for(int i = 0; i < width; i++){
                        if(a == 4){
                            a = 0;
                        }
                        if(newImageSize[count][i] > dithering4x4[0][a]){
                            newImageSize[count][i] = 225;
                        }
                        else{
                            newImageSize[count][i] = 0;
                        } a++;  
                    }
                    
                    //1
                    count++;
                    if(count == height){
                        break;
                    }
                    a = 0;
                    
                    //2
                    for(int i = 0; i < width; i++){
                        if(a == 4){
                            a = 0;
                        }
                        if(newImageSize[count][i] > dithering4x4[1][a]){
                            newImageSize[count][i] = 225;
                        }
                        else{
                            newImageSize[count][i] = 0;
                        } a++;
                    }
                    count++;
                    if (count == height){
                        break;
                    }
                    a = 0;
                    
                    //3
                    for(int i = 0; i < width; i++){
                        if(a == 4){
                            a = 0;
                        }
                        if(newImageSize[count][i] > dithering4x4[2][a]){
                            newImageSize[count][i] = 225;
                        }
                        else{
                            newImageSize[count][i] = 0;
                        } a++;
                    }
                    count++;
                    if(count == height){
                        break;
                    }
                    a = 0;
                    
                    //4
                    for(int i = 0; i < width; i++){
                        if(a == 4){
                            a = 0;
                        }
                        if(newImageSize[count][i] > dithering4x4[3][a]){
                            newImageSize[count][i] = 225;
                        }
                        else{
                            newImageSize[count][i] = 0;
                        } a++;
                    }
                    count++;
                    if(count == height){
                        break;
                    }
                    a = 0;
                }
                
                FileOutputStream output = new FileOutputStream("output/yoda_dithering4x4.raw");  
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newImageSize[i][j]);
                    }
                }
                output.close();
            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
    yd_histogram.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 62;
            int width = 123;
            int countHeight = 0 , countWidth = 0;
            //int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/yoda.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
                    
                int[] array = new int[256];
                int value;
                    
                int[] newImageSize = new int[(int)fileName.length()];
                int count = 0;
                while((value = myInputFile.read()) != -1){
                    newImageSize[count] = value;
                    array[value]++;
                    count++;
                }
                    
                int a = 0, b;
                int[] newArray = new int[256];
                for(int i = 0; i < 256; i++){
                    a = array[i] + a;
                    b = (a * 255)/(width * height);
                    newArray[i] = b;
                }
                FileOutputStream output = new FileOutputStream("output/yoda_HISTOGRAM.raw");
                for(int i = 0; i < fileName.length(); i++){
                    output.write(newArray[newImageSize[i]]);
                }
                output.close();
                    
                    //convert to Image
                    
            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
    yd_convolution.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 62;
            int width = 123; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            
            try{
                File fileName = new File("Images/yoda.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
                
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                int[][] kernal = {
                    {-1 , 0 , 1},
                    {-2 , 0 , 2},
                    {-1 , 0 , 1}
                };
                
                int[][] newSize = new int[height][width];
                int count = 0;
                for(int i = 0; i < height; i++){
                    for (int j = 0; j < width; j++){
                        newSize[i][j] = newImageSize[i][j];
                        if(i == 0 || j  % width == 0 || j == width-1 || i == height-1){
                            newSize[i][j] = 255;
                        }
                    }
                }
                
                int sum = 0;
                for(int i = 1; i < height - 1; i++){
                    for(int j = 1; j < width - 1; j++){
                        sum = 0;
                        for(int a = -1; a < 2; a++){
                            for(int b = -1; b < 2; b++){
                                sum = (kernal[a + 1][b + 1] * newImageSize[i - a][j - b]) + sum;
                            }
                        }
                        if(sum < 0){
                            newSize[i][j] = 0;
                        }
                        else if(sum > 255){
                            newSize[i][j] = 255;
                        }
                        else {
                            newSize[i][j] = sum;
                        }
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/yoda_CONVOLUTION.raw");
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newSize[i][j]);
                    }
                }
                output.close(); 

            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
    yd_lowpass.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 62;
            int width = 123; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/yoda.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
            
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                float[][] data = {
                    {0.111f , 0.111f , 0.111f},
                    {0.111f , 0.111f , 0.111f},
                    {0.111f , 0.111f , 0.111f}
                };
                
                int[][] newSize = new int [height][width];
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        newSize[i][j] = newImageSize[i][j];
                        if(i == 0 || j % width == 0 || j == width-1 || i == height-1){
                            newSize[i][j] = 255;
                        }
                    }
                }
                
                int sum = 0;
                for(int i = 1; i < height - 1; i++){
                    for(int j = 1; j < width - 1; j++){
                        sum = 0;
                        for(int a = -1; a < 2; a++){
                            for(int b = -1; b < 2; b++){
                                sum = (int)(data[a + 1][b + 1] * newImageSize[i - a][j - b]) + sum;
                            }
                        }
                        if(sum < 0){
                            newSize[i][j] = 0;
                        }
                        else if(sum > 255){
                            newSize[i][j] = 255;
                        }
                        else {
                            newSize[i][j] = sum;
                        }
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/yoda_LowPass3x3.raw");  
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newSize[i][j]);
                    }
                }
                output.close();

            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
    yd_lowpass5x5.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 62;
            int width = 123; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/yoda.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
            
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                double[][] data = {
                    {0.04 , 0.04 , 0.04 , 0.04 , 0.04}, // 0
                    {0.04 , 0.04 , 0.04 , 0.04 , 0.04}, // 1
                    {0.04 , 0.04 , 0.04 , 0.04 , 0.04}, // 2
                    {0.04 , 0.04 , 0.04 , 0.04 , 0.04}, // 3
                    {0.04 , 0.04 , 0.04 , 0.04 , 0.04}  // 4
                };
                
                int[][] newSize = new int [height][width];
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        newSize[i][j] = newImageSize[i][j];
                        if(i == 0 || j % width == 0 || j == width-1 || i == height-1){
                            newSize[i][j] = 255;
                        }
                    }
                }
                
                int sum = 0;
                double temp;
                int num_1 , num_2 , num_3;
                for(int i = 1; i < height - 1; i++){
                    for(int j = 1; j < width - 1; j++){
                        sum = 0;

                        for(int a = -3; a < 2; a++){
                            for(int b = -3; b < 2; b++){
                                num_1 = i - a;
                                num_2 = j - b;

                                if(num_1 >= width){
                                    num_3 = 0;
                                }
                                else if(num_2 >= height){
                                    num_3 = 0;
                                }
                                else if(num_1 >= height || num_2 >= width){
                                    num_3 = 0;
                                }
                                else{
                                    num_3 = newImageSize[i - a][j - b];
                                }
                                sum = (int)(data[a + 3][b + 3] * num_3) + sum;
                            }
                        }
                        if(sum < 0){
                            newSize[i][j] = 0;
                        }
                        else if(sum > 255){
                            newSize[i][j] = 255;
                        }
                        else {
                            newSize[i][j] = sum;
                        }
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/yoda_LowPass5x5.raw");  
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newSize[i][j]);
                    }
                }
                output.close();

            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
    yd_highpass.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 62;
            int width = 123; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/yoda.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
            
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                int[][] kernel3x3 = {
                    {-1 , -1 , -1},
                    {-1 , 8 , -1},
                    {-1 , -1 , -1}
                };
                
                int[][] newSize = new int[height][width];
                int count = 0;
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        newSize[i][j] = newImageSize[i][j];
                        if(i == 0 || j % width == 0 || j == width-1 || i == height-1){
                            newSize[i][j] = 255;
                        }
                    }
                }
                
                int sumZero, max = 0, min = 0;
                for(int i = 1; i < height - 1; i++){
                    for(int j = 1; j < width - 1; j++){
                        sumZero = 0;
                        for(int a = -1; a < 2; a++){
                            for(int b = -1; b < 2; b++){
                                sumZero = (kernel3x3[a + 1][b + 1] * newImageSize[i - a][j - b]) + sumZero;
                                if(sumZero > max){
                                    max = sumZero;
                                }
                                if(sumZero < min){
                                    min = sumZero;
                                }
                            }
                        }
                    }
                }
                
                int sum;
                int total;
                total = max + min;
                Math.abs(total);
                for(int i = 1; i < height - 1; i++){
                    for(int j = 1; j < width - 1; j++){
                        sum = 0;
                        for(int a = -1; a < 2; a++){
                            for(int b = -1; b < 2; b++){
                                sum = (kernel3x3[a + 1][b + 1] * newImageSize[i - a][j - b]) + sum;
                            }
                        }
                        if(sum < 0){
                            newSize[i][j] = (255 * (sum + Math.abs(min))/total);
                        }
                        else {
                            newSize[i][j] = sum;
                        }
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/yoda_highPass3x3.raw");  
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newSize[i][j]);
                    }
                }
                output.close();
                }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
    yd_highboost.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {  
            Scanner in = new Scanner(System.in);
            int height = 62;
            int width = 123; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/yoda.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
            
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                
                int c = 0;
                boolean onOff = true;
                while(onOff){
                    System.out.print("Input a number bigger than 8: ");
                    c = in.nextInt();
                    if(c < 8){
                        System.out.print("Invalid Input! Input bigger than 8");
                        System.out.println("Insert a number(must bigger than 8): ");
                    }else{
                        onOff = false;
                    }
                }
                
                int[][] kernelC = {
                    {-1 , -1 , -1},
                    {-1 , c , -1},
                    {-1 , -1 , -1}
                };
                
                int[][] newSize = new int[height][width];
                int count = 0;
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        newSize[i][j] = newImageSize[i][j];
                        if(i == 0 || j % width == 0 || j == width-1 || i == height-1){
                            newSize[i][j] = 255;
                        }
                    }
                }
                
                int sum = 0;
                for(int i = 1; i < height - 1; i++){
                    for(int j = 1; j < width - 1; j++){
                        //System.out.print(data[i][j] + " ");
                        sum = 0;
                        for(int a = -1; a < 2; a++){
                            for(int b = -1; b < 2; b++){
                                sum = (kernelC[a + 1][b + 1] * newImageSize[i - a][j - b]) + sum;
                            }
                        }
                        if(sum < 0){
                            newSize[i][j] = 0;
                        }
                        else if(sum > 255){
                            newSize[i][j] = 255;
                        }
                        else {
                            newSize[i][j] = sum;
                        }
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/yoda_highBoost" + c + ".raw");  
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newSize[i][j]);
                    }
                }
                output.close();
                }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
    yd_median.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 62;
            int width = 123; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/yoda.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
            
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                int[][] newSize = new int[height][width];
                int count = 0;
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        newSize[i][j] = newImageSize[i][j];
                        if(i == 0 || j % width == 0 || j == width-1 || i == height-1){
                            newSize[i][j] = 255;
                        }
                    }
                }
                
                int[] sum = new int[9];
                for(int i = 1; i < height - 1; i++){
                    for(int j = 1; j < width - 1; j++){
                        count = 0;
                        for(int a = -1; a < 2; a++){
                            for(int b = -1; b < 2; b++){
                                sum[count] = newImageSize[i - a][j - b];
                                count++;
                            }
                        }
                        Arrays.sort(sum);
                        newSize[i][j] = sum[4];
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/yoda_Median Filter.raw");  
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newSize[i][j]);
                    }
                }
                output.close();
            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
    yd_mean.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 62;
            int width = 123; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/yoda.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
            
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                int[][] newSize = new int[height][width];
                int count = 0;
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        newSize[i][j] = newImageSize[i][j];
                        if(i == 0 || j % width == 0 || j == width-1 || i == height-1){
                            newSize[i][j] = 255;
                        }
                    }
                }
                
                int sum = 0;
                for(int i = 1; i < height - 1; i++){
                    for(int j = 1; j < width - 1; j++){
                        sum = 0;
                        for(int a = -1; a < 2; a++){
                            for(int b = -1; b < 2; b++){
                                sum = (newImageSize[i - a][j - b]) + sum;
                            }
                        }
                        newSize[i][j] = (sum / 9);
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/yoda_Mean Filter.raw");  
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newSize[i][j]);
                    }
                }
                output.close();
            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
    //prewitt
    yd_edge.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 62;
            int width = 123; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/yoda.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
            
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                int[][] newSize = new int[height][width];
                int count = 0;
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        newSize[i][j] = newImageSize[i][j];
                        if(i == 0 || j % width == 0 || j == width-1 || i == height-1){
                            newSize[i][j] = 255;
                        }
                    }
                }
                
                int[] sum = new int [9];
                for(int i = 1; i < height - 1; i++){
                    for(int j = 1; j < width - 1; j++){
                        count = 0;
                        for(int a = -1; a < 2; a++){
                            for(int b = -1; b < 2; b++){
                                sum[count] = newImageSize[i - a][j - b];
                                count++;
                            }
                        }
                        newSize[i][j] = ((sum[8] + sum[7] + sum[6]) - (sum[0] 
                                        + sum[1] + sum[2])) + ((sum[2] + sum[5] 
                                        + sum[8]) - (sum[0] - sum[3] - sum[6]));
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/yoda_Edge Detection PrewittOperator.raw");  
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newSize[i][j]);
                    }
                }
                output.close();
            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
     yd_edgeSobel.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 62;
            int width = 123; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/yoda.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
            
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                int[][] newSize = new int[height][width];
                int count = 0;
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        newSize[i][j] = newImageSize[i][j];
                        if(i == 0 || j % width == 0 || j == width-1 || i == height-1){
                            newSize[i][j] = 255;
                        }
                    }
                }
                
                int[] sum = new int [9];
                for(int i = 1; i < height - 1; i++){
                    for(int j = 1; j < width - 1; j++){
                        count = 0;
                        for(int a = -1; a < 2; a++){
                            for(int b = -1; b < 2; b++){
                                sum[count] = newImageSize[i - a][j - b];
                                count++;
                            }
                        }
                        newSize[i][j] = ((sum[6] + (2 * sum[7]) + sum[8]) - (sum[0] 
                                          + (2 * sum[1]) + sum[2])) + ((sum[2] + (2 * sum[5]) 
                                          + sum[8]) - (sum[0] - (2 * sum[3]) - sum[6]));
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/yoda_Edge Detection SobelGradient.raw");  
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        output.write(newSize[i][j]);
                    }
                }
                output.close();
            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
     
    //size will be doubled
    yd_enlarge.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 62;
            int width = 123; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/yoda.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
            
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                int[][] newSize = new int[height*2][width*2];
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        for(int a = 0; a < 2; a++){
                            for(int b = 0; b < 2; b++){
                                newSize[(i * 2) + a][(j * 2) + b] = newImageSize[i][j];
                            }
                        }
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/yoda_Enlarged.raw");  
                for(int i = 0; i < (height * 2); i++){
                    for(int j = 0; j < (width * 2); j++){
                        output.write(newSize[i][j]);
                    }
                }
                output.close();
            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
    yd_shrinking.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
            int height = 62;
            int width = 123; 
            int countHeight = 0 , countWidth = 0;
            
            int[][] newImageSize = new int[height][width];
            try{
                File fileName = new File("Images/yoda.raw");
                FileInputStream myInputFile = new FileInputStream(fileName);
            
                int value; 
                while((value = myInputFile.read()) != -1){
                    if(countWidth == width){
                        countWidth = 0;
                        countHeight++;
                    }
                    newImageSize[countHeight][countWidth] = value;
                    countWidth++;
                }
                
                int[][] newSize = new int[height/2][width/2];
                int temp;
                for(int i = 0; i < height/2; i++){
                    for(int j = 0; j < width/2; j++){
                        temp = 0;
                        for(int a = 0; a < 2; a++){
                            for(int b = 0; b < 2; b++){
                                //new_data[(i * 2) + a][(j * 2) + b] = data[(i * 2) + a][(j * 2) + b];
                                temp = newImageSize[(i * 2) + a][(j * 2) + b] + temp;
                                //System.out.println((i * 2) + a);
                            }
                        }
                        //System.out.println("j: " + j);
                        newSize[i][j] = (temp / 4);
                    }
                }
                
                FileOutputStream output = new FileOutputStream("output/yoda_Shrinking.raw");  
                for(int i = 0; i < height/2; i++){
                    for(int j = 0; j < width/2; j++){
                        output.write(newImageSize[i][j]);
                    }
                }
                output.close();
            }
            catch (Exception ex){
                System.out.println("Exception: " + ex);
            }
        }
    });
    
    setLayout(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //setLocationRelativeTo(null);
    setSize(700,600);
    setVisible(true);
    }
    public static void main(String[] args) {
        new Group_project();
    }
    
}
