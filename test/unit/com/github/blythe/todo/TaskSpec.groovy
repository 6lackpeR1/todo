package com.github.blythe.todo

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification
import spock.i18n.Thai
import org.junit.*

/**
* create : `grails create-unit-test myApp.app`
* usage : `grails test-app`
*/


/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
class TaskSpec extends Specification {

	def "save Task"(){
		setup:
		mockDomain(Task)
		def card = "New Task"

		when:
		def task = new Task(subject: card)

		then:
		assertNotNull task.save()
	}
	
	def "validate Task"(){
		setup:
		mockForConstraintsTests(Task)

		when:
		def task = new Task()

		then:
		assertFalse task.validate()
	}
}