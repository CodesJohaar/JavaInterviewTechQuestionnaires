package com.java_interview_tech_questionnaires.mongock;

import io.mongock.driver.mongodb.springdata.v4.SpringDataMongoV4Driver;
import io.mongock.runner.springboot.MongockSpringboot;
import io.mongock.runner.springboot.base.MongockInitializingBeanRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @author RavikantS on Sept 09, 2025
 */
@Configuration
public class MongoConfig {
	@Bean
	public MongockInitializingBeanRunner mongockInitializingBeanRunner(MongoTemplate mongoTemplate,
	                                                                   ApplicationContext applicationContext) {
		return MongockSpringboot.builder()
				.setDriver(SpringDataMongoV4Driver.withDefaultLock(mongoTemplate))
				.addMigrationScanPackage("com.java_interview_tech_questionnaires.mongock")
				.setSpringContext(applicationContext)
				.buildInitializingBeanRunner();
	}
}
