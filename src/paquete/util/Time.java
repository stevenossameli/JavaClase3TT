package paquete.util;

public class Time {

    private long time;

    public Time(long time) {
        this.time = time;
    }

    public Time(){};



    public void start()
    {
        this.time = System.currentTimeMillis();
    }

    public void stop()
    {
        long endTime = System.currentTimeMillis();
        this.time = endTime - this.time;

    }

    public long getTime(){
        return this.time;
    }
}
