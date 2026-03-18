const express = require('express');
const { MongoClient } = require('mongodb');

const app = express();
const port = 3000;

const url = 'mongodb://mongo:27017';
const client = new MongoClient(url);

app.get('/', async (req, res) => {
  try {
    await client.connect();
    const db = client.db('test');
    const collection = db.collection('documents');
    const result = await collection.findOne({});
    res.send('Hello from Node.js + MongoDB! ' + JSON.stringify(result));
  } catch (err) {
    res.send('Error: ' + err.message);
  }
});

app.listen(port, () => {
  console.log(`App listening at http://localhost:${port}`);
});