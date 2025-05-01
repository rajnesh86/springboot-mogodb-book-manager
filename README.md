**Step-by-Step: MongoDB with Docker & MongoDB Compass**
**    Step 1: Run MongoDB Container**
          docker run -d \
        --name mongodb \
        -p 27017:27017 \
        -e MONGO_INITDB_ROOT_USERNAME=admin \
        -e MONGO_INITDB_ROOT_PASSWORD=password \
        mongo
        
**This command:**
Runs MongoDB in a container named mongodb
Sets up credentials: username admin, password password
Maps port 27017 so Compass can access it from your host

**    Step 2: Install MongoDB Compass**
Download and install MongoDB Compass from the official website:
👉 https://www.mongodb.com/try/download/compass

**    Step 3: Connect Using MongoDB Compass**
  Open MongoDB Compass
  Click "New Connection."
  **Enter this connection string:** mongodb://admin:password@localhost:27017
  Click "Connect."

**API for Testing**
**Post** : http://localhost:8080/books
          {
    "title": "Effective Java",
    "isbn": "3334445556",
    "price": 54.95,
    "author": {
        "name": "Joshua Bloch",
        "publisher": {
            "name": "Addison-Wesley",
            "address": {
                "street": "75 Arlington St",
                "city": "Boston",
                "zipcode": "02116",
                "country": {
                    "name": "USA",
                    "code": "US",
                    "continent": {
                        "name": "North America",
                        "hemisphere": "Western"
                    }
                }
            }
        }
    }
}


