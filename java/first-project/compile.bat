if not exist "out\" mkdir "out"
javac --release 17 -d out *.java
cd out
jar cfm ../Robot.jar ../manifest.txt .
cd ..
copy "Robot.jar" "../../website/java-source" /Y
pause