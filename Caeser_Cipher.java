package guardedWords;
import java.util.*;
public class Caeser_Cipher {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("***************** CEASER CIPHER *****************");
        System.out.println("Enter the Plain Text :");
        String str= sc.nextLine();
        System.out.println("Enter the Key :");
        int k=sc.nextInt();
        k = k%26;
        char arr[] = str.toCharArray();
        int n = arr.length;
        System.out.println("The Plain Text is : "+str);
        System.out.println("The Given Key is : "+k);
        String s="";
        for(int i=0;i<n;i++)
        {
            if(arr[i] >= 'a' && arr[i] <='z')
                s += str.substring(i,i+1);
            else if(arr[i] >= 'A'  && arr[i] <= 'Z')
            {
                //arr[i] = Character.toLowerCase(arr[i]);
                s += arr[i];
            }
        }
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println("The Modified String is : "+s);
        char a[] = s.toCharArray();
        String str1 = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
        char b[] = str1.toCharArray();
        String str2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char c[] = str2.toCharArray();

        String ss = "";
        for(int i=0;i<s.length();i++)
        {
            if(a[i] >= 'a' && a[i] <= 'z')
            {
                int z = (a[i] - 97)%26;
                ss += b[z+k];
            }
            else if(a[i] >= 'A' && a[i] <= 'Z')
            {
                int z = (a[i] - 65)%26;
                ss += c[z+k];
            }
            else
                ss += a[i];
        }
        System.out.println("The Encrypted String is : "+ss);
        char d[] = ss.toCharArray();

        String s1 = "";
        for(int i=0;i<ss.length();i++)
        {
            if(d[i] >= 'a' && d[i] <= 'z')
            {
                int z = ((d[i] - 97)%26)+26;
                s1 += b[z-k];
            }
            else if(d[i] >= 'A' && d[i] <= 'Z')
            {
                int z = ((d[i] - 65)%26)+26;
                s1 += c[z-k];
            }
            else
                s1 += a[i];
        }
        System.out.println("The Decrypted String is : "+s1);
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
    }
}