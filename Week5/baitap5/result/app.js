const express = require('express');
const { Client } = require('pg');

const app = express();
const port = 5001;

const client = new Client({
  host: 'postgres',
  port: 5432,
  user: 'postgres',
  password: 'password',
  database: 'votes'
});

client.connect();

app.get('/', async (req, res) => {
  try {
    const result = await client.query('SELECT * FROM votes');
    res.json(result.rows);
  } catch (err) {
    res.status(500).send(err.message);
  }
});

app.listen(port, () => {
  console.log(`Result app listening at http://localhost:${port}`);
});