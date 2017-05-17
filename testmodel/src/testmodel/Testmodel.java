package testmodel;

import java.awt.Label;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Testmodel {

    public static void main(String[] args) {
        String nume[] = {"test3","test2"};
        Arrays.sort(nume, (a,b) -> { return a.compareTo(b); });
        System.out.println(nume[0] + " " + nume[1]);
        
        ArrayList<Integer> lista1 = new ArrayList<>();
        ArrayList<Integer> lista2 = new ArrayList<>();
        ArrayList<Integer> lista3 = new ArrayList<>();
        
        lista1.add(1);
        lista1.add(3);
        lista1.add(5);
        lista1.add(7);
        
        lista2.add(2);
        lista2.add(4);
        lista2.add(6);
        lista2.add(8);
        
        int i1 = 0;
        int i2 = 0;
        
        while(i1<lista1.size() && i2<lista2.size()){
            if (lista1.get(i1) <= lista2.get(i2)){
                lista3.add(lista1.get(i1++));
            }else{
                lista3.add(lista2.get(i2++));
            }
        }
        
        while(i1<lista1.size()){
            lista3.add(lista1.get(i1++));
        }
        
        while(i2<lista2.size()){
            lista3.add(lista2.get(i2++));
        }
        System.out.println(lista3.toString());
        
//        Ex6("testam si noi","iauzi bre");
        //ex9(3);
        
        Arrays.asList(2,1,12,3,123,4)
              .stream()
              .map(x -> String.valueOf(x))
              .sorted((a,b) -> a.compareTo(b))
              .map(x -> Integer.parseInt(x))
              .forEach(System.out :: println);
        Integer a = new Integer(3);
        int c = 4;
        interschimbare(a,c);
        System.out.println(a+ " " + c);
    }
    
//    public void ex2(Scanner sc,String terminator,OutputStream os) throws IOException{
//        java.util.Stack<String> temp = new Stack<>();
//        terminator = terminator.toLowerCase();
//        while(sc.hasNext()){
//            String temp1 = sc.next();
//            String temp2 = temp1.toLowerCase();
//            if (temp2.equals(terminator)){
//                break;
//            }else{
//                temp.push(temp1);
//            }
//            
//        }
//        
//        while(!temp.isEmpty()){
//            os.write(temp.pop().getBytes());
//        }
//        os.close();
//        sc.close();
//    }
    
    public static void Ex6(String titlu,String mesaj){
        JFrame frame = new JFrame(titlu);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(new Label(mesaj));
        return;
    }
    
    public Socket ex8(String port) throws IOException{
        
        ServerSocket server = new ServerSocket(Integer.parseInt(port));
        Socket s = server.accept();
        return s;
    }
    
    public static void ex9(int n){
        
        try (Scanner sc = new Scanner(System.in);
             FileOutputStream os = new FileOutputStream("out.txt")){
            for (int i = 0; i < n; i++){
                os.write(sc.next().getBytes());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("iauzi");
        } catch (IOException ex) {
            System.out.println("iauzi2");
        }
    }
    
    public static void interschimbare(Integer a, int b){
        int c = b;
        b = a;
        a = c;
    }
    
    
}
