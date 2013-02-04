package com.example.hangmanx;
 
import android.util.Log;

//================== Check Start �͹��͡ IP ==================
 
public class ThreadCheck extends Thread {
 
    private int count;
    private Boolean stop=false;
    private HelloServer CDA;
 
    //�Ѻ��� count �ҡ CountDownActivity �����ҹѺ�����ѧ
    //�Ѻ Object CountDownActivity �������¡��ҹ runOnUiThread 㹡�� Update View
    public ThreadCheck(int count,HelloServer CDA){
        this.count = count;
        this.CDA = CDA;
    }
 
    //function �������Ѻ��ͧ�͡����ش��÷ӧҹ�ͧ Thread
    public void requestStop() {
        this.stop = true;
    }
 
  //function ��ǹ��÷ӧҹ�ͧ Thread
    @Override
    public void run() {
        // TODO Auto-generated method stub
 
        while(true) {
                    try {
                        sleep((long)1000); //��ش��÷ӧҹ 1 �Թҷ�
                    }
                    catch(InterruptedException e) {
                        Log.e("log_thread", "Error Thread : " + e.toString());
                    }
 
                    if(this.stop) //����ա����ͧ�͡����ش���� ��騺��÷ӧҹ�ͧ Thread
                        return;
 
                    count--;
 
                    //���¡�� function threadProcess �ͧ threadProcess
                    this.CDA.runOnUiThread(new Runnable(){
                        public void run(){
                            CDA.threadProcess(count);
                          }
                    });
        }
    }
}