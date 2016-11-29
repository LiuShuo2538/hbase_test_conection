import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

/**
 * 删除数据
 * Created by ${LiuShuo} on 2016/11/29.
 */
public class HBaseDataDelete {
    public static void main(String[] args) throws IOException {
        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", "182.92.68.59");// zookeeper地址
        conf.set("hbase.zookeeper.property.clientPort", "2181");// zookeeper端口
        HTable hTable = new HTable(conf, "LIUSHUO2");//哪一张表
        Delete delete = new Delete(("row2").getBytes());//哪一行
//        delete.deleteColumn(Bytes.toBytes("f1"), Bytes.toBytes("关相"));
//        delete.deleteFamily(Bytes.toBytes("f1"));//列族
        hTable.delete(delete);
        hTable.close();
        System.out.println("delete is OK!");
    }
}
