@echo off
chcp 65001 > nul
title Portfolio Java - TP2
cls

echo ===============================================
echo    PORTFOLIO JAVA - TRAVAUX PRATIQUES TP2
echo ===============================================
echo.
echo Compilation en cours...
echo.

cd /d "%~dp0"

javac -encoding UTF-8 MenuTPProfessionnel.java

if %errorlevel% neq 0 (
    echo.
    echo [ERREUR] La compilation a echoue !
    echo.
    pause
    exit /b 1
)

echo Compilation reussie !
echo.
echo Lancement du menu...
echo.

java MenuTPProfessionnel

echo.
echo Programme termine.
pause
