
/*
Problem Link : https://leetcode.com/problems/encode-and-decode-tinyurl/submissions/
Company : Google

Explanation : for encoding use a method of counting number of characters in the longUrl so , it will be 26 in length and print the character and its occurrence
             for decoding use the hashtable that will store the ascii code of the char in position x and when decoding , you will convert this ascii code into characters and will restore the original link

Solution by : Ahmed Salah
Contacts : https://www.linkedin.com/in/engahmedsalah98/
Github : https://github.com/EngAhmedSalah
 */

public class Codec
{
    String output = "http://tinyurl.com/";
    int[] count;
    int[] table;
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl)
    {
        int len = longUrl.length();
        count = new int[26];
        table = new int[len];
        for(int i = 0 ; i < len ; ++i)
        {
            table[i] = longUrl.charAt(i);

                if(Character.isLetter(longUrl.charAt(i)))
                    count[Character.toLowerCase(longUrl.charAt(i)) - 'a'] += 1;
        }
        for (int i = 0 ; i < 26 ; ++i)
            if(count[i] != 0)
            {
                output += (String.valueOf((char) (i + 'a') + "" + count[i]));
            }
        return output;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl)
    {
        String encodedUrl = "";
        for(int i = 0 ; i < table.length ; ++i)
            encodedUrl += (char)(table[i]);
        return encodedUrl;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
