/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sucrity;

/**
 *
 * @author dbah
 */
public class Atbash {
    
    public static String Encryption(String plaintext)
    {
      String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      String reversealph = "";
      
      for(int i=alph.length()-1;i>-1;i--)
      {
        reversealph+=alph.charAt(i);
      }
        
        plaintext=plaintext.toUpperCase();
        String ciphertext = "";
        for(int i=0;i<plaintext.length();i++)
        {
          if(plaintext.charAt(i)==(char)32) 
          {
            ciphertext+=" ";      
          }
          else 
          {
            for(int j=0;j<alph.length();j++)
            {
              if(plaintext.charAt(i)==alph.charAt(j))
              {
                 ciphertext +=reversealph.charAt(j);
                 break;
              }
            } //inner for
           }//if else 
        }//for
        return ciphertext ;
    }
    
    public static String Decryption(String ciphertext)
    {
      String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      String reversealph = "";
      
      for(int i=alph.length()-1;i>-1;i--)
      {
        reversealph+=alph.charAt(i);
      }
        
        ciphertext=ciphertext.toUpperCase();
        String plaintext = "";
        for(int i=0;i<ciphertext.length();i++)
        {
          if(ciphertext.charAt(i)==(char)32) 
          {
            plaintext+=" ";      
          }
          else 
          {
            for(int j=0;j<alph.length();j++)
            {
              if(ciphertext.charAt(i)==alph.charAt(j))
              {
                 plaintext +=reversealph.charAt(j);
                 break;
              }
            } //inner for
           }//if else 
        }//for   
    
        return plaintext;
    }
    
    
    
}
