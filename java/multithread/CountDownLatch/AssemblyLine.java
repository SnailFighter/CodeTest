/**
流水线
 */

import java.util.concurrent.CountDownLatch;
import java.lang.Thread;

import java.util.List;
import java.util.ArrayList;

import java.lang.Exception;



public class AssemblyLine {
    private int workerNum;
    private CountDownLatch cdl;
    private List<Work> list;

    public  AssemblyLine(int workerNum){
        cdl = new CountDownLatch(workerNum);
        list = new ArrayList<>();
        list.add(new CameraWorker(cdl));
        list.add(new MainBoardWorker(cdl));
        list.add(new AssembleWorker(cdl));
    }

    public void start() throws Exception{

        Thread.sleep(2000);

        for(int i=0;i<list.size();i++){
            list.get(i).prepare();
            new Thread(list.get(i)).start();
        }

        cdl.await();

        System.out.println("生产了，仓库人员搬货吧");

    
    }

}