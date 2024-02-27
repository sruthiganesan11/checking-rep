// Function to submit product form
document.getElementById("btnAdd").addEventListener("click", function(event) {
    event.preventDefault();
    //Show the Product Add page
    // Redirect to a page within the same application
    redirectTo("product-add.html");
    

});

// Function to submit product form
document.getElementById("btnDisplay").addEventListener("click", function(event) {
    event.preventDefault();
    //Show the Product Display page
    redirectTo("product-display.html");
  
});

function redirectTo(url) {
    window.location.href = url;
}