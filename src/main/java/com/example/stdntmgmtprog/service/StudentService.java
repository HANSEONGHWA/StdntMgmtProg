package com.example.stdntmgmtprog.service;

import com.example.stdntmgmtprog.entity.Student;
import com.example.stdntmgmtprog.entity.dto.StudentDto;
import com.example.stdntmgmtprog.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    /**
     * 학생 list
     */
    public List<Student> getList() {
        return studentRepository.findAll();
    }

    /**
     * 학생정보 등록
     */
    public void create(StudentDto dto) {
        Student std = Student.builder()
                .birth(dto.getBirth())
                .name(dto.getName())
                .s_grade(dto.getS_grade())
                .s_ban(dto.getS_ban())
                .s_number(dto.getS_number())
                .yearAdmission(dto.getYearAdmission())
                .build();
        studentRepository.save(std);
    }

    /**
     *
     */
    public Student getStudent(Integer id) throws DataFormatException {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return student.get();
        } else {
            throw new DataFormatException("student not found");
        }
    }

    /**
     * 학생수정
     */
    public void modify(Integer id, StudentDto dto) {
        Student std = Student.builder()
                .id(id)
                .birth(dto.getBirth())
                .s_grade(dto.getS_grade())
                .s_ban(dto.getS_ban())
                .s_number(dto.getS_number())
                .name(dto.getName())
                .yearAdmission(dto.getYearAdmission())
                .fileName(dto.getFileName())
                .fileOriName(dto.getFileName())
                .fileUrl(dto.getFileUrl())
                .build();
        studentRepository.save(std);
    }

    /**
     * 사진 업로드
     */
    public void fileUpload(Integer id, MultipartFile file) throws IOException {

        String oriName = file.getOriginalFilename();
        String fileUrl = "C:\\projectFile\\stdntMgmtProg\\file\\" + oriName;
        file.transferTo(new File(fileUrl));

        Student std = Student.builder()
                .id(id)
                .fileName(file.getName())
                .fileOriName(file.getOriginalFilename())
                .fileUrl(fileUrl)
                .build();
        studentRepository.save(std);


    }
}
