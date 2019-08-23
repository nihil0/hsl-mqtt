package com.kashyap.hsqlmqtt;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;


public class MQTTKinesisPublisher implements MqttCallback {

    @Override
    public void connectionLost(Throwable throwable) {
        System.out.println("Connection lost!");
    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        System.out.println(s);
        String messageContent = new String(mqttMessage.getPayload());
        System.out.println(messageContent);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        System.out.println("Delivery complete!");
    }
}
