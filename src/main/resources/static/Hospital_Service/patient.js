console.log( "patient.js open" );

// 1. 환자 등록
const onWrite = async () => {
    if( !confirm('환자를 등록하시곘습니까?')){ return; }
    try{
        const nameInput = document.querySelector( '#nameInput' );
        const birthdateInput = document.querySelector( '#birthdateInput' );
        const phoneInput = document.querySelector( '#phoneInput' );
        const addressInput = document.querySelector( '#addressInput' );

        const name = nameInput.value;
        const birthdate = birthdateInput.value;
        const phone = phoneInput.value;
        const address = addressInput.value;

        obj = { name, birthdate, phone, address };
        const response = await axios.post( '/patient' , obj )
        if( response.data ) { alert('환자 등록 성공'); findAll(); }
        else{ alert('환자 등록 실패'); }
    }catch(e){ console.log(e); }
} // f end

// 2. 환자 목록 출력
const findAll = async () => {
    try{
        const response = await axios.get( '/patient' );
        let html = '';
        response.data.forEach( patient => {
            const tbody = document.querySelector( 'tbody' );
            html += `<tr onclick="location.href='patientview.html?patientid=${patient.patientid}'" >
                         <th scope="row"> ${ patient.patientid } </th>
                         <td> ${ patient.name } </td>
                         <td> ${ patient.address } </td>
                     </tr>`;
            tbody.innerHTML = html;
        }) // for end
    }catch(e){ console.log(e); }
} // f end
findAll();