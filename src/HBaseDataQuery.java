import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.Iterator;
import java.util.NavigableMap;
import java.util.NavigableSet;

/**
 * Created by ${LiuShuo} on 2016/12/1.
 */
public class HBaseDataQuery {
    public static void main(String[] args) throws IOException, Exception {

        // Instantiating Configuration class
        Configuration config = HBaseConfiguration.create();
        config.set("hbase.zookeeper.quorum", "182.92.68.59");// zookeeper地址
        config.set("hbase.zookeeper.property.clientPort", "2181");// zookeeper端口
        // Instantiating HTable class
        HTable table = new HTable(config, "LIUSHUO1");

        // Instantiating Get class
        Get g = new Get(Bytes.toBytes("row1"));

        // Reading the data
        Result result = table.get(g);

        // Reading values from Result class object
        byte[] value = result.getValue(Bytes.toBytes("f1"), Bytes.toBytes("NAME"));
        NavigableMap<byte[], byte[]> f1 = result.getFamilyMap(Bytes.toBytes("f2"));
        byte[] value1 = result.getValue(Bytes.toBytes("f2"), Bytes.toBytes("IDCARD"));
        NavigableSet<byte[]> bytes = f1.navigableKeySet();
        Iterator<byte[]> iterator = bytes.iterator();
        while (iterator.hasNext()) {
            byte[] next = iterator.next();
            System.out.println(new String(next));
        }
        // Printing the values
        String name = Bytes.toString(value);
        String idCard = Bytes.toString(value1);
        System.out.println();
//        System.out.println("NAME: " + name + " IDCARD: " + idCard);
    }
}
