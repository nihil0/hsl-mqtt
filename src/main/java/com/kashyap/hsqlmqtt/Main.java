package com.kashyap.hsqlmqtt;

import org.eclipse.paho.client.mqttv3.*;

public class Main {
    public static void main(String[] args) throws MqttException {
        System.out.println("Hello");

        MqttConnectOptions options = new MqttConnectOptions();
        options.setMqttVersion(MqttConnectOptions.MQTT_VERSION_3_1_1);

        try {
            MqttClient hslMqtt = new MqttClient("tcp://mqtt.hsl.fi:1883", MqttClient.generateClientId());

            hslMqtt.setCallback(new MQTTKinesisPublisher());

            options.setCleanSession(true);
            hslMqtt.connect(options);
            System.out.println("connected!");

            hslMqtt.subscribe(args[0]);

        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
