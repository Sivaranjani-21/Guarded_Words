package guardedWords;

import java.util.*;
import java.lang.*;
public class Vigenere_Cipher {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("***************** VIGENERE CIPHER *****************");
        System.out.println("Enter the Plain Text :");
        String str = sc.nextLine();
        System.out.println("Enter the Key :");
        String key = sc.next();
        char arr[] = str.toCharArray();
        int n = arr.length;
        System.out.println("The Plain Text is : " + str);
        System.out.println("The Given Key is : " + key);
        String s = "";
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 'a' && arr[i] <= 'z')
                s += str.substring(i, i + 1);
            else if (arr[i] >= 'A' && arr[i] <= 'Z') {
                arr[i] = Character.toLowerCase(arr[i]);
                s += arr[i];
            }
        }
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println("The Modified String is : " + s);
        int cnt = s.length(), x = cnt;
        char a[] = s.toCharArray();
        String alp = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
        String kkey = "";
        while (x != 0) {
            kkey += key;
            x--;
        }
        String c = "";
        for (int i = 0; i < cnt; i++) {
            int z = a[i] - 'a';
            int y = kkey.charAt(i) - 'a';
            c += alp.charAt(z + y);
        }
        System.out.println("The Encrypted String is : " + c);
        String d = "";
        char b[] = c.toCharArray();
        for (int i = 0; i < cnt; i++) {
            int z = b[i] - 'a';
            int y = kkey.charAt(i) - 'a';
            if (z - y < 0)
                d += alp.charAt(52 - Math.abs(z - y));
            else
                d += alp.charAt(z - y);
        }
        System.out.println("The Decrypted String is : " + d);
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
    }
}
