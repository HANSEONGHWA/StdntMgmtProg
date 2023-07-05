package com.example.stdntmgmtprog.controller;

import com.example.stdntmgmtprog.entity.Student;
import com.example.stdntmgmtprog.entity.dto.StudentDto;
import com.example.stdntmgmtprog.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;

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
        return "student_addForm";
  }
    @PostMapping("/create")
    public String studentCreate(@ModelAttribute StudentDto dto){
        studentService.create(dto);
        return "redirect:/student/list";
    }

    /**
     * 학생정보 수정
     */
    @GetMapping("/modify/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) throws DataFormatException {
        Student student = studentService.getStudent(id);
        System.out.println(student.getFileUrl());
        model.addAttribute("student", student);
        return "student_form";
    }

    @PostMapping("/modify/{id}")
    public String modify(@PathVariable("id") Integer id, @ModelAttribute StudentDto dto ) throws DataFormatException {
        studentService.modify(id,dto);
        return "redirect:/student/list";
    }

    @GetMapping("/fileUpload/{id}")
    public String fileUpload(@PathVariable("id") Integer id, @ModelAttribute StudentDto dto, Model model) throws DataFormatException {
        Student student = studentService.getStudent(id);
//        model.addAttribute("student", student);
        return "test";
    }
    //사진파일 업로드
    @PostMapping("/fileUpload/{id}")
    public String fileUpload(@PathVariable Integer id, Model model, @RequestPart MultipartFile file)
            throws DataFormatException, IOException {

        studentService.fileUpload(id,file);
        System.out.println("file = " + file);
        Student student = studentService.getStudent(id);
        System.out.println(student.getFileUrl());
        model.addAttribute("student", student);
        return "redirect:/student/";
    }
}
