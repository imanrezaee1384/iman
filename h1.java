//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Scanner;
//import java.util.regex.Pattern;
//import java.util.regex.*;
//
//public class h1 {
//    public static Boolean tashkhis(String s){
//        if(s.compareTo("true")==0||s.compareTo("false")==0||s.compareTo("")==0){
//            return true;
//        }
//        if(s.charAt(0)=='"'&&s.charAt(s.length()-1)=='"'){
//            for(int i=1;i<s.length()-1;i++){
//                if(s.charAt(i)=='"'&&s.charAt(i-1)!='\\'){return false;}
//                if(s.charAt(i)=='>'&&s.charAt(i-1)!='\\'){return false;}
//                if(s.charAt(i)=='<'&&s.charAt(i-1)!='\\'){return false;}
//                if(s.charAt(i)=='\\'){
//                    if(s.charAt(i+1)=='\\'||s.charAt(i+1)=='"'||s.charAt(i+1)=='>'||s.charAt(i+1)=='<'){
//                        i = i+1;
//                    }
//                    else {
//                        return false;
//                    }
//                }
//            }
//            return true;
//        }
//        try {
//            Double a = Double.parseDouble(s);
//        }
//        catch (Exception e){
//            return false;
//        }
//        return true;
//    }
//    public static int f(ArrayList<String>a){
//        if(a.size()==1){
//            String s = a.get(0);
//            ArrayList<A> b = new ArrayList<>();
//            Pattern p1 = Pattern.compile("^\\s*<[^>]*>.*</[^>]*>$");
//            Matcher m1 = p1.matcher(s);
//            while (m1.find()){
//                Pattern p2 = Pattern.compile("<[^>]*>");
//                Matcher m2 = p2.matcher(s);
//                while (m2.find()){
//                    A e = new A(m2.start(),m2.end());
//                    b.add(e);
//                }
//                if(s.substring(b.get(b.size()-1).x,b.get(b.size()-1).y).compareTo("</"+s.substring(b.get(0).x+1,b.get(0).y))==0&&tashkhis(s.substring(b.get(0).y,b.get(b.size()-1).x))){
//                    return 2;
//                }
//                else{return 0;}
//            }
//            return 0;
//        }
//        else{
//            ArrayList<String>d = new ArrayList<>();
//            d.add(a.get(0) + a.get(a.size()-1));
//            if(f(d)==0){
//                return 0;
//            }
//            int sum = 0;
//            ArrayList<String>b = new ArrayList<>();
//            for(int i=1;i<a.size()-1;i++){
//                ArrayList<String>c = new ArrayList<>();
//                String s = a.get(i);
//                Pattern p2 = Pattern.compile("<[^>]*>");
//                Matcher m2 = p2.matcher(s);
//                while (m2.find()){
//                    b.add(s.substring(m2.start(),m2.end()));
//                    break;
//                }
//                Pattern p1 = Pattern.compile("^\\s*<[^>]*>.*</[^>]*>$");
//                Matcher m1 = p1.matcher(s);
//                if(m1.find()){
//                    c.add(s);
//                    if(f(c)!=0){
//                        sum = sum + f(c);
//                    }
//                    else {
//                        return 0;
//                    }
//                }
//                else{
//                    int x1 = 0;
//                    for(int t=0;t<s.length();t++){
//                        if(s.charAt(t)!=' '){
//                            x1 = t;
//                            t = 10000;
//                        }
//                    }
//                    c.add(s.substring(x1,s.length()));
//                    for(int j=i+1;j<a.size()-1;j++){
//                        String s2 = a.get(j);
//                        int x2 = 0;
//                        for(int t=0;t<s2.length();t++){
//                            if(s2.charAt(t)!=' '){
//                                x2 = t;
//                                t = 10000;
//                            }
//                        }
//                        c.add(s2.substring(x1,s2.length()));
//                        if(x2==x1){
//                            i = j;
//                            j = 10000;
//                        }
//                    }
//                    if(f(c)!=0){
//                        sum = sum + f(c);
//                    }
//                    else{
//                        return 0;
//                    }
//
//                }
//
//            }
//            for(int i=0;i<b.size();i++){
//                int x =0;
//                for(int j=i;j<b.size();j++){
//                    if(b.get(i).compareTo(b.get(j))==0){
//                        x++;
//                    }
//                    else {
//                        break;
//                    }
//                }
//                sum = sum - x + 1;
//                if(x>2){sum++;}
//            }
//            sum = sum + 1;
//            return sum;
//        }
//    }
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int o = -1;
//        ArrayList<String> a = new ArrayList<>();
//        while (scanner.hasNextLine()) {
//            o++;
//            String input = scanner.nextLine();
//            if (input.isEmpty()) {
//                break;
//            }
//            a.add(input);
//            if(o>0){
//                String s = a.get(o-1);
//                if(a.get(o).compareTo("</"+s.substring(1,s.length()))==0){
//                    String s1 = s + a.get(o);
//                    a.remove(o-1);
//                    a.remove(o-1);
//                    a.add(o-1,s1);
//                    o = o-1;
//                }
//
//            }
//        }
////        int sum = 0;
////        ArrayList<String>b = new ArrayList<>();
////        for(int i=1;i<a.size()-1;i++){
////            ArrayList<String>c = new ArrayList<>();
////            String s = a.get(i);
////            Pattern p2 = Pattern.compile("<[^>]*>");
////            Matcher m2 = p2.matcher(s);
////            while (m2.find()){
////                b.add(s.substring(m2.start(),m2.end()));
////                break;
////            }
////            Pattern p1 = Pattern.compile("^\s*<[^>]*>.*</[^>]*>$");
////            Matcher m1 = p1.matcher(s);
////            if(m1.find()){
////                c.add(s);
////            }
////            else{
////                int x1 = 0;
////                for(int t=0;t<s.length();t++){
////                    if(s.charAt(t)!=' '){
////                        x1 = t;
////                        t = 100000;
////                    }
////                }
////                c.add(s.substring(x1,s.length()));
////                for(int j=i+1;j<a.size()-1;j++){
////                    String s2 = a.get(j);
////                    int x2 = 0;
////                    for(int t=0;t<s2.length();t++){
////                        if(s2.charAt(t)!=' '){
////                            x2 = t;
////                            t = 100000;
////                        }
////                    }
////                    c.add(s2.substring(x1,s2.length()));
////                    if(x2==x1){
////                        i = j;
////                        j = 10000;
////                    }
////                }
////
////            }
////            System.out.println("1:");
////            for(int j=0;j<c.size();j++){
////                System.out.println(c.get(j));
////            }
////            System.out.println("2:");
////            for(int j=0;j<b.size();j++){
////                System.out.println(b.get(j));
////            }}
//        System.out.println(f(a));
//
//
//
//
//
//
//
//
//
//
//    }
//}
//class A{
//    int x;
//    int y;
//    public A(int x,int y){
//        this.x = x;
//        this.y = y;
//    }
//}
// salam
//salam
// yaali
// 123