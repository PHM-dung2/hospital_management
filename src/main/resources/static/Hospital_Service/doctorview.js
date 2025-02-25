console.log( 'doctorview.js open' );

// 0. doctorid 가져오기
    const doctorid = new URLSearchParams( window.location.search ).get( 'doctorid' );

// 1. input값 입력
const findInput = async () => {
    const nameInput = document.querySelector( '#nameInput' );
    const specialtyInput = document.querySelector( '#specialtyInput' );
    const phoneInput = document.querySelector( '#phoneInput' );
    const createdatInput = document.querySelector( '#createdatInput' );

    const response = await axios.get( `/doctor/view?doctorid=${doctorid}` );
    console.log( response.data.name);
    nameInput.value = response.data.name;
    specialtyInput.value = response.data.specialty;
    phoneInput.value = response.data.phone;
    createdatInput.value = response.data.createdat;

} // f end
findInput();

// 2. 수정 페이지 출력
const onUpdateLink = () => {
    location.href = `/hospital_service/doctorupdate.html?doctorid=${doctorid}`;
} // f end

// 3. 환자 삭제
const onDelete = async () => {
    if( !confirm( '의사를 정말 삭제하시겠습니까?' ) ){ return; }

    try{
        const response = await axios.delete( `/doctor?doctorid=${doctorid}` );
        if( response.data ){ alert( '의사 삭제 완료' ); location.href = '/hospital_service/doctor.html'; }
        else{ alert( '의사 삭제 실패' ) }
    }catch(e){ console.log( e );  }
} // f end