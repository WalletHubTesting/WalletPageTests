
PreCondition : Maven has to be installed
             : java has to be installed
			 : Chrome Browser Version : above  70
			 : FireFox Browser Version: above  60
             			 
  I have created this project in maven. so no need to install the plugins manually. I have added the dependencies according to the project needs in the pom.xml file.
Dependencies Added in to that project : 
   - Selenium WebDriver
   - ChromeDriver  
   - FireFox driver   
   - WebDriverManger
   - TestNg
   
 Open Project in Eclipse : 
 -------------------------
 Step 1 : Go to File
 Step 2 : Select Import
 Step 3 : Select Existing Maven Project and (Next)
 Step 4 : Give the root directory path( Where you have saved this project)
 Step 5 : Select the project in the project lists.
 Step 6 : Finish
 
 
 Project Description :
 -----------------------
 
 I have created this project in maven. so no need to install the plugins manually. I have added the dependencies according to the project needs in the pom.xml file.
Dependencies Added in to that project : 
   - Selenium WebDriver
   - ChromeDriver  
   - FireFox driver   
   - WebDriverManger
   - TestNg
   
   FrameWork used : Data driven framework with page object model design pattern 
                     TestNg framework used in testcases
   
   In my project have two folders MAIN and TESTS
   
   In MAIN Folder : I have created three packages such as 
                     1)config
					 2)base
					 3)Pages
					 
	 ===>   config package has "config.properties" file which has data of browser name, url...	          				 
	 ===>  "base" package have a class which contain the precondition method   - "driver initialization" (data value taken from "config.properties" file
	 ===>  Pages package has a class which contains the methods of that particular webpage,webelements....(Total four method for four cases)
	 
	In TEST Folder : I have created one package 
	                  1)pageTests- have a class contains testcases(each as methods) with testNg framework. (Total four test cases )
					  
Note : Created testNg.xml file also. ( we can run the test file from there also. Its like a suite file. but now i have only one test class.


Run the project : 
------------------

Two ways :
    1) through testNg.xml file. open the file -> right click -> runAs -> testNg suite
	2) through test class file : In TEST folder -> test package -> WalletHubPagesTests.java -> right click -> runAs -> testNg file
	
Note : This script can run in two browsers such as chrome and firefox.( "config.properties" file change the browser name according to ...)
					  
	