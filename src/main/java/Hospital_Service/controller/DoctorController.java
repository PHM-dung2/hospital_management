package Hospital_Service.controller;

import Hospital_Service.model.dto.DoctorDto;
import Hospital_Service.model.dto.PatientDto;
import Hospital_Service.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired private DoctorService doctorService;

    @PostMapping
    // 1. 환자 등록
    public boolean write(@RequestBody DoctorDto doctorDto) {
        System.out.println("DoctorController.write");
        System.out.println("doctorDto = " + doctorDto);
        return doctorService.write( doctorDto );
    } // f end

    @GetMapping
    // 2. 환자 전체 목록 조회
    public List<DoctorDto> findAll(){
        System.out.println("DoctorController.findAll");
        return doctorService.findAll();
    } // f end

    @GetMapping("/view")
    // 3. 환자 상세 조회
    public DoctorDto find(@RequestParam( "doctorid" ) int doctorid ){
        System.out.println("DoctorController.find");
        System.out.println("doctorid = " + doctorid);
        return doctorService.find( doctorid );
    } // f end

    @PutMapping
    // 4. 환자 수정
    public boolean update(@RequestParam( "doctorid" ) int doctorid, @RequestBody DoctorDto doctorDto ) {
        doctorDto.setDoctorid(doctorid);
        System.out.println("DoctorController.update");
        System.out.println("doctorid = " + doctorid + ", doctorDto = " + doctorDto);
        return doctorService.update( doctorDto );
    } // f end

    @DeleteMapping
    // 5. 환자 삭제
    public boolean delete(@RequestParam( "doctorid" ) int doctorid ){
        System.out.println("DoctorController.delete");
        System.out.println("doctorid = " + doctorid);
        return doctorService.delete( doctorid );
    } // f end

}
