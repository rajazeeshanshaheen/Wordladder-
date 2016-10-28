/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem;
import java.*;
import java.io.*;
import static java.sql.JDBCType.NULL;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/**
 *
 * @author Zeeshan
 */

public class Problem {
    

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
     public static boolean strDiffChop(String s1, String s2) {
       
        int differ = 0;
        for (int i = 0; i < s1.length(); i++) 
        {
            if (s1.charAt(i) != s2.charAt(i)) differ++;
            
        }
        if (differ == 1) return true;
        return false;
}
     public static boolean check(String s1, String s2) {
         return Math.abs(s1.length()- s2.length() ) == 0;
}
     public static Stack find(String start_name,String end_name,Set <String> dictonary,ArrayList visited){
              Queue store = new LinkedList();
                   
                for(Iterator<String> i = dictonary.iterator(); i.hasNext(); ) {
                       String item = i.next();               
                       
                       if(strDiffChop(start_name,item)){
                        
                        Stack st = new Stack();
                        if(!visited.contains(start_name)){
                            visited.add(start_name);
                       
                       
                       
                            
                        }
                        
                        if(!visited.contains(item)){
                        
                        st.push(start_name);
                        st.push(item);   
                           
                       
                       
                            
                        }
                        
                         
                        
                        
                        if(!st.isEmpty()){
                        store.add(st);
                       
                       
                        }
                        
                       
                       
                       }
                       else{
                           if(!visited.contains(start_name)){
                               
                           visited.add(start_name);
                           }
                           
                       
                       }
                       
               
                
                       
                       
}
                 if(store.peek()==null){
                return null;
                }
                else{
                    Stack temp = (Stack)store.remove();
                    String curr =(String)temp.peek();
                    if( curr.equals(end_name)){
                    return temp;
                    
                    }
                    
                    else{
                        
                    String b =(String)temp.pop();
                    Stack temporary = find(b,end_name,dictonary,visited);
                    while(temporary == null){
                    while(!store.isEmpty()){
                    temp=(Stack) store.remove();
                    b= (String)temp.pop();
                   
                   temporary = find(b,end_name,dictonary,visited);
                   if(temporary!=null){
                       Stack result=new Stack();
                    result.push((String)temp.pop());
                   
                    Stack storing = new Stack();
                    while(!(temporary.isEmpty())){
                    String d=(String)temporary.pop();
                    storing.push(d);
                    
                    
                    }
                    while(!(storing.isEmpty())){
                    String d=(String)storing.pop();
                    result.push(d);
                    
                    
                    }
                    return result;
                   }
                   
                    
                    
                    }
                    return null;
                    }
                    Stack result=new Stack();
                    result.push((String)temp.pop());
                   
                    Stack storing = new Stack();
                    while(!(temporary.isEmpty())){
                    String d=(String)temporary.pop();
                    storing.push(d);
                    
                    
                    }
                    while(!(storing.isEmpty())){
                    String d=(String)storing.pop();
                    result.push(d);
                    
                    
                    }
                    return result;
                    }
                }
            
            
            
     }
     public static Set get(Set a,String b){
         int c = b.length();
         Set<String> set = new HashSet<String>();
         Iterator iter = a.iterator();
         while (iter.hasNext()) {
             String cur =(String)iter.next();
             if(cur.length()==c){
                 set.add(cur);
             }
         }
         
     return set;
     }
    public static void main(String[] args) throws IOException, ParseException  {
        // TODO code application logic here
        try {
            
            FileReader reader = new FileReader("C:\\Users\\Zeeshan\\Documents\\NetBeansProjects\\Problem\\src\\problem\\demo.json");
            JSONObject JSONObject = null;
            JSONObject = (JSONObject) new JSONParser().parse(reader);
            Set <String> dictonary = JSONObject.keySet();
            
            
            
            
            
            
            
            Scanner user_input = new Scanner( System.in );
            System.out.println("Enter start word :");
            String start_name;
            start_name = user_input.next( );
            System.out.println("Enter end word :");
            String end_name;
            end_name = user_input.next( );
            if(check(start_name,end_name)){
            if(dictonary.contains(start_name)&& dictonary.contains(end_name)){    
            Set <String> set =get(dictonary,start_name);
            TreeSet myset =new TreeSet();
            myset.addAll(set);
            Stack result =Problem.find(start_name,end_name,myset,new ArrayList());
            
            System.out.println(result);
            }
            else{
            System.out.println("not validated");
            }
            }
            
            
        }
        catch (IOException | ParseException e){
            e.printStackTrace();
        
        }
        
    }

}
