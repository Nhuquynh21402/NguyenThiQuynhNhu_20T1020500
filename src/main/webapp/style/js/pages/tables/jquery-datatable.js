$(function() {
	//Exportable table
	$('.js-exportable').DataTable({
		dom: 'Bfrtip',
		responsive: true,
		buttons: [
			'copy', 'csv', 'excel', 'pdf', 'print'
		],
		language: {
			 url: 'style/vi.json',
		}
	});

	$('.js-basic-example').DataTable({
		language: {
		 url: 'style/vi.json',
		},
		responsive: true
	});
});