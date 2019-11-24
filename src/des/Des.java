/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package des;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author madonna 
 */
public class Des {

    /**
     * @param args the command line arguments
     */
   private static final byte []pCh2={14,17,11,24,1,5,3,28,15,6,21,10,23,19,12,4,26,8,16,7,27,20,13,2,41,52,31,37,47,55,30,40,51,45,33,48,44,49,39,56,34,53,46,42,50,36,29,32};
    private static final byte []pCh1={57,49,41,33,25,17,9,1,58,50,42,34,26,18,10,2,59,51,43,35,27,19,11,3,60,52,44,36,63,55,47,39,31,23,15,7,62,54,46,38,30,22,14,6,61,53,45,37,29,21,13,5,28,20,12,4};
    private static final byte []p={16,7,20,21,29,12,28,17,1,15,23,26,5,18,31,10,2,8,24,14,32,27,3,9,19,13,30,6,22,11,4,25};
    private static final byte[][] SBOX = new byte[][]{
        {14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7, 0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8, 4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0, 15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13},
        {15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10, 3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5, 0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15, 13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9},
        {10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8, 13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1, 13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7, 1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12},
        {7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15, 13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9, 10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4, 3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14},
        {2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9, 14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6, 4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14, 11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3},
        {12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11, 10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8, 9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6, 4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13},
        {4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1, 13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6, 1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2, 6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12},
        {13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7, 1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2, 7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8, 2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11}
    };
    private static final byte[] DBox = new byte[]{
        32, 1, 2, 3, 4, 5,
        4, 5, 6, 7, 8, 9,
        8, 9, 10, 11, 12, 13,
        12, 13, 14, 15, 16, 17,
        16, 17, 18, 19, 20, 21,
        20, 21, 22, 23, 24, 25,
        24, 25, 26, 27, 28, 29,
        28, 29, 30, 31, 32, 1};
    private static final byte[] shift = new byte[]{1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1};

    private static final byte[] ip = new byte[]{
        58, 50, 42, 34, 26, 18, 10, 2,
        60, 52, 44, 36, 28, 20, 12, 4,
        62, 54, 46, 38, 30, 22, 14, 6,
        64, 56, 48, 40, 32, 24, 16, 8,
        57, 49, 41, 33, 25, 17, 9, 1,
        59, 51, 43, 35, 27, 19, 11, 3,
        61, 53, 45, 37, 29, 21, 13, 5,
        63, 55, 47, 39, 31, 23, 15, 7};

    private static final byte[] fp = new byte[]{
        40, 8, 48, 16, 56, 24, 64, 32,
        39, 7, 47, 15, 55, 23, 63, 31,
        38, 6, 46, 14, 54, 22, 62, 30,
        37, 5, 45, 13, 53, 21, 61, 29,
        36, 4, 44, 12, 52, 20, 60, 28,
        35, 3, 43, 11, 51, 19, 59, 27,
        34, 2, 42, 10, 50, 18, 58, 26,
        33, 1, 41, 9, 49, 17, 57, 25};
   
   static String prevright;
   static String prevleft;
   static String newright ;
   static String newleft;
    public static String to64bit(String eightLetters){
        String _64bit="";
        String _8bit;
        for (int i = 0; i < eightLetters.length(); i++) {
            _8bit=Integer.toBinaryString(eightLetters.charAt(i));
            
            while(_8bit.length()<8){
                _8bit="0"+_8bit;
            }
            
            _64bit+=_8bit;
        }
        
        return _64bit;
    }

   static public String permute(String recieve,byte [] table){
        StringBuilder builder = new StringBuilder();
        for(byte index : table){
            
            builder.append(recieve.charAt(index-1));
            
            
        }
        return builder.toString();
        
    }
   static public String shiftleft(String prev,int shifttimes){
        return prev.substring(shifttimes)+prev.substring(0, shifttimes);
        
        
    }
    static public List<String> generatkey(String key){
         List<String> subkey1 = new ArrayList<>();
         String prevle="";
         String prevri="";
         String newleftk="";
         String newrightk="";
         String newkey="";
         key = to64bit(key);
         key = permute(key , pCh1);
        prevle= key.substring(0, key.length()/2);
        prevri= key.substring(key.length()/2);
        for (int i = 0; i < 16; i++) {
            newleftk= shiftleft(prevle,shift[i]);
            newrightk= shiftleft(prevri,shift[i]);
            newkey = newleftk+newrightk;
            newkey=permute(newkey,pCh2);
            subkey1.add(newkey);
            prevle= newleftk;
            prevri= newrightk;
        }
        return subkey1;
    }
    
   static public String formating (String plain){
        while(plain.length()%8!=0){
            plain+="x";
        }
        return plain;
    }
    static  void fun(String key){
       
        newright= permute(prevright,DBox);
        
        newright= xor(newright, key);
      
        newright = sbox(newright);
     
        newright = permute(newright, p);
        
    }
    static String sbox(String newrigh){
        StringBuilder builder = new StringBuilder();
        
    int rbv,cbv,c,sboxvalue;
    char c1 ,c6;
    String sixbit,strsboxvalue="";
        
        for (int i = 0; i < 48; i+=6) {
            sixbit= newrigh.substring(i,i+6);
           
           
            
            rbv = Integer.parseInt(""+sixbit.charAt(0)+sixbit.charAt(5),2);
         
            cbv= Integer.parseInt(sixbit.substring(1, 5), 2);
            c= (rbv*16)+cbv;
            sboxvalue= SBOX[i/6][c];
            strsboxvalue = Integer.toBinaryString(sboxvalue);
            while(strsboxvalue.length()<4)
                strsboxvalue="0"+strsboxvalue;
            builder.append(strsboxvalue);
          
        }
       
        
        return builder.toString();
    }
    
    
    
    static String xor(String one,String two)
    {
        long lone= Long.parseLong(one, 2);
        long ltwo= Long.parseLong(two, 2);
        long xorded = lone ^ ltwo ;
        String strxored = Long.toBinaryString(xorded);
            while(strxored.length()<one.length())
                strxored="0"+strxored;
        return strxored;
    }
    
    
   static String encryption(String plain,String key)
   {
      plain = formating(plain);
         List<String> subkey1 = new ArrayList<>();
       //System.out.println("for"+plain);
      subkey1=generatkey(key);
      String _8byte,_64bit, temp="",cipher="",fincipher="";
        for (int i = 0; i < plain.length(); i+=8) {
          _8byte = plain.substring(i, i+8);
            _64bit=to64bit(_8byte);
            _64bit=permute(_64bit, ip);
            prevleft = _64bit.substring(0,_64bit.length()/2);
            prevright = _64bit.substring(_64bit.length()/2);
            
            for (int j = 0; j < 16; j++) {
                fun(subkey1.get(j));
                newright=xor(newright, prevleft);
                prevleft= prevright;
                prevright=newright;
            }
            
            cipher= newright+prevleft;
            cipher=permute(cipher, fp);
            
            cipher=toFinalCipher(cipher);
            fincipher+=cipher;
        }
        
        return fincipher;
    }
   
   
    static String decryption(String cipher,String key)
       {
             List<String> subkey1 = new ArrayList<>();
             cipher = formating(cipher);
             subkey1=generatkey(key);
             String _8bute,_64bit, temp="",plain="",fincipher="";
             for (int i = 0; i < cipher.length(); i+=8) 
                 {
                    _8bute = cipher.substring(i, i+8);
                    _64bit=to64bit(_8bute);
                   _64bit=permute(_64bit, ip);
                   prevleft = _64bit.substring(0,32);
                   prevright = _64bit.substring(32);
           
            for (int j = 0; j < subkey1.size(); j++)  
                {
                  
                    fun(subkey1.get(subkey1.size()-1-j));
                   newright=xor(newright, prevleft);
                   prevleft= prevright;
                   prevright=newright;
            }
            
            plain= newright+prevleft;
            plain=permute(plain, fp);
            plain=toFinalCipher(plain);
            fincipher+=plain;
        }
        
        return fincipher;
    }
    
    
    public static String toFinalCipher(String _64bit)  
       {
          String _8bit;
          String cipher="";
          for (int i = 0; i < 64; i+=8)  
            {
         
             _8bit=""+(char)Integer.parseInt(_64bit.substring(i, i+8),2);
            
            cipher +=_8bit;
            } 
       
        return cipher;
    }

    public static void main(String[] args) {
        // TODO code application logic here
          String enresult,dersult;
        enresult=encryption("abcdefghijklmn","abcdefgh");

      
        dersult= decryption(enresult, "abcdefgh");

       System.out.println(dersult);
    }
    
}
