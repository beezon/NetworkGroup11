package com.example.hangmanx;
 
import android.util.Log;

//================== Check Start ตอนกรอก IP ==================
 
public class ThreadCheck extends Thread {
 
    private int count;
    private Boolean stop=false;
    private HelloServer CDA;
 
    //รับค่า count จาก CountDownActivity เพื่อมานับถอยหลัง
    //รับ Object CountDownActivity เพื่อเรียกใช้งาน runOnUiThread ในการ Update View
    public ThreadCheck(int count,HelloServer CDA){
        this.count = count;
        this.CDA = CDA;
    }
 
    //function ไว้สำหรับร้องขอการหยุดการทำงานของ Thread
    public void requestStop() {
        this.stop = true;
    }
 
  //function ส่วนการทำงานของ Thread
    @Override
    public void run() {
        // TODO Auto-generated method stub
 
        while(true) {
                    try {
                        sleep((long)1000); //หยุดการทำงาน 1 วินาที
                    }
                    catch(InterruptedException e) {
                        Log.e("log_thread", "Error Thread : " + e.toString());
                    }
 
                    if(this.stop) //ถ้ามีการร้องขอการหยุดแล้ว ให้จบการทำงานของ Thread
                        return;
 
                    count--;
 
                    //เรียกใช้ function threadProcess ของ threadProcess
                    this.CDA.runOnUiThread(new Runnable(){
                        public void run(){
                            CDA.threadProcess(count);
                          }
                    });
        }
    }
}