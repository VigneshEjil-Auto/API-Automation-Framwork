
/*
16 -  1+ 36
13 - 1+9 =10
10 = 1 + 0 = 1
 */
/*
Unit Testing :
----------
13
9
123455667888
1a3d4f5hg
123@#$#
-34566
34.56
C
3  . 55
Integer. max
Integer.min
 */

import java.util.HashSet;

public class HappyNumber {

    public static void main(String[] args) {
        int n =9;
        System.out.println("The number is : " + n + " Is this a Happy number ? ");
        System.out.println(isHappy(n));

    }

    public static  boolean isHappyNumber(int n)
    {
        HashSet<Integer> set = new HashSet<>();

        if(n<= 0)
            return false;

        while(n!=1)
        {
            if(set.contains(n))
                return false;

            set.add(n);
            int tmp =0;

            while(n!=0)
            {
              tmp += Math.pow(n%10,2);
              n/=10;
            }
             n= tmp;
        }
        return true;
    }

}
