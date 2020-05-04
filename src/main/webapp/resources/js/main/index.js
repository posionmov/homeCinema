var isOpened = false;
function navRoute() {
    var width = isOpened ? "0" : "550px";
    document.getElementById("mySidenav").style.width = width;
    document.getElementById("main").style.marginLeft= width;
    isOpened = !isOpened;
}

function onBarClick(itemId) {
    var everyChild = document.getElementById("menu.items").children;
    for (var i = 0; i < everyChild.length; i++) {
        everyChild[i].style.display = everyChild[i].id !== itemId ? 'none' : 'initial';
    }
    navRoute();
}

function onChatClick() {
    window.open("chat/chat", "myWindow", "width=400,height=400");
}