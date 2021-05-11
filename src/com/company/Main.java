package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");
        operate(array); // чтобы сменить решим на консольный, замените array на args и закомментируйте строчки 14 и 15
    }

    public static void operate(String[] args){
        switch (args.length){
            case 1:
                if(args[0].equals("read")){
                    try(FileReader reader = new FileReader("players.txt"))
                    {
                        // читаем посимвольно
                        int c;
                        while((c=reader.read())!=-1){

                            System.out.print((char)c);
                        }
                    }
                    catch(IOException ex){

                        System.out.println(ex.getMessage());
                    }
                }
                else if(args[0].equals("delete")){
                    try(FileWriter writer = new FileWriter("players.txt", false))
                    {
                        // запись всей строки
                        String text = "";
                        writer.write(text);
                        writer.flush();
                        System.out.println("File cleared");
                    }
                    catch(IOException ex){

                        System.out.println(ex.getMessage());
                    }
                }
                else if(args[0].equals("shuffle")){
                    try(FileReader reader = new FileReader("players.txt"))
                    {
                        String global = "";
                        // читаем посимвольно
                        int c;
                        while((c=reader.read())!=-1){
                           global+=String.valueOf((char) c);

                        }
                        //System.out.println("// " + global);
//                        ArrayList<String> array = new ArrayList<>();
                        ArrayList<String> we = new ArrayList<>();
                        ArrayList<String> they = new ArrayList<>();
                        String[] array = global.split(" # ");
                        for (int i = 0; i < array.length; i++) {
                            //System.out.println("// " + array[i]);
                            //System.out.println("// " + String.valueOf(array[i].charAt(array[i].length()-2)));
                            if (array[i]!=null){
                                if(!array[i].equals("")){
                                    if (String.valueOf(array[i].charAt(array[i].length()-2)).equals("И")){
                                        we.add(array[i]);
                                    }
                                    else if (String.valueOf(array[i].charAt(array[i].length()-2)).equals("4")){
                                        they.add(array[i]);
                                    }
                                }
                            }
                        }
                        Integer position;
                        while (we.size()>0 || they.size()>0){
                            if(we.size()==0){
                                position = (int) (Math.random() * they.size());
                                //System.out.println("// position " + position.toString());
                                System.out.println(they.get(position));
                                they.remove(position+0);
                            }
                            else if(they.size()==0) {
                                position = (int) (Math.random() * we.size());
                                //System.out.println("// position " + position.toString());
                                System.out.println(we.get(position));
                                we.remove(position+0);
                            }
                            else if(they.size()>we.size()){
                                position = (int) (Math.random() * they.size());
                                //System.out.println("// position " + position.toString());
                                System.out.println(they.get(position));
                                they.remove(position+0);

                                position = (int) (Math.random() * we.size());
                                //System.out.println("// position " + position.toString());
                                System.out.println(we.get(position));
                                we.remove(position+0);
                            }
                            else {
                                position = (int) (Math.random() * we.size());
                                //System.out.println("// position " + position.toString());
                                System.out.println(we.get(position));
                                we.remove(position+0);

                                position = (int) (Math.random() * they.size());
                                //System.out.println("// position " + position.toString());
                                System.out.println(they.get(position));
                                they.remove(position+0);
                            }
                        }
                    }
                    catch(IOException ex){

                        System.out.println(ex.getMessage());
                    }
                }
                break;
            case 4:
                String text = "";
                if(args[0].equals("put")){
                    try(FileReader reader = new FileReader("players.txt"))
                    {
                        // читаем посимвольно
                        int c;
                        //System.out.print("// ");
                        while((c=reader.read())!=-1){
                            text+=String.valueOf((char) c);
                            //System.out.print((char)c);
                        }
                        //System.out.println("");
                    }
                    catch(IOException ex){
                        System.out.println(ex.getMessage());
                    }

                    try(FileWriter writer = new FileWriter("players.txt", false))
                    {
                        //System.out.println("// " + text);

                        text+=args[1]+" "+args[2];
                        if (args[3].equals("1")){
                            text+=" (Предуниверситарий НИЯУ МИФИ) # ";
                        }
                        else{
                            text+=" (ГБОУ Школа 1474) # ";
                        }
                        writer.write(text);
                        writer.flush();
                        System.out.println("Student added");
                    }
                    catch(IOException ex){

                        System.out.println(ex.getMessage());
                    }
                }
                break;
        }
    }
}
