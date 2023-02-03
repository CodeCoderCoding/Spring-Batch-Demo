package com.supremepole.tasklet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:job.xml",
        "classpath:job-context.xml",
        "classpath:job-test.xml"})
public class BillTaskletTest {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Test
    public void execute() {
        JobExecution jobExecution = jobLauncherTestUtils.launchStep("billStep");
        assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());
    }

}