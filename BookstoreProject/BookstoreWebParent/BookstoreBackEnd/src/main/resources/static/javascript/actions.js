$(document).ready(function() {
	$("#logoutLink").on("click", function(e) {
		e.preventDefault();
		document.logoutForm.submit();
	});
	customizeDropDownMenu();
});

function customizeDropDownMenu() {
	//fix nav bar issues when logging in
	$(".navbar .dropdown").hover(
		function() {
			$(this).find('.dropdown-menu').first().stop(true, true).delay(200).slideDown();
		}, function() {
			$(this).find('.dropdown-menu').first().stop(true, true).delay(200).slideUp();
		}
	)
	$(".dropdown > a").click(function() {
		location.href = this.href;
	});
}	