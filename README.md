# AppiumJavaPOM
This is sample framework for Android Test using Appium Cucumber and Java


## 1. Please Checkout this project into your local system
## 2. Installation (pre-requisites)

1. Make sure JDK 1.8+ is installed (make sure Java class path is set)
2. Maven is installed (make sure .m2 class path is set)
3. Install NodeJS and node version 10 or above
4. Install Appium using NPM (npm install -g appium)
5. Install Android SDK(Android Studio) and ANDROID_HOME and Path is set
6. If you are using Emulator, Virtual Devices should be created and configured
7. If you are using Real Android device its should be connected to PC and ADB debugging should be enabled on device.
8. Import project in any IDE like Eclipse/Intellij

## 3. For Running Tests

1. Download this repository to your local machine
2. **Using Command Line :** Open Command Prompt and Navigate to folder AppiumJavaPOM folder and run command : mvn clean test, it will execute the tests and generate the reports in folder : target/telstraTestHTMLReport.
4. **Using Cucumber Runner Class :** right click of TestRunner.java class and run as > Junit test.
5. **Using Features files :** select AmazonLogin.feature feature file and right click select run as > cucumber feature file

