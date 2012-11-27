class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/com/github/blythe/todo/todo.zul")
		"500"(view:'/error')
	}
}
