package com.ashref.soap.api.endpoints;

import javax.xml.stream.events.Namespace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.ashref.soap.api.services.TemperatureService;
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
}
