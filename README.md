# Automation-web-whatsdoc
## Setup for Windows

## Install Java
```
1. Download Java https://www.java.com/en/
2. copy folder to c program file
3. copy address java folder
4. go to advanced system setting
5. go to environment variables
6. create new system variables and paste address bin java folder
7. copy address bin java folder
8. go to path in system variables
9. create new and paste address bin java folder
10. open command prompt write java --version
```

## Install Maven
```
1. Download Maven https://maven.apache.org/download.cgi - windows download binary zip archive
2. copy folder to c program file
3. copy address Maven folder
4. go to advanced system setting
5. go to environment variables
6. create new system variables and paste address Maven folder
7. copy address bin Maven folder
8. go to path in system variables
9. create new and paste address bin Maven folder
10. open command prompt write mvn --version
```

## How to run in Windows
```
1. Clone github
2. Open command prompt
3. Cd to folder
4. Run in headless use this : mvn test -PRegression -Dbrowser=chromeheadless
5. Run in browser user this : mvn test -PRegression -Dbrowser=chrome
```

## How to check report HTML
```
1. Open folder 
2. Open folder reports
3. Click report.html
```
