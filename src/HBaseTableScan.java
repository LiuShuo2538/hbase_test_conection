import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

/**
 * Created by ${LiuShuo} on 2016/12/2.
 */
public class HBaseTableScan {
    public static void main(String[] args) throws IOException {
        Configuration config = HBaseConfiguration.create();
        config.set("hbase.zookeeper.quorum", "182.92.68.59");// zookeeper地址
        config.set("hbase.zookeeper.property.clientPort", "2181");// zookeeper端口

// 创建全表扫描的scan
        Scan scan = new Scan();
        HTable table = new HTable(config, "LIUSHUO1");
        //不放就全都查出来了

//        scan.addColumn(Bytes.toBytes("f1"), Bytes.toBytes("NAME"));
//        scan.addColumn(Bytes.toBytes("f1"), Bytes.toBytes("ADDRESS"));
//        scan.addColumn(Bytes.toBytes("f2"), Bytes.toBytes("IDCARD"));
        ResultScanner scanner = table.getScanner(scan);
        for (Result result = scanner.next(); result != null; result = scanner.next()) {
            byte[] row = result.getRow();
            System.out.println(new String(row));
//            System.out.println("Found row : " +  result);

        }
        scanner.close();
    }
}
