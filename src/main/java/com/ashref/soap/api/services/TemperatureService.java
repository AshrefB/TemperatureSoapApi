package com.ashref.soap.api.services;

import java.util.Comparator;
import java.util.List;
import org.springframework.stereotype.Service;

import com.ashref.soap.api.temperature.AvgTemperatureRequest;
import com.ashref.soap.api.temperature.AvgTemperatureResponse;
import com.ashref.soap.api.temperature.MaxTemperatureRequest;
import com.ashref.soap.api.temperature.MaxTemperatureResponse;
import com.ashref.soap.api.temperature.MinTemperatureRequest;
import com.ashref.soap.api.temperature.MinTemperatureResponse;

@Service
public class TemperatureService {
	public MinTemperatureResponse min(MinTemperatureRequest request) {
		MinTemperatureResponse response = new MinTemperatureResponse();
		List<Integer> list = request.getTemperatures();
		list.sort(Comparator.naturalOrder());
		response.setResult(list.get(0));
		return response;
	}
	
	public MaxTemperatureResponse max(MaxTemperatureRequest request) {
		MaxTemperatureResponse response = new MaxTemperatureResponse();
		List<Integer> list = request.getTemperatures();
		list.sort(Comparator.naturalOrder());
		response.setResult(list.get(list.size()-1));
		return response;
	}
	
	public AvgTemperatureResponse avg(AvgTemperatureRequest request) {
		AvgTemperatureResponse response = new AvgTemperatureResponse();
		List<Integer> list = request.getTemperatures();
		double avg = list.stream()
			.mapToInt(i -> i)
			.average()
			.getAsDouble();
		
		response.setResult(avg);
		return response;
	}
}
