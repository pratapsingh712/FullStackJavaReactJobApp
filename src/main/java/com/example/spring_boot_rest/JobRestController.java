package com.example.spring_boot_rest;

import com.example.spring_boot_rest.model.JobPost;
import com.example.spring_boot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class JobRestController {

    @Autowired
    private JobService jobService;

    @GetMapping("jobPosts")
    @ResponseBody
    public List<JobPost> getAllJobs(){
        return jobService.getAllJobs();
    }
}
