package cn.itcast.zk;

import javafx.scene.chart.PieChart;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.text.SimpleDateFormat;
import java.util.Date;


public class ZkClient {
    public static void main(String[] args) throws Exception {

        ZooKeeper zk =new ZooKeeper("192.168.206.106:2181,192.168.206.102", 300000, new Watcher() {
            public void process(WatchedEvent watchedEvent) {
//                System.out.println(watchedEvent.getState());
//                System.out.println(watchedEvent.getType());
//                System.out.println(watchedEvent.getPath());
//                //System.out.println(watchedEvent.getWrapper());
//                System.out.println(watchedEvent.toString());
//                System.out.println("---------------------------------------------");
            }
        });
         //zk.create("/myzk","zhangsan".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        byte[] data = zk.getData("/myzk", true, null);

        //System.out.println(new String(data));

        zk.setData("/myzk", "性感".getBytes(), -1);
//        System.out.println(stat);
//        Date date= new Date(stat.getCtime());
//        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String format = simpleDateFormat.format(date);
//        System.out.println(format);
        zk.close();

    }
}
