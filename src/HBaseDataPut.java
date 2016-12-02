import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

/**
 * 添加数据
 * Created by ${LiuShuo} on 2016/11/28.
 */
public class HBaseDataPut {

    public static void main(String[] args) throws IOException {


// Instantiating Configuration class
        Configuration config = HBaseConfiguration.create();
        config.set("hbase.zookeeper.quorum", "182.92.68.59");// zookeeper地址
        config.set("hbase.zookeeper.property.clientPort", "2181");// zookeeper端口
        // Instantiating HTable class
        HTable hTable = new HTable(config, "LIUSHUO1");

        // Instantiating Put class
        // accepts a row name.
        Put p = new Put(Bytes.toBytes("row2"));

        // adding values using add() method
        // accepts column family name, qualifier/row name ,value
        p.add(Bytes.toBytes("f1"),
                Bytes.toBytes("NAME"),Bytes.toBytes("张飞"));

        p.add(Bytes.toBytes("f2"),Bytes.toBytes("IDCARD"),
                Bytes.toBytes("220323199203080818"));

        // Saving the put Instance to the HTable.
        hTable.put(p);
        System.out.println("data inserted");

        // closing HTable
        hTable.close();
    }
}
