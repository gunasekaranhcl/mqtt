package com.mqtt;

import java.util.Random;

public class Mqttanalytics {

	public static void main(String[] args) {

		DataStores ds1 = new DataStores();
		ds1.createTable();
		// note a single Random object is reused here
		Random randomGenerator = new Random();
		for (int idx = 1; idx <= 10; ++idx) {
			int randomInt = randomGenerator.nextInt(80);

		}

		for (int i = 0; i < 10000; i++) {

			String data = "pulse:true;time:" + System.currentTimeMillis();

			String[] datastore = data.split(";");

			HeartBeats.data = data;
			if (HeartBeats.series.isEmpty()) {
				HeartBeats.series = data;
			} else {
				HeartBeats.series = HeartBeats.series + "/" + data;
			}
			HeartBeats.series = HeartBeats.series + "/" + data;

			if (datastore[0].contains("true")) {
				HeartBeats.pulse = true;
			} else {
				HeartBeats.pulse = false;
			}
			HeartBeats.count = HeartBeats.count + 1;
			if (HeartBeats.count == 100) {
				synchronized (HeartBeats.series) {
					DataStores ds = new DataStores();
					ds.insertData(HeartBeats.series);
					HeartBeats.series = "";
				}

			}

		}

		DataStores ds = new DataStores();
		ds.selectTable();

	}

}
