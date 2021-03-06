Test Project Setup
==================
Here's how to create Chapter 2's `speakers-web-1`, `speakers-web-2`, and`speakers-web-3` projects with Yeoman.


## Contents
- [Install Yeoman](#install-yeoman)
- [Install the `generator-webapp` Yeoman Generator](#install-the-generator-webapp-yeoman-generator)
- [Generate The Web Application](#generate-the-web-application)
    - [Create the Project Directory](#create-the-project-directory)
    - [Create the Project](#create-the-project)
    - [Start The Web Application](#start-the-web-application)
    - [Shutdown The Web Application](#shutdown-the-web-application)
- [References](#references)


## Install Yeoman
To install Yeoman, do the following:
```
npm install -g yo
npm install -g gulp-cli
npm install -g bower
```


## Install the `generator-webapp` Yeoman Generator
Install the [`generator-webapp` Yeoman Generator](https://github.com/yeoman/generator-webapp) as follows:
```
npm install -g generator-webapp
```

You still need Grunt to run some of the gulp tasks:
```
npm install -g grunt-cli
```


## Generate The Web Application
We'll use the [`generator-webapp` Yeoman Generator](https://github.com/yeoman/generator-webapp) to create a simple web app.

### Create the Project Directory
First, find a suitable directory for your projects.
`cd ~/projects`

Next, create the `speakers-web-1` directory and navigate there:
```
mkdir speakers-web-1

cd speakers-web-1
```

Note: You'll follow the same steps for the `speakers-web-2` and`speakers-web-3` projects.

### Create the Project
Now, create your Yeoman project. Choose Bootstrap and leave out Sass and Modernizr.
After making that selection, then choose Bootstrap 4. Finally, choose "BDD" as your style of DSL (i.e., Mocha and Chai). Your CLI session should look like this:

```
yo webapp

json-at-work => yo webapp

     _-----_     ╭──────────────────────────╮
    |       |    │  'Allo 'allo! Out of the │
    |--(o)--|    │    box I include HTML5   │
   `---------´   │ Boilerplate, jQuery, and │
    ( _´U`_ )    │ a gulpfile to build your │
    /___A___\   /│           app.           │
     |  ~  |     ╰──────────────────────────╯
   __'.___.'__
 ´   `  |° ´ Y `

 ? Which additional features would you like to include?
  ◯ Sass
  ◉ Bootstrap
 ❯◯ Modernizr

...

? Which additional features would you like to include? Bootstrap
? Which version of Bootstrap would you like to include? Bootstrap 4
? Choose your style of DSL BDD
   create bower.json
   create package.json
   create gulpfile.js
   create .babelrc
   create .gitignore
   create .gitattributes
   create .bowerrc
   create .editorconfig
   create app/favicon.ico
   create app/apple-touch-icon.png
   create app/robots.txt
   create app/styles/main.css
   create app/scripts/main.js
   create app/index.html
   create test/spec/test.js
   create test/index.html


I'm all done. Running npm install && bower install for you to install the required dependencies. If this fails, try running the command yourself.

...


bootstrap#4.0.0-alpha.6 bower_components/bootstrap
├── jquery#3.2.0
└── tether#1.4.0

jquery#3.2.0 bower_components/jquery

tether#1.4.0 bower_components/tether
bower mocha#*                   cached https://github.com/mochajs/mocha.git#3.2.0
bower mocha#*                 validate 3.2.0 against https://github.com/mochajs/mocha.git#*
bower chai#*                    cached https://github.com/chaijs/chai.git#3.5.0
bower chai#*                  validate 3.5.0 against https://github.com/chaijs/chai.git#*
bower chai#^3.5.0              install chai#3.5.0
bower mocha#^3.2.0             install mocha#3.2.0

chai#3.5.0 bower_components/chai

mocha#3.2.0 bower_components/mocha

```

### Start The Web Application
To start the application, type `gulp serve`

### Shutdown The Web Application
To stop the application, enter `Ctrl+C`


## References
TOC generated by [md-toc](https://www.npmjs.com/package/md-toc).
