cd ~/Documents/Git/pCalculator/
javac -d bin -cp bin -sourcepath . src/com/macphage/tool/Debug.java
javac -d bin -cp bin -sourcepath . src/com/macphage/tool/Variable.java
javac -d bin -cp bin -sourcepath . src/com/macphage/function/Add.java
javac -d bin -cp bin -sourcepath . src/com/macphage/function/Subtract.java
javac -d bin -cp bin -sourcepath . src/com/macphage/function/Multiply.java
javac -d bin -cp bin -sourcepath . src/com/macphage/function/Divide.java
javac -d bin -cp bin -sourcepath . src/com/macphage/function/Power.java
javac -d bin -cp bin -sourcepath . src/com/macphage/function/Squareroot.java
javac -d bin -cp bin -sourcepath . src/com/macphage/function/Factorial.java
javac -d bin -cp bin -sourcepath . src/com/macphage/function/QuadraticFormula.java
javac -d bin -cp bin -sourcepath . src/com/macphage/function/GreatestCommonDivisor.java
javac -d bin -cp bin -sourcepath . src/com/macphage/function/LeastCommonMultiple.java
javac -d bin -cp bin -sourcepath . src/com/macphage/function/Simplify.java
javac -d bin -cp bin -sourcepath . src/com/macphage/function/Count.java
javac -d bin -cp bin -sourcepath . src/com/macphage/Calculator.java

jar cfm bin/pCalculator-snapshot.jar Manifest.txt com/macphage/Calculator.class com/macphage/function/*.class com/macphage/tool/*.class


