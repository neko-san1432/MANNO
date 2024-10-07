package MANNO.test;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class test_time {
  private static final int INITIAL_COUNTDOWN_SECONDS = 10;
  private static Timer timer;
  private static AtomicBoolean paused = new AtomicBoolean(false);

  public static void main(String[] args) {
    timer = new Timer();

    // Schedule the countdown task
    timer.scheduleAtFixedRate(new CountdownTask(), 0, 1000);

    // Pause the countdown after some time
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    pauseCountdown();

    // Resume the countdown after some time
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    resumeCountdown();
  }

  private static void pauseCountdown() {
    paused.set(true);
  }

  private static void resumeCountdown() {
    paused.set(false);
  }

  private static class CountdownTask extends TimerTask {
    private int remainingSeconds = INITIAL_COUNTDOWN_SECONDS;

    @Override
    public void run() {
      if (!paused.get()) {
        System.out.println("Remaining seconds: " + remainingSeconds);

        if (remainingSeconds == 0) {
          System.out.println("Countdown complete!");
          timer.cancel();
        } else {
          remainingSeconds--;
        }
      } else {
        System.out.println("Countdown paused.");
      }
    }
  }
}