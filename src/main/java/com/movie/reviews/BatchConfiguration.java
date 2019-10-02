package com.movie.reviews;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.movie.reviews.processor.MovieReviewProcessor;
import com.movie.reviews.reader.MovieReviewReader;
import com.movie.reviews.writer.MovieReviewWriter;

@SpringBootApplication
@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
	
	public static void main(String[] args) {
		SpringApplication.run(BatchConfiguration.class, args);
	}
	
	@Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;
    
   
    @Bean
    public ItemReader reader() {
        return new MovieReviewReader();
    }
    
    @Bean
    public ItemProcessor processor() {
        return new MovieReviewProcessor();
    }
    
    @Bean
    public ItemWriter writer() {
        return new MovieReviewWriter();
    }
    
    
    
    @Bean
    public Job calculateMovieRatings(JobCompletionNotificationListener listener, Step step1) {
        return jobBuilderFactory.get("calculateMovieRatings")
            .incrementer(new RunIdIncrementer())
            .listener(listener)
            .flow(step1)
            .end()
            .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1").chunk(1)
            .reader(reader())
            .processor(processor())
            .writer(writer())
            .build();
    }
    

}
