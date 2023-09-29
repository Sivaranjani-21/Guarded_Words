package guardedWords;
import java.util.*;

public class PlayFair_Cipher {
    public static String encrypt(String[][] mat,String x,String y)
    {
        int a=-1,b=-1,c=-1,d=-1;
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                if(mat[i][j].equals(x))
                {
                    a = i;
                    b = j;
                }
                if(mat[i][j].equals(y))
                {
                    c = i;
                    d = j;
                }
            }
        }
        String z ="";
        if(a==c)
        {
            if(++b == 5)
                b = 0;
            else if(++d == 5)
                d = 0;
            z += mat[a][b];
            z += mat[c][d];
        }
        else if(b == d)
        {
            if(++a == 5)
                a = 0;
            else if(++c == 5)
                c = 0;
            z += mat[a][b];
            z += mat[c][d];
        }
        else
        {
            z += mat[a][d];
            z += mat[c][b];
        }
        return z;
    }
    public static String decrypt(String[][] mat,String x,String y)
    {
        int a=-1,b=-1,c=-1,d=-1;
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                if(mat[i][j].equals(x))
                {
                    a = i;
                    b = j;
                }
                if(mat[i][j].equals(y))
                {
                    c = i;
                    d = j;
                }
            }
        }
        String z ="";
        if(a==c)
        {
            if(--b == -1)
                b = 4;
            else if(--d == -1)
                d = 4;
            z += mat[a][b];
            z += mat[c][d];
        }
        else if(b == d)
        {
            if(--a == -1)
                a = 4;
            else if(--c == -1)
                c = 4;
            z += mat[a][b];
            z += mat[c][d];
        }
        else
        {
            z += mat[a][d];
            z += mat[c][b];
        }
        return z;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("***************** PLAYFARE CIPHER *****************");
        System.out.println("Enter the Plain Text :");
        String text = sc.next();
        System.out.println("Enter the Key :");
        String key = sc.next();
        String t = "";
        for(int i=0;i<text.length();i++)
        {
            if(text.charAt(i) >= 'a' && text.charAt(i) <= 'z')
            {
                if(text.charAt(i) == 'j')
                    t += "i";
                else
                    t += text.charAt(i);
            }
            else if(text.charAt(i) >= 'A' && text.charAt(i) <= 'Z')
                t += Character.toLowerCase(text.charAt(i));
        }
        System.out.println("Plain Text after preProcessing : "+t);
        String a = "abcdefghijklmnopqrstuvwxyz";
        char arr[] = a.toCharArray();
        char arr1[] = t.toCharArray();
        for(int i=0;i<key.length();i++)
        {
            int z = key.charAt(i) - 'a';
            if(z == 9)
                z = 8;
            arr[z] = '0';
        }
        String b = key;
        System.out.println("KEY : "+b);
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i] != '0')
                b += arr[i];
        }
        int cnt=0,d=0;
        String mat[][] = new String[5][5];
        System.out.println("***************** KEY MATRIX : *****************");
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                if(b.substring(d,d+1).equals("j"))
                    d++;
                mat[i][j] = b.substring(d,d+1);
                System.out.print(mat[i][j]+" ");
                d++;
            }
            System.out.println();
        }
        String z = "";
        int x = 0,y = 1;
        while(x < t.length() && y < t.length())
        {
            if(arr1[x] == arr1[y])
            {
                z += arr1[x];z += "x";
                x++;y++;
            }
            else
            {
                z += arr1[x];z += arr1[y];
                x+=2;y+=2;
            }
        }
        z += arr1[t.length()-1];
        z += "x";

        System.out.println();
        System.out.println("String after addition of X : "+z);
        String cc = "";
        int xx=0,yy=1;
        for(int i=0;i<z.length()/2;i++)
        {
            String ch = ""+z.charAt(xx);
            String ch1 = ""+z.charAt(yy);
            String c = encrypt(mat,ch,ch1);
            cc += c;
            xx+=2;
            yy+=2;
        }
        System.out.println("Encrypted String : "+cc);
        String cc1 = "";
        int xx1=0,yy1=1;
        for(int i=0;i<cc.length()/2;i++)
        {
            String ch = ""+cc.charAt(xx1);
            String ch1 = ""+cc.charAt(yy1);
            String c = decrypt(mat,ch,ch1);
            cc1 += c;
            xx1+=2;
            yy1+=2;
        }
        System.out.println("Decrypted String : "+cc1);
        System.out.println();
        System.out.println("***************************************************");
    }
}
