package com.active.mysensor;

import com.active.mysensor.untils.HttpClientUtil;
import com.active.mysensor.untils.InfoUtils;
import com.active.mysensor.untils.SystemInfoTest;
import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.Components;
import com.profesorfalken.jsensors.model.components.Cpu;
import com.profesorfalken.jsensors.model.sensors.Fan;
import com.profesorfalken.jsensors.model.sensors.Temperature;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.*;
import java.util.ArrayList;

@SpringBootApplication
public class MysensorApplication {

	public static void main(String[] args) {

//		SystemInfoTest.test();

		Map<String, String> map = new HashMap<>();
		map.put("text", InfoUtils.get("currentStatus") + ": " + InfoUtils.getHostname());
		map.put("desp", InfoUtils.getDeviceInfo());

		HttpClientUtil.doPost("https://sc.ftqq.com/SCU48981T4fb6e368a395cf49b26f8bec99fe6cbf5cb93aed4ba36.send", map);

		SpringApplication.run(MysensorApplication.class, args);

			test();
	}




	private static void test(){

		System.out.println("===============jSensor BEGIN===================================");
		Components components = JSensors.get.components();

		List<Cpu> cpus = components.cpus;
		if (cpus != null) {
			for (final Cpu cpu : cpus) {
				System.out.println("Found CPU component: " + cpu.name);
				if (cpu.sensors != null) {
					System.out.println("Sensors: ");

					//Print temperatures
					List<Temperature> temps = cpu.sensors.temperatures;
					for (final Temperature temp : temps) {
						System.out.println(temp.name + ": " + temp.value + " C");
					}

					//Print fan speed
					List<Fan> fans = cpu.sensors.fans;
					for (final Fan fan : fans) {
						System.out.println(fan.name + ": " + fan.value + " RPM");
					}
				}
			}
		}

		System.out.println("===============jSensor  END===================================");
	}

}
