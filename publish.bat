set path=%path%;C:\Program Files (x86)\Java\jdk1.7.0_51\bin
cd src
cd Algorithms
javac ClassicShift.java
javac TrueCaesar.java
javac Morse.java
javac Numbers.java
javac Skip.java
cd ..
javac Obskewer.java
jar cfm ../bin/Obskewer.jar Manifest.txt Obskewer.class Algorithms/*.class
