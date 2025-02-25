package Hospital_Service.controller;

import Hospital_Service.model.dto.AppointmentDto;
import Hospital_Service.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired private AppointmentService appointmentService;

    @PostMapping
    // 1. 진료 예약 등록
    public boolean write( @RequestBody AppointmentDto appointmentDto ){
        System.out.println("AppointmentController.write");
        System.out.println("appointmentDto = " + appointmentDto);
        return appointmentService.write( appointmentDto );
    } // f end

    @GetMapping
    // 2. 전체 진료 조회
    public List<AppointmentDto> findAll(){
        System.out.println("AppointmentController.findAll");
        return appointmentService.findAll();
    } // f end

    // 2-1. 진료 상세 조회
    @GetMapping("/view")
    public AppointmentDto find( @RequestParam( "appointmentid" ) int appointmentid ){
        System.out.println("AppointmentController.findById");
        System.out.println("appointmentid = " + appointmentid);
        return appointmentService.find( appointmentid );
    } // f end

    @GetMapping( "/date" )
    // 3. 날짜별 예약 조회
    public List<AppointmentDto> findByDate( @RequestParam( "appointmentdate" ) String appointmentdate ){
        System.out.println("AppointmentController.findDate");
        System.out.println("appointmentdate = " + appointmentdate);
        return appointmentService.findByDate( appointmentdate );
    } // f end

    @GetMapping( "/patient" )
    // 4. 환자별 예약 조회
    public List<AppointmentDto> findByPatient( @RequestParam( "patientid" ) int patientid ){
        System.out.println("AppointmentController.findByPatient");
        System.out.println("patientid = " + patientid);
        return appointmentService.findByPatient( patientid );
    } // f end

    @GetMapping( "/doctor" )
    // 5. 의사별 예약 조회
    public List<AppointmentDto> findByDoctor( @RequestParam( "doctorid" ) int doctorid ){
        System.out.println("AppointmentController.findByDoctor");
        System.out.println("doctorid = " + doctorid);
        return appointmentService.findByDoctor( doctorid );
    } // f end

    @PutMapping
    // 6. 진료 변경
    public boolean update( @RequestParam( "appointmentid" ) int appointmentid, @RequestBody AppointmentDto appointmentDto ){
        appointmentDto.setAppointmentid(appointmentid);
        System.out.println("AppointmentController.update");
        System.out.println("appointmentDto = " + appointmentDto);
        return appointmentService.update( appointmentDto );
    } // f end

    @PutMapping( "/cancle" )
    // 7. 진료 취소
    public boolean delete( @RequestParam( "appointmentid" ) int appointmentid ){
        System.out.println("AppointmentController.delete");
        System.out.println("appointmentid = " + appointmentid);
        return appointmentService.delete( appointmentid );
    } // f end

}
