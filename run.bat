@echo off
cd /d "%~dp0"

echo Compiling our Dungeon Game...
if not exist bin mkdir bin
javac --release 11 -d bin src\*.java
if %ERRORLEVEL% neq 0 (
    echo.
    echo Compilation failed!
    pause
    exit /b %ERRORLEVEL%
)

echo.
echo Launching Dungeon Game...
echo -------------------------
java -cp bin Game
echo.
pause
