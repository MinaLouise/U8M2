package com.example.U8M1.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/school")
public class SchoolController {
    private final SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService){
        this.schoolService = schoolService;
    }
    @GetMapping
    public List<School> getSchoolAll(){
        return schoolService.getSchoolAll();
    }
    @GetMapping(path = "{schoolId}")
    public School getSchoolById(@PathVariable("schoolId") Long schoolId){
        return schoolService.getSchool(schoolId);
    }
    @PostMapping
    public void registerNewSchool(@RequestBody School school){
        schoolService.addNewSchool(school);
    }

    @DeleteMapping(path = "{schoolId}")
    public void deleteSchool(@PathVariable("schoolId") Long schoolId){
        schoolService.deleteSchool(schoolId);
    }

    @PutMapping(path = "{schoolId}")
    public void updateSchool(
            @PathVariable("schoolId") Long schoolId,
            @RequestParam(required = false)String name,
            @RequestParam(required = false)String missionstatment,
            @RequestParam(required = false)String phoneNum){
        schoolService.updateSchool(schoolId, name, missionstatment, phoneNum);
    }
}