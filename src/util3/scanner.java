package util3;

import java.util.Scanner;

/**
 * Created by mathieu on 17/05/2017.
 */
public class scanner {






public static int scannerint()
{
  int x;
    try{Scanner scanner = new Scanner(System. in);
        String tempon = scanner.nextLine();
        x=Integer.parseInt(tempon);

    }
    catch (java.lang.NumberFormatException a) {
        return 0;
    }


    return x;
}

    public static int scannerint(int min,int max)
    {
        int x;
        do {
            x=scannerint();
        }while (x<min ||x>max);


        return x;
    }












}
