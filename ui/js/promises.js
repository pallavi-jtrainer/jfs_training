// function getAllEmployees() {
//     return [
//         {
//             empId: 101, empName: 'Employee1'
//         },
//         {
//             empId: 102, empName: 'Employee2'
//         },
//         {
//             empId: 103, empName: 'Employee3'
//         }
//     ];
// }

// function getEmployeeById(id) {
//     const employees = getAllEmployees();
//     const employee = employees.find(emp => emp.empId === id);
//     return employee;
// }

function loadData(url) {
    return new Promise((resolve, reject) => {
        const req = new XMLHttpRequest();
        req.setRequestHeader("Access-Control-Allow-Origin", "*");
        req.setRequestHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        res.setHeader("Access-Control-Allow-Headers", "Content-Type");
        req.open('GET', url);

        req.onload = () => {
            if(req.status >= 200) {
                resolve(req.response);
            } else {
                reject(req.response);
            }
        }
        // req.onreadystatechange = () => {
        //     if(req.readyState == 4 || req.status == 200) {
        //         resolve(req.response);
        //     } else {
        //         reject(req.status);
        //     }
        // };
        // req.open('GET', url, true);
        req.send();
    });
}

const url = 'https://www.javascripttutorial.net/sample/promise/api.json';
const btnRequest = document.querySelector('#btnRequest');
const res = document.querySelector('#result');

btnRequest.addEventListener('click', () => {
    loadData(url)
    .then((response) => {
        const json = JSON.parse(response);
        res.innerHTML = json.message;
    })
    .catch(err => {res.innerHTML = `Error getting data, Http Status: ${err.status}`;
    });
});

