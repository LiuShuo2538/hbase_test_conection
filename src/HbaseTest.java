import java.io.IOException;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.HBaseAdmin;


import org.apache.hadoop.conf.Configuration;

/**
 * 建表
 */
public class HbaseTest {

	public static void main(String[] args) throws IOException {
//		182.92.68.59
		// Instantiating configuration class
		Configuration con = HBaseConfiguration.create();
		con.set("hbase.zookeeper.quorum", "182.92.68.59");// zookeeper地址
		con.set("hbase.zookeeper.property.clientPort", "2181");// zookeeper端口
		// Instantiating HbaseAdmin class
		HBaseAdmin admin = new HBaseAdmin(con);

		// Instantiating table descriptor class
		HTableDescriptor tableDescriptor = new HTableDescriptor(TableName.valueOf("LIUSHUO2"));

		// Adding column families to table descriptor
		tableDescriptor.addFamily(new HColumnDescriptor("f1"));
		tableDescriptor.addFamily(new HColumnDescriptor("f2"));


		// Execute the table through admin
		admin.createTable(tableDescriptor);
		System.out.println(" Table created ");
	}
}