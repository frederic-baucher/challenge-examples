$(document).ready(function () {
  fetchCats();
});

function fetchCats() {
  $.ajax({
    url: "/cats",
    type: "GET",
    dataType: "json",
    success: function (cats) {
      buildCatsHtml(cats);
    },
  });
}

function fetchComments(catId) {
  $.ajax({
    url: "/cats/" + catId + "/comments",
    type: "GET",
    dataType: "json",
    success: function (comments) {
      buildCommentsHtml(comments, catId);
    },
  });
}

function postComment(catId) {
  let comment = document.getElementById("comment-cat" + catId).value;

  $.ajax({
    url: "/cats/" + catId + "/comments",
    type: "POST",
    dataType: "json",
    contentType: "application/json",
    data: JSON.stringify({ comment }),
    success: function (data) {
      commentPosted(data.token, catId);
    },
  });
}

function restart() {
  $.ajax({
    url: "/program",
    type: "DELETE",
  });

  $("#restart-spinner").css("display", "block");

  setTimeout(() => {
    // first timeout to be sure the application is ko
    setInterval(() => {
      fetch(document.location).then((response) => {
        if (response.ok) {
          $("#restart-spinner").css("display", "none");
          location.reload();
        }
      });
    }, 700);
  }, 5200);
}

function buildCatsHtml(cats) {
  let catsDiv = $("#cats");
  catsDiv.empty();
  if (cats.length) {
    cats.forEach((cat) => {
      catsDiv.append(buildCatHtml(cat));
      fetchComments(cat.id);
    });
  } else {
    catsDiv.text("No cats found in the database");
  }
}

function buildInputZone(cat) {
  const input = $("<input>", {
    id: "comment-cat" + cat.id,
    type: "text",
    maxlength: 140,
    placeholder: "Your comment",
  });
  const buttonPost = $("<button>", {
    href: "#",
    text: "Post",
    class: "btn btn-primary",
    type: "button",
    onClick: `postComment(${cat.id})`,
  });

  input.keypress((e) => {
    if (e.originalEvent.charCode === 13) {
      postComment(cat.id);
    }
  });

  const div = $("<div/>", { class: "input-zone" });
  div.append(input);
  div.append(buttonPost);

  return div;
}

function buildCatHtml(cat) {
  const image = $("<img>", {
    src: cat.url,
    class: "card-img-top",
    alt: cat.name,
  });
  const name = $("<h5>", { class: "card-title" }).text(cat.name);

  const title = $("<div>", {
    class: "title",
    id: cat.id,
  }).append(name);

  const body = $("<div>", { id: `card-body-${cat.id}`, class: "card-body" });

  return $("<div>", { class: "card bg-light" })
    .append(image)
    .append(title)
    .append(body)
    .append(buildInputZone(cat));
}

function buildCommentsHtml(comments, catId) {
  const catBody = $(`#card-body-${catId}`);

  catBody.empty();

  comments.forEach((comment) => {
    catBody.append(buildCommentHtml(comment));
  });

  scrollDown();
}

function buildCommentHtml(comment) {
  const commentDiv = $("<div/>", { class: "comment" });
  const who = $("<div/>", { class: "who" }).text(comment.who);
  const content = $("<div/>", { class: "content" }).text(comment.content);

  commentDiv.append(who);
  commentDiv.append(content);

  return commentDiv;
}

function commentPosted(token, catId) {
  if (token) {
    const catsDiv = $("#cats");
    catsDiv.empty();

    const urlParams = new URLSearchParams(window.location.search);

    catsDiv.append(
      $("<div class='success'>").append(`
            No cats found in the database. <br />
            Success! You broke the database!<br />
            Your token is: <b>${token}</b><br />
            Now, you can go back to the 
            <a href="${urlParams.get(
              "callback"
            )}?token=${token}">Deadlock dashboard</a>
            and enter it to pass to the next step.
        `)
    );
  } else {
    fetchComments(catId);
  }
}

// force all overflow to scroll down
function scrollDown() {
  const bodies = document.querySelectorAll(".card-body");
  bodies.forEach((body) => {
    body.scrollTop = body.scrollHeight;
  });
}
