function refresh()
{
    document.getElementById("txtMail").value = "";
    document.getElementById("txtMdp").value = "";
}

function keepContent() {
	if(status == 302){
		window.localStorage.setItem("co", "connecté");
	}
}