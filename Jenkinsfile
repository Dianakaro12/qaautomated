pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/Dianakaro12/qaautomated.git'
            }
        }

        stage('Run Tests') {
            steps {
               bat 'mvn clean test -Dcucumber.plugin="pretty,json:target/cucumber-report.json,html:target/cucumber-html-report.html"'
            }
        }

        stage('Verificar JSON') {
            steps {
                bat '''
                dir target
                if not exist target\\cucumber-report.json (
                    echo ERROR: El archivo cucumber-report.json no existe.
                    exit /b 1
                )
                for %%F in (target\\cucumber-report.json) do set size=%%~zF
                if %size% EQU 0 (
                    echo ERROR: El archivo cucumber-report.json está vacío.
                    exit /b 1
                )
                echo Archivo cucumber-report.json existe y no está vacío. Tamaño: %size% bytes
                type target\\cucumber-report.json
                '''
            }
        }

        stage('Verificar token parcial') {
            steps {
                withCredentials([string(credentialsId: 'github_pat', variable: 'XRAY_TOKEN')]) {
                    bat '''
                    echo Verificando los primeros caracteres del token...
                    echo Token empieza con: %XRAY_TOKEN:~0,10%
                    '''
                }
            }
        }

        stage('Upload Results to Xray') {
            steps {
                withCredentials([string(credentialsId: 'github_pat', variable: 'XRAY_TOKEN')]) {
                    bat '''
                    curl -H "Authorization: Bearer %XRAY_TOKEN%" ^
                         -H "Content-Type: application/json" ^
                         --data-binary @target/cucumber-report.json ^
                         https://xray.cloud.getxray.app/api/v2/import/execution/cucumber
                    '''
                }

            }
        }
       stage('Archive Reports') {
                  steps {
                      // Archivar JSON + HTML
                      archiveArtifacts artifacts: 'target/cucumber-report.json, target/cucumber-html-report.html', fingerprint: true
                  }
              }

              stage('Publish HTML Report') {
                  steps {
                      publishHTML([
                          reportName: 'Cucumber HTML Report',
                          reportDir: 'target',
                          reportFiles: 'cucumber-html-report.html',
                          keepAll: true,
                          alwaysLinkToLastBuild: true,
                          allowMissing: false
                      ])
                  }
              }
          }

          post {
              always {
                  cucumber buildStatus: 'UNSTABLE', fileIncludePattern: '**/target/cucumber-report.json'
              }
          }
      }


