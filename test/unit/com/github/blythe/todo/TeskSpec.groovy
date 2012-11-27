package com.github.blythe.todo


import static org.junit.Assert.*
import grails.test.mixin.*
import grails.test.mixin.support.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
@Mock(Task)
class TaskSpec extends spock.lang.Specification {

	def "save Task"(){
		setup:
		def card = "New Task"

		when:
		def task = new Task(subject: card)

		then:
		assertNotNull task.save()
	}
}
