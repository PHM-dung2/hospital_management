package Hospital_Service.model.mapper;

import Hospital_Service.model.dto.DoctorDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DoctorMapper {
    // 1. 환자 등록
    @Insert( "INSERT INTO doctor( name, specialty, phone ) VALUES( #{name} , #{specialty} , #{phone}  )" )
    boolean write( DoctorDto doctorDto);
    // 2. 환자 전체 목록 조회
    @Select( "SELECT * FROM doctor" )
    List<DoctorDto> findAll();
    // 3. 환자 상세 조회
    @Select( "SELECT * FROM doctor WHERE doctorid = #{doctorid}" )
    DoctorDto find( int doctorid );
    // 4. 환자 수정
    @Update( "UPDATE doctor SET specialty = #{specialty}, phone = #{phone} WHERE doctorid = #{doctorid}" )
    boolean update( DoctorDto doctorDto );
    // 5. 환자 삭제
    @Delete( "DELETE FROM doctor WHERE doctorid = #{doctorid}" )
    boolean delete( int doctorid );

}
