package Hospital_Service.model.dto;

import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class AppointmentDto {
    private int appointmentid;
    private int patientid;
    private int doctorid;
    private String appointmentdate;
    private String appointmenttime;
    private int status;
    private String createdat;
}
