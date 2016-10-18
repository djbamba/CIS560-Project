$(document).ready(()=>{
    var search = $('#search-button');
    search.on('click', (event) => {
        event.preventDefault();
        console.log("It works");
    });
});
