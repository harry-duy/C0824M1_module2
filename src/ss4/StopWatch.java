package ss4;

public class StopWatch {
    private long startTime, endTime;

    StopWatch() {
        startTime = System.currentTimeMillis() ;

    }
    void start() {
        startTime = System.currentTimeMillis() ;
    }
    void stop() {
        endTime = System.currentTimeMillis() ;
    }
    long getElapsedTime() {
        return endTime - startTime;
    }
}


