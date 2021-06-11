In this project we are going to migrate xtext dsl to the web:

-- First, we need to create xtext web integrated project.
--- Create an xtext project, ckick next. In the coming advanced xtext configuration, check the web integration
--- You also need to check maven as the prefered build system, fat as language server and source as plain

For me I usually developing dsl using xtend language. it is a variant and python but very powerful, anything in Java runs seamlessly in that language but using it u get addition features such as code generation templates. If u want to use it, be sure to check the xtend as the preferXtendStubs to true in the file with .mwe2 extension in the main package. After that you can generate xtext artifact and run mwe2. To generate artifact right click in the xtext grammar, run as --> and generate xtext artifacts. And then run as on .mwe2 and the run .mwe2 workflow. This will generate the all needed classes.

--- Code to the web directory, right click it and run it as java application, the server will start, copy the link (localhost:8080) and you will ace editor

---

The next, let us create a web server with vue.

> > Run: vue create name-of-project
> > cd in the directory and run: yarn serve | npm run serve

Once it is done, <br>
The _.web/ directory of the Xtext project shows us some of the resources to run the code editor, but not all of them. As soon as you start the Xtext web server, the web server will use web jars, which are web libraries as JAR Files. Start your Xtext web server, as already shown in part 1, and open http://localhost:8080/webjars/ to have a look at some of the libraries, which are used in the background. Make sure to close the Vue process first, so the used ports do not collide._

Copy the file in the public of the create vue project while the server is running from eclipse

> > wget --mirror --reject=index.html,style.css -nH -P public/ http://localhost:8080/{xtext,xtext-resources,webjars}

_When you updated the language in xtext project, u need to run again the command above after xtext-resources to update the syntax in the code editor_

The web server from eclipse has to be run as java application <br>
You can run the language server by running as java application ServerLauncher inside web sub-project in the src folder.
To stop the server, press enter. Inside ServerLauncher.xtend, you can change the port.

Right click the web sub-project, export the jar as runnable and select copy all required libraries into sub-folder next to a jar: this is the language server<br>
Inside the launch configuration, you need to select the right Main you want to export
To run the server as standlone, run: java -jar name-of-exported-jar.jar

Next you need to export the compiler, you will need to: <br>
-- When you first create the project, enable the web integration from the startup startup
-- Once go to to the mwe2, and enable the main method, "generateXtendMain = true". this line generates the main
-- You will also need to enable xtend, just set it true as preferred language inside mwe2
-- Right click the Main.xtend in generotor pacakage, export it as the the runnable jar, and select package required libraries into jar

Afterwards, copy the language server and the compiler in their folder in web project, make sure the server for the language server is set well.

Download the files: xtext-resources, xtext, webjars
Run the xtext web server from eclipse: wget --mirror --reject=index.html,style.css -nH -P ./ http://localhost:8090/{xtext,xtext-resources,webjars}
You should be inside the public folder of the frontend server!

Once you are done, check the extensions of the dsl, and adjust the version by the checking these files in public and the extensions of the subdirectories
