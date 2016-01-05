package com.haozi;


import com.haozi.future.IntFutre;
import com.haozi.future.Task1;
import com.haozi.future.Tesk2;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by James on 2016/1/4 0004.
 */
public class Test {

    public static void main(String[] args){

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");

        IntFutre intFutre = (IntFutre)applicationContext.getBean("intFutre");

        for(int i=0;i<=10;i++){
            intFutre.exec(Task1.class,String.valueOf(i));
            intFutre.getRmain();
        }
        for(int i=0;i<=10;i++){
            intFutre.exec(Tesk2.class,String.valueOf(i),"nihaoya");
            intFutre.getRmain();
        }

        System.out.println("this is task end....");
      /*  try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        intFutre.getRmain();
*/
    }
}
