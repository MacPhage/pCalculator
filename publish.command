cd ~/Documents/Git/pCalculator/src/
javac -d . -sourcepath . Function/Debug.java
javac -d . -sourcepath . Function/Add.java
javac -d . -sourcepath . Function/Subtract.java
javac -d . -sourcepath . Function/Multiply.java
javac -d . -sourcepath . Function/Divide.java
javac -d . -sourcepath . Function/Power.java
javac -d . -sourcepath . Function/Squareroot.java
javac -d . -sourcepath . Function/Factorial.java
javac -d . -sourcepath . Function/QuadraticFormula.java
javac Calculator.java
jar cfm ../bin/pCalculator-snapshot.jar Manifest.txt Calculator.class Function/*.class res/icon_1024.png

cd ~/Documents/Git/pCalculator/src/
rm *.class
cd Function
rm *.class
