# QuickQueue

### Shop Faster Shop Smarter Shop Safer ###

# About This Project

QuickQueue envision's a one-stop shop for all your consumer goods needs. In our current pandemic climate our goal was to build a functional, and practical store that links customers to shoppers and facilitates safe handoffs for all our vital needs. How we aimed to achieve this was simple, we wanted to build a light and snappy SPA(single-page application) that can communicate quickly and efficiently with our back-end and RDS(relational database). We want all our users (whether they're shoppers or customers) to have a refined, responsive, and snappy experience that would encourage them to return.

# How It All Works

Our application utilizes a storefront API which communicates using RESTful conventions with our backend, which is hosted on AWS's (Amazon Web Services) EC2 servers. In turn - our backend utilizes Hibernate and STS (Spring Tool Suite) to communicate with a PostgreSQL RDS we also host on AWS.

All this comes together in our frontend which is built using React. Our two distinct API's meet here and communicate through standard HTTP protocols. We encrypt all our users logins as well as ensure all endpoints are distinct and cannot be compromised. 

# Technologies Used

 ### Back-End ###
 QuickQueue's back-end is a Java built application also utilizing:
  - Maven
  - Spring Tool Suite (Spring MVC)
  - Hibernate and JPA (Java Persistence API)
  
 ### Front-End ###
 On the Frontend we used React with:
  - React Hooks
  - Axios
  - Typescript
  - Material UI
  
 ### Additional Technology
 In addition we made use of:
  - AWS RDS and EC2 hosting
  - Docker
  - Git and GitHub
  - Node JS and NPM (Node Package Manager)

# Usage

To utilize the application simply visit our live-hosted endpoint at: http://ec2-18-218-116-207.us-east-2.compute.amazonaws.com/login

Additionally you may clone the front-end repository. Once done, run an 'npm install' in your terminal to locally install all dependencies. Once your dependencies are installed you can execute 'npm start' to launch QuickQueue as a locally hosted React app.

# Contributors

Application designed, coded, and implemented by Aleks Nikolic @aleksdoesit, Kelvin Trih, and Colin Shaw.


