@ECHO OFF

REM -------------------------CAMINHO PARA O VISUAL STUDIO-------------------------------------
START "" "C:\Program Files (x86)\Microsoft Visual Studio\2017\Community\Common7\IDE\devenv.exe"
REM -------------------------------------------------------------------------------------------
FOR /L %%i IN (1,1,100) DO (
  (TASKLIST | FIND /I "devenv.exe") && GOTO :startnext

  PING 1.1.1.1 -n 1 -w 2000 > NUL
)
GOTO :EOF


:startnext
PING 1.1.1.1 -n 1 -w 5000 > NUL

REM ---------------CAMINHO PARA O VISUAL STUDIO CODE-------
START code .
REM -------------------------------------------------------
FOR /L %%i IN (1,1,100) DO (
  (TASKLIST | FIND /I "Code.exe") && GOTO :startnext

  PING 1.1.1.1 -n 1 -w 2000 > NUL
)
GOTO :EOF

:startnext
PING 1.1.1.1 -n 1 -w 5000 > NUL

REM ------CAMINHO PARA O POSTMAN. COPIE E COLE DO MEU ATALHO DELE SE NÃO ABRIR-------
START chrome --profile-directory="Profile 1" --app-id=fhbjgbiflinjbdggehcddcbncdddomop
REM ------------------------------------------------------------------------------------
FOR /L %%i IN (1,1,100) DO (
  (TASKLIST | FIND /I "chrome.exe") && GOTO :startnext

  PING 1.1.1.1 -n 1 -w 2000 > NUL
)
GOTO :EOF


:startnext
PING 1.1.1.1 -n 1 -w 5000 > NUL

REM -----------------CAMINHO PARA O PROJETO FRONT-END (ABRIR O HTTP-SERVER)-------------------
START http-server -C -1 
REM -------------------------------------------------------------------------------------------
FOR /L %%i IN (1,1,100) DO (
  (TASKLIST | FIND /I "node.exe") && GOTO :startnext

  PING 1.1.1.1 -n 1 -w 2000 > NUL
)
GOTO :EOF


PING 1.1.1.1 -n 1 -w 5000 > NUL
:startnext

REM -------SEU ENDEREÇO LOCALHOST-----
START chrome http://localhost:8080 
REM -------------------------------

START chrome https://crescer2017-1.slack.com