package com.example.U8M1.school;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SchoolService {
    private final SchoolRepository schoolRepository;

    @Autowired
    public SchoolService(SchoolRepository schoolRepository){
        this.schoolRepository = schoolRepository;
    }
    public List<School> getSchool(){
        return schoolRepository.findAll();
    }
    public void addNewSchool(School school){
        Optional<School> schoolByName = schoolRepository.findSchoolBy(school.getName());
        if (schoolByName.isPresent()){
            throw new IllegalStateException("email taken");
        }
        System.out.println(school);
        schoolRepository.save(school);
    }
    public void deleteSchool(Long schoolId){
        boolean exists = schoolRepository.existsById(schoolId);
        if(!exists){
            throw new IllegalStateException(
                    "Member with id "+schoolId+" does NOT exist."
            );
        }
        schoolRepository.deleteById(schoolId);
    }

    @Transactional
    public void updateSchool(Long schoolId,
                                   String name,
                                   String missionstatment, String phoneNum) {
        School school = schoolRepository.findById(schoolId).orElseThrow(
                ()-> new IllegalStateException(
                        "Member with Id "+schoolId+" does NOT exist."
                ));
        if (name != null &&
                !Objects.equals(school.getName(), name)){
            school.setName(name);
        }
        if (missionstatment != null &&
                !Objects.equals(school.getName(), missionstatment)){
            school.setMissionStatement(missionstatment);
        }
        if (phoneNum != null &&
                !phoneNum.isEmpty() &&
                !Objects.equals(school.getPhoneNum(), phoneNum)){
            school.setPhoneNum(phoneNum);
        }
    }

    public School getSchool(Long schoolId) {
        return schoolRepository.findById(schoolId).orElseThrow(
                ()-> new IllegalStateException(
                        "Member with Id "+schoolId+" does NOT exist."
                )
        );
    }
}
