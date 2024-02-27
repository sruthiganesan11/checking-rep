$(document).ready(function () {
    const URL = "http://localhost:8081/product";
    //Sent HTTP Get request
    getRequest(URL);
    //log the data
    //populate the data
});

async function getRequest(url) {
    try {
        const response = await fetch(url, {
            method: 'GET',
            headers: {
                "Content-Type": "application/json",
            }
        });

        const result = await response.json();
        console.log("Success:", result);
        populateTableData(result);

    } catch (error) {
        console.log("Error:", error);
    }
}

function populateTableData(data) {
    //javascript array -> table data populate

}