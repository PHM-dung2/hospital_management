console.log( 'patientupdate.js open' );

// 0. 취소 버튼
const onCancle = () => {
    location.href = `/hospital_service/patientview.html?patientid=${patientid}`;
} // f end

// 1. 환자 수정
const onUpdate = async () => {
    if( !confirm( '환자를 정말 수정하시겠습니까?' ) ){ return; }

    try{
        const birthdate = document.querySelector('#birthdateInput').value;
        const phone = document.querySelector( '#phoneInput' ).value;
        const address = document.querySelector( '#addressInput' ).value;
        const obj = { birthdate, phone, address };

        const response = await axios.put( `/patient?patientid=${patientid}` , obj )
        if( response.data ){ alert( '환자 수정 성공' ); onCancle(); }
        else{ alert( '환자 수정 실패' ); onCancle(); }
    }catch(e){ console.log(e); }

} // f end