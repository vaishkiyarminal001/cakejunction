# CakeJunction 🍰
This is a simple CRUD (Create, Read, Update, Delete) website that allows users to manage data. The website is built using HTML, CSS, and JavaScript, and it interacts with a backend API to perform CRUD operations.<br>

<img align="right" alt="Coding" width="100%" src="/1.png"><br>

## Features
📝 Add Data: Users can add new data by providing a name, description, and image URL.
👀 Get Data: Users can view all the data in a card format.
✏️ Update Data: Users can update existing data by providing a new name, description, and image URL.
❌ Delete Data: Users can delete existing data.

## Technologies Used
🖥️ Frontend: HTML, CSS, JavaScript
🔙 Backend: Java, Spring Boot
💾 Database: MySQL

## API Endpoints
📡 GET /data/getAllData: Get all data.
🔍 GET /data/getDataById/{id}: Get data by ID.
📤 POST /data/registerData: Add new data.
🔄 PUT /data/updateData/{id}: Update data by ID.
🗑️ DELETE /data/deleteData/{id}: Delete data by ID.