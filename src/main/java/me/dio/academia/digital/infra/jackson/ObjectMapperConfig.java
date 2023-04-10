package me.dio.academia.digital.infra.jackson;

import com.fasterxml.jackson.databind.SerializationFeature;
import me.dio.academia.digital.infra.jackson.deser.LDDeserializer;
import me.dio.academia.digital.infra.jackson.deser.LDTDeserializer;
import me.dio.academia.digital.infra.jackson.ser.LDSerializer;
import me.dio.academia.digital.infra.jackson.ser.LDTSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Venilton Falvo Jr
 */
@Configuration
public class ObjectMapperConfig implements Jackson2ObjectMapperBuilderCustomizer {
	
	@Override
	public void customize(Jackson2ObjectMapperBuilder jacksonObjectMapperBuilder) {
		jacksonObjectMapperBuilder.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
				.serializerByType(LocalDate.class, new LDSerializer())
				.serializerByType(LocalDateTime.class, new LDTSerializer())
				.deserializerByType(LocalDate.class, new LDDeserializer())
				.deserializerByType(LocalDateTime.class, new LDTDeserializer());
	}
}
