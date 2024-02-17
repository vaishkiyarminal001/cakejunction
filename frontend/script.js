// Function to fetch data from the API
function fetchDataAndDisplay() {
    fetch('https://cakejunction-production.up.railway.app/data/getAllData')
        .then(response => response.json())
        .then(data => {
            
            console.log(data);
            document.querySelector('#user-cards').innerHTML = '';

            // Loop through the data and add cards to the container
            data.forEach(item => {
                var card = document.createElement('div');
                card.classList.add('card');
                card.innerHTML = `
                    <div class="card-body">
                        <h5 class="card-title">${item.name}</h5>
                        <p class="card-text">${item.description}</p>
                        <img src="${item.imageUrl}" alt="${item.name}" class="card-image">
                        <button onclick="deleteData(${item.id})">Delete</button>
                        <button onclick="showUpdateForm(${item.id})">Update</button>
                    </div>
                `;
                document.querySelector('#user-cards').appendChild(card);
            });
        })
        .catch(error => console.error('Error fetching data:', error));
}

// Calling function
fetchDataAndDisplay();

// Function to add new data
function addData() {
    var name = document.getElementById('name').value;
    var description = document.getElementById('description').value;
    var imageUrl = document.getElementById('image-url').value;
    console.log(imageUrl);
    console.log("Hi");

    fetch('https://cakejunction-production.up.railway.app/data/registerData', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            name: name,
            description: description,
            imageUrl: imageUrl
        })
    })
    .then(response => response.json())
    .then(data => {
        fetchDataAndDisplay();
        document.getElementById('name').value = '';
        document.getElementById('description').value = '';
        document.getElementById('image-url').value = '';
    })
    .catch(error => console.error('Error adding data:', error));
}

// Function to delete data
function deleteData(id) {
    fetch('https://cakejunction-production.up.railway.app/data/deleteData/' + id, {
        method: 'DELETE'
    })
    .then(response => {
        if (response.ok) {
            fetchDataAndDisplay();
        } else {
            console.error('Error deleting data:', response.statusText);
        }
    })
    .catch(error => console.error('Error deleting data:', error));
}

// Function to show update form
function showUpdateForm(id) {
    var updateForm = document.getElementById('update-form');
    var updateNameInput = document.getElementById('update-name');
    var updateDescriptionInput = document.getElementById('update-description');
    var updateImageUrlInput = document.getElementById('update-image-url');
    var updateButton = document.getElementById('update-button');

    updateForm.style.display = 'block';

    updateButton.onclick = function() {
        var newName = updateNameInput.value;
        var newDescription = updateDescriptionInput.value;
        var newImageUrl = updateImageUrlInput.value;

        fetch('https://cakejunction-production.up.railway.app/data/updateData/' + id, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                name: newName,
                description: newDescription,
                imageUrl: newImageUrl
            })
        })
        .then(response => response.json())
        .then(data => {
            fetchDataAndDisplay();
            closeModal();
        })
        .catch(error => console.error('Error updating data:', error));
    };
}

function closeModal() {
    var modal = document.getElementById('update-form');
    modal.style.display = 'none';
}

document.getElementById('add-form').addEventListener('submit', function(event) {
    event.preventDefault(); 
    addData();
});
