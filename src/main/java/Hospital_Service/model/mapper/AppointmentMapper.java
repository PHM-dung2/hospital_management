package Hospital_Service.model.mapper;

import Hospital_Service.model.dto.AppointmentDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface AppointmentMapper {
    // 1. 진료 예약 등록
    @Insert( "INSERT INTO appointment ( patientid, doctorid, appointmentdate, appointmenttime ) " +
            "VALUES ( #{patientid}, #{doctorid}, #{appointmentdate}, #{appointmenttime} )")
    boolean write( AppointmentDto appointmentDto );

    // 2. 전체 진료 조회
    @Select( "SELECT p.name, d.name, a.* FROM appointment a INNER JOIN patient p ON p.patientid = a.patientid " +
            "INNER JOIN doctor d ON d.doctorid = a.doctorid ORDER BY a.appointmentdate DESC" )
    List<AppointmentDto> findAll();

    // 3. 날짜별 예약 조회
    @Select( "SELECT p.name, d.name, a.* FROM appointment a INNER JOIN patient p ON p.patientid = a.patientid " +
            "INNER JOIN doctor d ON d.doctorid = a.doctorid WHERE a.appointmentdate = #{appointmentdate} " +
            "ORDER BY a.appointmentdate DESC" )
    List<AppointmentDto> findByDate( String appointmentdate );

    // 4. 환자별 예약 조회
    @Select( "SELECT p.name, d.name, a.* FROM appointment a INNER JOIN patient p ON p.patientid = a.patientid " +
            "INNER JOIN doctor d ON d.doctorid = a.doctorid WHERE a.patientid = #{patientid} " +
            "ORDER BY a.appointmentdate DESC" )
    List<AppointmentDto> findByPatient( int patientid );

    // 5. 의사별 예약 조회
    @Select( "SELECT p.name, d.name, a.* FROM appointment a INNER JOIN patient p ON p.patientid = a.patientid " +
            "INNER JOIN doctor d ON d.doctorid = a.doctorid WHERE a.doctorid = #{doctorid} " +
            "ORDER BY a.appointmentdate DESC" )
    List<AppointmentDto> findByDoctor( int doctorid );

    // 6. 진료 변경
    @Update( "UPDATE appointment SET doctorid = #{doctorid}, appointmentdate = #{appointmentdate}, appointmenttime = #{appointmenttime} " +
            "WHERE appointmentid = #{appointmentid}" )
    boolean update( AppointmentDto appointmentDto );

    // 7. 진료 취소
    @Update( "UPDATE appointment SET status = '0' WHERE appointmentid = #{appointmentid}" )
    boolean delete( int appointmentid );

}
