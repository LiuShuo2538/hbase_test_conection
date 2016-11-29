/**
 * hbase上存的是字节数组
 * 转换
 * Created by ${LiuShuo} on 2016/11/28.
 */
public class Temp {
    public static void main(String[] args) {

        byte[] bytes = "吕布".getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println((int) bytes[i]);
        }

        byte[] bytes2 =  {-27, -123, -77, -25, -101, -72};
        String s = new String(bytes2);
        System.out.println(s);
    }
}
