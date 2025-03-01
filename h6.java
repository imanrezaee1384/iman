import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.*;
//  Arrays.sort(b);
public class h6 {
    public static Boolean tashkhis_s(String s){
        if(s.charAt(0)=='"'&&s.charAt(s.length()-1)=='"'){
            for(int i=1;i<s.length()-1;i++){
                if(s.charAt(i)=='\\'){
                    if(s.charAt(i+1)=='\\'||(i<s.length()-2&&s.charAt(i+1)=='"')){
                        i++;
                    }
                    else{
                        return false;
                    }
                }
                if(s.charAt(i)=='"'&&s.charAt(i-1)!='\\'){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    public static Boolean tashkhis(String s){
        if(s.compareTo("true")==0||s.compareTo("false")==0||s.compareTo("null")==0){
            return true;
        }
        else if(s.charAt(0)=='"'&&s.charAt(s.length()-1)=='"'){
            for(int i=1;i<s.length()-1;i++){
                if(s.charAt(i)=='\\'){
                    if(s.charAt(i+1)=='\\'||(i<s.length()-2&&s.charAt(i+1)=='"')){
                        i++;
                    }
                    else{
                        return false;
                    }
                }
                if(s.charAt(i)=='"'&&s.charAt(i-1)!='\\'){
                    return false;
                }
            }
            return true;
        }
        try {
            double e = Double.parseDouble(s);
        }
        catch (Exception ex){
            return false;
        }
        return true;
    }
    public static int f(String s){
        if(s.compareTo("{}")==0){return 1;}
        if(s.compareTo("{ }")==0){return 1;}
        StringBuilder d = new StringBuilder();
        d.append(s);
        if(s.charAt(0)!='{'||s.charAt(s.length()-1)!='}'){
            return 0;
        }
        Pattern p = Pattern.compile("\"[^\"]*\":");
        Matcher m = p.matcher(s);
        ArrayList<A>c = new ArrayList<>();
        ArrayList<String>y = new ArrayList<>();
        ArrayList<String>jason_a = new ArrayList<>();
        ArrayList<String>jason_o = new ArrayList<>();
        ArrayList<String>jason_v = new ArrayList<>();
        StringBuilder d2 = new StringBuilder();
        d2.append("{");
        if(s.indexOf("\"")==-1){return 0;}

        while (m.find()){
            if(s.charAt(m.end())=='['){
                int sum1 = 0;
                int sum2 = 0;
                int k = -1;
                for(int i = m.end();i<s.length()-1;i++){
                    if(s.charAt(i)=='['&&(s.charAt(i-1)==':'||s.charAt(i-1)==','||s.charAt(i-1)=='['||s.charAt(i-1)=='{')){sum1++;}
                    if(s.charAt(i)==']'&&(s.charAt(i+1)=='}'||s.charAt(i+1)==','||s.charAt(i+1)==']')){sum2++;}
                    if(sum1==sum2){
                        k = i;
                        i = 10000;
                    }
                }
                if(k==-1){return 0;}
                jason_a.add(s.substring(m.start(), k + 1));
                d2.append(s.substring(m.start(), k + 1));
                d2.append(",");
                String a1 = s.substring(m.start(), m.end());
                String a2 = "jason_a";
                if (y.indexOf(a1) == -1) {
                    y.add(a1);
                    int u = y.indexOf(a1);
                    A r = new A(a1, a2, 1);
                    c.add(u, r);
                } else {
                    int u = y.indexOf(a1);
                    int x = c.get(u).t;
                    x = x + 1;
                    A r = new A(a1, a2, x);
                    c.remove(u);
                    c.add(u, r);
                    s = s.replace(s.substring(m.start(), k + 1), "");
                }
                p = Pattern.compile("\"[^\"]*\":");
                m = p.matcher(s);

            }
            else if(s.charAt(m.end())=='{'){
                int sum1 = 0;
                int sum2 = 0;
                int k = -1;
                for(int i = m.end();i<s.length()-1;i++){
                    if(s.charAt(i)=='{'&&(s.charAt(i-1)==':'||s.charAt(i-1)==','||s.charAt(i-1)=='['||s.charAt(i-1)=='{')){sum1++;}
                    if(s.charAt(i)=='}'&&(s.charAt(i+1)=='}'||s.charAt(i+1)==','||s.charAt(i+1)==']')){sum2++;}
                    if(sum1==sum2){
                        k = i;
                        i = 10000;
                    }
                }
                if(k==-1){return 0;}
                jason_o.add(s.substring(m.start(), k + 1));
                d2.append(s.substring(m.start(), k + 1));
                d2.append(",");
                String a1 = s.substring(m.start(), m.end());
                String a2 = "jason_o";
                if (y.indexOf(a1) == -1) {
                    y.add(a1);
                    int u = y.indexOf(a1);
                    A r = new A(a1, a2, 1);
                    c.add(u, r);
                } else {
                    int u = y.indexOf(a1);
                    int x = c.get(u).t;
                    x = x + 1;
                    A r = new A(a1, a2, x);
                    c.remove(u);
                    c.add(u, r);
                }
                s = s.replace(s.substring(m.start(), k + 1), "");
                p = Pattern.compile("\"[^\"]*\":");
                m = p.matcher(s);


            }
            else {
                int k = s.length()-2;
                for(int i=m.end();i<s.length();i++){
                    if(s.charAt(i)==','){
                        k = i-1;
                        break;
                    }
                }
                jason_v.add(s.substring(m.start(),k+1));
                d2.append(s.substring(m.start(),k+1));
                d2.append(",");
                String a1 = s.substring(m.start(),m.end());
                String a2 = "jason_v";
                if(y.indexOf(a1)==-1){
                    y.add(a1);
                    int u = y.indexOf(a1);
                    A r = new A(a1,a2,1);
                    c.add(u,r);
                }
                else{
                    int u = y.indexOf(a1);
                    int x = c.get(u).t;
                    x = x+1;
                    A r = new A(a1,a2,x);
                    c.remove(u);
                    c.add(u,r);
                }
                s = s.replace(s.substring(m.start(),k+1),"");
                p = Pattern.compile("\"[^\"]*\":");
                m = p.matcher(s);

            }
        }
        d2.deleteCharAt(d2.length()-1);
        d2.append("}");
//        if(d2.toString().compareTo(d.toString())!=0){return 0;}
        int sum = 0;
        for(int i=0;i<jason_v.size();i++){
            String s_v = jason_v.get(i);
            p = Pattern.compile("\"[^\"]*\":");
            m = p.matcher(s_v);
            while (m.find()) {
                String a1 = s_v.substring(m.start(),m.end());
                String a2 = "jason_v";
                int u = y.indexOf(a1);
                if(tashkhis_s(s_v.substring(0, m.end() - 1))==false || tashkhis(s_v.substring(m.end(), s_v.length()))==false){
                    return 0;
                }
                else if(c.get(u).value.compareTo(a2)==0){
                    int o = 1;
                    for(int j=i+1;j<jason_v.size();j++){
                        String s_v_2 = jason_v.get(j);
                        Pattern p2 = Pattern.compile("\"[^\"]*\":");
                        Matcher m2 = p.matcher(s_v_2);
                        while (m2.find()){
                            String a3 = s_v_2.substring(m2.start(),m2.end());
                            if(a3.compareTo(a1)==0){
                                o = 0;
                                break;
                            }
                            break;
                        }
                        if(o==0){break;}
                    }
                    if(o==1){
                        sum++;
                    }
                }
                break;
            }
        }
        for(int i=0;i<jason_a.size();i++) {
            String s_a = jason_a.get(i);
            p = Pattern.compile("\"[^\"]*\":");
            m = p.matcher(s_a);
            while (m.find()) {
                String a1 = s_a.substring(m.start(), m.end());
                String a2 = "jason_a";
                int u = y.indexOf(a1);
                if(tashkhis_s(a1.substring(0,a1.length()-1))==false||g(s_a.substring(m.end(),s_a.length()))==0){
                    return 0;
                }
                else if(c.get(u).value.compareTo(a2)==0){
                    int o = 1;
                    for(int j=i+1;j<jason_a.size();j++){
                        String s_a_2 = jason_a.get(j);
                        Pattern p2 = Pattern.compile("\"[^\"]*\":");
                        Matcher m2 = p.matcher(s_a_2);
                        while (m2.find()){
                            String a3 = s_a_2.substring(m2.start(),m2.end());
                            if(a3.compareTo(a1)==0){
                                o = 0;
                            }
                            break;
                        }
                        if(o==0){break;}
                    }
                    if(o==1){
                        sum = sum + g(s_a.substring(m.end(),s_a.length()));
                    }
                }
                break;
            }
        }
        for(int i=0;i<jason_o.size();i++){
            String s_a = jason_o.get(i);
            p = Pattern.compile("\"[^\"]*\":");
            m = p.matcher(s_a);
            while (m.find()){
                String a1 = s_a.substring(m.start(),m.end());
                String a2 = "jason_o";
                int u = y.indexOf(a1);
                if(tashkhis_s(a1.substring(0,a1.length()-1))==false||f(s_a.substring(m.end(),s_a.length()))==0){
                    return 0;
                }
                else if(c.get(u).value.compareTo(a2)==0){
                    int o = 1;
                    for(int j=i+1;j<jason_o.size();j++){
                        String s_a_2 = jason_a.get(j);
                        Pattern p2 = Pattern.compile("\"[^\"]*\":");
                        Matcher m2 = p.matcher(s_a_2);
                        while (m2.find()){
                            String a3 = s_a_2.substring(m2.start(),m2.end());
                            if(a3.compareTo(a1)==0){
                                o = 0;
                            }
                            break;
                        }
                        if(o==0){break;}
                    }
                    if(o==1){
                        sum = sum + f(s_a.substring(m.end(),s_a.length()));
                    }
                }
                break;
            }
        }
        sum++;
        return sum;
    }
    public static int g(String s){
        if(s.compareTo("[]")==0){return 1;}
        if(s.charAt(0)!='['||s.charAt(s.length()-1)!=']'){return 0;}
        Pattern p = Pattern.compile("[^,]*,");
        Matcher m = p.matcher(s);
        ArrayList<String> jason_a = new ArrayList<>();
        ArrayList<String> jason_o = new ArrayList<>();
        StringBuilder d = new StringBuilder();
        d.append(s);
        d.deleteCharAt(0);
        d.deleteCharAt(d.length()-1);
        s = d.toString();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='['){
                int sum1 = 0;
                int sum2 = 0;
                int k = -1;
                for(int j=i;j<s.length();j++){
                    if(s.charAt(j)=='['){sum1++;}
                    if(s.charAt(j)==']'){sum2++;}
                    if(sum1==sum2&&sum1!=0){
                        k = j;
                        break;
                    }
                }
                if(k!=-1) {
                    jason_a.add(s.substring(i, k + 1));
                    i = k;
                    s = s.replace(s.substring(i, k + 1), "");
                    i = 0;
                }
            }
            if(s.charAt(i)=='{'){
                int sum1 = 0;
                int sum2 = 0;
                int k = -1;
                for(int j=i;j<s.length();j++){
                    if(s.charAt(j)=='{'){sum1++;}
                    if(s.charAt(j)=='}'){sum2++;}
                    if(sum1==sum2&&sum1!=0){
                        k = j;
                        break;
                    }
                }
                if(k!=-1) {
                    jason_o.add(s.substring(i, k + 1));
                    s = s.replace(s.substring(i, k + 1), "");
                    i = 0;
                }
            }
        }
        ArrayList<String> jason_v = new ArrayList<>();
        String[]a = s.split(",");
        for(int i=0;i<a.length;i++){
            if(a[i]!=null){
                jason_v.add(a[i]);
            }
        }
        int sum = 0;
        for(int i=0;i<jason_v.size();i++){
            String s_v = jason_v.get(i);
            if(tashkhis(s_v)){
                sum++;
            }
            else{
                return 0;
            }
        }
        for(int i=0;i<jason_a.size();i++){
            String s_a = jason_a.get(i);
            if(g(s_a)!=0){
                sum = sum + g(s_a);
            }
            else{
                return 0;
            }
        }
        for(int i=0;i<jason_o.size();i++){
            String s_o = jason_o.get(i);
            if(f(s_o)!=0){
                sum = sum + f(s_o);
            }
            else{
                return 0;
            }
        }
        sum = sum +1;
        return sum;

    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        while (s.indexOf(" , ")!=-1||s.indexOf(", ")!=-1||s.indexOf(" ,")!=-1){
            s = s.replace(" , ",",");
            s = s.replace(", ",",");
            s = s.replace(" ,",",");
        }
        while (s.indexOf(" { ")!=-1||s.indexOf("{ ")!=-1||s.indexOf(" {")!=-1){
            s = s.replace(" { ","{");
            s = s.replace("{ ","{");
            s = s.replace(" {","{");
        }
        while (s.indexOf(" } ")!=-1||s.indexOf("} ")!=-1||s.indexOf(" }")!=-1){
            s = s.replace(" } ","}");
            s = s.replace("} ","}");
            s = s.replace(" }","}");
        }
        while (s.indexOf(" [ ")!=-1||s.indexOf("[ ")!=-1||s.indexOf(" [")!=-1){
            s = s.replace(" [ ","[");
            s = s.replace("[ ","[");
            s = s.replace(" [","[");
        }
        while (s.indexOf(" ] ")!=-1||s.indexOf("] ")!=-1||s.indexOf(" ]")!=-1){
            s = s.replace(" ] ","]");
            s = s.replace("] ","]");
            s = s.replace(" ]","]");
        }
        while (s.indexOf(" : ")!=-1||s.indexOf(": ")!=-1||s.indexOf(" :")!=-1){
            s = s.replace(" : ",":");
            s = s.replace(": ",":");
            s = s.replace(" :",":");
        }
        System.out.println(f(s));




    }
}
class A{
    String key;
    String value;
    int t;
    public A(String key,String value,int t){
        this.key = key;
        this.value = value;
        this.t = t;
    }
}