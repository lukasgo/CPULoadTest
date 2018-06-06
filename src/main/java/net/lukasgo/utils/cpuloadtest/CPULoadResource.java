package net.lukasgo.utils.cpuloadtest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CPULoadResource {


	@GetMapping("/ping")
	public String echo() {
		return "Server up and running";
	}

	@GetMapping("/produceload")
	public String produceLoad() {
		final int NUM_TESTS = 1000;
		long start = System.nanoTime();
		for (int i = 0; i < NUM_TESTS; i++) {
			spin(500);
		}

		return "CPU Load Test completed";
	}

	private static void spin(int milliseconds) {
		long sleepTime = milliseconds*1000000L; // convert to nanoseconds
		long startTime = System.nanoTime();
		while ((System.nanoTime() - startTime) < sleepTime) {}
	}


}
