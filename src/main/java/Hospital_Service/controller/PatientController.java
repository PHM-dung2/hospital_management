package Hospital_Service.controller;

import Hospital_Service.model.dto.PatientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import Hospital_Service.service.PatientService;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired private PatientService patientService;

    // 1. 환자 등록
    @PostMapping
    public boolean write(@RequestBody PatientDto patientDto) {
        System.out.println("PatientController.write");
        System.out.println("patientDto = " + patientDto);
        return patientService.write( patientDto );
    } // f end

    @GetMapping
    // 2. 환자 전체 목록 조회
    public List<PatientDto> findAll(){
        System.out.println("PatientController.findAll");
        return patientService.findAll();
    } // f end

    @GetMapping("/view")
    // 3. 환자 상세 조회
    public PatientDto find(@RequestParam( "patientid" ) int patientid ){
        System.out.println("PatientController.find");
        System.out.println();
        return patientService.find( patientid );
    } // f end

    @PutMapping
    // 4. 환자 수정
    public boolean update(@RequestParam( "patientid" ) int patientid, @RequestBody PatientDto patientDto ) {
        patientDto.setPatientid( patientid );
        System.out.println("PatientController.update");
        System.out.println("patientDto = " + patientDto);
        return patientService.update( patientDto );
    } // f end

    @DeleteMapping
    // 5. 환자 삭제
    public boolean delete(@RequestParam( "patientid" ) int patiendid ){
        System.out.println("PatientController.delete");
        System.out.println("patientid = " + patiendid);
        return patientService.delete( patiendid );
    } // f end

}
