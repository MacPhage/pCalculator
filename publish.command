cd ~/Documents/Git/pCalculator/src/
cd Function
javac -d . -sourcepath . Errors.java
javac -d . -sourcepath . Add.java
javac -d . -sourcepath . Subtract.java
javac -d . -sourcepath . Multiply.java
javac -d . -sourcepath . Divide.java
javac -d . -sourcepath . Power.java
javac -d . -sourcepath . Squareroot.java
cd ..
javac Calculator.java
jar cfm ../bin/pCalculator-snapshot.jar Manifest.txt Calculator.class Function/*.class icon_1024.png
