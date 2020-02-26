package com.ashref.soap.api.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.ashref.soap.api.services.TemperatureService;
import com.ashref.soap.api.temperature.AvgTemperatureRequest;
import com.ashref.soap.api.temperature.AvgTemperatureResponse;
import com.ashref.soap.api.temperature.ClosestToZeroTemperatureRequest;
import com.ashref.soap.api.temperature.ClosestToZeroTemperatureResponse;
import com.ashref.soap.api.temperature.MaxTemperatureRequest;
import com.ashref.soap.api.temperature.MaxTemperatureResponse;
import com.ashref.soap.api.temperature.MinTemperatureRequest;
import com.ashref.soap.api.temperature.MinTemperatureResponse;

@Endpoint
public class TemperatureEndPoint {
	@Autowired
	private TemperatureService service;
	private final String NAMESPACE = "http://www.ashref.com/soap/api/temperature";

	@PayloadRoot(namespace = NAMESPACE, localPart = "MinTemperatureRequest")
	@ResponsePayload
	public MinTemperatureResponse getMinTemperature(@RequestPayload MinTemperatureRequest request) {
		return service.min(request);
	}
	
	@PayloadRoot(namespace = NAMESPACE, localPart = "MaxTemperatureRequest")
	@ResponsePayload
	public MaxTemperatureResponse getMaxTemperature(@RequestPayload MaxTemperatureRequest request) {
		return service.max(request);
	}
	
	@PayloadRoot(namespace = NAMESPACE, localPart = "AvgTemperatureRequest")
	@ResponsePayload
	public AvgTemperatureResponse getAvgTemperature(@RequestPayload AvgTemperatureRequest request) {
		return service.avg(request);
	}
	
	@PayloadRoot(namespace = NAMESPACE, localPart = "ClosestToZeroTemperatureRequest")
	@ResponsePayload
	public ClosestToZeroTemperatureResponse getClosestToZeroTemperature(@RequestPayload ClosestToZeroTemperatureRequest request) {
		return service.closestToZero(request);
	}
}
