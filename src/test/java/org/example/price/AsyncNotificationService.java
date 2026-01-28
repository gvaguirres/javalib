package org.example.price;

public class AsyncNotificationService implements NotificationService {

    private boolean isSent = false;

    @Override
    public void notify(String productName, int price) {
        new Thread(()-> {
            try {
                Thread.sleep(500);
                isSent = true;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    @Override
    public boolean isSent() {
        return isSent;
    }
}
