console.log( "appointment.js open" );

// 4. 진료 예약 목록 출력
const findAll = async () => {
    try{
        const response = await axios.get( '/appointment' );
        let html = '';
        response.data.forEach( appointment => {
            const tbody = document.querySelector( 'tbody' );
            html += `<tr>
                         <th scope="row"> ${ appointment.appointmentid } </th>
                         <td> ${ appointment.pname } </td>
                         <td> ${ appointment.dname } </td>
                         <td> ${ appointment.appointmentdate } </td>
                         <td> ${ appointment.appointmenttime } </td>
                         <td>
                            <button onclick-"" type="button" class="btn btn-success"> 수정 </button>
                            <button onclick="" type="button" class="btn btn-success"> 삭제 </button>
                         </td>
                     </tr>`;
            tbody.innerHTML = html;
        }) // for end
    }catch(e){ console.log(e); }
} // f end
findAll();