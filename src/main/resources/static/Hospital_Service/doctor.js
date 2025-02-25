console.log( "doctor.js open" );

// 1. 의사 등록
const onWrite = async () => {
    if( !confirm('의사를 등록하시곘습니까?')){ return; }
    try{
        const nameInput = document.querySelector( '#nameInput' );
        const specialtyInput = document.querySelector( '#specialtyInput' );
        const phoneInput = document.querySelector( '#phoneInput' );

        const name = nameInput.value;
        const specialty = specialtyInput.value;
        const phone = phoneInput.value;

        const obj = { name, specialty, phone };
        const response = await axios.post( '/doctor' , obj )
        if( response.data ) { alert('의사 등록 성공'); findAll(); }
        else{ alert('의사 등록 실패'); }
    }catch(e){ console.log(e); }
} // f end

// 2. 환자 목록 출력
const findAll = async () => {
    try{
        const response = await axios.get( '/doctor' );
        let html = '';
        response.data.forEach( doctor => {
            const tbody = document.querySelector( 'tbody' );
            html += `<tr onclick="location.href='doctorview.html?doctorid=${doctor.doctorid}'" >
                         <th scope="row"> ${ doctor.doctorid } </th>
                         <td> ${ doctor.name } </td>
                         <td> ${ doctor.specialty } </td>
                     </tr>`;
            tbody.innerHTML = html;
        }) // for end
    }catch(e){ console.log(e); }
} // f end
findAll();