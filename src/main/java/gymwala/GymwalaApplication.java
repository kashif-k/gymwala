package gymwala;

import org.springframework.web.filter.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class GymwalaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GymwalaApplication.class, args);

	}

	@Bean
	public CorsFilter corsFilter(){
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration config = new CorsConfiguration();
		config.setAllowedOrigins(Collections.singletonList("*"));
		config.setAllowedHeaders(Collections.singletonList("*"));
		config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}

}
