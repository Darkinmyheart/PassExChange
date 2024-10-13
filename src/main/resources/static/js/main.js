(function ($) {
  "use strict";

  // Spinner
  var spinner = function () {
    setTimeout(function () {
      if ($("#spinner").length > 0) {
        $("#spinner").removeClass("show");
      }
    }, 1);
  };
  spinner(0);

  // // Fixed Navbar
  // $(window).scroll(function () {
  //   if ($(this).scrollTop() > 300) {
  //     $(".fixed-top .container").addClass("shadow-sm").css("max-width", "100%");
  //   } else {
  //     $(".fixed-top .container")
  //       .removeClass("shadow-sm")
  //       .css("max-width", "100%");
  //   }
  // });

  // Donation
  $(".progress").waypoint(
    function () {
      $(".progress-bar").each(function () {
        $(this).css("width", $(this).attr("aria-valuenow") + "%");
      });
    },
    { offset: "80%" }
  );

  // Facts counter
  $('[data-toggle="counter-up"]').counterUp({
    delay: 5,
    time: 2000,
  });

  // Event carousel
  $(".event-carousel").owlCarousel({
    autoplay: true,
    smartSpeed: 1000,
    center: false,
    dots: false,
    loop: true,
    margin: 25,
    nav: true,
    navText: [
      '<i class="bi bi-arrow-left"></i>',
      '<i class="bi bi-arrow-right"></i>',
    ],
    responsiveClass: true,
    responsive: {
      0: {
        items: 1,
      },
      768: {
        items: 1,
      },
      992: {
        items: 2,
      },
      1200: {
        items: 3,
      },
    },
  });

  // Back to top button
  $(window).scroll(function () {
    if ($(this).scrollTop() > 300) {
      $(".back-to-top").fadeIn("slow");
    } else {
      $(".back-to-top").fadeOut("slow");
    }
  });
  $(".back-to-top").click(function () {
    $("html, body").animate({ scrollTop: 0 }, 1500, "easeInOutExpo");
    return false;
  });
})(jQuery);

// Sử dụng Fetch API để tải nội dung từ header.html
fetch("fragments/header.html")
  .then((response) => {
    if (!response.ok) {
      throw new Error("Network response was not ok");
    }
    return response.text(); // Chuyển đổi phản hồi thành văn bản
  })
  .then((data) => {
    document.getElementById("header").innerHTML = data; // Chèn nội dung vào div với id="header"
  })
  .catch((error) => console.error("Có lỗi xảy ra:", error));

// Gọi footer
fetch("fragments/footer.html") // Tương tự gọi footer.html
  .then((response) => {
    if (!response.ok) {
      throw new Error("Network response was not ok");
    }
    return response.text();
  })
  .then((data) => {
    document.getElementById("footer").innerHTML = data; // Chèn nội dung vào div với id="footer"
  })
  .catch((error) => console.error("Có lỗi xảy ra:", error));

// Tải modal từ searchModal.html
fetch("fragments/searchModal.html")
  .then((response) => {
    if (!response.ok) {
      throw new Error("Network response was not ok");
    }
    return response.text();
  })
  .then((data) => {
    document.getElementById("modalContainer").innerHTML = data;
    // Khởi tạo modal Bootstrap sau khi nội dung đã được chèn vào
    const modal = new bootstrap.Modal(document.getElementById("searchModal"));
  })
  .catch((error) => console.error("Có lỗi xảy ra:", error));
