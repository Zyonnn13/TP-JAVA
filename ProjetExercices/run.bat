@echo off
chcp 65001 > nul
cls

echo ========================================
echo  LANCEMENT DE L'APPLICATION
echo ========================================
echo.

REM Vérifier si les classes compilées existent
if not exist "bin\Main.class" (
    echo ERREUR: Le projet n'est pas compile !
    echo.
    echo Veuillez d'abord compiler avec 'compile.bat'
    echo.
    pause
    exit /b 1
)

echo Demarrage de l'application...
echo.

REM Lancer l'application
java -cp bin Main

if %errorlevel% neq 0 (
    echo.
    echo ========================================
    echo  ERREUR D'EXECUTION
    echo ========================================
    echo.
)

echo.
pause
