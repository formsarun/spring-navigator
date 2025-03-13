package com.arun.navigator;

import com.arun.navigator.model.Direction;
import com.arun.navigator.model.OceanGrid;
import com.arun.navigator.model.Probe;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NavigatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(NavigatorApplication.class, args);
	}

//	@Scope("singleton")
	@Bean
	OceanGrid getGrid() {
		return new OceanGrid();
	}

//	@Scope("singleton")
	@Bean
	Probe getProbe(OceanGrid grid) {
		return new Probe(0,0, Direction.NORTH, grid);
	}
}
