package com.optative.bf.ws;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ser.CustomSerializerFactory;
import org.joda.time.DateTime;

public class CustomObjectMapper extends ObjectMapper {

	public CustomObjectMapper() {
		CustomSerializerFactory factory = new CustomSerializerFactory();
	//	factory.addSpecificMapping(DateTime.class, new CustomDateSerializer());
		this.setSerializerFactory(factory);

	}

}
