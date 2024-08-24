const express = require('express');
const jwt = require('jsonwebtoken');

const app = express();

const verifyToken = (req, res, next) => {
  const token = req.headers.authorization;

  if (!token) {
    return res.status(401).json({ message: 'No token.' });
  }

  jwt.verify(token, 'strongSecret', (error, decoded) => {
    if (error) {
      return res.status(403).json({ message: 'Auth Failed.' });
    }
    req.user = decoded;
    next();
  });
};

app.get('/protected', verifyToken, (req, res) => {
  res.json({ message: "Protected route accessed successfully." });
});

app.listen(3000, () => {
  console.log('Server running on port 3000');
});