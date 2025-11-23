package com.example.spring_boot_rest.controller;

import com.example.spring_boot_rest.model.JobPost;
import com.example.spring_boot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

    @Autowired
    private JobService jobService;

    @GetMapping("jobPosts")
//    @ResponseBody -- this is not required as I am using RestController now and it does not think below method is returning jsp by default
//    @CrossOrigin(origins = "http://localhost:3000")
    public List<JobPost> getAllJobs(){
        return jobService.getAllJobs();
    }

//    @GetMapping("jobPost/103")
//    public JobPost getJob(){
//        return jobService.getJob(103);
//    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword) {
       return jobService.search(keyword);
    }

    @GetMapping(path="jobPost/{postId}", produces = {"application/json"})
    public JobPost getJob(@PathVariable int postId){
        return jobService.getJob(postId);
    }

//    @PostMapping("jobPost")
//    public JobPost addJob(@RequestBody JobPost jobPost){
//        jobService.addJob(jobPost);
//        return jobPost; -------returning this has a problem that we don't know if it's stored in the collection or not to overcome this refer below method
//    }

    @PostMapping(path="jobPost", consumes = {"application/xml"})
    public JobPost addJob(@RequestBody JobPost jobPost){
        jobService.addJob(jobPost);
        return jobService.getJob(jobPost.getPostId());
    }

    @PutMapping(path="jobPost", consumes = {"application/xml"})
    public JobPost updateJob(@RequestBody JobPost jobPost){
        jobService.updateJob(jobPost);
        return jobService.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable int postId){
        jobService.deleteJob(postId);
        return "Deleted";
    }

    @GetMapping("load")
    public String loadData(){

        jobService.load();

        return "success";
    }
}
