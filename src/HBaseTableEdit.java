import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.client.HBaseAdmin;

import java.io.IOException;

/**
 * 使用API添加列族
 * Created by ${LiuShuo} on 2016/11/30.
 */
public class HBaseTableEdit {
    public static void main(String[] args) throws IOException {
        Configuration config = HBaseConfiguration.create();
        config.set("hbase.zookeeper.quorum", "182.92.68.59");// zookeeper地址
        config.set("hbase.zookeeper.property.clientPort", "2181");// zookeeper端口
        HBaseAdmin admin = new HBaseAdmin(config);
        HColumnDescriptor columnDescriptor = new HColumnDescriptor("f1");
        admin.addColumn("LIUSHUO2", columnDescriptor);
        System.out.println("coloumn added");
    }
}
