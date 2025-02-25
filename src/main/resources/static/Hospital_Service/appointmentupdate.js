console.log( 'appointmentwrite.js open' );

// 1. appointmentid 얻기
const appointmentid = new URLSearchParams(location.search).get('appointmentid');

// 2. 취소 버튼
const onCancle = () => {
    location.href = `/hospital_service/index.html`;
} // f end

// 3. input값 입력
const findInput = async () => {
    const patientSelect = document.querySelector( '#patientSelect' );
    const doctorSelect = document.querySelector( '#doctorSelect' );
    const dateInput = document.querySelector( '#dateInput' );
    const timeInput = document.querySelector( '#timeInput' );

    const response = await axios.get( `/appointment/view?appointmentid=${appointmentid}` );
    console.log( response.data.name);
    patientSelect.value = response.data.patientid;
    doctorSelect.value = response.data.doctorid;
    dateInput.value = response.data.appointmentdate;
    timeInput.value = response.data.appointmenttime;

} // f end
findInput();

// 4. 진료 예약 수정
const onUpdate = async () => {
    if(!confirm('진료 예약을 수정하시겠습니까?')){ return; }
    try{
        const doctorid = document.querySelector('#doctorSelect').value;
        const appointmentdate = document.querySelector('#dateInput').value;
        const appointmenttime = document.querySelector('#timeInput').value;
        const obj = { doctorid, appointmentdate, appointmenttime };

        const response = await axios.put( `/appointment?appointmentid=${appointmentid}` , obj );
        if( response.data ) { alert('진료 예약 수정 성공'); onCancle(); }
        else{ alert('진료 예약 수정 실패'); }
    }catch(e){ console.log(e); }
} // f end
