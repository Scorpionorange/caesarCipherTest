import java.util.*;
/**
 * Created by ScorpionOrange on 2016/07/26.
 */
public class CaesarCipherMain {

    Scanner in = new Scanner(System.in);

    public void run(){
        System.out.println("请选择：加密( A ) 或是 解密( B )");
        String choice = in.next().trim();

        if("A".equalsIgnoreCase(choice)){
            Encrypt encrypt = new Encrypt();
            encrypt.run();
        }
        else if("B".equalsIgnoreCase(choice)){
            Decrypt decrypt = new Decrypt();
            decrypt.run();
        }
        else {
            System.out.println("输入错误，请重新输入！");
            run();
        }
        System.out.println("\n是否继续？( 继续请按Y，退出请按其他键 )");
        //boolean isContinue = "Yes".equalsIgnoreCase(in.next().trim());
        while ("Y".equalsIgnoreCase(in.next().trim())){
            System.out.println();
            run();
        }
        System.exit(0);
    }
}
