@echo off
setlocal

set "WRAPPER_DIR=%~dp0.mvn\wrapper"
set "PROPS_FILE=%WRAPPER_DIR%\maven-wrapper.properties"

if not exist "%PROPS_FILE%" (
  echo Maven wrapper properties not found: %PROPS_FILE%
  exit /b 1
)

for /f "tokens=1,* delims==" %%A in ('findstr /b "distributionUrl=" "%PROPS_FILE%"') do set "DISTRIBUTION_URL=%%B"
if "%DISTRIBUTION_URL%"=="" (
  echo distributionUrl is missing in %PROPS_FILE%
  exit /b 1
)

set "MAVEN_BASE=%USERPROFILE%\.m2\wrapper\dists"
if not exist "%MAVEN_BASE%" mkdir "%MAVEN_BASE%"

for %%I in ("%DISTRIBUTION_URL%") do set "MAVEN_ZIP_NAME=%%~nxI"
set "MAVEN_VERSION=%MAVEN_ZIP_NAME:-bin.zip=%"
set "MAVEN_HOME=%MAVEN_BASE%\%MAVEN_VERSION%"
set "MAVEN_CMD=%MAVEN_HOME%\bin\mvn.cmd"

if not exist "%MAVEN_CMD%" (
  echo Downloading Maven distribution: %DISTRIBUTION_URL%
  powershell -NoProfile -ExecutionPolicy Bypass -Command ^
    "$ErrorActionPreference='Stop';" ^
    "$url='%DISTRIBUTION_URL%';" ^
    "$zipPath=Join-Path '%MAVEN_BASE%' '%MAVEN_ZIP_NAME%';" ^
    "Invoke-WebRequest -Uri $url -OutFile $zipPath;" ^
    "Expand-Archive -Path $zipPath -DestinationPath '%MAVEN_BASE%' -Force;" ^
    "Remove-Item -Path $zipPath -Force"
  if errorlevel 1 (
    echo Failed to download/extract Maven distribution.
    exit /b 1
  )
)

if not exist "%MAVEN_CMD%" (
  echo Maven executable not found at %MAVEN_CMD%
  exit /b 1
)

call "%MAVEN_CMD%" %*
endlocal
