package com.service.consumer.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;


@Controller
public class ConsumerControllerClient {
	
	private static final Logger logger = LoggerFactory.getLogger(ConsumerControllerClient.class);
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Autowired
	private LoadBalancerClient loadBalancer;
	
	@RequestMapping(value = "/consumer/getPatientDetails", method = RequestMethod.GET)
	public String getPatientDetail(Model patientDetModel)  {

		//String baseUrl = "http://localhost:8083/rest/db/a";
		
		//List<ServiceInstance> instances=discoveryClient.getInstances("PATIENT-APPT-SERVICE");
		//ServiceInstance serviceInstance=instances.get(0);
		
		//ServiceInstance serviceInstance_ribbon=loadBalancer.choose("Patient-appt-service");
		//String baseUrl=serviceInstance_ribbon.getUri().toString();
		//String baseUrl=serviceInstance.getUri().toString();
		
		//logger.debug("---------------------------------------"+serviceInstance.getUri());
		
		String baseUrl="http://localhost:8083/rest/db/getAllPatientDetails";
		
		RestTemplate restTemplate = new RestTemplate();
		List<PatientAppointmentDetail> patientAppointmentDetails =
				restTemplate.getForObject(baseUrl, List.class);
		
		patientDetModel.addAttribute("patientAppointmentDetails", patientAppointmentDetails); 
		//ResponseEntity<PatientAppointmentDetail> response=null;
		/*try{
		response=restTemplate.exchange(baseUrl,
				HttpMethod.GET, getHeaders(),PatientAppointmentDetail.class);
		}catch (Exception ex)
		{
			System.out.println(ex);
		}*/
		//List<PatientAppointmentDetail> patientAppointmentDetails= response.getBody();
		//System.out.println(response.getBody());
		return "console";
	}
	
/*	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}*/
	
}
