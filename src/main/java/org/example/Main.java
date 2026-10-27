package org.example;

import org.example.buoi261026.Circle;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(1,1,3.5);
        Circle circle2 = new Circle();

        System.out.println("Circle 1: " + circle);
        System.out.println("Circle 2: " + circle2);
        System.out.println("dien tich hinh tron 1 là: " + circle.area());

        if(circle.area() > circle2.area()){
            System.out.println("Hình tròn 1 có diện tích lớn hơn hình tròn 2");
        } else if(circle.area() < circle2.area()){
            System.out.println("Hình tròn 2 có diện tích lớn hơn hình tròn 1");
        } else {
            System.out.println("Hai hình tròn có diện tích bằng nhau");
        }

        System.out.println("Tịnh tiến : " + circle.tinhTien(2));

    }
}