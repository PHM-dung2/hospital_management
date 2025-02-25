console.log( 'doctorupdate.js open' );

// 0. 취소 버튼
const onCancle = () => {
    location.href = `/hospital_service/doctorview.html?doctorid=${doctorid}`;
} // f end

// 1. 환자 수정
const onUpdate = async () => {
    if( !confirm( '의사를 정말 수정하시겠습니까?' ) ){ return; }

    try{
        const specialty = document.querySelector('#specialtyInput').value;
        const phone = document.querySelector( '#phoneInput' ).value;
        const obj = { specialty, phone };

        const response = await axios.put( `/doctor?doctorid=${doctorid}` , obj )
        if( response.data ){ alert( '의사 수정 성공' ); onCancle(); }
        else{ alert( '의사 수정 실패' ); onCancle(); }
    }catch(e){ console.log(e); }

} // f end