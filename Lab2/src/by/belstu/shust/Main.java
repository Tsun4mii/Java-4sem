package by.belstu.shust;
import java.io.UnsupportedEncodingException;

import static java.lang.Math.*;

/**Лаба 2
 * @author Yuri Shust
 * @version 1.0.0
 */
public class Main {
    public static double rnd(int min, double max)//Random
    {
        max -= min;
        return (double) (Math.random() * max) + min;
    }
    public static void main(String[] args) throws UnsupportedEncodingException {
        /**
         * @return
         * @throws
         * @param
         */
        System.out.println("B)---------------------------------------------------------");
        /**
         * @value
         * @see
         */
        char cha;
        int x;
        byte byt;
        long lon;
        boolean bool;

        String string = "Юра";
        double a = 4.12;
        cha = 'a';
        x = 2;
        byt = 22;
        lon = 2147483648l;
        bool = true;
        System.out.println("String + int = " + string + x);
        System.out.println("String + char = " + string + cha);
        System.out.println("String + double = " + string + a);
        byte byt2 = (byte) (byt + x);
        System.out.println("byte+int = " + byt2);
        int xx = (int) (a + lon);
        System.out.println("Double+int = " + xx);
        long lon2 = x + 2147483647l;
        System.out.println("int + 2147483647 = " + lon2);
           /* int sint = 0;
        System.out.println(sint);*/
        boolean bool2 = false, bool3;
        bool3 = bool2 && bool;
        System.out.println("True and false = " + bool3);
        bool3 = bool2 ^ bool;
        System.out.println("True or false = " + bool3);//исключающее или
        //bool3=bool2+bool;нельзя
        long lon3 = 9223372036854775807l;//для такого числа подходит Long от -9223372036854775808 до 9223372036854775807
        //double byte2=0x7fff_ffff_fff;
        System.out.println("3.45 % 2.4 = " + 3.45 % 2.4);
        System.out.println("1.0 / 0.0 = " + 1.0 / 0.0);
        System.out.println("0.0 / 0.0 = " + 0.0 / 0.0);
        System.out.println("log(-345) = " + Math.log(-345));
        System.out.println("Float.intBitsToFloat(0x7F800000) = " + Float.intBitsToFloat(0x7F800000));
        System.out.println("Float.intBitsToFloat(0xFF800000) = " + Float.intBitsToFloat(0xFF800000));
        //в 2, в 10,в 16

        System.out.println("С)---------------------------------------------------------");
        final int MY_CONST = 777;
        final int MY_CONST2 = 100;
        System.out.println("Константа №1 = " + MY_CONST + " Константа №2 = " + MY_CONST2);
        //static можно менять и она применяется, когда переменная не зависит от объекта. final же не изменяется и для каждого объекта может быть своим

        System.out.println("D)---------------------------------------------------------");
        System.out.println("Pi = " + Math.PI);
        System.out.println("Exp = " + Math.E);
        System.out.println("Округление Pi = " + Math.round(Math.PI));
        System.out.println("Округление Exp = " + Math.round(Math.E));
        System.out.println("Минимальное число из Pi и Exp = " + Math.min(Math.PI, Math.E));
        final int min = 0;
        final double max = 1.0;
        final double rnd = rnd(min, max);
        System.out.println("Псевдослучайное целое число: " + rnd);
        System.out.println("E)---------------------------------------------------------");

        Boolean wrapBool = new Boolean( false );
        Boolean wrapBool2 = new Boolean( true );
        System.out.println(wrapBool& wrapBool2);//and

        char ch = '9';
        Character cl = new Character(ch);
        System.out.println("Character = " + ch);
        Integer aa = new Integer(6);//классы обертки
        Integer b = new Integer(1);
        System.out.println("Сдвиги Integer(>>>,<<,>>)");
        System.out.println(aa >>> b); // Беззнаковый сдвиг
        System.out.println(aa << b);
        System.out.println(aa >> b);

        Integer integer = 9;//упаковка
        System.out.println("Упаковка "+integer);
        System.out.println("Распаковка "+integer);

        int par = Integer.parseInt("444",16);
        System.out.println("ParseInt "+par);

        String hex = Integer.toHexString(170);
        System.out.println("toHexString "+hex);

        System.out.println("compare(100,100) = "+Integer.compare(100, 100));
        System.out.println("compare(101,100) = "+Integer.compare(101, 100));
        System.out.println("compare(100,101) = "+Integer.compare(100, 101));

        System.out.println("toString(100,101) = "+Integer.toString(1002));

        System.out.println("Max value Long = "+Long.MAX_VALUE);
        System.out.println("Min value Long = "+Long.MIN_VALUE);

        System.out.println("Max value Double = "+Double.MAX_VALUE);
        System.out.println("Min value Double = "+Double.MIN_VALUE);

        Byte aaa =  127;//упаковка
        System.out.println("Упаковка "+aaa);
        Byte aaa2 = 0;
        aaa2=new Byte((byte) 127);
        System.out.println("Распаковка "+aaa2);
        System.out.println("F)---------------------------------------------------------");

        String s34 = "2345";
        int s35 = Integer.parseInt(s34);
        System.out.println("Преобразование String в int = "+s35);
        Integer i2 = Integer.valueOf(s34);
        System.out.println("Преобразование через valueof String в int = "+i2);
        Integer i1 = new Integer("2345");
        System.out.println("Преобразование через конструктор String в int = "+i1);

        byte[] arr =s34.getBytes("UTF-8");
        System.out.println("переводит строки в массив байтов = "+arr);
        String str = new String(arr,"UTF-8");
        System.out.println("переводит  массив байтов в строку = "+str);

        boolean bool1,  boolean1;
        //с использованием метода parseBoolean
        bool1 = Boolean.parseBoolean(s34);
        System.out.println("String в bool by parseBoolean ="+bool1 );
        //c использованием метода valueOf
        boolean1 = Boolean.valueOf(s34);
        System.out.println("String в bool by vaalueof ="+ boolean1 );//возрващает объект булеан

        String string1 = "привет";
        String string2 = "приветы";
        System.out.println(string1==string2);
        System.out.println("Equals? "+string1.equals(string2));
        System.out.println("CompareTo = "+string1.compareTo(string2));

        String str2 = "geekss@for@geekss";
        String [] arrOfStr = str2.split("@", 3);
        for (String ac : arrOfStr)
            System.out.print(" split ="+ac);

        String name="what do you know about me";// содержит ли одна строка другую
        System.out.println(name.contains("do you know"));//true

        String Str = new String("Добро пожаловать");
        System.out.println("Хэш-код для Str: " + Str.hashCode());
        System.out.println("Length для Str: " + Str.length());
        //System.out.println("Replace для Str: " + Str.replace('о','Ф'));

        System.out.println("G)---------------------------------------------------------");


        char[][] c1;


        c1 = new char[3][];
        c1[0] = new char[1];
        c1[1] = new char[2];
        c1[2] = new char[3];

        c1[0][0] = 'a';
        c1[1][0] = 'd';
        c1[1][1] = 'a';
        c1[2][0] = 'n';
        c1[2][1] = 'e';
        c1[2][2] = 't';

        System.out.println("Length для Str1: " +c1[0].length);
        System.out.println("Length для Str2: " +c1[1].length);
        System.out.println("Length для Str3: " +c1[2].length);

        for (char[] xz : c1) {
            System.out.println(xz);
        }
        System.out.println("H)---------------------------------------------------------");
        StringWrapper sw = new StringWrapper("A,B,C");
        sw.replace(',',';');
        System.out.println(sw.getStr());
        sw.delete('A');
        System.out.println(sw.getStr());
    }
}

