# Adopt a Pet!

We at Launch Academy are big fans of pets. There are many pets out there looking for a home. Your challenge is to build an app that allows good pets to find their ultimate destination! Wait... does this seem familiar? It should! This challenge will serve as an assessment of what you've learned throughout the program, with an emphasis on Spring. You will be taking your work from the Node Group Project and refactoring the Express backend to run on Spring! 

## Getting Started 

To get started, run the following commands:

```no-highlight
dropdb pets_development
createdb pets_development
cd challenges
et get java-spring-express-refactor
cd java-spring-express-refactor
./mvnw spring-boot:run
```

A completed React frontend has been provided for you for all "Meets Expectation" requirements, under `src/main/frontend`. It is a carbon copy of the final code for the entire Node Group Project, [_which can be found here on GitHub_][node-group-project-final-code]. You have also been provided with a `HomeController` which allows the React page to load up at both the root `/` path, and `/pets`. Navigate to <http://localhost:8080/pets> and at this point, you should simply see a React NavBar load up with two links: "All Pet Types" and "List a Pet for Adoption".

## Meeting Expectations

Your task will be to replace the former Express backend shown in the repository linked above with a Java Spring backend, and for the provided React code to work with no changes needed. Feel free to reference the final code for the Express backend (the repository for the full-stack Node app is again [linked here][node-group-project-final-code]), to see the existing Express backend, in order to know what your new replacement Spring backend will have to include.

**Note that you are expected to work on this project on your own, without pairing or working primarily with your peers. Staff will of course be available for any and all questions (including debugging questions, not just clarification and configuration!) over the Question Queue throughout the week.

The user stories from your original project must be satisfied, including any schema setup _and seeding of data_. The user stories can be found in the original [Node Group Project lesson][node-group-project-lesson]. We recommend tackling things in the same order as the original project.

* List of Pet Types
* Pets of a Given Type
* Display Pet Detail (Individual Pets)
* Apply to Adopt
* Add a Pet
* Only View Pets that are Available for Adoption

Unless otherwise specified:
- All data must be served from a Spring Rest Controller to a React Component
  - Make sure to create new migrations when creating or editing tables in your database
  - All entities should have validation at the model level as well as the database level where possible

**_HINT: For each user story you will need some or all of the following. Use your discernment to distinguish when you need a new Rest Controller, new methods on your Service, etc:_**

- Migration
- Entity
- Repository
- Service
- Rest Controller

## Exceeding Expectations

To Exceed Expectations, you will need to work through the Exceeds stories listed on the original Node Group Project. Note that this will also necessitate building out the related React frontend, as well.

[node-group-project-final-code]: https://github.com/LaunchAcademy/node-group-project-final
[node-group-project-lesson]: https://learn.launchacademy.com/lessons/node-group-project