# dev-test-courrieros
### Description
This repository was made for a development test.

### Challenge
[Challenge URL](https://github.com/courrieros/dev-test)

### What was made
I created two solutions for the problem.
- An Android application that loads a static `csv` file embedded in the project and displays a list of Total CO² per company, grouping it by company name.
- A Node application that have basically two entries
  - A job that loads a `csv` file, do all the data proccessing as grouping it and summing the CO², and stores it into a MongoDB.
  - The second entry basically is a `HTTP GET` that loads the data from the first file and returns a formatted JSON. 

### How to test

#### Android
- Install the `Android Build Tools` and `API 27`
- Install `Java8`
- Go to the folder `android` via terminal
- With an emulator or a physical device connected type `./gradlew install`

#### Node
- Install `node` and `npm`.
- You need an instance of `MongoDB` running in the default port `27017`.
- Go to the `node` folder.
- Run `npm install` to download the required dependencies.
- Run `node jobs/import-client-jobs.js` to populate the Database.
- Run `node server/server.js` to start the Express instance.
- Run `curl -v http://localhost:3000/client/total` to display the resulting JSON.

### TODO
Host the `node` endpoint into some cloud similar to Heroku, and request the Data from the Android app via HTTP.


