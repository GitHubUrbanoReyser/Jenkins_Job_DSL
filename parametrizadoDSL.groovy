job('ejemplo2-job-DSL') {
	description('Job DSL de ejemplo')
  	scm {
      		git('https://github.com/GitHubUrbanoReyser/Jenkins_Job_DSL.git', 'main') { node ->
        		node / gitConfigName('demo')
        		node / gitConfigEmail('demo@gmail.com')
      		}
    	} 
  	parameters {
   		stringParam('nombre', defaultValue = 'Jenkins', description = 'Parametro de cadena para el Job Booleano')
      		choiceParam('planeta', ['Mercurio', 'Venus', 'Tierrra', 'Marte', 'Jupiter', 'Saturno', 'Urano', 'Neptuno'])
      		booleanParam('agente', false)
    	}
  	triggers {
    		cron('H/7 * * * *')
    	}
  	steps {
    		shell("bash jobscript.sh")
    	}
  	publishers {
      		mailer('demo@gmail.com', true, true)
      		slackNotifier {
		  notifyAborted(true)
		  notifyEveryFailure(true)
		  notifyNotBuilt(false)
		  notifyUnstable(false)
		  notifyBackToNormal(true)
		  notifySuccess(false)
		  notifyRepeatedFailure(false)
		  startNotification(false)
		  includeTestSummary(false)
		  includeCustomMessage(false)
		  customMessage(null)
		  sendAs(null)
		  commitInfoChoice('NONE')
		  teamDomain(null)
		  authToken(null)
        	}
    	}
}
