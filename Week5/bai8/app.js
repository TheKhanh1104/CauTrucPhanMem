const express = require('express');
const mysql = require('mysql');
const app = express();
const port = 3000;

const connection = mysql.createConnection({
  host: 'mysql',
  user: 'user',
  password: 'password',
  database: 'mydb'
});

connection.connect((err) => {
  if (err) {
    console.error('Error connecting to MySQL:', err);
    return;
  }
  console.log('Connected to MySQL');
});

app.get('/', (req, res) => {
  connection.query('SELECT 1 + 1 AS solution', (err, results) => {
    if (err) {
      res.send('Error querying database');
    } else {
      res.send('Hello World from Node.js! MySQL result: ' + results[0].solution);
    }
  });
});

app.listen(port, () => {
  console.log(`App listening at http://localhost:${port}`);
});