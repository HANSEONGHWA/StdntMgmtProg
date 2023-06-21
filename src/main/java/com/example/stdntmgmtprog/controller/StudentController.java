package com.example.stdntmgmtprog.controller;

import com.example.stdntmgmtprog.entity.Student;
import com.example.stdntmgmtprog.entity.dto.StudentDto;
import com.example.stdntmgmtprog.service.StudentService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/list")
    public String list(Model model){
        List<Student> students = studentService.getList();
        model.addAttribute("students", students);
        return "student_list";
    }

    //학생정보관리 list 페이지 이동
    @GetMapping("/")
    public String root(){
        return "redirect:/student/list";
    }


    /**
     * 학생정보등록
     */
    @GetMapping("/create")
    public String studentCreate(){
        return "student_form";
  }
    @PostMapping("/create")
    public String studentCreate(@ModelAttribute StudentDto dto){
        studentService.create(dto);
        return "redirect:/student/list";
    }


}
