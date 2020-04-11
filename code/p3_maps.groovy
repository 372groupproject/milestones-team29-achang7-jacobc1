// Groovy's map uses an instance of Java'a LinkedHashMap class.
// Java's map classes can also be used in Groovy, but the following is the
// built in Groovy map

class p3_maps{
	static void main(String[] args){
		// You can define an empty dictionary by the following:
		def capitals = [:]
		println "capitals = $capitals"

		// New key:value pairs can be created in two ways:
		capitals['Arizona'] = "Phoenix"
		println "capitals = $capitals"

		// or
		capitals.Colorado = "Denver"
		println "capitals = $capitals"

		// Maps can also be defined to be non-empty
		def world_capitals = ['USA':'Washington DC', 'France':'Paris', 'China':'Beijing', 'Germany':'Berlin']
		println "world_capitals = $world_capitals"

		// Values in the map cn be accessed in two ways:
		println "${world_capitals['France']} is the capital of France"

		// or
		println "${world_capitals.China} is the capital of China"
	}
}
