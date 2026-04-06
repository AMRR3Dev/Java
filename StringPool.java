public class StringPool {
   
    public static void main(String[] args) {
        
System.out.println("Inside stringPool");

String s1 = "hello!";
String s2 = "hello!";
String s3 = "hello!".intern();
String s4 = new String("hello!");
final String s5 = "lo!";


System.out.println("s1 == s2: "+ (s1==s2));
System.out.println("s1 == s3: "+ (s1==s3));
System.out.println("s1 == s4: "+ (s1==s4));
System.out.println("s1 == s4.intern(): "+ (s1==s4.indent(0)));
System.out.println("s1 == \"hel\" + \"lo!\": "+ (s1=="hel"+"lo!"));
System.out.println("s1 == \"hel\" + s5: "+ (s1=="hel"+s5));



    }



}
