cd ~/Documents/Git/pCalculator/
javac -d bin -cp bin -sourcepath . src/com/ruthlessphysics/pcalculator/tool/Debug.java
javac -d bin -cp bin -sourcepath . src/com/ruthlessphysics/pcalculator/Header.java
javac -d bin -cp bin -sourcepath . src/com/ruthlessphysics/pcalculator/tool/Var.java
javac -d bin -cp bin -sourcepath . src/com/ruthlessphysics/pcalculator/function/Add.java
javac -d bin -cp bin -sourcepath . src/com/ruthlessphysics/pcalculator/function/Subtract.java
javac -d bin -cp bin -sourcepath . src/com/ruthlessphysics/pcalculator/function/Multiply.java
javac -d bin -cp bin -sourcepath . src/com/ruthlessphysics/pcalculator/function/Divide.java
javac -d bin -cp bin -sourcepath . src/com/ruthlessphysics/pcalculator/function/Power.java
javac -d bin -cp bin -sourcepath . src/com/ruthlessphysics/pcalculator/function/Squareroot.java
javac -d bin -cp bin -sourcepath . src/com/ruthlessphysics/pcalculator/function/Factorial.java
javac -d bin -cp bin -sourcepath . src/com/ruthlessphysics/pcalculator/function/QuadraticFormula.java
javac -d bin -cp bin -sourcepath . src/com/ruthlessphysics/pcalculator/function/GreatestCommonDivisor.java
javac -d bin -cp bin -sourcepath . src/com/ruthlessphysics/pcalculator/function/LeastCommonMultiple.java
javac -d bin -cp bin -sourcepath . src/com/ruthlessphysics/pcalculator/function/Simplify.java
javac -d bin -cp bin -sourcepath . src/com/ruthlessphysics/pcalculator/function/Count.java
javac -d bin -cp bin -sourcepath . src/com/ruthlessphysics/pcalculator/function/NRoot.java
javac -d bin -cp bin -sourcepath . src/com/ruthlessphysics/pcalculator/function/Logarithm.java


javac -d bin -cp bin -sourcepath . src/com/ruthlessphysics/pcalculator/Calculator.java

cd bin

jar cfm pCalculator-snapshot.jar ../Manifest.txt com/ruthlessphysics/pcalculator/* com/ruthlessphysics/pcalculator/function/* com/ruthlessphysics/pcalculator/tool/*

