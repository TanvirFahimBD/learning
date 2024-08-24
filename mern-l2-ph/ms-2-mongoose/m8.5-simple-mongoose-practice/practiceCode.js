//? Task 1: Find all users who are located in New York.
//db.personsAll.find({"address.city": "New York"})

//? Task 2: Find the user(s) with the email "johndoe@example.com" and retrieve their favorite movie.
//db.personsAll.find({ "email": "johndoe@example.com" }, { "favorites.movie": 1 })

//? Task 3: Find all users with "pizza" as their favorite food and sort them according to age.
// db.personsAll.find({ "favorites.food": "pizza" })
//     .project({ "favorites.food": 1, age: 1 })
//     .sort({ age: -1 })

//? Task 4: Find all users over 30 whose favorite color is "green".
// db.personsAll
//   .find({
//     $and: [{ age: { $gt: 30 } }, { "favorites.color": "green" }],
//   })
//   .project({ "favorites.color": 1, age: 1 })
//   .sort({ age: -1 });

//? Task 5: Count the number of users whose favorite movie is "The Shawshank Redemption."
// db.personsAll.countDocuments({ "favorites.movie": "The Shawshank Redemption" });

//? Task 6: Update the zipcode of the user with the email "johndoe@example.com" to "10002".
// db.personsAll.updateOne(
//   { email: "johndoe@example.com" },
//   { $set: { "address.zipcode": "10002" } }
// );

//? Task 7: Delete the user with the email "alicewilliams@example.com" from the user data.
// db.personsAll.deleteOne({ email: "alicewilliams@example.com" });

//? Task 8: Group users by their favorite movie and retrieve the average age in each movie group.
// db.personsAll.aggregate([
//   {
//     $group: {
//       _id: "$favorites.movie",
//       averAge: { $avg: "$age" },
//     },
//   },
// ]);

//? Task 9: Calculate the average age of users with a favorite " pizza " food.
// db.personsAll.aggregate([
//   { $match: { "favorites.food": "pizza" } },
//   { $group: { _id: null, avgAge: { $avg: "$age" } } },
// ]);

//? Task 10: Perform a lookup aggregation to retrieve the orders data along with the customer details for each order.
// db.ordersPractice.aggregate([
//   {
//     $lookup: {
//       from: "customersPractice",
//       localField: "customer_id",
//       foreignField: "_id",
//       as: "customerDetails",
//     },
//   },
// ]);

//! More Tasks on Aggregation
//? Task 1: Group users by their favorite color and retrieve the count of users in each color group.
// db.personsAll.aggregate([
//   {
//     $group: {
//       _id: "$favorites.color",
//       persons: { $sum: 1 },
//     },
//   },
//   {
//     $project: {
//       _id: 0,
//       color: "$_id",
//       persons: 1,
//     },
//   },
// ]);

//? Task 2: Find the user(s) with the highest age.
// db.personsAll.aggregate([
//   {
//     $project: {
//       age: 1,
//     },
//   },
//   { $sort: { age: -1 } },
//   { $limit: 1 },
// ]);

//? Task 3: Find the most common favorite food among all users.
// db.personsAll.aggregate([
//   { $group: { _id: "$favorites.food", personsFavCount: { $sum: 1 } } },
//   { $sort: { personsFavCount: -1 } },
//   { $project: { _id: 0, food: "$_id" } },
//   { $limit: 1 },
// ]);

//? Task 4: Calculate the total count of friends across all users.
// db.personsAll.aggregate([
//   {
//     $group: {
//       _id: null,
//       totalFriends: { $sum: { $size: "$friends" } },
//     },
//   },
// ]);

//? Task 5: Find the user(s) with the longest name.
// db.personsAll.aggregate([
//   {
//     $project: {
//       name: 1,
//       nameLength: { $strLenCP: "$name" },
//     },
//   },
//   { $sort: { name: 1 } },
//   { $limit: 1 },
// ]);

//? Task 6: Calculate each state's total number of users in the address field.
// db.personsAll.aggregate([
//   { $group: { _id: "$address.state", users: { $sum: 1 } } },
//   { $group: { _id: null, totalUsers: { $sum: "$users" } } },
// ]);

//? Task 7: Find the user(s) with the highest number of friends.
// db.personAll.aggregate([
//   {
//     $group: {
//       _id: "$friends",
//       friendsNum: { $sum: { $size: "$friends" } },
//     },
//   },
//   { $project: { friendsNum: 1, _id: 0 } },
//   { $sort: { friendsNum: -1 } },
//   { $limit: 1 },
// ]);

//! These tasks involve using various aggregation operators such as $group, $avg, $max, $sum, and $project to perform complex calculations and data transformations. You can write MongoDB aggregation queries to accomplish each task based on user data. Adjust the queries according to your specific implementation and requirements.
