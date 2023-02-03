package com.supremepole.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import java.util.Map;

public class BillTasklet implements Tasklet {

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        String jobName=chunkContext.getStepContext().getJobName();
        String stepName=chunkContext.getStepContext().getStepName();
        System.out.println(jobName);
        System.out.println(stepName);
        chunkContext.getStepContext().getStepExecution().getExecutionContext().put("key", "value");
        System.out.println(stepContribution);
        return RepeatStatus.FINISHED;
    }

}
