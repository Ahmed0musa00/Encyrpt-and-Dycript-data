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
public class Vigenere_Cipher {
    
    
        public static String encrypt(String text, String key)

        {

            String res = "";

            text = text.toUpperCase();

                        key = key.toUpperCase();

            for (int i = 0, j = 0; i < text.length(); i++)

            {

                char c = text.charAt(i);

                if (c < 'A' || c > 'Z')

                    continue;

                res += (char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A');

                j = ++j % key.length();

            }

            return res;

        }
        
        
        
        public static String decrypt(String text,String key)

        {

            String res = "";
                        key = key.toUpperCase();

            text = text.toUpperCase();

            for (int i = 0, j = 0; i < text.length(); i++)

            {

                char c = text.charAt(i);

                if (c < 'A' || c > 'Z')

                    continue;

                res += (char) ((c - key.charAt(j) + 26) % 26 + 'A');

                j = ++j % key.length();

            }

            return res;

        }

    
    
}
