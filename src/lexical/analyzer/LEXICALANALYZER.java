/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexical.analyzer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/**
 *
 * @author muhaiminur
 */
public class LEXICALANALYZER {

    static List<String> iden = new ArrayList<String>();
    static String []key={"auto","break","case","char","const","continue","default","do","double","else","enum","extern","float","for","goto","if","int","long","register","return","short","signed","sizeof","static","struct","switch","typedef","union","unsigned","void","volatile","while"};
    static List<String> keywords = new ArrayList<String>();
    static String []op={"+","-","/","%","*","="};
    static List<String>operator = new ArrayList<String>();
    static String[]lo={"==","!=",">","<",">=","<="};
    static List<String>logicaloperator = new ArrayList<String>();
    static List<String>num = new ArrayList<String>();
    static String[]ot={",","(",")","{","}",";","[","]"};
    static List<String>other = new ArrayList<String>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            String line;
            while ((line = br.readLine()) != null){
                StringTokenizer st = new StringTokenizer(line);
                while (st.hasMoreElements()){
                    String s=(String)st.nextElement();
                    System.out.println(s);
                    if(Arrays.asList(key).contains(s)){
                            keywords.add(s);
                            while(s.equalsIgnoreCase("int")||s.equalsIgnoreCase("float")){
                                String ss=(String)st.nextElement();
                                if(findc(ss)){
                                    System.out.println("abir============="+ss);
                                    String sp2=spchar(ss);
                                    other.add(sp2);
                                }
                                if(ss.contains(";")){
                                    iden.add(ss);
                                    break;
                                }
                                
                                iden.add(ss);
                            }
                        }
                        if(Arrays.asList(op).contains(s)){
                            operator.add(s);
                        }
                        if(Arrays.asList(lo).contains(s)){
                            logicaloperator.add(s);
                        }
                        if(extractNumber(s)){
                            
                            String sb=s.replace(";","");
                            //System.out.println("result==============ok==============="+sb);
                            num.add(sb);
                        }
                        if(findc(s)){
                            System.out.println("abir============="+s);
                            String sp2=spchar(s);
                            other.add(sp2);
                        }
                }
            }
        } catch (Exception e) {
            
        }
        print();
    }
    public static void check(String s){
        
    }
    public static void print(){
        System.out.println("OUTPUT::");
        System.out.print("PRINTING KEYWORDS ::");
        for (String s : keywords) {
            System.out.print(s+" ");
        }
        System.out.println();
        System.out.print("PRINTING IDENTIFIER ::");
        for (String s : iden) {
            System.out.print(s+" ");
        }
        System.out.println();
        System.out.print("PRINTING MATH OPERATOR ::");
        Set<String> t = new LinkedHashSet<>(operator);
        for (String s : t) {
            System.out.print(s+" ");
        }
        System.out.println();
        System.out.print("PRINTING LOGICAL OPERATORS ::"); // prints "Hello!"
        Set<String> t2 = new LinkedHashSet<>(logicaloperator);
        for (String s : t2) {
            System.out.print(s+" ");
        }
        System.out.println();
        System.out.print("PRINTING NUMARICAL VALUES ::"); // prints "Hello!"
        Set<String> t3 = new LinkedHashSet<>(num);
        for (String s : t3) {
            System.out.print(s+" ");
        }
        System.out.println();
        System.out.print("PRINTING OTHER ::"); // prints "Hello!"
        Set<String> t4 = new LinkedHashSet<>(other) ;
        for (String s : t4) {
            System.out.print(s+" ");
        }
        System.out.println();
    }
    public static boolean extractNumber(String str) {
        StringBuilder sb = new StringBuilder();
        boolean found = false;
        for(char c : str.toCharArray()){
            if(Character.isDigit(c)){
                sb.append(c);
                found = true;
            }else if(found){
                // If we already found a digit before and this char is not a digit, stop looping
                break;
            }                
        }
        return found;
    }
    
    public static boolean findc(String s){
        boolean r=false;
        if(s.contains(",") || s.contains("(")||s.contains(")") || s.contains("{")||s.contains("}") || s.contains(";")||s.contains("[") || s.contains("]")){
            r=true;
        }
        return r;
    }
    public static String spchar(String s){
        String c="";
        if(s.contains(",")){
            c=",";
        }
        if(s.contains("(")){
            c="(";
        }
        if(s.contains(")")){
            c=")";
        }
        if(s.contains("{")){
            c="{";
        }
        if(s.contains("}")){
            c="}";
        }
        if(s.contains(";")){
            c=";";
        }
        if(s.contains("[")){
            c="[";
        }
        if(s.contains("]")){
            c="]";
        }
        return c;
    }
}
