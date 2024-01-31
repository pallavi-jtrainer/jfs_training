function addValue(value){
    document.getElementById('display').value += value; 
}
function clearValue(){
    document.getElementById('display').value = " ";
}
function calculateValue(){
    try{
        document.getElementById('display').value = eval(document.getElementById('display').value);
    }catch(error){
        document.getElementById('display').value = "Error";
    }
}
