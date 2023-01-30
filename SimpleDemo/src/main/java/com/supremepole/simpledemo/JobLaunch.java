package com.supremepole.simpledemo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class JobLaunch {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("job.xml");
        JobLauncher launcher = (JobLauncher) context.getBean("jobLauncher");
        Job job = (Job) context.getBean("billJob");
        try {
            JobParameters jobParameters=new JobParametersBuilder().addDate("date", new Date()).toJobParameters();
            JobExecution jobExecution = launcher.run(job, jobParameters);
            ExecutionContext executionContext=jobExecution.getExecutionContext();
            System.out.println(executionContext);
            executionContext.putString("executionContextKey", "executionContextValue");
            jobExecution.setExecutionContext(executionContext);
            System.out.println(executionContext);
            System.out.println(jobExecution.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
