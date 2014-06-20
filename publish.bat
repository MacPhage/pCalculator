set path=%path%;C:\Program Files (x86)\Java\jdk1.7.0_51\bin
cd src
javac -d . -sourcepath . Function/Debug.java
javac -d . -sourcepath . Function/Add.java
javac -d . -sourcepath . Function/Subtract.java
javac -d . -sourcepath . Function/Multiply.java
javac -d . -sourcepath . Function/Divide.java
javac -d . -sourcepath . Function/Power.java
javac -d . -sourcepath . Function/Squareroot.java
javac -d . -sourcepath . Function/Factorial.java
javac -d . -sourcepath . Function/QuadraticFormula.java
javac -d . -sourcepath . Function/GreatestCommonDivisor.java
javac -d . -sourcepath . Function/LeastCommonMultiple.java
javac -d . -sourcepath . Function/Simplify.java
javac Calculator.java
cd ..
jar cfm /bin/pCalculator-snapshot.jar Manifest.txt src/Calculator.class src/Function/*.class


cd src
rm *.class
cd Function
rm *.class