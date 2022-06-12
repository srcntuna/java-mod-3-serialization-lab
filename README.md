# Serialization Lab

## Learning Goals

- Serialize objects in Java

## Instructions

Using the code in the previous lesson as a baseline, create a version of our
previous person information gathering program that saves each person object to
its own file, using the first name of the person as the file name, then give the
user the option to restore a person from their serialized copy, just so you can
see your own output on the console.

Hints:

- You could add a call to the `serializedPerson()` method in your input loop
  after your get the Person's information from the user
- Be mindful of your exception handling, as calling methods that can throw
  exceptions means you need to catch them or let them bubble up to the caller
- You can add a transient variable to your `Person` class to see that its value
  is not restored when an instance is deserialized
