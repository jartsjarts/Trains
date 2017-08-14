This project uses maven as software project management. The project has unit tests in order to 
ensure the correctness of the application. For this reason we provide some tests:

######################   Tests: ######################  

[INFO] Scanning for projects...
[WARNING] 
[WARNING] Some problems were encountered while building the effective model for com.thought.works:trains-JD:jar:0.0.1-SNAPSHOT
[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-jar-plugin is missing. @ line 57, column 12
[WARNING] 
[WARNING] It is highly recommended to fix these problems because they threaten the stability of your build.
[WARNING] 
[WARNING] For this reason, future Maven versions might no longer support building such malformed projects.
[WARNING] 
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building Trains JD 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ trains-JD ---
[INFO] Deleting /Users/jordi/Desktop/Thoughts/trains-JD/target
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ trains-JD ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 0 resource
[INFO] 
[INFO] --- maven-compiler-plugin:2.1:compile (default-compile) @ trains-JD ---
[INFO] Compiling 11 source files to /Users/jordi/Desktop/Thoughts/trains-JD/target/classes
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ trains-JD ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 0 resource
[INFO] 
[INFO] --- maven-compiler-plugin:2.1:testCompile (default-testCompile) @ trains-JD ---
[INFO] Compiling 2 source files to /Users/jordi/Desktop/Thoughts/trains-JD/target/test-classes
[INFO] 
[INFO] --- maven-surefire-plugin:2.19.1:test (default-test) @ trains-JD ---

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.thought.works.domain.model.HeapTest
Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.094 sec - in com.thought.works.domain.model.HeapTest
Running com.thought.works.domain.RailwayNetworkTest
Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.022 sec - in com.thought.works.domain.RailwayNetworkTest

Results :

Tests run: 10, Failures: 0, Errors: 0, Skipped: 0

[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ trains-JD ---
[INFO] Building jar: /Users/jordi/Desktop/Thoughts/trains-JD/target/trains-JD-0.0.1-SNAPSHOT.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 7.962s
[INFO] Finished at: Tue Jul 04 23:29:42 CEST 2017
[INFO] Final Memory: 18M/222M
[INFO] ------------------------------------------------------------------------
[WARNING] The requested profile "local" could not be activated because it does not exist.



Execution instructions:

>Unzip "trains-JD.zip" in a directory ${APP_HOME_DIRECTION}
>cd ${APP_HOME_DIRECTION}
>mvn clean package
>cd ${APP_HOME_DIRECTION}/target
>java -jar trains-JD-0.0.1-SNAPSHOT.jar

######################  (Application starts)  ######################

                           '@@@@#@@@@@:                                                                   
                         @''''''''''''''@                                                                 
                         @+++++++++++++@                                                                 
        ;''#@             @;;;;;;;;;;;@                                                                  
      `@#@@@@#            @;;;;;;;;;;;@                                                                  
      .:;;;''@            @'.........;@                                                                  
      .;;;;''@            @'`  ``````;@    @@@@@@@@@@@@@@@@@@@@@@@@@@     @@@@@@@@@@@@@@@@@@@@@@@@@@     
       .''''@             @'` `````..;@    '`;;;;;;;;;;;;;;;;;;;;;;;@     #`;;;;;;;;;;;;;;;;;;;;;;;@     
       ..;;'@             @'``````...'@    ';;;;;;;;;;;;;;;;;;;;;;;;@     #:;;;;;;;;;;;;;;;;;;;;;;;@     
       ..;;'@             @'`````....'@    ''``````@@``````'@``````'@     #;``````@+``````@@``````'@     
   `   ;:''+@::::::::::   @'```......'@    ''` ````@@  ````'@  ````'@     #;`  ```@+` ````@@` ````'@     
     @'''#;,....,,,;;;;': @'```......'@    ''` ````@@ `````'@ `````'@     #;` ````@+``````@@``````'@     
    +,,,'@;;;;;;;;;;;;;'#+@'``.......'@    ''`````.@@ ````.'@ ````.'@     #;``````@+``````@@ ````.'@     
    @+++';;;;;;;;;;;;;;'#'@'@@@@@@@@@'@    ''````..@@`````.'@````..'@     #;`````.@+`````.@@````..'@     
    ''''+;;;;;;;;;;;;;;'#'@;;;;;;;''''@    ''```...@@```...'@```...'@     #;````..@+````..@@```...'@     
   ,''''@;;;;;;;;;;;;;;'#'@;;;;;;'''''@    ''@@@@@@@@@@@@@@'@@@@@@@'@     #;@@@@@@@+@@@@@@@@@@@@@@'@     
   @''''@;;;;;;;;;;;;;;'#'@;;;;;;'''''@    ';;;;;;;;;;;;;;''''''''''@     #;;;;;;;;;;;;;;''''''''''@     
   @''''@;;;;;;;;;;;;;;'#'@;;;;;;'''''@    ';;;;;;;;;;;;''''''''''''@     #;;;;;;;;;;;;;'''''''''''@     
   @''''@;;;;;;;;;;;;;;'#'@;;;;;''''''@    ';;;;;;;;;;;'''''''''''''@     #;;;;;;;;;;;'''''''''''''@     
   @####@;;;;;;;;;;;;;;'#'@;;;;;''''''@    ';;;;;;;;;;''''''''''''''@     #;;;;;;;;;;''''''''''''''@     
   @####@'''''''''''''''##@;;;;;''''''@    ';;;;;;;;;'''''''''''''''@     #;;;;;;;;;'''''''''''''''@     
   @####@'''''''''''''''##@;;;;'''''''@    ';;;;;;;;''''''''''''''''@     #;;;;;;;;''''''''''''''''@     
   +####@'''''''''''''''##@+@@@#''''''@    ';;;;;;;'''''''''''''''''@     #;;;;;;;'''''''''''''''''@     
    #####'''''''''''''''#@#'''''+@''''@    ';;;;;'''''''''''''''''''@     #;;;;;;''''''''''''''''''@     
    @+####@@@@@@@@@@@@@@@';;;;;;;'@'''@''@ ';;;;''''''''''''''''''''@@'', #;;;;''''''''''''''''''''@.''@ 
     ;#################@';;''''';;'@''@+@@ ';;;'''''''''''''''''''''@@'', #;;;'''''''''''''''''''''@.''@ 
   @#@+++++++++++++++++@;;'''''''';'++@++''';;''''''''''''''''''''''@'+@''#;;''''''''''''''''''''''@'':` 
  @.,@''''''''''''''''+';''''''''';'@''++++';'''''''''''''''''''''''@++@++#;'''''''''''''''''''''''@++.  
 .,;;@''''''''''''''''@';'''###''';;@@+,  +@@@@@@@@@@@@@@@@@@@@@@@@@@:   .@@@@@@@@@@@@@@@@@@@@@@@@@@@    
 @;'@@@@@@@@@@@@@@@@@@@';'''###+''';#    #::::::::::::::::::::::::::::. .;:::::::::::::::::::::::::::@   
#;;'@@@'##@@@@@@@@@+@@@';'''###'''';@    @:@@@@@@@@@@@@@`@@@@@@@@@@@@'@ :;@@@@@@@@@@@@@`@@@@@@@@@@@@@@   
@;''@@'.@+++++++##@.'@@';''''+'''';'@     @:@''@@@@#'+@' @#'+@@@@''@@.   ; @''@@@@@''@@ @@''@@@@+'#@     
';''@@.+'';'@@@,+''+:@@#;;'''''''';',      @''''@@+'''': +''''@@''''@     @''''@@@''''@ @''''@@''''+     
@@@@@@.'+'+;@@@,'+++,@@@';;'''''';'@       +'##'+'''#''@;''#''@@'+#''`    @'+#'',''#+'@ ''#+'@@''#'';    
     @',''.', @+.''.+'  @';;;';;;'@        #'++'#;''+''@:''+''@@''+''     @''+'' ''+''@ ''+''@@''+'':    
      @'..+@   @'..+@    @+';;;''@         @''''@ @'''+  @'''+ ;''''@     ;''''@ @'''': @''''; +'''@     
       @@@@     @@@@       @@@@@.           @@@@   @@@`   @@@`  ;@@@       ;@@@   @@@;   @@@;  `@@@

Welcome to Kiwiland Commuter railroad route information provider: 
Please enter the railway network:

(Input the comma separated edge array: e.g: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7)

#1: 9
#2: 5
#3: 13
#4: 22
#5: NO SUCH ROUTE
#6: 2
#7: 3
#8: 9
#9: 9
#10: 7
Execution ends successfully.

(The results for the algorithm execution are shown for the input)

######################  (Application ends)  ######################