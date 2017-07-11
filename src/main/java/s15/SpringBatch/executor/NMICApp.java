package s15.SpringBatch.executor;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NMICApp {


	  public static void main(String[] args) {

		String[] springConfig  =
			{
				"batch/jobs/job-NMIC.xml"
			};

		ApplicationContext context =
				new ClassPathXmlApplicationContext(springConfig);

		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		Job job = (Job) context.getBean("testJob");

		try {
			JobParameters param = new JobParametersBuilder().addString("amt", "1").toJobParameters();
			JobExecution execution = jobLauncher.run(job, param);
			System.out.println("Exit Status : " + execution.getStatus());

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Done");

	  }

	
}
