const simulator = () => {
    let url = window.origin + '/tanksimulator/rest/level/generator';
    fetch(url, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        })
        .then(response => response.json())
        .then(resp => {
            let display = '<table class="table">';
            let diplayHeader = '<thead><tr><th class="text-center">Tank Name</th><th class="text-center">Level</th></tr></thead>';
            let diplayval = '<tbody>';
            let keys = Object.keys(resp);
            keys.map(k => {
                diplayval += '<tr><td align="center">' + k + '</td><td align="center">' + resp[k] + '</td></tr>';
            });
            diplayval += '</tbody>'; 
            display += diplayHeader;
            display += diplayval;
            display += '</table>';
            document.getElementById('data').innerHTML = display;
        })
        .catch(error => console.log('Error in loading api: ', error))
}

setTimeout(function() {
    window.location.reload(1);
}, 30000);