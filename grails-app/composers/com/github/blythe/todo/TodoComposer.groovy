package com.github.blythe.todo

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class TodoComposer extends GrailsComposer {

    def afterCompose = { window ->
        // initialize components here
        def tasks = Task.list()
        if (tasks.size() > 0) {
            tasks.each { task ->
                addTaskToList(task)
            }
        }
    }

    //Create TaskList
    def addTaskToList(task) {
    $('#taskList').append {
        div(id: "task_${task.id}", sclass: 'task-card') {
            label(id: "task_${task.id}_done", value: "[x]", sclass: "task-done")
            textbox(id: "subject_${task.id}", value: task.subject, inplace: true, instant: true)
        }
    }

    $("#task_${task.id}_done").on('click', {
        $("#task_${task.id}").detach()
        task.delete()
    })

    $("#task_${task.id}").link(task, [subject: "#subject_${task.id}"])

    $("#subject_${task.id}").on('change', {
        task.save()
    })
}
	
	//Check Event
    @Listen("onClick = #createTask")
    def createTask(){
    	def subject = $('#subject').text()
    	def task    = new Task(subject: subject).save()

    	//create ui
    	addTaskToList(task)
    }
}
