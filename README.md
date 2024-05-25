
## ![TECH_STACK](https://img.shields.io/badge/BlossomCare-%231572B6.svg?style=for-the-badge)

REST API for an Online Plant Nursery Platform that allows customers to view the list of plants, seeds, and planters. 
The application also includes user and admin validation and authentication.

## ![TECH_STACK](https://img.shields.io/badge/Tech_Stack-%231572B6.svg?style=for-the-badge)

- JAVA
- SPRING
- SPRINGBOOT
- HIBERNATE
- MAVEN
- MYSQL
- HTML
- CSS
- JAVASCRIPT

## ![TECH_STACK](https://img.shields.io/badge/Dependencies-%231572B6.svg?style=for-the-badge)

- SPRING DATA JPA
- SPRING WEB
- HIBERNATE
- MYSQL DRIVER
- LOMBOK
- Log4j

## ![TECH_STACK](https://img.shields.io/badge/Run_Locally-%231572B6.svg?style=for-the-badge)

Note:minikube installation required on local machine

- Clone the github repositiory.

- Update the ansible hostname in "inventory".

- Create a new github repository.

- Update the repository name in the "jenkinsfile".

- Update the docker image names, add your github username in the image name.

- Push the changes to the github repository.

- Create jenkins pipeline project and add your git repository to access pipline script.

- Add dockerhub credentials and github token and execute the jenkins pipeline.
 
- Once pipeline execution is successful, execute the shell script "application_setup.sh" in the project main folder.

- You will be able to access the project at "http://192.168.49.2:30080"
