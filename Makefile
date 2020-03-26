helloWorld : helloWorld.groovy
	groovyc helloWorld.groovy
	groovy helloWorld

fact : fact.groovy
	groovyc fact.groovy
	groovy fact
