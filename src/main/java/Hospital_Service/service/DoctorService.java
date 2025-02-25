package Hospital_Service.service;

import Hospital_Service.model.dto.DoctorDto;
import Hospital_Service.model.mapper.DoctorMapper;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class DoctorService {

    @Autowired private DoctorMapper doctorMapper;

    // 1. 환자 등록
    public boolean write( DoctorDto doctorDto) {
        System.out.println("DoctorController.write");
        System.out.println("doctorDto = " + doctorDto);
        return doctorMapper.write( doctorDto );
    } // f end

    // 2. 환자 전체 목록 조회
    public List<DoctorDto> findAll(){
        System.out.println("DoctorController.findAll");
        return doctorMapper.findAll();
    } // f end

    // 3. 환자 상세 조회
    public DoctorDto find( int doctorid ){
        System.out.println("DoctorController.find");
        System.out.println("doctorid = " + doctorid);
        return doctorMapper.find( doctorid );
    } // f end

    // 4. 환자 수정
    public boolean update( DoctorDto doctorDto ) {
        System.out.println("DoctorController.update");
        System.out.println("doctorDto = " + doctorDto);
        return doctorMapper.update( doctorDto );
    } // f end

    // 5. 환자 삭제
    public boolean delete( int doctorid ){
        System.out.println("DoctorController.delete");
        System.out.println("doctorid = " + doctorid);
        return doctorMapper.delete( doctorid );
    } // f end

}
