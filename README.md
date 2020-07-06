<div align="center" id="top">
	<br>
	<br>
	<br>
	<img width="500" height="350" src="https://raw.githubusercontent.com/mani1soni/jenkins-shared-library/master/logo/jenkins.jpeg" >
	<br>
	<br>
	<br>
        
# jenkins-shared-library

[![PRs Welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg)](http://makeapullrequest.com) [![License](https://img.shields.io/badge/license-GPL-green.svg)](LICENSE)

This is open source jenkins shared library repository. This repository contains groovy functions, anyone can call them in their groovy scripts. 
</div>


## Tutorial

* Make a Jenkinsfile in your own github repository
* Fork this repo
* Call groovy function like following example-->
    ```
    library identifier: 'general_node-app_template@', retriever: modernSCM(
    [$class: 'GitSCMSource',
     remote: 'Forked Repo URL',
     credentialsId: 'YOUR-Credentials'])
    
     general_node-app_template()

     ```


## Contributions 

#### Contribution steps

* Create a new branch in your forked repository and then start working
* Include a proper commit message in your commits
* Always rebase with `master:mani1soni/jenkins-shared-library` to avoid merge conflicts whenever you start to work
* Include proper PR message while giving pull request
* Try to keep pull requests small to minimize merge conflicts

#### Getting Started

* Fork this repo (button on top)
* Clone on your local machine
    ```
        $ git clone https://github.com/mani1soni/jenkins-shared-library
    ```
* Change to `jenkins-shared-library` directory
    ```
        $ cd jenkins-shared-library
    ```
* Create a new branch
    ```
        $ git checkout -b my-new-branch
    ```
* Add your contribution
* Commit and push
    ```
        $ git add .
    ```
    ```
        $ git commit -m "your-commit-msg"
    ```
    ```
        $ git push origin my-new-branch
    ```
* Create a new pull request from your forked repository to `master` branch of `mani1soni/jenkins-shared-library`

:tada: :confetti_ball: :smiley: _**Happy Contributing**_ :smiley: :confetti_ball: :tada:

## For more details visit:-
* [shared-libraries](https://www.jenkins.io/doc/book/pipeline/shared-libraries/)

## Technologie used 
* [groovy](https://groovy-lang.org/)

## Maintainers

| <img alt="Manish Soni" src="https://avatars3.githubusercontent.com/u/30206849?s=460&v=4" height="70"   />                                                                                                                  |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| [Manish Soni](https://mani1soni.github.io/)<br><strong>Twitter</strong>: [@manisomanish](https://twitter.com/manisomanish)<br><strong>Github</strong>: [@mani1soni](https://github.com/mani1soni)<br> <strong>Linkedin<strong>: [@manisomanish](https://www.linkedin.com/in/manisomanish/)<br> _DevOps Engineer_ |





## License
[GPL-3.0](LICENSE)
