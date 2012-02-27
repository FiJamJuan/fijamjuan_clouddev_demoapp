package ie.cit.cloudapp;

import java.util.ArrayList;
import java.util.List;

public class ToDoRepository {
	private List<Todo> todos = new ArrayList<Todo>();

	public List<Todo> getTodos() {
		return todos;
	}

	public void addTodo(Todo todo) {
		todos.add(todo);
	}

}
