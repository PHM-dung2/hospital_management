console.log( 'patientview.js open' );

// 0. patientid 가져오기
    const patientid = new URLSearchParams( window.location.search ).get( 'patientid' );

// 1. input값 입력
const findInput = async () => {
    const nameInput = document.querySelector( '#nameInput' );
    const birthdateInput = document.querySelector( '#birthdateInput' );
    const phoneInput = document.querySelector( '#phoneInput' );
    const addressInput = document.querySelector( '#addressInput' );
    const createdatInput = document.querySelector( '#createdatInput' );

    const response = await axios.get( `/patient/view?patientid=${patientid}` );
    console.log( response.data.name);
    nameInput.value = response.data.name;
    birthdateInput.value = response.data.birthdate;
    phoneInput.value = response.data.phone;
    addressInput.value = response.data.address;
    createdatInput.value = response.data.createdat;

} // f end
findInput();

// 2. 수정 페이지 출력
const onUpdateLink = () => {
    location.href = `/hospital_service/patientupdate.html?patientid=${patientid}`;
} // f end

// 3. 환자 삭제
const onDelete = async () => {
    if( !confirm( '환자를 정말 삭제하시겠습니까?' ) ){ return; }

    try{
        const response = await axios.delete( `/patient?patientid=${patientid}` );
        if( response.data ){ alert( '환자 삭제 완료' ); location.href = '/hospital_service/patient.html'; }
        else{ alert( '환자 삭제 실패' ) }
    }catch(e){ console.log( e );  }
} // f end