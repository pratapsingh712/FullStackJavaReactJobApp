package com.example.spring_boot_rest.service;

import com.example.spring_boot_rest.model.JobPost;
import com.example.spring_boot_rest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {


    @Autowired
    private JobRepo repo;

    public void addJob(JobPost jobPost) {
        repo.save(jobPost);
    }

    public List<JobPost> getAllJobs() {
        return repo.findAll();
    }

    public JobPost getJob(int postId) {
        return repo.findById(postId).orElse(new JobPost());
    }

    public void updateJob(JobPost jobPost) {
        repo.save(jobPost);
    }

    public void deleteJob(int postId) {
        repo.deleteById(postId);
    }


    public void load() {
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
                        5, Arrays.asList("Node.js", "Express", "React", "MongoDB"))));

        repo.saveAll(jobs);
    }

    public List<JobPost> search(String keyword) {
       return repo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }
}
