package com.example.spring_boot_rest;

import com.example.spring_boot_rest.model.JobPost;
import com.example.spring_boot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Controller
@RestController
public class JobRestController {

    @Autowired
    private JobService jobService;

    @GetMapping("jobPosts")
//    @ResponseBody -- this is not required as I am using RestController now and it does not think below method is returning jsp by default
    @CrossOrigin(origins = "http://localhost:3000")
    public List<JobPost> getAllJobs(){
        return jobService.getAllJobs();
    }

//    @GetMapping("jobPost/103")
//    public JobPost getJob(){
//        return jobService.getJob(103);
//    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJob(int postId){
        return jobService.getJob(postId);
    }
}
