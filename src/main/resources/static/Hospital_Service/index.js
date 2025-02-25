console.log( "index.js open" );

// 1. 환자 select option
const patientSelect = async () => {
    try{
        let html = '';
        const response = await axios.get( '/patient' )
        response.data.forEach( patient => {
            const patientSelect = document.querySelector( '#patientSelect' );
            html += `<option value="${patient.patientid}"> ${patient.name} </option>`;
            patientSelect.innerHTML = html;
        }) // f end

    }catch(e){ console.log( e ); }
} // f end
patientSelect();

// 2. 의사 select option
const doctorSelect = async () => {
    try{
        let html = '';
        const response = await axios.get( '/doctor' )
        response.data.forEach( doctor => {
            const doctorSelect = document.querySelector( '#doctorSelect' );
            html += `<option value="${doctor.doctorid}"> ${doctor.name}( ${doctor.specialty} ) </option>`;
            doctorSelect.innerHTML = html;
        }) // f end

    }catch(e){ console.log( e ); }
} // f end
doctorSelect();

// 3. 진료 예약 등록
const onWrite = async () => {
    if( !confirm('진료 예약하시곘습니까?')){ return; }
    try{
        const patientSelect = document.querySelector( '#patientSelect' );
        const doctorSelect = document.querySelector( '#doctorSelect' );
        const dateInput = document.querySelector( '#dateInput' );
        const timeInput = document.querySelector( '#timeInput' );

        const patientid = patientSelect.value;
        const doctorid = doctorSelect.value;
        const appointmentdate = dateInput.value;
        const appointmenttime = timeInput.value;

        const obj = { patientid, doctorid, appointmentdate, appointmenttime };
        const response = await axios.post( '/appointment' , obj )
        if( response.data ) { alert('진료 예약 성공'); findAll(); }
        else{ alert('진료 예약 실패'); }
    }catch(e){ console.log(e); }
} // f end

// 4. 진료 예약 목록 출력
const findAll = async () => {
    try{
        const response = await axios.get( '/appointment' );
        let html = '';
        response.data.forEach( appointment => {
            if( appointment.status == 1 ){
                const tbody = document.querySelector( 'tbody' );
                html += `<tr>
                             <th scope="row"> ${ appointment.appointmentid } </th>
                             <td class="pname${appointment.appointmentid}"> ${ appointment.pname } </td>
                             <td class="dname${appointment.appointmentid}"> ${ appointment.dname }( ${ appointment.specialty } ) </td>
                             <td class="date${appointment.appointmentid}"> ${ appointment.appointmentdate } </td>
                             <td class="time${appointment.appointmentid}"> ${ appointment.appointmenttime } </td>
                             <td class="btn${appointment.appointmentid}">
                                <button onclick="onUpdateLink(${appointment.appointmentid})" type="button" class="btn btn-success"> 수정 </button>
                                <button onclick="onDelete(${appointment.appointmentid})" type="button" class="btn btn-success"> 취소 </button>
                             </td>
                         </tr>`;
                tbody.innerHTML = html;
            }
        }) // for end
    }catch(e){ console.log(e); }
} // f end
findAll();

// 4. 진료 예약 수정 페이지 이동
const onUpdateLink = (id) => {
    location.href = `/hospital_service/appointmentupdate.html?appointmentid=${id}`;
}

// 6. 진료 예약 목록 취소
const onDelete = async (id) => {
    if(!confirm('진료 예약을 취소하시겠습니까?')){ return; }
    try{
        const response = await axios.put( `/appointment/cancle?appointmentid=${id}` );
        if( response.data ) { alert('진료 예약 취소 성공'); findAll(); }
        else{ alert('진료 예약 취소 실패'); }
    }catch(e){ console.log(e); }
} // f end
