import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.io.encoding.DataBlockEncoding;
import org.apache.hadoop.hbase.protobuf.generated.HBaseProtos;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 列出表
 * Created by ${LiuShuo} on 2016/11/30.
 */
public class HBaseTableList {
    public static void main(String[] args) throws IOException {
        Configuration config = HBaseConfiguration.create();
        config.set("hbase.zookeeper.quorum", "182.92.68.59");// zookeeper地址
        config.set("hbase.zookeeper.property.clientPort", "2181");// zookeeper端口

        // Instantiating HBaseAdmin class
        HBaseAdmin admin = new HBaseAdmin(config);

        // Getting all the list of tables using HBaseAdmin object
        HTableDescriptor[] tableDescriptor =admin.listTables();

        // printing all the table names.
        for (int i=0; i<tableDescriptor.length;i++ ){
            //表名
            String nameAsString = tableDescriptor[i].getNameAsString();
            //查询表里族
            Set<byte[]> familiesKeys = tableDescriptor[i].getFamiliesKeys();



            //获取族名
            Collection<HColumnDescriptor> families = tableDescriptor[i].getFamilies();
            for (HColumnDescriptor ii:families) {
                byte[] name = ii.getName();
                Map<ImmutableBytesWritable, ImmutableBytesWritable> values = ii.getValues();
                System.out.println(nameAsString+"."+ new String(name));
            }

        }

    }
}
