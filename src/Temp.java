/**
 * hbase上存的是字节数组
 * 转换
 * Created by ${LiuShuo} on 2016/11/28.
 */
public class Temp {
    public static void main(String[] args) {
;
        byte[] bytes = "1".getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.print((int) bytes[i]+",");
        }
        System.out.println();
        byte[] bytes2 =  {-27, -112, -107, -27, -72, -125};
        String s = new String(bytes2);
        System.out.println(s);
    }
}
