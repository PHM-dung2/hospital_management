package Hospital_Service.model.dto;

import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class PatientDto {
    private int patientid;
    private String name;
    private String birthdate;
    private String phone;
    private String address;
    private String createdat;
}
