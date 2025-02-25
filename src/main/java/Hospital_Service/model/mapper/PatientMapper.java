package Hospital_Service.model.mapper;

import Hospital_Service.model.dto.PatientDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PatientMapper {
    // 1. 환자 등록
    @Insert( "INSERT INTO patient( name, birthdate, phone, address ) VALUES( #{name} , #{birthdate}, #{phone}, #{address} )" )
    boolean write( PatientDto patientDto );
    // 2. 환자 전체 목록 조회
    @Select( "SELECT * FROM patient" )
    List<PatientDto> findAll();
    // 3. 환자 상세 조회
    @Select( "SELECT * FROM patient WHERE patientid=#{patientid}" )
    PatientDto find( int patiendid );
    // 4. 환자 수정
    @Update( "UPDATE patient SET birthdate = #{birthdate}, phone = #{phone}, address = #{address} WHERE patientid=#{patientid}")
    boolean update( PatientDto patientDto );
    @Delete( "DELETE FROM patient WHERE patientid=#{patientid}" )
    // 5. 환자 삭제
    boolean delete( int patiendid );
}
