package Hospital_Service.service;

import Hospital_Service.model.dto.AppointmentDto;
import Hospital_Service.model.mapper.AppointmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired private AppointmentMapper appointmentMapper;

    // 1. 진료 예약 등록
    public boolean write( AppointmentDto appointmentDto ){
        System.out.println("AppointmentController.write");
        System.out.println("appointmentDto = " + appointmentDto);
        return appointmentMapper.write( appointmentDto );
    } // f end

    // 2. 전체 진료 조회
    public List<AppointmentDto> findAll(){
        System.out.println("AppointmentController.findAll");
        return appointmentMapper.findAll();
    } // f end

    // 3. 날짜별 예약 조회
    public List<AppointmentDto> findByDate( String appointmentdate ){
        System.out.println("AppointmentController.findDate");
        System.out.println("appointmentdate = " + appointmentdate);
        return appointmentMapper.findByDate( appointmentdate );
    } // f end

    // 4. 환자별 예약 조회
    public List<AppointmentDto> findByPatient( int patientid ){
        System.out.println("AppointmentController.findByPatient");
        System.out.println("patientid = " + patientid);
        return appointmentMapper.findByPatient( patientid );
    } // f end

    // 5. 의사별 예약 조회
    public List<AppointmentDto> findByDoctor( int doctorid ){
        System.out.println("AppointmentController.findByDoctor");
        System.out.println("doctorid = " + doctorid);
        return appointmentMapper.findByDoctor( doctorid );
    } // f end

    // 6. 진료 변경
    public boolean update( AppointmentDto appointmentDto ){
        System.out.println("AppointmentController.update");
        System.out.println("appointmentDto = " + appointmentDto);
        return appointmentMapper.update( appointmentDto );
    } // f end

    // 7. 진료 취소
    public boolean delete( int appointmentid ){
        System.out.println("AppointmentController.delete");
        System.out.println("appointmentid = " + appointmentid);
        return appointmentMapper.delete( appointmentid );
    } // f end

}
