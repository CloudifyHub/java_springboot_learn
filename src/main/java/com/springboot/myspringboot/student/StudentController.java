package com.springboot.myspringboot.student;


import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private  final  StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }


    @PostMapping
    public void registerNewStudent(@RequestBody Object student) throws IOException {
       // studentService.addNewStudent(student);
        Gson gson = new Gson();
        String emailBody = gson.toJson(student);
        SendEmail sendMail = new SendEmail();
        sendMail.sendEmail(emailBody);

    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestBody(required = false) String name,
            @RequestBody(required = false) String email ){
                 studentService.updateStudent(studentId, name, email);
    }

}


