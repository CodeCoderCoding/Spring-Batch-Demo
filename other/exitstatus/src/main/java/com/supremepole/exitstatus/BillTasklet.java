package com.supremepole.exitstatus;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class BillTasklet implements Tasklet {

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        stepContribution.setExitStatus(ExitStatus.FAILED);
        System.out.println("step执行中的，stepContribution的exitStatus："+stepContribution.getExitStatus());
        System.out.println("step执行中的，stepExecution的exitStatus："+chunkContext.getStepContext().getStepExecution().getExitStatus());
        System.out.println("step执行中的，jobExecution的exitStatus："+chunkContext.getStepContext().getStepExecution().getJobExecution().getExitStatus());
        return RepeatStatus.FINISHED;
    }

}
