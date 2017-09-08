personRefresh();

document.getElementById("refresh").addEventListener("click", function() {
    personRefresh();
})

function personRefresh() {
    fetch("api/person/all", {method: "get"})
            .then(function (response) {
                return response.json();
    })
            .then(function (json) {
                document.getElementById("tablePersonsBody").innerHTML = "";
        
        var rows = "";
        
        for (var i in json)
        {
            rows += '<tr>';
                    rows += '<td>' + json[i].idpersons + '</td>';
                    rows += '<td>' + json[i].firstname + '</td>';
                    rows += '<td>' + json[i].lastname + '</td>';
                    rows += '<td>' + json[i].phonenr + '</td>';
        }
        
        document.getElementById("tablePersonsBody").innerHTML = rows;
    })
            .catch(function  (error) {
        alert("unable to refresh!");
    });
}