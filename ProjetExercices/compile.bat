@echo off
chcp 65001 > nul
cls

echo ========================================
echo  COMPILATION DU PROJET
echo ========================================
echo.

REM Créer le dossier bin s'il n'existe pas
if not exist "bin" mkdir bin

echo Compilation en cours...
echo.

REM Compiler tous les fichiers Java
cd src
javac -encoding UTF-8 -d ..\bin Main.java model\*.java view\*.java

if %errorlevel% equ 0 (
    echo.
    echo ========================================
    echo  COMPILATION REUSSIE !
    echo ========================================
    echo.
    echo Les fichiers compiles sont dans le dossier 'bin'
    echo Utilisez 'run.bat' pour lancer l'application
) else (
    echo.
    echo ========================================
    echo  ERREUR DE COMPILATION
    echo ========================================
    echo.
    echo Verifiez les messages d'erreur ci-dessus
)

cd ..
echo.
pause
