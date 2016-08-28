import java.util.Scanner;

/**
 * Created by ScorpionOrange on 2016/07/26.
 */
public class Encrypt {

    public void run(){
        Base b = new Base();
        String inputString = "";
        String outputString = "";
        int key = 0;

        Scanner in = new Scanner(System.in);

        System.out.println("请输入需要加密的内容：");
        inputString = in.nextLine();
        System.out.println("请输入凯撒密码的密匙（任意正整数）：");
        key = in.nextInt();

        //将输入的字符串拆分成char数组
        char[] inputChar = inputString.toCharArray();

        //将char数组转换成字符串数组；
        String[] inputStringArray = new String[inputChar.length];
        for(int i = 0; i < inputStringArray.length; i++){
            inputStringArray[i] = String.valueOf(inputChar[i]);
        }

        //位数数组：将字符串数组的每一位与base比较，相同的记录下位数，用以后面的平移；
        int[] inputNO = new int[inputStringArray.length];
        for(int i = 0; i < inputStringArray.length; i++){
            for(int j = 0; j < b.base.length; j++){
                if(inputStringArray[i].equals(b.base[j])){
                    inputNO[i] = j;
                }
            }
        }

        /*
        //测试：位数数组是否运作正常；
        for(int i : inputNO){
            System.out.print(i + " ");
        }
        System.out.println();
        */

        if(key < b.base.length){
            for(int i = 0; i < inputNO.length; i++){
                if((inputNO[i] + key) < b.base.length){
                    inputNO[i] = inputNO[i] + key;
                }
                else {
                    inputNO[i] = inputNO[i] + key - b.base.length;
                }
            }
        }
        else {
            for(int i = 0; i < inputNO.length; i++){
                if((inputNO[i] + (key % b.base.length)) < b.base.length){
                    inputNO[i] = inputNO[i] + (key % b.base.length);
                }
                else {
                    inputNO[i] = inputNO[i] + (key % b.base.length) - b.base.length;
                }
            }
        }

        /*
        //测试：位数数组是否平移正常；
        for(int i : inputNO){
            System.out.print(i + " ");
        }
        */

        //输出用的字符串数组，将平移后的位数数组对照base一一赋值；
        String[] outputStringArray = new String[inputStringArray.length];
        for(int i = 0; i <outputStringArray.length; i++){
            outputStringArray[i] = b.base[inputNO[i]];
        }

        /*
        //测试：平移后的字符串数组是否运作正常；
        for(String s : outputStringArray){
            System.out.print(s+" ");
        }
        */

        for(int i = 0; i <outputStringArray.length; i++){
            outputString = outputString + outputStringArray[i];
        }
        System.out.println("加密后的内容为：");
        System.out.println(outputString);
    }
}
