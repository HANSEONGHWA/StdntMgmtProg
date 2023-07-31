package com.example.stdntmgmtprog.Student;

import com.example.stdntmgmtprog.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
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

        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            Student std1 = student.get();
            Student std = Student.builder()
                    .id(id)
                    .birth(dto.getBirth())
                    .s_grade(dto.getS_grade())
                    .s_ban(dto.getS_ban())
                    .s_number(dto.getS_number())
                    .name(dto.getName())
                    .yearAdmission(dto.getYearAdmission())
                    .fileName(std1.getFileName())
                    .fileOriName(std1.getFileOriName())
                    .fileUrl(std1.getFileUrl())
                    .build();
            studentRepository.save(std);
        }
    }

    /**
     * 사진 업로드
     */
    public void fileUpload(Integer id, MultipartFile file) throws IOException {
        //파일 크기 확인
        if (file.getSize() > (10 * 1024 * 1024)) {
            throw new IllegalArgumentException("파일 크기가 제한을 초과했습니다.");
        }

        //이미지 규격확인
        BufferedImage image = ImageIO.read(file.getInputStream());
        int width = image.getWidth();
        int height = image.getHeight();

        if (width > 450 || height > 550) {
            throw new IllegalArgumentException("이미지 크기가 제한을 초과했습니다.");
        }

        //파일 업로드
        String fileName = file.getName();
        String oriName = file.getOriginalFilename();
        String fileUrl = "C:\\projectFile\\stdntMgmtProg\\src\\main\\resources\\static\\img\\" + oriName;
        file.transferTo(new File(fileUrl));

        // 이미지, 학생정보 저장
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            Student std1 = student.get();
            Student std2 = Student.builder()
                    .id(std1.getId())
                    .birth(std1.getBirth())
                    .s_grade(std1.getS_grade())
                    .s_ban(std1.getS_ban())
                    .s_number(std1.getS_number())
                    .name(std1.getName())
                    .yearAdmission(std1.getYearAdmission())
                    .fileName(fileName)
                    .fileOriName(file.getOriginalFilename())
                    .fileUrl(fileUrl)
                    .build();
            studentRepository.save(std2);
//        }else{
//            throw new
//        }
        }
    }

    /**
     * 사진 삭제
     */
    public void delete(Student dto){
    studentRepository.delete(dto);
    }

    /**
     * select 태그 option
     */
    public List<Student>selectSearch(){

        List<Student> select = studentRepository.findAll();
//        List<Student> select = studentRepository.findByYearAdmission();
        return select;
    }

    /**
     * 검색
     */

//    public List<Student> search(String yearAdmission){
//
//        List<Student> searchStd = studentRepository.findByYearAdmission(yearAdmission);
//
//        return searchStd;
//    }
}
