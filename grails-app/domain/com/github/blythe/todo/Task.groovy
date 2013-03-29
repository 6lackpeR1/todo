package com.github.blythe.todo

class Task {

	String subject
	
    static constraints = {
    	subject blank:false
    }
}
