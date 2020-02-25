package com.coffee.run;

import com.coffee.Air.NodeAir;
import com.coffee.Air.NodeLoop;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AirApplication {
    public static void main(String[] args) {
       // SpringApplication.run(AirApplication.class,args);
        NodeAir<Integer> a = new NodeAir<>(1);
        NodeAir<Integer> b = new NodeAir<>(2);
        NodeAir<Integer> c = new NodeAir<>(3);
        NodeAir<Integer> d = new NodeAir<>(4);
        a.addNode(b);
        b.addNode(c);
        a.show();
        System.out.println("---------");

        a.after(d);
        a.show();
        System.out.println("-----");
        NodeLoop<Integer> e = new NodeLoop<>(30);
        NodeLoop<Integer> f = new NodeLoop<>(50);
        NodeLoop<Integer> g = new NodeLoop<>(60);

        e.after(f);
        System.out.println(e.nextNode().getData());
        System.out.println(e.nextNode().nextNode().getData());



    }



}
