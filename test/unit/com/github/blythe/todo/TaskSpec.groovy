package com.github.blythe.todo

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification
import spock.i18n.Thai
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
class TaskSpec extends Specification {

	def "save Task"(){
		given:
		def card = "New Task"

		when:
		def task = new Task(subject: card)

		then:
		assertNotNull task.save()
	}
}