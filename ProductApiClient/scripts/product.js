// Function to submit product form
document.getElementById("productForm").addEventListener("submit", function(event) {
    event.preventDefault();
    addProduct();    
});




  async function postRequest(data, url,requestType) {
    try {
      const response = await fetch(url, {
        method: requestType, // or 'PUT'
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(data),
      });
  
      const result = await response.json();
      console.log("Success:", result);
    } catch (error) {
      console.log("Error:", error);
    }
  }


 
  
// Function to add product
function addProduct() {
    const productName = document.getElementById("productName").value;
    const productPrice = document.getElementById("productPrice").value;
    const productCategory = document.getElementById("productCategory").value;

    
    const URL = 'http://localhost:8081/product';
    const data = {
        name: productName,
        price: productPrice,
        category: productCategory
    }
    console.log("add-product - send request to: " + URL + "with data" + JSON.stringify(data));
    postRequest(data, URL, "POST");
}
