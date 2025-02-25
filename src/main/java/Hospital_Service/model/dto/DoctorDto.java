package Hospital_Service.model.dto;

import lombok.*;

@Getter @Setter
@ToString
@NoArgsConstructor @AllArgsConstructor
public class DoctorDto {
    private int doctorid;
    private String name;
    private String specialty;
    private String phone;
    private String createdat;
}
