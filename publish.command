cd ~/Documents/Git/Obskewer/src/
cd Algorithms
javac ClassicShift.java
javac TrueCaesar.java
javac Morse.java
javac Numbers.java
javac Skip.java
cd -
javac Obskewer.java
jar cfm ../bin/Obskewer-snapshot.jar Manifest.txt Obskewer.class Algorithms/*.class
