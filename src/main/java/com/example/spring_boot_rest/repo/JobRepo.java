package com.example.spring_boot_rest.repo;

import com.example.spring_boot_rest.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer> {


}

// mocking like an actual database
/*
 List<JobPost> jobs = new ArrayList<>(Arrays.asList(
            new JobPost(101, "Backend Developer", "Responsible for building and maintaining server-side applications.",
                    3, Arrays.asList("Java", "Spring Boot", "MySQL")),

            new JobPost(102, "Frontend Engineer",
                    "Develop modern, responsive web user interfaces.",
                    2, Arrays.asList("React", "TypeScript", "HTML", "CSS")),

            new JobPost(103, "Mobile App Developer",
                    "Build and optimize mobile applications for iOS and Android.",
                    4, Arrays.asList("Swift", "Kotlin", "Firebase")),

            new JobPost(104, "Full Stack Developer",
                    "Work on both frontend and backend to build scalable applications.",
                    5, Arrays.asList("Node.js", "Express", "React", "MongoDB")),

            new JobPost(105, "Data Engineer",
                    "Design and maintain robust data pipelines and ETL processes.",
                    3, Arrays.asList("Python", "Spark", "AWS", "SQL")),

            new JobPost(106, "DevOps Engineer",
                    "Automate deployments and manage CI/CD infrastructure.",
                    4, Arrays.asList("Docker", "Kubernetes", "AWS", "Jenkins")),

            new JobPost(107, "AI Engineer",
                    "Develop, train, and deploy machine learning models.",
                    5, Arrays.asList("Python", "TensorFlow", "PyTorch", "FastAPI")),

            new JobPost(108, "QA Automation Engineer",
                    "Design automated test suites and ensure application reliability.",
                    2, Arrays.asList("Selenium", "Java", "JUnit")),

            new JobPost(109, "System Administrator",
                    "Manage and monitor servers, ensuring security and uptime.",
                    3, Arrays.asList("Linux", "Bash", "Ansible")),

            new JobPost(110, "Cloud Architect",
                    "Design cloud-based solutions and oversee infrastructure deployments.",
                    6, Arrays.asList("AWS", "Azure", "Terraform", "Docker"))
    ));

    public List<JobPost> getAllJobs(){
        return jobs;
    }

    public void addJob(JobPost job){
        jobs.add(job);
        System.out.println(jobs);
    }

    public JobPost getJob(int postId) {

        for(JobPost job : jobs){
            if(job.getPostId() == postId){
                return job;
            }
        }

        return null;
    }

    public void updateJob(JobPost jobPost) {
        for(JobPost jobPost1 : jobs){
            if(jobPost1.getPostId() == jobPost.getPostId()){
                jobPost1.setPostProfile(jobPost.getPostProfile());
                jobPost1.setPostDesc(jobPost.getPostDesc());
                jobPost1.setReqExperience(jobPost.getReqExperience());
                jobPost1.setPostTechStack(jobPost.getPostTechStack());
            }
        }
    }

    public void deleteJob(int postId) {
        for(JobPost jobPost : jobs){
            if(jobPost.getPostId() == postId){
                jobs.remove(jobPost);
            }
        }
    }
 */