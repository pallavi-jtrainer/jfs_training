//1. geolocation
function getGeolocation() {
    if(navigator.geolocation) { 
        navigator.geolocation.getCurrentPosition(
            function(position) {
                var lat = position.coords.latitude;
                var lon = position.coords.longitude;

                var positionInfo = "Position: (Latitude: " + lat +
                    ", Longitude: " + lon + ")";
                
                document.getElementById("result").innerHTML = positionInfo;
            }
        );
    } else {
        alert("Your browser does not support Geolocation");
    }
}

//2. Offline AppCache

//3. Web storage
//1. localStorage
//2. sessionStorage

function useStorage() {
    // localStorage.setItem("username", "user@ssh.com");
    // localStorage.setItem("password", "pass123");
    sessionStorage.setItem("username", "user@ssh.com");
    sessionStorage.setItem("password", "pass123");
}

function showStorage() {
    // let user = localStorage.getItem("username");
    // let pass = localStorage.getItem("password");

    let user = sessionStorage.getItem("username");
    let pass = sessionStorage.getItem("password");

    alert("User: " + user + " Password: " + pass);
}


















