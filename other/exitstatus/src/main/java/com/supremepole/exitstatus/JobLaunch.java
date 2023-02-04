package com.supremepole.exitstatus;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collection;
import java.util.Iterator;

public class JobLaunch {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("job.xml");
        JobLauncher launcher = (JobLauncher) context.getBean("jobLauncher");
        Job job = (Job) context.getBean("billJob");
        try {
            JobExecution jobExecution = launcher.run(job, new JobParameters());
            System.out.println("step结束后的，jobExecution的exitStatus："+jobExecution.getExitStatus());
            Collection<StepExecution> collection=jobExecution.getStepExecutions();
            Iterator iterator=collection.iterator();
            StepExecution stepExecution=(StepExecution) iterator.next();
            System.out.println("step结束后的，stepExecution的exitStatus："+stepExecution.getExitStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
