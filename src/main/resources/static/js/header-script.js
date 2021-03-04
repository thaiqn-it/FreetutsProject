const $dropdown = $(".nav-item");
const $dropdownLink = $(".nav-item > a");
const $dropdownToggle = $(".dropdown-toggle");
const $dropdownMenu = $(".dropdown-lv1");
const showClass = "show";

$(window).on("load resize", function() {
	if (this.matchMedia("(min-width: 768px)").matches) {
		$dropdown.hover(
			function() {
				const $this = $(this);
				$this.addClass(showClass);
				$this.find($dropdownToggle).attr("aria-expanded", "true");
				$this.find($dropdownMenu).addClass(showClass);
			},
			function() {
				const $this = $(this);
				$this.removeClass(showClass);
				$this.find($dropdownToggle).attr("aria-expanded", "false");
				$this.find($dropdownMenu).removeClass(showClass);
			}
		);
		$dropdown.click(
			function() {
				const $this = $(this);
				window.location.replace($this.find($dropdownLink).attr("href"));
			}
		);
	} else {
		$dropdown.off("mouseenter mouseleave");
	}
});