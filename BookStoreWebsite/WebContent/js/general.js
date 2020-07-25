function confirmDelete(id, controller) {
	var location = '';
	
	if (controller === "user") {
		location = 'delete_user?id=' + id;
	} else if (controller === "category") {
		location = 'delete_category?id=' + id;
	} else if (controller == "book") {
		location = 'delete_book?id=' + id;
	}
	
	if (confirm('Are you sure you want to delete ID ' + id + "?")) {
		window.location = location;
	}
}