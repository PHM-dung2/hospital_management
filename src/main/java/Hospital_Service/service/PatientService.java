package Hospital_Service.service;

import Hospital_Service.model.dto.PatientDto;
import Hospital_Service.model.mapper.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired private PatientMapper patientMapper;

    // 1. 환자 등록
    public boolean write( PatientDto patientDto ) {
        System.out.println("PatientController.write");
        System.out.println("patientDto = " + patientDto);
        return patientMapper.write( patientDto );
    } // f end

    // 2. 환자 전체 목록 조회
    public List<PatientDto> findAll(){
        System.out.println("PatientController.findAll");
        return patientMapper.findAll();
    } // f end

    // 3. 환자 상세 조회
    public PatientDto find( int patientid ){
        System.out.println("PatientController.find");
        System.out.println("patientid = " + patientid);
        return patientMapper.find( patientid );
    } // f end

    // 4. 환자 수정
    public boolean update( PatientDto patientDto ) {
        System.out.println("PatientController.update");
        System.out.println("patientDto = " + patientDto);
        return patientMapper.update( patientDto );
    } // f end

    // 5. 환자 삭제
    public boolean delete( int patientid ){
        System.out.println("PatientController.delete");
        System.out.println("patientid = " + patientid);
        return patientMapper.delete( patientid );
    } // f end

}
