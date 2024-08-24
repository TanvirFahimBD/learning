const { MongoClient, ServerApiVersion } = require("mongodb");
require("dotenv").config();

const uri = `mongodb+srv://${process.env.DB_USER}:${process.env.DB_PASS}@cluster0.kgjk6dy.mongodb.net/?retryWrites=true&w=majority`;

const client = new MongoClient(uri, {
  serverApi: {
    version: ServerApiVersion.v1,
    strict: true,
    deprecationErrors: true,
  },
});

async function run(req, res) {
  try {
    await client.connect();
    const newsCollection = client.db("news_portal").collection("news");

    if (req.method === "GET") {
      const news = await newsCollection.find({}).toArray();
      res.send({ message: "success", status: 200, data: news });
    }

    if (req.method === "POST") {
      const newsInfo = req.body;
      const insertInfo = await newsCollection.insertOne(newsInfo);
      res.send({ message: "success", status: 200, result: insertInfo });
    }

    console.log("db connection successful");
  } finally {
    // await client.close();
  }
}
export default run;
