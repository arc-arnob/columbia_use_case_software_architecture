package com.demo.blazeguard.service;


import org.springframework.stereotype.Service;

@Service
public class AlertNotificationService {
    public static void notify(String message) {
        System.out.println("Notification: " + message);
        sendDashBoardNotification(message);
        sendSMSNotification(message);

    }

    private static void sendSMSNotification(String message) {
        //SMS logic
        System.out.println("Sending SMS Notifcation: " + message);
    }

    private static void sendDashBoardNotification(String message) {
        //dashboard notifcation logic
        System.out.println("Sending DashBoard Notifcation: " + message);
    }
}
