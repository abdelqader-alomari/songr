# Procedure

- Create hello route "/hello", and ensure that you can visit that route in your browser and see a rendered page

- Create a route that turns words into UPPER CASE.

- Create a home page for the Songr app, available at the root route

- Create an Album class to act as a model in our app. An Album has a title, an artist, a songCount, a length (in seconds), and an imageUrl that is a link to that album’s art.

- Create a route at /albums that shows three album instances. to show (Album with title, artist,# of songs, length seconds)

## Run the app:

- git clone the app from the link or download it as compressed folder and extract it and open it using IntelliJ IDE
- Choose run and the app should run the port 8080(default) and you can see rendered content according to end point.
- I modify my app and run into port 8082

## Test the app:

You can test the app from IntelliJ by navigate to MainTest and run the test.

# lab 12

Update Album model so that it can be saved in a database. An Album has a title, an artist, a songCount, a length (in seconds), and an imageUrl that is a link to that album’s art. A user should be able to see information about all the albums on the site. A user should be able to add albums to the site.

## Test

gradle bootRun command test is ok and work properly

# Lab 13

Create a Song model. A Song has a title, a length (in seconds), a trackNumber, and the album on which that song appears. Ensure that the relationship between Albums and Songs is appropriately set up. A user should be able to see information about all the songs on the site. A user should be able to view a page with data about one particular album. A user should be able to add songs to an album. A user should be able to see the songs that belong to an album when looking at that album.

