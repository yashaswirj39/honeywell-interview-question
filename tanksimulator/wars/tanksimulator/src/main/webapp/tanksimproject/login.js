const sendLoginReq = () => {
    let user = $('#username').val(); //document.getElementById('username');
    let pass = $('#userpassword').val();

    console.log(user + " ------> " + pass);

    var data = { "userName": user, "password": pass};
    var url = window.origin + '/tanksimulator/rest/auth/loginauth';
    fetch(url, {
        method: 'POST', // or 'PUT'
        body: JSON.stringify(data), // data can be `string` or {object}!
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => response.json())
    .then(resp => {
        //let ele = '<a href="tanksim.html" />';
        //document.getElementById('ref').innerHTML = ele;
        console.log("resp ----> " + resp);
        if(resp.status === "success") {
            console.log("success");
        } else if (resp.status === "failed") {
            alert("Invalid Username/Password");
        }
    })
    .catch(error => console.log('Error in loading api: ', error))
}